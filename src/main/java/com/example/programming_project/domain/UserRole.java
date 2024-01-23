package com.example.programming_project.domain;

public enum UserRole {
    ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

    private final String code;

    UserRole(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
