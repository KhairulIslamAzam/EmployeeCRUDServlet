package com.crud.servlet;

import com.crud.dao.EmployeeDao;
import com.crud.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        Employee u = new Employee();
        u.setId(id);
        EmployeeDao.delete(u);
        response.sendRedirect("ViewServlet");
    }


}
