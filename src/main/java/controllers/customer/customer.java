package controllers.customer;

import dao.customer.GetAllProducts;
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
import java.util.HashMap;

@WebServlet(value = "/customer")
public class customer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        User user = null;
        user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("/login");
        } else {


            if (request.getSession() == null) {
                response.sendRedirect("login");
            }

            if (session.getAttribute("cart") == null) {
                session.setAttribute("cart", new HashMap<Integer, Integer>());
            }

            GetAllProducts products = new GetAllProducts();

            request.setAttribute("products", products.getAllProducts());

            RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");

            rd.forward(request, response);

        }
    }
}
