package application.mongo.config;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

public abstract class AbstractMongoConfig {

	// Mongo DB Properties
	private String host, database;
	private int port;

	public AbstractMongoConfig() {
		
	}
	
	public AbstractMongoConfig(String host, String database, int port) {
		super();
		this.host = host;
		this.database = database;
		this.port = port;
	}

	/**
	 * Creates MongoDbFactory Common to the MongoDb connections
	 * 
	 * @return
	 */
	public MongoDbFactory mongoDbFactory() {
		return new SimpleMongoDbFactory(getMongoClient(), database);
	}

	/**
	 * Creates MongoClient
	 * 
	 * @return
	 */
	private MongoClient getMongoClient() {
		return new MongoClient(host, port);
	}

	/**
	 * Factory method to create the MongoTemplate
	 */
	abstract public MongoTemplate getMongoTemplate();

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
