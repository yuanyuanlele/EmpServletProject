package com.emp.jsp;

import com.emp.enity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/manager/safe/showallEmpJsp")
public class showallEmpJsp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> emps=(List<Emp>) req.getAttribute("emps");
        PrintWriter printWriter=resp.getWriter();
        printWriter.println("<html>");
        printWriter.println(    "<head>");
        printWriter.println(    "<title>查询所有员工页面</title>");
        printWriter.println(    "</head>");
        printWriter.println(    "<body>");
        printWriter.println(        "<table border='1'>");
        printWriter.println(        "<tr>");
        printWriter.println(        "<td>编号</td>");
        printWriter.println(        "<td>姓名</td>");
        printWriter.println(        "<td>工资</td>");
        printWriter.println(        "<td>年龄</td>");
        printWriter.println(        "<td colspan='2'>操作</td>");
        printWriter.println(        "</tr>");
        for (Emp emp:emps){
            printWriter.println(        "<tr>");
            printWriter.println(        "<td>"+emp.getId()+"</td>");
            printWriter.println(        "<td>"+emp.getName()+"</td>");
            printWriter.println(        "<td>"+emp.getSalary()+"</td>");
            printWriter.println(        "<td>"+emp.getAge()+"</td>");
            printWriter.println(        "<td>删除</td>");
            printWriter.println(        "<td>修改</td>");
            printWriter.println(        "</tr>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
