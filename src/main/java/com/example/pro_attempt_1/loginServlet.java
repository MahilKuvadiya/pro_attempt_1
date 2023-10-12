package com.example.pro_attempt_1;

import com.example.pro_attempt_1.models.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "auth", value = "/auth")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("into the get method");

        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            System.out.println("in here");
            response.sendRedirect("chat");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("into the post method");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        User user = userService.findUser(username, password);
        User user = new User();
        String destPage = "auth";
        if (user != null) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
            destPage = "chat";
        }
        response.sendRedirect(destPage);
    }
}
