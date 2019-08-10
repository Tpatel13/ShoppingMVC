package controllers;

import dao.LoginDao;
import models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class login extends javax.servlet.http.HttpServlet {

    protected void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

      response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        LoginDao login = new LoginDao();

        String[] data= login.checkLogin(email, password, type);

        if (data!=null) {
            HttpSession session=request.getSession();
            User user=new User();
            user.setId(Integer.parseInt(data[0]));
            user.setName(data[1]);
            user.setType(type);
            session.setAttribute("user",user);
            response.sendRedirect("/" + type);
        }
        else  response.sendRedirect("/login");



    }

}
