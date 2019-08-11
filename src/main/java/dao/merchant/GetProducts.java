package dao.merchant;

import db.dbConnection;
import models.Product;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetProducts {

    public ArrayList<Product> getProducts(User user){

        try {

            ArrayList<Product> products = new ArrayList<>();
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select name,price,info,id from products where merchantID=?");
            ps.setInt(1, user.getId());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product p = new Product(rs.getDouble(2), rs.getString(1), rs.getString(3),rs.getInt(4));

                products.add(p);
            }
            ;
            return products;

        } catch (Exception e) {
            e.printStackTrace();

        }
return null;


    }
}
