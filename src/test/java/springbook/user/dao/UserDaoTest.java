/**
 * 
 */
package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author tildev
 * @date 2018. 6. 16.
 */
public class UserDaoTest {
	public static void main(String[] args) {
//		ConnectionMaker conn = new DConnectionMaker();
//
//		UserDao dao = new DaoFactory().userDao();
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
	}
}
