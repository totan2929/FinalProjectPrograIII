package org.ciaf.client;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import java.util.ArrayList;
import java.util.List;

public class ClientGenerator {
    private static final Logger logger = LogManager.getLogger(ClientGenerator.class);
    private static final int NUM_CLIENTS = 1;

    public static List<Client> generateClients() {
        List<Client> clients = new ArrayList<>();
        Faker faker = new Faker();



        try {
            for (int i = 0; i < NUM_CLIENTS; i++) {
                String name = faker.name().fullName();
                String email = faker.internet().emailAddress();
                String cellPhone = faker.phoneNumber().cellPhone();
                Client client = new Client(clients.size() + 1, name, email, cellPhone);
                clients.add(client);
                logger.info("Client generated: " + "Id: : " + client.getId() + ", name: " + name + ", email: " + email);
            }
        } catch (Exception e) {
            logger.error("Error generating the clients.", e);
            throw new RuntimeException("Error generating the client.", e);
        }

        return clients;
    }
}
