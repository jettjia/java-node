package com.jettjia._springbootlession3.controller;
import org.springframework.hateoas.ResourceSupport;
public class User extends ResourceSupport{
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
