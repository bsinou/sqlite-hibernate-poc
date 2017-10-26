package net.sinou.poc.cms.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import net.sinou.poc.cms.domain.Page;

public class PageFacade extends AbstractFacade<Page> {

	@PersistenceContext(unitName = "cms-poc")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PageFacade() {
		super(Page.class);
	}

	public Optional<Page> findByUrl(String relativeUrl) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		cq.select(cq.from(Page.class));
		Query q = getEntityManager().createQuery(cq);
		q.setParameter("url", relativeUrl);
		List res = q.getResultList();
		if (res.isEmpty())
			return null;
		else if (res.size() > 1)
			throw new RuntimeException(
					"Found " + res.size() + " for page with URL " + relativeUrl + ", cannot proceed");
		else
			return Optional.of((Page) res.get(0));
	}
}
