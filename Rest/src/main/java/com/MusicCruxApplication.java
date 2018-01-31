package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages= "com.db.mongo.repositories")

public class MusicCruxApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicCruxApplication.class, args);
    }
}
