package com.example.microservices.userservice;

import com.example.microservices.model.users.UserDto;
import org.modelmapper.ModelMapper;

import java.util.UUID;

final class Mapper {

    private static ModelMapper mapper = new ModelMapper();

    private Mapper() {
        throw new IllegalArgumentException("no-no-no!");
    }

    static User map(UserDto dto) {
        return mapper.map(dto, User.class);
    }

    static User mapNew(UserDto dto) {
        dto.setUuid(UUID.randomUUID());
        return mapper.map(dto, User.class);
    }

    static UserDto map(User dto) {
        return mapper.map(dto, UserDto.class);
    }
}
