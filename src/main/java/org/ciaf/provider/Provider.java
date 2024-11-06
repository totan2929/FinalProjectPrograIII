package org.ciaf.provider;

import org.ciaf.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    private  int id;
    private String name;
    private List<Product> products = new ArrayList<>();

    public Provider( int id, String name){
        this.id=id;
        this.name=name;
    }

    public void  addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts(){
        return products;
    }
}
