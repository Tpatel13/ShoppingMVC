package dao.customer;

import dao.GetProduct;
import dao.product.GetProductByID;
import db.dbConnection;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetOrderByCustomerID {
    public ArrayList<Product> orders(int id) {
        try {

            ArrayList<Product> products = new ArrayList<>();
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select productID from orders where customerID=?");


            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                GetProductByID product=new GetProductByID();




                Product p =product.getProduct(rs.getInt(1));
                products.add(p);
            }

            return products;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
