package dao.merchant;

import dao.customer.GetCustomerByName;
import dao.product.GetProductByID;
import db.dbConnection;
import models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetOrderDao {

    public ArrayList<Order> getOrders(User user){

        ArrayList<Order> products = new ArrayList<Order>();


        try{
            Connection con = dbConnection.connect();

            GetMerchantByName merchantID=new GetMerchantByName();
            PreparedStatement ps = null;
            ps = con.prepareStatement("select customerID,productID,count,orderID,merchantID from orders where merchantID=?");

            ps.setInt(1,merchantID.getMerchantID(user.getName()));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                GetCustomerByName customerByID=new GetCustomerByName();
                GetProductByID productSearch=new GetProductByID();
                GetMerchantByID merchantSearch=new GetMerchantByID();
                Order p = new Order(productSearch.getProduct(rs.getInt(2)), rs.getInt(3), customerByID.getCustomer(rs.getInt(1)),rs.getString(4),merchantSearch.getMerchantID(rs.getInt(5)));
                products.add(p);
            }
            return products;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
