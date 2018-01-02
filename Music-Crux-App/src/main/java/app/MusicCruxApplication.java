package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import repositories.*; // From the 'common' module

@SpringBootApplication
@EnableMongoRepositories(basePackages="repositories")

public class MusicCruxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicCruxApplication.class, args);
	}
}