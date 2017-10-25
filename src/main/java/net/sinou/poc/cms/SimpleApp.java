package net.sinou.poc.cms;

import java.text.MessageFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import net.sinou.poc.cms.domain.Editor;
import net.sinou.poc.cms.domain.User;

public class SimpleApp {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		final Configuration configuration = new Configuration().configure();
		final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		configuration.addAnnotatedClass(Editor.class).addAnnotatedClass(User.class);
		final SessionFactory factory = configuration.buildSessionFactory(builder.build());
		final Session session = factory.openSession();
		final Editor editor = new Editor("JD", "jd@examle.com");
		session.beginTransaction();
		session.save(editor);
		session.getTransaction().commit();

		System.out.println("\n----\n");
		List res = session.createCriteria(Editor.class).list();
		debug(res, "session.createCriteria(Editor.class)");

		res = session.createSQLQuery("Select * from EDITORS").list();
		debug(res, "session.createSQLQuery(\"Select * from EDITORS\")");

		res = session.createQuery("from EDITORS").list();
		debug(res, "session.createQuery(\"from EDITORS\")");

		session.close();
		factory.close();
	}

	@SuppressWarnings("rawtypes")
	private static void debug(List results, String queryStr) {
		System.out.println("Executing: " + queryStr + "\n");
		System.out.println(MessageFormat.format("Found {0} rows in the database", results.size()));
		for (Object b : results) {
			System.out.println(b);
		}
		System.out.println("\n----\n");
	}
}
