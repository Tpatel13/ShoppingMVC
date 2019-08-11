package controllers.customer;

import dao.customer.GetOrderByCustomerID;
import models.Product;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/customer/getOrders")
public class getOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user=(User)session.getAttribute("user");

        GetOrderByCustomerID orders=new GetOrderByCustomerID();
        ArrayList<Product> products=orders.orders(user.getId());
        request.setAttribute("products",products);
        RequestDispatcher rd = request.getRequestDispatcher("orders.jsp");
        rd.forward(request, response);;
    }
}
