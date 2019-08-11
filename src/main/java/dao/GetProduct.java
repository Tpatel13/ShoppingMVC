package dao;

import db.dbConnection;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetProduct {

    public Product getProductByID(int id){

        try {
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from products where id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Product p = new Product(rs.getDouble(3), rs.getString(2), rs.getString(4),rs.getInt(1), rs.getInt(5));
                return p;
            };

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
