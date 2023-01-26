package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {
	
	private DBConnectionMgr pool;
	
	public RoleInsert() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public int saveRole(String roleName) {
		int succeccCount = 0;
		
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			
			sql = "insert into role_mst values (0, ?)";
			
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// Statement.RETURN_GENERATED_KEYS 있어야지 generate key가져올 수 있음
			pstmt.setString(1, roleName);
			// 첫번째에 roleName
			succeccCount = pstmt.executeUpdate();
			// ctrl + enter와 같이 pstmt에 저장된 쿼리문이 전송..?/.?
			
			int newKey = 0;
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) { // insert가 하나만 있기에 while이 아니라 if 사용
				newKey = rs.getInt(1); // rs에서 첫번째 컬럼의 키값 가져옴
			}
			
			System.out.println(newKey != 0 ? "새로운 키값: " + newKey : "키가 생성되지 않음");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// exeption이 터져도 꼭 실행되어야 하는 경우
			pool.freeConnection(con, pstmt, rs);
			// getConnection 연결 안될 수 있고
			// 예외뜨면 예외처리 그래서 try안에 끼워져있다..?
		}
		
		return succeccCount;
	}
	
	public static void main(String[] args) {
		
		RoleInsert roleInsert = new RoleInsert();
		
		int successCount = roleInsert.saveRole("ROLE_TESTER");
		System.out.println("insert 성공 건수: " + successCount);
	}

}
