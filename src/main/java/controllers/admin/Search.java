package controllers.admin;

import dao.SearchDao;
import dao.product.SearchProductByNameLike;
import models.Customer;
import models.Merchant;
import models.Product;
import models.SearchModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/admin/search")
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search");

        SearchDao s = new SearchDao();
        SearchModel data = s.search(search);



        request.setAttribute("customers", data.getCustomer());
        request.setAttribute("merchants",  data.getMerchant());
        request.setAttribute("products", data.getProduct());
        RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
        rd.forward(request, response);

    }
}
