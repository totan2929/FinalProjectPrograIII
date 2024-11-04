package org.ciaf.product;

public class Product {
    private String id;
    private String name;
    private String description;
    private String price;
    private String stock;


    public Product(String id, String name, String description, String price, String stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id= ' " + id + '\'' +
                "name=' " + name + '\'' +
                ", description= ' " + description + '\'' +
                ", price= ' " + price + '\'' +
                ", stock= ' " + stock + '\'' +
                '}';
    }
}
