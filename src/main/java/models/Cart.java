package models;

import java.util.HashMap;

public class Cart {

    private HashMap<Integer,Integer> products=new HashMap<>();

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Integer> products) {
        this.products = products;
    }
}
