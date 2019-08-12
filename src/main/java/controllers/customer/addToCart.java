package controllers.customer;

import dao.GetProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/addToCart")
public class addToCart extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();


        if (request.getSession() == null) {
            response.sendRedirect("login");
        }
        int productID = Integer.parseInt(request.getParameter("id"));

        HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");

        request.getSession().removeAttribute("cart");

        GetProduct product = new GetProduct();


        if (cart.containsKey(productID)) {
            System.out.println("updating product value");
            cart.put(productID, 1 + cart.get(productID));
        } else cart.put(productID, 1);

        float sum = 0.0f;
        for (float f : cart.values()) {
            sum += f;
        }

        System.out.println(sum);
        session.setAttribute("cart", cart);
        session.setAttribute("counter", cart.size());
        session.setAttribute("totalCounter", sum);

        response.sendRedirect("/customer");

    }
}
