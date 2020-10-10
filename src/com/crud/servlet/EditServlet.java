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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Update User</h3>");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        Employee u = EmployeeDao.getInfoById(id);
        out.println("<form action='UpdateServlet' method='POST'>");
        out.println("<table>");
        out.println("<tr><td></td><td><input type='hidden' name='id' value='"+u.getId()+"' /></td></tr>");
        out.println("<tr><td>Name : </td><td><input type='text' name='username' value='"+u.getName()+"' /></td></tr>");
        out.println("<tr><td>Grade : </td><td><input type='text' name='email' value='"+u.getGrade()+"' /></td></tr>");
        out.println("<tr><td>Address : </td><td><input type='text' name='fullname' value='"+u.getAddress()+"' /></td></tr>");
        out.println("<tr><td>Mobile : </td><td><input type='text' name='password' value='"+u.getMobile()+"' /></td></tr>");
        out.println("<tr><td>BankAccount : </td><td><input type='text' name='phone' value='"+u.getBankacc()+"' /></td></tr>");
        out.println("<tr><td colspan='2'><input type='submit'  value='Update' /></td></tr>");
        out.println("</table>");
        out.println("</form>");

    }
}
