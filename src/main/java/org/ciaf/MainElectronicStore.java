package org.ciaf;

import java.util.Scanner;

import static org.ciaf.menuadmin.MenuAdmin.*;

public class MainElectronicStore {
    public static void main(String[] args) {
        boolean continuee = true;
        Scanner sc = new Scanner(System.in);

        while (continuee){

            System.out.println("Welcome to the Store Inventory Management System");
            System.out.println("1. Register User");
            System.out.println("2. Register Product");
            System.out.println("3. Make Sale");
            System.out.println("4. Generate Sales Report");
            System.out.println("5. Generate Inventory Report");
            System.out.println("6. Customer Management");
            System.out.println("7. Exit");

            System.out.println("Select an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    registerUser();
                    break;

                case 2:
                    registerProduct();
                    break;

                case 3:
                    makeSale();
                    break;

                case 4:
                    generateSalesReport();
                    break;

                case 5:
                    generateInventoryReport();
                    break;

                case 6:
                    managementClients();
                    break;

                case 7:
                    continuee = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
