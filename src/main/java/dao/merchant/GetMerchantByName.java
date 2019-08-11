package dao.merchant;

import db.dbConnection;
import models.Customer;
import models.Merchant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetMerchantByName {
    public int getMerchantID(String name){

        try {
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select id from merchant where name=?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
//                Merchant merchant = new Merchant(rs.getInt(1),rs.getString(2),rs.getString(3));
//                return merchant;
                return rs.getInt(1);
            };

        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }
}
