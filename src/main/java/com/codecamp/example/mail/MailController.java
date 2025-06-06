package com.codecamp.example.mail;

import com.codecamp.example.types.Mail;
import com.codecamp.example.types.Shop;
import com.codecamp.example.types.User;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class MailController {

    private List<Mail> mails;

    // will be called only if the client also requests the Mails of the User
    @SchemaMapping
    public List<Mail> mails(User user) throws InterruptedException {
        //log.info("wait 1 second in MailController for list of mails for given user with name {}", user.getName());
        Thread.sleep(1_000); // fetch mails from db or other microservice
        // get only Mails of this User
        return mails.stream()
                .filter(mail -> mail.getUserId().equals(user.getId()))
                .collect(Collectors.toList());
    }

    // will be called only if the client also requests the Mails of the User
//    @BatchMapping
//    public List<List<Mail>> mails(List<User> users) throws InterruptedException {
//        log.info("wait 1 second in MailController for batch list of all mails");
//        Thread.sleep(1_000); // fetch mails from db or other microservice
//
//        // group mails by user-id
//        Map<String, List<Mail>> mailsByUserId = mails.stream()
//                .collect(Collectors.groupingBy(Mail::getUserId));
//
//        // map mails in user
//        return users.stream()
//                .map(user -> mailsByUserId.getOrDefault(user.getId(), new ArrayList<>()))
//                .toList();
//    }

    @PostConstruct
    private void initMails() {
        this.mails = new ArrayList<>(List.of(
                Mail.newBuilder()
                        .address("robin@codecamp.com")
                        .userId("Robin-1")
                        .build(),
                Mail.newBuilder()
                        .address("peter@codecamp.com")
                        .userId("Peter-1")
                        .build(),
                Mail.newBuilder()
                        .address("max@codecamp.com")
                        .userId("Max-1")
                        .build(),
                Mail.newBuilder()
                        .address("andi@codecamp.com")
                        .userId("Andi-1")
                        .build()
        ));
    }

}
