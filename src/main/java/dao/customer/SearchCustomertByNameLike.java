package dao.customer;

import db.dbConnection;
import models.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchCustomertByNameLike {
    public ArrayList<Customer> getProductLike(String name) {


        try {
            ArrayList<Customer> customers = new ArrayList<>();
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from customer where name LIKE '%" + name + "%'");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3));
                customers.add(customer);
            }
            return customers;

        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }


}
