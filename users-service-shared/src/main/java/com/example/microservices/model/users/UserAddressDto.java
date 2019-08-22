package com.example.microservices.model.users;

import lombok.Data;

@Data
public class UserAddressDto {

    private String country;
    private String region;
    private String city;
    private String address;
}
