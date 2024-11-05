package org.ciaf;

import org.ciaf.product.Product;
import org.ciaf.sale.Sale;

import java.util.List;

public class Report {

    public void generateSalesReport(List<Sale> sales){
        sales.forEach(sale -> {
            String reportSale = "Sale{" +
                    "Sale ID=' " + sale.getId() + '\'' +
                    ", Date= ' " + sale.getDateTime() + '\'' +
                    ", Total Sale= ' " + sale.getTotalSale() + '\'' +
                    '}';
            System.out.println(reportSale);

        });
    }

    public void generateSalesInventory(List<Product> products){
        products.forEach(product -> {
            String reportInventory = "Sale{" +
                    "Product ID=' " + product.getId() + '\'' +
                    ", Name= ' " + product.getName() + '\'' +
                    ", Stock= ' " + product.getStock() + '\'' +
                    '}';
            System.out.println(reportInventory);
        });
    }
}
