package org.ciaf;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.ciaf.menuadmin.MenuAdmin.*;


public class MainElectronicStore {
    private static final Logger logger = Logger.getLogger(MainElectronicStore.class.getName());
    public static void main(String[] args) throws IOException {





        boolean continuee = true;
        Scanner sc = new Scanner(System.in);

        while (continuee){

            logger.info(" \n"
            + "Welcome to your Friendly store\n"
            + "****************************************************\n"
            + "1. Register User\n"
            + "2. Register Product\n"
            + "3. Make Sale\n"
            + "4. Generate Inventory Report\n"
            + "5. Customer Management\n"
            + "6. Exit");

            logger.info("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    logger.info("****************************************************");
                    registerUser();
                    logger.info("****************************************************");
                    break;

                case 2:
                    logger.info("****************************************************");
                    registerProduct();
                    logger.info("****************************************************");
                    break;

                case 3:
                    logger.info("****************************************************");
                    makeSale();
                    logger.info("****************************************************");
                    break;

                case 4:
                    logger.info("****************************************************");
                    generateInventoryReport();
                    logger.info("****************************************************");
                    break;

                case 5:
                    logger.info("****************************************************");
                    managementClients();
                    logger.info("****************************************************");
                    break;

                case 6:
                    logger.info("****************************************************");
                    continuee = false;
                    logger.info("Thank you for using our system see you soon!!!!!");
                    logger.info("****************************************************");
                    break;

                default:
                    logger.info("****************************************************");
                    logger.info("Invalid option.");
                    logger.info("****************************************************");
            }
        }
    }
}
