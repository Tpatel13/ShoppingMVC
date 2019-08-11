package dao.product;

import db.dbConnection;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteProductByID {
    public boolean delete(int id){
        try {
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("delete from products where id=?");
            ps.setInt(1, id);

           return ps.execute();



        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
