package com.emp.filter;

import com.emp.enity.EmpManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/manager/safe/*")
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session= request.getSession();
        EmpManager empManager=(EmpManager) session.getAttribute("empManager");
        if (empManager!=null){
            filterChain.doFilter(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
    }

    @Override
    public void destroy() {

    }
}
