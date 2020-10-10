package com.crud.servlet;



import com.crud.dao.EmployeeDao;
import com.crud.dao.SalaryManager;
import com.crud.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<a href='index.html'>Add New Employee</a>");
        out.println("<h2>User List</h2>");
        List<Employee> list= EmployeeDao.getAll();
        out.println("<table border='1'>");
        out.println("<tr><th>Employee Name</th><th>Grade</th><th>Address</th><th>Phone</th><th>Bank Account</th><th>Salary</th><th colspan='2'>Action</th></tr>");
        for(Employee u : list) {
            SalaryManager salaryManager = new SalaryManager();
            double salary = salaryManager.calculateSalary(u.getGrade());
            out.println("<tr><td>"+u.getName()+"</td><td>"+u.getGrade()+"</td><td>"+u.getAddress()+"</td><td>"+u.getMobile()+"</td><td>"+u.getBankacc()+"</td><td>"+salary+"</td><td><a href='EditServlet?id="+u.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+u.getId()+"'>Delete</a></td></tr>");

        }
        out.println("</table>");
        out.close();
    }
}