package controllers.merchant;

import dao.merchant.GetOrderDao;
import dao.merchant.GetProducts;
import models.Order;
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

@WebServlet(value = "/merchant/orders")
public class orders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = null;
        user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("/login");
        } else {
            GetOrderDao orders = new GetOrderDao();
            System.out.println(user.getName());
            ArrayList<Order> ordersList = orders.getOrders(user);
            ordersList.forEach(e -> {
                System.out.println(e.getCustomer().getName()+" ordered "+e.getProduct().getName());
            });
            request.setAttribute("orderList", ordersList);

            RequestDispatcher rd = request.getRequestDispatcher("orders.jsp");
            rd.forward(request, response);

        }
    }
}
