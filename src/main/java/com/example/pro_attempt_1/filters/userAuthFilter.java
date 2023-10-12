package com.example.pro_attempt_1.filters;

import com.example.pro_attempt_1.models.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = { "/chat", "/urlPattern2" })
public class userAuthFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Doing filtering");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
            rd.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
