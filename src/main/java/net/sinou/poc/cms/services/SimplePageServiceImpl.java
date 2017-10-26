package net.sinou.poc.cms.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import net.sinou.poc.cms.conf.SqliteJpaConf;
import net.sinou.poc.cms.domain.Page;

public class SimplePageServiceImpl implements PageService {

	@Override
	public List<Page> getAllPages() {
		try {
			Session session = SqliteJpaConf.getSessionfactory().openSession();
			List res = session.createCriteria(Page.class).list();
			return (List<Page>) res;
		} catch (HibernateException e) {
			throw new RuntimeException("Cannot list all pages", e);
		}
	}

	@Override
	public Page getPageById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page savePage(Page page) {
		try {
			Session session = SqliteJpaConf.getSessionfactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(page);
			transaction.commit();
			return page;
		} catch (HibernateException e) {
			throw new RuntimeException("Cannot save page", e);
		}
	}

	@Override
	public void deletePage(Integer id) {
		try {
			Session session = SqliteJpaConf.getSessionfactory().openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(getPageById(id));
			transaction.commit();
		} catch (HibernateException e) {
			throw new RuntimeException("Cannot delete page with id " + id, e);
		}
	}

	@Override
	public Optional<Page> findByUrl(String relativeUrl) {

		try {
			Session session = SqliteJpaConf.getSessionfactory().openSession();
			Criteria ct = session.createCriteria(Page.class).add(Restrictions.eq("url", relativeUrl));
			List res = ct.list();
			if (res.isEmpty())
				return Optional.empty();
			else if (res.size() > 1)
				throw new RuntimeException(
						"Found " + res.size() + " for page with URL " + relativeUrl + ", cannot proceed");
			else
				return Optional.of((Page) res.get(0));
		} catch (HibernateException e) {
			throw new RuntimeException("Cannot list all pages", e);
		}
	}
}
