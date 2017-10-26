package net.sinou.poc.cms.conf;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "net.sinou.poc.cms.domain", "net.sinou.poc.cms.repositories" })
@EnableTransactionManagement
public class RepositoryConfiguration {

	private final static String DB_PATH = "/tmp/sqlite/sqlite.db";

	public void init() {
	}

	@Bean
	public DataSource jdbcDataSource() {
		SingleConnectionDataSource ds = new SingleConnectionDataSource();
		ds.setDriverClassName("org.sqlite.JDBC");
		ds.setUrl("jdbc:sqlite:" + DB_PATH);
		return ds;
	}
}