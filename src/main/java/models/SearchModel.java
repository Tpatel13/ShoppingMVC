package models;

import java.util.ArrayList;

public class SearchModel {
    private ArrayList<Customer> customer;
    private ArrayList<Merchant> merchant;
    private ArrayList<Product> product;

    public SearchModel(ArrayList<Customer> customer, ArrayList<Merchant> merchant, ArrayList<Product> product) {
        this.customer = customer;
        this.merchant = merchant;
        this.product = product;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public ArrayList<Merchant> getMerchant() {
        return merchant;
    }

    public void setMerchant(ArrayList<Merchant> merchant) {
        this.merchant = merchant;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }


}
