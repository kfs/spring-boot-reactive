package com.example.microservices.userservice;

import com.example.microservices.model.users.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public Flux<UserDto> getUsers() {
        return this.repository
                .findAll()
                .map(Mapper::map)
                .log();
    }

    @GetMapping(path = "/users", produces = "application/stream+json")
    public Flux<UserDto> getUsersStream() {
        return this.repository
                .findUsersBy()
                .map(Mapper::map)
                .log();
    }

    @PostMapping(path = "/users", consumes = "application/stream+json")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> bulkCreateUsers(@RequestBody Flux<UserDto> users) {
        return this.repository
                .insert(users.map(Mapper::map))
                .then()
                .log();
    }
}
