package com.example.microservices.model.users;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private UserAddressDto address;
}
