package com.example.pro_attempt_1;

import com.example.pro_attempt_1.models.User;
import com.example.pro_attempt_1.services.userService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "auth", value = "/auth")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            response.sendRedirect("chat");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " "+ password);
        userService getUser = new userService();
        User user = null;
        try {
            user = getUser.findByUserNameAndPassword(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String destPage = "auth";
        if (user != null) {
            System.out.println(user.getUsername()+"hiiiiii");
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
            destPage = "chat";
        }
        response.sendRedirect(destPage);
    }
}
