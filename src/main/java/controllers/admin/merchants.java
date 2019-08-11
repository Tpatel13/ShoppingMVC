package controllers.admin;

import dao.merchant.GetAllMerchants;
import dao.merchant.GetProducts;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value="/merchants")
public class merchants extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = null;
        user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("/login");
        } else {
            GetAllMerchants merchants = new GetAllMerchants();


            request.setAttribute("merchants", merchants.getMerchant());


            RequestDispatcher rd = request.getRequestDispatcher("merchants.jsp");
            rd.forward(request, response);

        }
    }
}
