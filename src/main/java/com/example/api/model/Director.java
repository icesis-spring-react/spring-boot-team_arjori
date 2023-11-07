package com.example.api.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Director {
    private Long id;
    private String name;

    public Director() {
    }

    public Director(String name) {
        this.id = (long) (Math.random() * 10000000000000000L);
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
