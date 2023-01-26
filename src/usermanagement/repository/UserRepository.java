package usermanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usermanagement.config.DBConnectionMgr;
import usermanagement.entity.RoleDtl;
import usermanagement.entity.RoleMst;
import usermanagement.entity.User;

/*
 * UserDao(Data Access Object)
 */
public class UserRepository {
	
	// 싱글톤
	private static UserRepository instance;
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
		
	}
	
	private DBConnectionMgr pool;
	
	private UserRepository() {
		
		pool = DBConnectionMgr.getInstance();
		
	}
	
	public int saveUser(User user) {
		int successCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // AI 키값 받기 위한 변수
		
		try {
			con = pool.getConnection();
			
			String sql = "insert into user_mst values(0, ?, ?, ?, ?)"; // AI, username, password, name, email
			
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			successCount = pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys(); // AI 키값 rs에 들고옴
			if(rs.next()) {
				user.setUserId(rs.getInt(1)); // User의 userId에 AI 키값을 set
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
	}
	
	public int saveRoleDtl(RoleDtl roleDtl) {
		int succesCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = pool.getConnection();
			
			String sql = "insert into role_dtl values (0, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, roleDtl.getRoleId());
			pstmt.setInt(2, roleDtl.getUserId());
			
			succesCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		return succesCount;
	}
	
	public User findUserByUsername(String username) {
		User user = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			String sql = "select \r\n"
					+ "		um.user_id, \r\n"
					+ "		um.username, \r\n"
					+ "		um.password, \r\n"
					+ "		um.name, \r\n"
					+ "		um.email,\r\n"
					+ "    	rd.role_dtl_id,\r\n"
					+ "  	rd.role_id,\r\n"
					+ "   	rd.user_id,\r\n"
					+ "   	rm.role_id,\r\n"
					+ "   	rm.role_name\r\n"
					+ "from \r\n"
					+ "	user_mst um\r\n"
					+ "    left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "    left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
					+ "where\r\n"
					+ "		um.username = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();
			
			List<RoleDtl> roleDtls = new ArrayList<>(); // ?????????????????????
			int i = 0; // 인덱스를 생성하여 몇 번째 반복인지 확인한다.
			
			while(rs.next()) { // if(rs.next())를 하면 1개의 row만 들고오게되므로 반복을 돌려야함
				if(i == 0) {
					user = User.builder()	// user는 한 번만 생성되어 리스트에 넣어야하기 때문에 
							.userId(rs.getInt(1))
							.username(rs.getString(2))
							.password(rs.getString(3))
							.name(rs.getString(4))
							.email(rs.getString(5))
							.build();
				}
				
				RoleMst roleMst = RoleMst.builder()
								.roleId(rs.getInt(9))
								.roleName(rs.getString(10))
								.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
								.roleDtlId(rs.getInt(6))
								.roleId(rs.getInt(7))
								.userId(rs.getInt(8))
								.roleMst(roleMst)
								.build();
				
				roleDtls.add(roleDtl); 
				
				i++;
			}
			
			if(user != null) {
				user.setRoleDtls(roleDtls); // 완성된 dtl을 user에 넣어줌
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
	
	public User findUserByEmail(String email) {
		User user = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			String sql = "select \r\n"
					+ "		um.user_id, \r\n"
					+ "		um.username, \r\n"
					+ "		um.password, \r\n"
					+ "		um.name, \r\n"
					+ "		um.email,\r\n"
					+ "    	rd.role_dtl_id,\r\n"
					+ "  	rd.role_id,\r\n"
					+ "   	rd.user_id,\r\n"
					+ "   	rm.role_id,\r\n"
					+ "   	rm.role_name\r\n"
					+ "from \r\n"
					+ "	user_mst um\r\n"
					+ "    left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "    left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
					+ "where\r\n"
					+ "		um.email = ? ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			List<RoleDtl> roleDtls = new ArrayList<>(); 
			int i = 0; // 인덱스를 생성하여 몇 번째 반복인지 확인한다.
			
			while(rs.next()) { // if(rs.next())를 하면 1개의 row만 들고오게되므로 반복을 돌려야함
				if(i == 0) {
					user = User.builder()	// user는 한 번만 생성되어 리스트에 넣어야하기 때문에 
							.userId(rs.getInt(1))
							.username(rs.getString(2))
							.password(rs.getString(3))
							.name(rs.getString(4))
							.email(rs.getString(5))
							.build();
				}
				
				RoleMst roleMst = RoleMst.builder()
								.roleId(rs.getInt(9))
								.roleName(rs.getString(10))
								.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
								.roleDtlId(rs.getInt(6))
								.roleId(rs.getInt(7))
								.userId(rs.getInt(8))
								.roleMst(roleMst)
								.build();
				
				roleDtls.add(roleDtl); 
				
				i++;
			}
			
			if(user != null) {
				user.setRoleDtls(roleDtls); // 완성된 dtl을 user에 넣어줌
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
	
}

























