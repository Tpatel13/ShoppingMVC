package controllers;

import dao.LoginDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class login extends javax.servlet.http.HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

    }

    protected void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session=request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        LoginDao login = new LoginDao();

        String[] data= login.checkLogin(email, password, type);

      try {

          HttpSession session = request.getSession();
          User user = new User();
          user.setId(Integer.parseInt(data[0]));
          user.setName(data[1]);
          user.setType(type);
          session.setAttribute("user", user);
          session.setAttribute("name", user.getName());
          response.sendRedirect("/" + type);
      }
      catch(Exception e) {
         response.sendRedirect("/login");
      }


    }

}
