package dao.merchant;

import db.dbConnection;
import models.Merchant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetMerchantByID {
    public Merchant getMerchantID(int id) {

        try {

            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from merchant where id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Merchant merchant = new Merchant(rs.getInt(1), rs.getString(2), rs.getString(3));
                return merchant;

            }
            ;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
