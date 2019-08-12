package dao.merchant;

import db.dbConnection;
import models.Merchant;
import models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchMerchantByNameLike {
    public ArrayList<Merchant> getProductLike(String name) {


        try {
            ArrayList<Merchant> merchants = new ArrayList<>();
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from merchant where name LIKE '%" + name + "%'");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Merchant merchant = new Merchant(rs.getInt(1), rs.getString(2), rs.getString(3));
                merchants.add(merchant);
            }
            ;
            return merchants;
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }


}
