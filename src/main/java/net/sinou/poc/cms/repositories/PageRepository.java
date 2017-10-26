package net.sinou.poc.cms.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.sinou.poc.cms.domain.Page;

public interface PageRepository extends CrudRepository<Page, Integer> {
	
	@Query("SELECT t FROM PAGES t where t.url = :url") 
    Page findByUrl(@Param("url") String url);
	
}