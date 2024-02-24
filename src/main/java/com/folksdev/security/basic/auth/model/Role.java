package com.folksdev.security.basic.auth.model;

import org.springframework.security.core.GrantedAuthority;

// Birden fazla rolümüz olsun ve bunlar kendi customize ettiğimiz roller olsun.
public enum Role implements GrantedAuthority {

    ROLE_USER,
    ROLE_ADMIN,
    ROLE_MOD,
    ROLE_KAAN;

    @Override
    public String getAuthority() {
        return name();
    }
}
