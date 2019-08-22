package com.example.microservices.userservice;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
interface UserRepository extends ReactiveMongoRepository<User, UUID> {

    @Tailable
    Flux<User> findUsersBy();
}
