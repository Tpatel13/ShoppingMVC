package models;

import java.io.PrintWriter;

public class Order {
    private int count;
    private Customer customer;
    private String orderID;
    private Product product;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    private Merchant merchant;
    public Order(Product product, int count, Customer customer,String orderID,Merchant merchant) {
        this.product= product;
        this.count = count;
        this.customer = customer;
        this.orderID=orderID;
        this.merchant=merchant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
