package com.list.to_do.DTO;

import com.list.to_do.entities.ENUM.UserRole;

public record RegisterDto(String name, String email, String password, UserRole role) {

}
