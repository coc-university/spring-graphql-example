package com.codecamp.example.user;

import com.codecamp.example.types.User;
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
        //log.info("User Name: {}", name);
        return User.newBuilder()
                .name(name)
                .email("email")
                .build();
    }

    @QueryMapping
    public List<User> users() {
        return List.of(
                User.newBuilder()
                        .name("Robin")
                        .email("email")
                        .build(),
                User.newBuilder()
                        .name("Peter")
                        .email("email")
                        .build()
        );
    }
}
