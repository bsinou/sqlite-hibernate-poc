package net.sinou.poc.cms.conf;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import net.sinou.poc.cms.domain.Editor;
import net.sinou.poc.cms.domain.Page;
import net.sinou.poc.cms.domain.User;

public class SqliteJpaConf {

	private static SessionFactory factory;

	public static SessionFactory getSessionfactory() {
		if (factory == null) {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			configuration.addAnnotatedClass(Editor.class).addAnnotatedClass(User.class).addAnnotatedClass(Page.class);
			factory = configuration.buildSessionFactory(builder.build());
		}
		return factory;
	}
}
