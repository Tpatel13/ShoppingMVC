package dao.product;

import db.dbConnection;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchProductByNameLike {
    public ArrayList<Product> getProductLike(String name) {


        try {
            ArrayList<Product> products = new ArrayList<>();
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from products where name LIKE '%"+name+"%'");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getInt(3), rs.getString(2), rs.getString(4));
                products.add(product);
            }
            ;
            return products;
        } catch (Exception e) {
            e.printStackTrace();

        }

return null;
    }


}
