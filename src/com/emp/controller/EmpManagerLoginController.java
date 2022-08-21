package com.emp.controller;

import com.emp.enity.EmpManager;
import com.emp.service.EmpManagerService;
import com.emp.service.Impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/manager/EmpManagerLoginController")
public class EmpManagerLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String inputVcode=req.getParameter("inputVcode");
        HttpSession session= req.getSession();
        String codes=(String)session.getAttribute("codes");
        if (!inputVcode.isEmpty()&&inputVcode.equalsIgnoreCase(codes)){
            EmpManagerService empManagerService=new EmpManagerServiceImpl();
            EmpManager empManager=empManagerService.login(username,password);
            if (empManager!=null){
                session.setAttribute("empManager",empManager);
                resp.sendRedirect(req.getContextPath()+"/manager/showAllEmpController");
            }else {
                resp.sendRedirect(req.getContextPath()+"/login.html");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
