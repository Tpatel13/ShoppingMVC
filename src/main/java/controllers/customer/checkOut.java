package controllers.customer;

import dao.GetProduct;
import dao.PostOrderDao;
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

@WebServlet("/checkOut")
public class checkOut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post checkout");
        HttpSession session = request.getSession();
        HashMap<Product, Integer> data = (HashMap<Product, Integer>) session.getAttribute("data");
        User user = (User) session.getAttribute("user");

        PostOrderDao post = new PostOrderDao();
        post.order(user, data);
        session.removeAttribute("cart");
        session.removeAttribute("counter");
        session.removeAttribute("totalCOunt");
        response.sendRedirect("/customer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (request.getSession() == null) {
            response.sendRedirect("login");
        }


        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        GetProduct product = new GetProduct();
        HashMap<Product, Integer> data = new HashMap<Product, Integer>();
        cart.forEach((k, v) -> {
            data.put(product.getProductByID(k), v);

        });

        session.setAttribute("data", data);

        RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");

        rd.forward(request, response);


    }
}
