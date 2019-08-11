package dao.product;

import db.dbConnection;
import models.Customer;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetProductByID {

    public Product getProduct(int id){

        try {
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from products where id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product product = new Product(rs.getInt(1),rs.getString(2),rs.getString(3));
                return product;
            };

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}