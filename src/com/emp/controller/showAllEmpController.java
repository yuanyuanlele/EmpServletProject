package com.emp.controller;

import com.emp.enity.Emp;
import com.emp.service.EmpService;
import com.emp.service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/manager/safe/showAllEmpController")
public class showAllEmpController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmpService empService=new EmpServiceImpl();
        List<Emp> emps=empService.showallEmp();
        req.setAttribute("emps",emps);
        req.getRequestDispatcher("/manager/safe/showallEmpJsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
