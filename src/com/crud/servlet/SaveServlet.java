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
import java.sql.Connection;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {

    // HttpServlet is a base class for handling Http request and providing response
    // doPost method handles the POST request
    // request object provides the access to the request information for HTTP servlets
    // can write information about the data it will send back.

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // getParameter() -> to retrieve the input values from HTML page
        String name= request.getParameter("name");
        int grade=Integer.parseInt(request.getParameter("grade"));
        String address= request.getParameter("address");
        String mobile= request.getParameter("mobile");
        String bankacc= request.getParameter("bankacc");

        Employee e = new Employee();
        e.setName(name);
        e.setGrade(grade);
        e.setAddress(address);
        e.setMobile(mobile);
        e.setBankacc(bankacc);

        int status = EmployeeDao.save(e);
        //System.out.println(status);
        if(status>0) {
            out.print("<p> Record Saved Successfully</p>");
            request.getRequestDispatcher("index.html").include(request, response);

        }else {
            out.print("Sorry ! Unable to save record");
        }
        out.close();
    }

}
