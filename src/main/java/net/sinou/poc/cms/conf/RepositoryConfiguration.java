package net.sinou.poc.cms.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories(basePackages = { "net.sinou.poc.cms.domain" })
@EnableTransactionManagement
public class RepositoryConfiguration {
	
	public void init() {
		System.out.println("Created bean... ");
	}
}