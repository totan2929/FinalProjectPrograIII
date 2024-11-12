package org.ciaf.product;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;


    public Product(int id, String name, String description, double price, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public double getPrice() {
        return price;
    }


    public int getStock() {
        return stock;
    }



    public void updateStock(int stock){
        this.stock += stock;
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
