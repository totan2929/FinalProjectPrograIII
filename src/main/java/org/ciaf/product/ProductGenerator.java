package org.ciaf.product;

import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.List;

public class ProductGenerator {
    private static final int NUM_USERS = 20;

    public static List<Product> generateUsers() {
        List<Product> products = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < NUM_USERS; i++) {
            String id = faker.idNumber().toString();
            String name = faker.name().name();
            String description = faker.lorem().paragraph();
            String price = faker.crypto().toString();
            String stock = faker.stock().toString();

            Product product = new Product(id, name, description, price, stock);
            products.add(product);
        }

        return products;
    }

}
