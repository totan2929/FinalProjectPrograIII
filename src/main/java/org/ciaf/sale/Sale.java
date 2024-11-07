package org.ciaf.sale;

import org.ciaf.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    private int id;
    private List<Product> productsSold = new ArrayList<>();
    private double totalSale;
    private LocalDateTime dateTime;

    public Sale(int id) {
        this.id = id;
        this.dateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(List<Product> productsSold) {
        this.productsSold = productsSold;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void addProduct(Product product, int stock){
        product.updateStock(-stock);
        productsSold.add(product);
        calculateTotalSale();
    }

    public Object calculateTotalSale(){
        totalSale = 0.0;
        for (Product product : productsSold){
            totalSale += product.getPrice();
        }
        return null;
    }
}
