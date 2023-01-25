package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import usermanagement.entity.User;

public class UserInsert {
	
	private DBConnectionMgr pool;
	
	public UserInsert() {
		pool = DBConnectionMgr.getInstance(); // UserInsert 생성되면 대입
		// 
	}
	
	public int saveUser(User user) {
		int successCount = 0; // 결과 return을 위해 전역으로 뺌
		
		String sql = null; // sql 구문 작성을 위한 변수 선언
		Connection connection = null; // 자바와 DB와 연동하기 위한 Connection 객체 생성
		PreparedStatement preparedStatement = null; // statement와 달리 변수값 대신 ?를 사용하여 변수값을 지정할 수 있음
		ResultSet resultSet = null; // key 값을 들고오기 위한 변수
		
		try {
			connection = pool.getConnection();
			
			sql = "insert into user_mst\r\n"
					+ "values (0, ?, ?, ?, ?)"; // ?는 표기용으로 사용됨
			
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			// PreparedStatement를 사용하기 위해서 connection의 prepareStatement를 참조해서 sql문을 preparedStatement 형식으로 변수에 저장, AI로 만들어진 key값 들고오는 Statement.RETURN_GENERATED_KEYS
			preparedStatement.setString(1, user.getUsername()); // sql에서 받을 자료형이 string이라서 setString, 만약 int를 받는다면  setInt
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());
			// setString하는 순간 작은따옴표 포함해서 만들어주고 순서대로 넣어줌
			// 
			
			successCount = preparedStatement.executeUpdate(); // insert, update, delete 명령 실행할때 사용하는 것이 excuteUpdate 나머지는 excuteSql
			// 적용된 행의 갯수를 int로 return
			
			resultSet = preparedStatement.getGeneratedKeys(); // 복수형. insert는 여러개가 동시에 들어갈 수 있기 때문에 여러 AI 키값을 들고오기 위해서
			// set. 반복문을 쓸 때 iterator가 next를 꺼내서 쓰는 방식과 동일하게 next를 사용함
			// update가 되고나서(값이 들어간 후에) 생성된 키값을을 set형태로 들고옴
			
			// 여러개의 키값을 가지고 있는 리스트...?
			if(resultSet.next()) {
				System.out.println("이번에 만들어진 user_id Key값: " + resultSet.getInt(1));
				user.setUserId(resultSet.getInt(1));
			}
			
			System.out.println("쿼리 실행 성공: " + successCount + "건");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return successCount;
	}
	
	public int saveRoles(Map<String, Object> map) {
		int successCount = 0;
		
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = pool.getConnection();
			List<Integer> roles = (List<Integer>) map.get("roles"); // 업캐스팅되어 있어 for문에서 길이 메소드를 사용할 수 없어 다운캐스팅을 해줘야 함 
			User user = (User) map.get("user");
			
			sql = "insert into role_dtl values "; // map안의 list의 크기만큼 반복돼야함
			
			for(int i = 0; i < roles.size(); i++) {
				
				sql += "(0, ?, ?)";
				
				if(i < roles.size() - 1) { // sql문에 ,가 붙어야하는데 마지막에는 안붙어야하니까
					sql += ","; 
				}
			}
			
			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(3, roles.get(1));
//			preparedStatement.setInt(4, user.getUserId());
			
			for(int i = 0; i < roles.size(); i++) {
				preparedStatement.setInt((i * 2) + 1, roles.get(i));
				preparedStatement.setInt((i * 2) + 2, user.getUserId());
			}
			
			successCount = preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return successCount;
		
	}

	
	public static void main(String[] args) {
		
		UserInsert userInsert = new UserInsert(); // saveUser가 static이 아니기에 사용하기 위해서 객체 생성

		
		User user = User.builder()
					.username("ccc")
					.password("1234")
					.name("ccc")
					.email("ccc@gmail.com")
					.build();
		
		int successCount = userInsert.saveUser(user);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
		System.out.println(user);
		
		/*==========================================================================*/
		
		List<Integer> roleIdList = new ArrayList<>();
		roleIdList.add(2);
		roleIdList.add(3);
		
		Map<String, Object> map = new HashMap<>();
		map.put("user", user); // 업캐스팅되었기에 가지고올때는 다운캐스팅 해서 들고와야함
		map.put("roles", roleIdList);
		
		System.out.println(map);
		
		successCount = userInsert.saveRoles(map); // 1. map을 받아서 saveRoles에 던져줌
		
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
//		int listSize = 3;
//		
//		String sql = "insert into test values";
//		String values = "(0, ?, ?)";
//		
//		for(int i = 0; i < listSize; i++) {
//			sql += values;
//			if(i < listSize - 1) {
//				sql += ",";
//			}
//		}
//		
//		System.out.println(sql);
		
		
		
	}

}
