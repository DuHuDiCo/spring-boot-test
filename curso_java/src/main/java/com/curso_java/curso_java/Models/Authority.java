package com.curso_java.curso_java.Models;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

    private String authority;
    
    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
    
}
