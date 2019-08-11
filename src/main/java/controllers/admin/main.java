package controllers.admin;

import dao.customer.GetAllProducts;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin")
public class main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = null;
        user = (User) session.getAttribute("user");

        if (!user.getType().equals("admin")) {
            response.sendRedirect("/login");
        } else {

            request.setAttribute("products", new GetAllProducts().getAllProducts());
            RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
            rd.forward(request, response);

        }
    }
}
