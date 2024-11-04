package org.ciaf.user;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class UserGenerator {
    private static final int NUM_USERS = 20;

    public static List<User> generateUsers() {
        List<User> users = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < NUM_USERS; i++) {
            String name = faker.name().fullName();
            String password = faker.internet().password();
            String rol = faker.job().position();

            User user = new User(name, password, rol);
            users.add(user);
        }

        return users;
    }

}
