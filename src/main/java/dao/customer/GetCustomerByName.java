package dao.customer;

import db.dbConnection;
import models.Customer;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetCustomerByName {

    public Customer getCustomer(int id){

        try {
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from customer where id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Customer customer = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3));
                return customer;
            };

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
