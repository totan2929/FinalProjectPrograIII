package org.ciaf.promotion;

import org.ciaf.product.Product;

import java.time.LocalDate;

public class Promotion {
    private Product product;
    private double discount;
    private LocalDate initDate;
    private LocalDate endDate;

    public Promotion(Product product, double discount, LocalDate initDate, LocalDate endDate) {
        this.product = product;
        this.discount = discount;
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public double applyDiscount(){
        return product.getPrice() * (1 - discount);
    }
}
