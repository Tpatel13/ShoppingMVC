package dao;

import db.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class RegisterDao {

    public boolean addUser(String name, String password, String email, String type) {


        try {


            Connection con = dbConnection.connect();
            PreparedStatement pst = con.prepareStatement(" insert into `" + type + "`(name,password,email) values(?,?,?)");
            pst.setString(1, name);
            pst.setString(2, password);
            pst.setString(3, email);
            pst.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;


    }
}
