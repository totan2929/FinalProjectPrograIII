package org.ciaf.user;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserGenerator {
    private static final Logger logger = LogManager.getLogger(UserGenerator.class);
    private static final int NUM_USERS = 5;

    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>();
        Faker faker = new Faker();
        Random random = new Random();
        List<String> roles = new ArrayList<>();
        roles.add("Administrator");
        roles.add("Salesperson");
        roles.add("Manager");


        try {
            for (int i = 0; i < NUM_USERS; i++) {
                String randomRole = roles.get(random.nextInt(roles.size()));
                String name = faker.name().fullName();
                String email = faker.internet().emailAddress();
                String address = faker.address().fullAddress();

                User user = new User(users.size()+1,name, "password123", randomRole);
                users.add(user);
                logger.info("User generated: " + "Id: " + user.getId() +  name + ", email: " + email + ", rol: " + user.getRol() + ", address: " + address);
            }
        } catch (Exception e) {
            logger.error("Error generating the users.", e);
            throw new RuntimeException("Error generating the users.", e);
        }

        return users;
    }

}
