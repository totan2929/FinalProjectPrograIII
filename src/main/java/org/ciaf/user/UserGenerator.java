package org.ciaf.user;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class UserGenerator {
    private static final Logger logger = LogManager.getLogger(UserGenerator.class);
    private static final int NUM_USERS = 20;

    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < NUM_USERS; i++) {
            String name = faker.name().fullName();
            String email = faker.internet().emailAddress();
            String address = faker.address().fullAddress();

            User user = new User(name, "password123", "vendedor");
            users.add(user);
            logger.info("User generated: " + name + ", email: " + email, ", Address: " + address);
        }

        return users;
    }

}
