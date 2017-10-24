package net.sinou.poc.cms;

import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import net.sinou.poc.cms.domain.Editor;

public class SimpleApplication {
	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;

	private static SessionFactory initialiseDatasource() throws HibernateException {
		Configuration configuration = new Configuration();
		configuration.configure();
		// Explicitely add entity classes
		configuration.addAnnotatedClass(Editor.class);

		Properties properties = configuration.getProperties();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();

		// Once built the factory is immutable
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		try {
			Object obj = configuration.getClass().getClassLoader().loadClass("org.h2.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sessionFactory;

	}

	private static void init2() {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Editor.class);
			configuration.configure();

			Properties properties = configuration.getProperties();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(properties).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		init2();

		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Creating Contact entity that will be save to the sqlite database
			Editor e1 = new Editor("John Doo", "john@email.com");
			Editor e2 = new Editor("Melinda Smith", "melindas@email.com");

			// Saving and committing the change to the database
			session.save(e1);
			session.save(e2);
			session.flush();
			tx.commit();

			// Fetching saved data
			Query query = session.createQuery("from EDITORS");
			@SuppressWarnings("unchecked")
			List<Editor> editorList = (List<Editor>) query.list();

			for (Editor contact : editorList) {
				System.out.println(
						"Id: " + contact.getId() + " | Name:" + contact.getName() + " | Email:" + contact.getEmail());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			// Rolling back changes so data stays consistent in case of any failure
			// between the multiple database write operations.
			tx.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}