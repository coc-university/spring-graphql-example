package com.codecamp.example.shop;

import com.codecamp.example.types.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class ShopController {

    @QueryMapping
    public Shop shop() {
        return Shop.newBuilder()
                .id("shop-1")
                .name("Test-Shop")
                //.users() // is null, will be fetched via @SchemaMapping in UserController
                .build();
    }

}
