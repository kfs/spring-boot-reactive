package com.example.microservices.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    public CommandLineRunner initializeUserData(MongoOperations mongo) {
        return (String... args) -> {
            mongo.dropCollection(User.class);
            mongo.createCollection(User.class, CollectionOptions.empty().size(99999).capped());

            Flux.range(0, 10)
                    .map(i -> new User(UUID.randomUUID(), "User_" + i, "¯\\_(ツ)_/¯"))
                    .doOnNext(mongo::save)
                    .blockLast(Duration.ofSeconds(3));
        };
    }
}
