package net.sinou.poc.cms.services;

import java.util.List;
import java.util.Optional;

import net.sinou.poc.cms.domain.Page;

public interface PageService {

	List<Page> getAllPages();

	Page getPageById(Integer id);

	Page savePage(Page page);

	void deletePage(Integer id);

	Optional<Page> findByUrl(String relativeUrl);
}
