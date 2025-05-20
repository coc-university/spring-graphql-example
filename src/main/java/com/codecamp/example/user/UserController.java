package com.codecamp.example.user;

import com.codecamp.example.types.Shop;
import com.codecamp.example.types.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class UserController {

    private final List<User> users;

    public UserController() {
        this.users = List.of(
                User.newBuilder()
                        .id("Robin-1")
                        .shopId("shop-1")
                        .name("Robin")
                        //.email() // is null, will be fetched via @SchemaMapping in MailController
                        .build(),
                User.newBuilder()
                        .id("Peter-1")
                        .shopId("shop-2")
                        .name("Peter")
                        //.email() // is null, will be fetched via @SchemaMapping in MailController
                        .build(),
                User.newBuilder()
                        .id("Max-1")
                        .shopId("shop-1")
                        .name("Max")
                        //.email() // is null, will be fetched via @SchemaMapping in MailController
                        .build()
        );
    }

    @QueryMapping
    public User user(@Argument String name) {
        log.info("User Name: {}", name);
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    // will be called only if the client also requests the Users of the Shop
    @SchemaMapping
    public List<User> users(Shop shop) throws InterruptedException {
        log.info("wait 2 seconds in UserController for list of users for given shop");
        Thread.sleep(2_000); // fetch users from db or other microservice
        // get only Users of this Shop
        return users.stream()
                .filter(user -> user.getShopId().equals(shop.getId()))
                .collect(Collectors.toList());
    }
}
