package controllers.customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/addToCart")
public class addToCart extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String productID = request.getParameter("id");
        HashMap<Integer,Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");
        request.getSession().removeAttribute("cart");
        System.out.println(cart.containsValue(Integer.parseInt(productID)));
        if(cart.containsValue(Integer.parseInt(productID))){
            Integer i=cart.get(Integer.parseInt(productID))+1;
            cart.put(Integer.parseInt(productID),i);
        }
        else cart.put(Integer.parseInt(productID),1);

        session.setAttribute("cart", cart);
        session.setAttribute("counter", cart.size());
        response.sendRedirect("/customer");

    }
}
