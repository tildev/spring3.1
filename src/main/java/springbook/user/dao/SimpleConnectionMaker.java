/**
 * 
 */
package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tildev
 * @date 2018. 6. 16.
 */
public class SimpleConnectionMaker {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// DB 연결을 위한 connection
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "springbook", "springbook");
		return c;
	}
}
