package net.sinou.poc.cms.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.sinou.poc.cms.conf.SqliteJpaConf;
import net.sinou.poc.cms.domain.User;

public class UserDAO {

	public void addUserDetails(String userName, String password, String email, String phone, String city) {
		try {
			Session session = SqliteJpaConf.getSessionfactory().openSession();

			Transaction transaction = session.beginTransaction();
			User user = new User();
			user.setUserName(userName);
			user.setPassword1(password);
			user.setEmail(email);
			user.setCity(city);
			user.setPhone(phone);
			session.save(user);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
			e.printStackTrace();
		}
	}
}
