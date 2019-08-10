package dao.merchant;

import db.dbConnection;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProduct {

    public void addProduct(Product product,int id){

        try {


            Connection con = dbConnection.connect();
            PreparedStatement pst = con.prepareStatement(" insert into products(name,price,info,merchantID) values(?,?,?,?)");
            pst.setString(1, product.getName());
            pst.setDouble(2, product.getPrice());
            pst.setString(3, product.getInfo());
            pst.setInt(4, id);
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}
