package org.ciaf.sale;

import org.ciaf.product.Product;

import java.util.Date;
import java.util.List;

public class Sale {
    private String id;
    private List<Product> productsSold;
    private double totalSale;
    private Date dateTime;

    public Sale(String id, List<Product> productsSold, double totalSale, Date dateTime) {
        this.id = id;
        this.productsSold = productsSold;
        this.totalSale = totalSale;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void addProduct(Product product){
        productsSold.add(product);
        calculateTotalSale();
    }

    private void calculateTotalSale(){
        totalSale = 0.0;
        for (Product product : productsSold){
            totalSale += product.getPrice();
        }
    }
}
