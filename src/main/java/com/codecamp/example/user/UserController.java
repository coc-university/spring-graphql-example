package com.codecamp.example.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class UserController {

    @QueryMapping
    public String hello() {
        return "Hello World";
    }

    @QueryMapping
    public User user(@Argument String name) {
        log.info("User Name: {}", name);
        return new User(name, "test");
    }

    @QueryMapping
    public List<User> users() {
        return List.of(
                new User("Robin", "test"),
                new User("Peter", "test")
        );
    }
}
