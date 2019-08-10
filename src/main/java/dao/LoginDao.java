package dao;

import db.dbConnection;

import java.sql.*;

public class LoginDao {

    public String[] checkLogin(String email, String password, String type) {


        try {
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select id,name from `"+type+"` where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            String data[]=new String[2];
            while(rs.next()){
                data[0]=String.valueOf(rs.getInt(1));
                data[1]=rs.getString(2);
            };
            return data;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
