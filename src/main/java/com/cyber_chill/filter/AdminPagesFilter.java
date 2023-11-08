package com.cyber_chill.filter;


import com.cyber_chill.entity.User;
import com.cyber_chill.entity.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/reserve-info")
public class AdminPagesFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null && user.getRole() == UserRole.ADMIN) {

            filterChain.doFilter(request, response);
        } else {

            response.sendRedirect("/");
        }
    }

    private boolean checkAdminRole(ServletRequest request) {
        return false;
    }

    @Override
    public void destroy() {

    }
}