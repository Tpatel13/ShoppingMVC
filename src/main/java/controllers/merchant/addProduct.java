package controllers.merchant;

import dao.merchant.AddProduct;
import models.Product;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/addProduct")
public class addProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("productName");
        String price = request.getParameter("productPrice");
        String info = request.getParameter("productInfo");

        HttpSession user = request.getSession();
        Product p = new Product(Double.parseDouble(price), productName, info);
        User user1 = (User) user.getAttribute("user");

        AddProduct add = new AddProduct();

        add.addProduct(p,user1.getId());

        response.sendRedirect("/merchant");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
