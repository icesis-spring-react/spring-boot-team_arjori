package com.example.api.model;

import org.springframework.stereotype.Component;

@Component
public class Director {
    private Long id;
    private String name;

    public Director() {
    }

    public Director(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
