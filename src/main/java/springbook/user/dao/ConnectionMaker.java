/**
 * 
 */
package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author tildev
 * @date 2018. 6. 16.
 */
public interface ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
