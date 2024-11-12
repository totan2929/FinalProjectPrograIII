package org.ciaf.menuadmin;

import org.ciaf.MainElectronicStore;
import org.ciaf.client.Client;
import org.ciaf.product.Product;
import org.ciaf.user.User;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;



import java.io.IOException;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.ciaf.invoicepdf.InvoicePDF.readFromPDF;
import static org.ciaf.invoicepdf.InvoicePDF.writeToPDF;
import static org.ciaf.product.ProductGenerator.generateProducts;
import static org.ciaf.user.UserGenerator.generateUsers;

public class MenuAdmin {

    private static final Logger logger = Logger.getLogger(MainElectronicStore.class.getName());
    // Metodos para el menu de administraccion de acciones

    private static List<User> users = generateUsers();
    private static List<Product> products = generateProducts();
    private static List<Product> sales = new ArrayList<>();
    private static List<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);



    public static void registerUser(){
        LocalDateTime date = LocalDateTime.now();
        logger.info("Enter username:");
        String nameUser = sc.nextLine();

        logger.info("Enter password:");
        String password = sc.nextLine();

        logger.info("Enter the user's role (administrator, salesperson, manager):");
        String rol = sc.nextLine();

        User user = new User(users.size()+1, nameUser,password,rol);
        users.add(user);
        logger.info("User successfully registered.");
    }



    public static void registerProduct(){
        logger.info("Enter product name:");
        String nameProduct = sc.nextLine();

        logger.info("Enter product description:");
        String description = sc.nextLine();

        logger.info("Enter product price:");
        double price = sc.nextDouble();

        logger.info("Enter product stock:");
        int stock = sc.nextInt();

        Product product = new Product(products.size()+1, nameProduct, description, price, stock);
        products.add(product);
        logger.info("Product successfully registered.");
    }



    public static void makeSale() throws IOException {


        logger.info("Enter customer name:");
        String nameClient = sc.nextLine();

        logger.info("Enter customer email:");
        String email = sc.nextLine();

        logger.info("Enter customer cellPhone:");
        String cellPhone = sc.nextLine();

        Client client = new Client(clients.size()+1, nameClient, email, cellPhone);
        clients.add(client);
        logger.info("Customer successfully registered.");

        List<Product> productsSold = new ArrayList<>();
        boolean cont = true;
        while (cont){
            logger.info("Enter the ID of the product you want to sell (0 or -1 to finish):");
            int idProduct = sc.nextInt();
            sc.nextLine();

            if (idProduct == -1) break;

            Product product = searchProductById(idProduct);
            //System.out.println(product);

            if (product != null){
                productsSold.add(product);
                product.updateStock(-1);
                logger.info("Product added to sale.");
                logger.info("Press s to add another product or another key to continue");
                String option = sc.nextLine().toLowerCase();

                switch (option){
                    case "s":
                        break;
                    default: cont = false;
                }

            }else {
                logger.warning("Product not available or out of stock.");
            }
        }

        double totalSale =0;
        for (Product product : productsSold){
            totalSale += product.getPrice();
        }

        StringBuilder factura = new StringBuilder();
        factura.append("=========================================================================\n");
        factura.append("  FACTURA: " + client.getName().substring(1,3).toUpperCase()+ "-" + LocalDateTime.now() + "-" + client.getName().substring(2,3).toUpperCase() + "\n");
        factura.append("=========================================================================\n");
        factura.append("Client: " + client.getName() + "\n");
        factura.append("Email: " + client.getEmail() + "\n");
        factura.append("cellPhone: " + client.getCellPhone() + "\n");
        factura.append("------------------------------------------------------------------------------------------------------------ \n");
        factura.append("Products:\n");
        for (Product product : productsSold){
            factura.append("ProductId: " + product.getId()+ ", Name: "+ product.getName() + ", ..........................Price" + product.getPrice() + "\n");
        }
        factura.append("-------------------------------------------------------------------------------------------------------------\n");
        factura.append(String.format("Total:.........................................................................$%.2f\n", totalSale));
        factura.append("==========================================================================\n");
        factura.append("                                              Thank you for your purchase\n");
        factura.append("==========================================================================");

        //System.out.println(factura.toString());
        String fileName =  client.getName() + ".pdf";
        writeToPDF(fileName, factura);
        String readText = readFromPDF(fileName);
        System.out.println("Texto leído desde el archivo PDF:");
        System.out.println(readText);

        //String text = "Ensayo";
        //writeToPDF(fileName, text);
        /*String fileName = "factura.pdf";
        String textToWrite = factura.toString();
        writeToPDF(fileName, textToWrite);

        // Leer desde archivo PDF
        String readText = readFromPDF(fileName);
        System.out.println("Texto leído desde el archivo PDF:");
        System.out.println(readText);*/

        logger.info("Sale successfully completed. Total: $" + totalSale);

    }




    public static void generateInventoryReport(){
        logger.info("Generating inventory report...");

        if (products.isEmpty()){
            logger.info("There are no products in inventory.");
            return;
        }

        for (Product product : products){
            logger.info("ID: " + product.getId());
            logger.info("Name: " + product.getName());
            logger.info("Description: " + product.getDescription());
            logger.info("Price: " + product.getPrice());
            logger.info("Stock: " + product.getStock());
            logger.info("------------------------------");
        }
    }

    public static void managementClients(){
        logger.info("1. Register Customer");
        logger.info("2. Show Customers");

        logger.info("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option){
            case 1:
                logger.info("Enter customer name:");
                String nameClient = sc.nextLine();

                logger.info("Enter customer email:");
                String email = sc.nextLine();

                logger.info("Enter customer email:");
                String cellPhone = sc.nextLine();

                Client client = new Client(clients.size() + 1, nameClient, email,cellPhone);
                clients.add(client);
                logger.info("Customer successfully registered.");
                break;

            case 2:
                logger.info("List of registered customers:");
                for (Client client1 : clients){
                    logger.info("Name: " + client1.getName());
                    logger.info("Email: " + client1.getEmail());
                    logger.info("------------------------------------");
                }
                logger.warning("There are no registered clients!!!!");

                break;

            default:
                logger.info("Invalid option.");
        }
    }

    //Metodos auxiliares para buscar productos



    private static Product searchProductById(int idProduct){
        for (Product product : products){
            if (product.getId() == idProduct){
                return product;
            }
        }

        return null;
    }


}
