package controllers.customer;

import dao.GetProduct;
import models.Product;

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


        HttpSession session=request.getSession();


        if(request.getSession()==null){
            response.sendRedirect("login");
        }
        int productID = Integer.parseInt(request.getParameter("id"));

        HashMap<Integer,Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");

        request.getSession().removeAttribute("cart");

        GetProduct product=new GetProduct();




        if(cart.containsKey(productID))
        {
            System.out.println("updating product value");


            System.out.println(productID+":::"+cart.get(productID));


            cart.put(productID,1+cart.get(productID));
        }

        else cart.put(productID,1);



        session.setAttribute("cart", cart);

        session.setAttribute("counter", cart.size());

        response.sendRedirect("/customer");

    }
}
