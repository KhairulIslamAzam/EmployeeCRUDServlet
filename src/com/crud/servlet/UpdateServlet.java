package com.crud.servlet;

import com.crud.dao.EmployeeDao;
import com.crud.model.Employee;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String name= request.getParameter("name");
        String grade= request.getParameter("grade");
        String address= request.getParameter("address");
        String mobile= request.getParameter("mobile");
        String bankacc= request.getParameter("bankacc");

        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        e.setGrade(Integer.parseInt(grade));
        e.setAddress(address);
        e.setMobile(mobile);
        e.setBankacc(bankacc);

        int status = EmployeeDao.update(e);
        if(status>0) {
            response.sendRedirect("ViewServlet");
        }else {
            out.println("Sorry! Unable to update record");
        }

    }

}
