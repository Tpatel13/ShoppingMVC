package controllers.admin;

import dao.adminDao.GetAllOrders;
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

@WebServlet(value = "/admin/orders")
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


            request.setAttribute("orderList", new GetAllOrders().getOrders());

            RequestDispatcher rd = request.getRequestDispatcher("orders.jsp");
            rd.forward(request, response);
        }
    }
}
