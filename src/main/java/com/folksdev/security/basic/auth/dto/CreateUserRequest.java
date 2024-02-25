package com.folksdev.security.basic.auth.dto;

import com.folksdev.security.basic.auth.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
){
}
