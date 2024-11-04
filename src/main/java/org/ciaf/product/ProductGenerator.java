package org.ciaf.product;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class ProductGenerator {
    private static final Logger logger = LogManager.getLogger(ProductGenerator.class);
    private static final int NUM_USERS = 20;

    public static List<Product> generateUsers() {
        List<Product> products = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < NUM_USERS; i++) {
            String name = faker.commerce().productName();
            double price = faker.number().randomDouble(2,10,1000);
            int stock = faker.number().numberBetween(1,500);

            Product product = new Product(i, name, "Description of: " + name, price, stock);
            products.add(product);
            logger.info("Product generated: " + name + ", Price:" + price);
        }

        return products;
    }

}
