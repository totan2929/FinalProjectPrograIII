package org.ciaf;

import org.ciaf.client.Client;
import org.ciaf.product.Product;
import org.ciaf.sale.Sale;
import org.ciaf.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAdmin {

    // Metodos para el menu de administraccion de acciones

    private static List<User> users = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Sale> sales = new ArrayList<>();
    private static List<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private static void registerUser(){
        System.out.println("Enter username:");
        String nameUser = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();

        System.out.println("Enter the user's role (administrator, salesperson, manager):");
        String rol = sc.nextLine();

        User user = new User(nameUser,password,rol);
        users.add(user);
        System.out.println("User successfully registered.");
    }

    private static void registerProduct(){
        System.out.println("Enter product name:");
        String nameProduct = sc.nextLine();

        System.out.println("Enter product description:");
        String description = sc.nextLine();

        System.out.println("Enter product price:");
        double price = sc.nextDouble();

        System.out.println("Enter product stock:");
        int stock = sc.nextInt();

        Product product = new Product(products.size()+1, nameProduct, description, price, stock);
        products.add(product);
        System.out.println("Product successfully registered.");
    }

    private static void makeSale(){
        System.out.println("Enter the username making the sale:");
        String nameUser = sc.nextLine();
        User user = searchUser(nameUser);

        if (user == null || !user.getRol().equals("salesperson")){
            System.out.println("User not found or does not have permission to make sales.");
            return;
        }

        List<Product> productsSold = new ArrayList<>();
        System.out.println("Enter the ID of the product you want to sell (0 or -1 to finish):");

        while (true){
            int idProduct = sc.nextInt();
            sc.nextLine();

            if (idProduct == -1) break;

            Product product = searchProductById(idProduct);

            if (product != null && product.getStock() > 0){
                productsSold.add(product);
                product.updateStock(-1);
                System.out.println("Product added to sale.");
            }else {
                System.out.println("Product not available or out of stock.");
            }
        }

        Sale sale = new Sale(productsSold);
        sales.add(sale);
        System.out.println("Sale successfully completed. Total: $" + sale.calculateTotalSale());
    }

    private static void generateSalesReport(){
        System.out.println("Generating sales report...");
        if (sales.isEmpty()){
            System.out.println("No sales have been recorded.");
            return;
        }

        for (Sale sale : sales){
            System.out.println("ID sale: " + sale.getId());
            System.out.println("Products sold:");

            for (Product product : sale.getProductsSold()){
                System.out.println("- " + product.getName() + ": $" + product.getPrice());
            }
            System.out.println("Sale total: $" + sale.calculateTotalSale());
            System.out.println("Sale date: " + sale.getDateTime());
            System.out.println("----------------------------------");
        }
    }


    private static void generateInventoryReport(){
        System.out.println("Generating inventory report...");

        if (products.isEmpty()){
            System.out.println("There are no products in inventory.");
            return;
        }

        for (Product product : products){
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Stock: " + product.getStock());
            System.out.println("------------------------------");
        }
    }

    private static void managementClients(){
        System.out.println("1. Register Customer");
        System.out.println("2. Show Customers");

        System.out.println("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option){
            case 1:
                System.out.println("Enter customer name:");
                String nameClient = sc.nextLine();

                System.out.println("Enter customer email:");
                String email = sc.nextLine();

                Client client = new Client(nameClient, email);
                clients.add(client);
                System.out.println("Customer successfully registered.");
                break;

            case 2:
                System.out.println("List of registered customers:");
                for (Client client1 : clients){
                    System.out.println("Name: " + client1.getName());
                    System.out.println("Email: " + client1.getEmail());
                    System.out.println("Loyalty points: " + client1.getPointsFidelity());
                    System.out.println("------------------------------------");
                }
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    //Metodos auxiliares para buscar usuarios y productos
    private static User searchUser(String nameUser){
        for (User user : users){
            if (user.getName().equals(nameUser)){
                return user;
            }
        }
        return null;
    }

    private static Product searchProductById(int idProduct){
        for (Product product : products){
            if (product.getId() == idProduct){
                return product;
            }
        }

        return null;
    }
}
