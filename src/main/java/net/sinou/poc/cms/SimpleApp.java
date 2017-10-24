package net.sinou.poc.cms;

import java.text.MessageFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import net.sinou.poc.cms.domain.Editor;

public class SimpleApp {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration().configure();
		final StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		configuration.addAnnotatedClass(Editor.class);
		final SessionFactory factory = configuration.buildSessionFactory(builder.build());
		final Session session = factory.openSession();
		final Editor editor = new Editor("JD", "jd@examle.com");
		session.beginTransaction();
		session.save(editor);
		session.getTransaction().commit();

		final List<Editor> books = session.createCriteria(Editor.class).list();

		System.out.println("\n----\n");
		System.out.println(MessageFormat.format("Storing {0} editors in the database", books.size()));
		for (final Editor b : books) {
			System.out.println(b);
		}

		Query query = session.createQuery("from EDITORS");
		@SuppressWarnings("unchecked")
		List<Editor> editorList = (List<Editor>) query.list();
		for (Editor contact : editorList) {
			System.out.println(
					"Id: " + contact.getId() + " | Name:" + contact.getName() + " | Email:" + contact.getEmail());
		}

		System.out.println("\n----\n");
		session.close();
		factory.close();
	}
}
