package com.example.microservices.userservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {

    private UUID uuid;
    private String firstName;
    private String lastName;
}
