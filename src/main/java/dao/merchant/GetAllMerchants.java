package dao.merchant;

import db.dbConnection;
import models.Merchant;
import models.Product;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetAllMerchants {
    public ArrayList<Merchant> getMerchant(){

        try {

            ArrayList<Merchant> merchants = new ArrayList<>();
            Connection con = dbConnection.connect();


            PreparedStatement ps = null;
            ps = con.prepareStatement("select * from merchant");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Merchant p = new Merchant(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));

                merchants.add(p);
            }
           // System.out.println(merchants.size());
            return merchants;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
}
}
