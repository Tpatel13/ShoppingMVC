package dao;

import db.dbConnection;
import models.Product;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.UUID;

public class PostOrderDao {
    public boolean order(User user, HashMap<Product, Integer> products) {
        int userID = user.getId();
        String rID = UUID.randomUUID().toString();
        products.forEach((product, count) -> {

            try {
                Connection con = dbConnection.connect();
                PreparedStatement ps = con.prepareStatement("insert into orders (merchantID,customerID,orderID,productID,count) values(?,?,?,?,?)");
                ps.setInt(1, product.getMerchantID());
                ps.setInt(2, userID);
                ps.setString(3, rID);
                ps.setInt(4, product.getProductID());
                ps.setInt(5, count);
                ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }


        });


        return true;
    }
}
