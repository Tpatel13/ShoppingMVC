package dao.customer;

import db.dbConnection;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetAllProducts {

    public ArrayList<Product> getAllProducts() {
        try {

            ArrayList<Product> products = new ArrayList<>();
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from products");


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product p = new Product(rs.getDouble(3), rs.getString(2), rs.getString(4),rs.getInt(1), rs.getInt(5));

                products.add(p);
            }

            return products;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;


    }

}
