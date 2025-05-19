package com.codecamp.example.user;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @QueryMapping
    public String hello() {
        return "Hello World";
    }

    @QueryMapping
    public User user() {
        return new User("Robin", "test");
    }

    @QueryMapping
    public List<User> users() {
        return List.of(
                new User("Robin", "test"),
                new User("Peter", "test")
        );
    }
}
