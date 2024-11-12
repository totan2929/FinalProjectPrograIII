package org.ciaf.product;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class ProductGenerator {
    private static final Logger logger = LogManager.getLogger(ProductGenerator.class);
    private static final int NUM_PRODUCTS = 20;

    public static List<Product> generateProducts() {
        Faker faker = new Faker();
        List<Product> products = new ArrayList<>();



        try {
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                String name = faker.commerce().productName();
                String description = faker.lorem().sentence(10);
                double price = faker.number().randomDouble(2,10,100);
                int stock = faker.number().numberBetween(1,500);

                Product product = new Product(products.size()+1, name, description, price, stock);
                products.add(product);
                logger.info("Product generated: " + ", ID: " + product.getId() + ", Name: " + name +  ", Description: " + name + ", Price: " + price + ", Stock: " + stock);
            }
        } catch (Exception e) {
            logger.error("Error generating the products.", e);
            throw new RuntimeException("Error generating the products.", e);
        }
        return products;
    }

}
