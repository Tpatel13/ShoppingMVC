package controllers.merchant;

import dao.product.DeleteProductByID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteProduct")
public class deleteProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        DeleteProductByID product = new DeleteProductByID();
        product.delete(Integer.parseInt(id));
        System.out.println(id);
        response.sendRedirect("/merchant");
    }
}
