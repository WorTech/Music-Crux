package application.mongo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
		basePackages = {"application.discogsDB.repositories" }, 
		mongoTemplateRef = "discogsMongoTemplate")
@ConfigurationProperties(prefix = "discogs.mongodb")
public class DiscogsMongoConnection extends AbstractMongoConfig {

	/**
	 * Implementation of the MongoTemplate factory method
	 *
	 * @Bean gives a name (discogsMongoTemplate) to the created MongoTemplate
	 *       instance
	 */
	
	@Override
	@Bean(name = "discogsMongoTemplate")
	public MongoTemplate getMongoTemplate() {
		return new MongoTemplate(mongoDbFactory());
	}

}
