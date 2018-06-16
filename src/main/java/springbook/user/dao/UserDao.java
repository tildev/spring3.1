/**
 * 
 */
package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.user.domain.UserDto;

/**
 * @author tildev
 * @date 2018. 6. 16.
 */
public class UserDao {

	private ConnectionMaker connectionMaker;

	/**
	 * @param simpleConnectionMaker
	 */
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	// private Connection getConnection() throws ClassNotFoundException,
	// SQLException {
	// Class.forName("oracle.jdbc.driver.OracleDriver");
	// // DB 연결을 위한 connection
	// Connection c =
	// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
	// "springbook", "springbook");
	// return c;
	// }

	public void add(UserDto user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();

		// SQL 을 담은 PreparedStatement 을 만든다.
		PreparedStatement ps = c.prepareStatement("insert into users(userid, name, password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		// 만들어진 Statement 실행
		ps.executeUpdate();

		// 작업 중 생성된 Connection, Statement, ResultSet 같은 리소스는 작업을 마친 후 반드시 닫아준다.
		ps.close();
		c.close();
	}
//76p
	public UserDto get(String id) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.makeConnection();

		// SQL 을 담은 PreparedStatement 을 만든다.
		PreparedStatement ps = c.prepareStatement("select * from users where userid = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		UserDto user = new UserDto();

		user.setId(rs.getString("userid"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();
		return user;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// UserDao dao = new UserDao();
		//
		// UserDto user = new UserDto();
		// user.setId("whiteship");
		// user.setName("백기선");
		// user.setPassword("married");
		// dao.add(user);
		// System.out.println(user.getId() + " 등록 성공");
		//
		// UserDto user2 = dao.get(user.getId());
		// System.out.println(user2.getName());
		// System.out.println(user2.getPassword());
		// System.out.println(user2.getId() + " 조회 성공");
	}
}
