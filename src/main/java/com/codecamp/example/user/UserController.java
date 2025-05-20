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
                        //.mails() // is null, will be fetched via @SchemaMapping in MailController
                        .build(),
                User.newBuilder()
                        .id("Peter-1")
                        .shopId("shop-2")
                        .name("Peter")
                        //.mails() // is null, will be fetched via @SchemaMapping in MailController
                        .build(),
                User.newBuilder()
                        .id("Max-1")
                        .shopId("shop-1")
                        .name("Max")
                        //.mails() // is null, will be fetched via @SchemaMapping in MailController
                        .build(),
                User.newBuilder()
                        .id("Andi-1")
                        .shopId("shop-1")
                        .name("Andi")
                        //.mails() // is null, will be fetched via @SchemaMapping in MailController
                        .build(),
                User.newBuilder()
                        .id("Laura-1")
                        .shopId("shop-1")
                        .name("Laura")
                        //.mails() // is null and stays null, user has no mails
                        .build(),
                User.newBuilder()
                        .id("Eva-1")
                        .shopId("shop-1")
                        .name("Eva")
                        //.mails() // is null and stays null, user has no mails
                        .build()
        );
    }

    @QueryMapping
    public User user(@Argument String name) {
        //log.info("User Name: {}", name);
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    // will be called only if the client also requests the Users of the Shop
    @SchemaMapping
    public List<User> users(Shop shop) throws InterruptedException {
        //log.info("wait 1 second in UserController for list of users for given shop with name {}", shop.getName());
        Thread.sleep(1_000); // fetch users from db or other microservice
        // get only Users of this Shop
        return users.stream()
                .filter(user -> user.getShopId().equals(shop.getId()))
                .collect(Collectors.toList());
    }
}
