package com.example.microservices.userservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
class User {

    private UUID uuid;
    private String firstName;
    private String lastName;
}
