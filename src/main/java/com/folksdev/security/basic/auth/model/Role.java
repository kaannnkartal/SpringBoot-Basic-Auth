package com.folksdev.security.basic.auth.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

// Birden fazla rolümüz olsun ve bunlar kendi customize ettiğimiz roller olsun.

public enum Role implements GrantedAuthority {

    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_MOD("MOD"),
    ROLE_KAAN("KAAN");


    private String value;


    Role(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
