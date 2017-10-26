package net.sinou.poc.cms.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CmsContextListener implements ServletContextListener {

	// Prepare the EntityManagerFactory & Enhance:
	public void contextInitialized(ServletContextEvent e) {
//		com.objectdb.Enhancer.enhance("guest.*");
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/guest.odb");
//		e.getServletContext().setAttribute("emf", emf);
	}

	// Release the EntityManagerFactory:
	public void contextDestroyed(ServletContextEvent e) {
		EntityManagerFactory emf = (EntityManagerFactory) e.getServletContext().getAttribute("emf");
		emf.close();
	}
}