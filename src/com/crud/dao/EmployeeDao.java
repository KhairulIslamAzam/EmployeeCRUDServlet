package com.crud.dao;

import com.crud.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public static Connection getConnection() {
        Connection con = null;
        String url= "jdbc:mysql://localhost:3306/employee_salary";
        String user="springstudent";
        String password="springstudent";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url, user, password);
            System.out.println("Database connected...");
        }catch(Exception e) {
            System.out.println(e);
        }

        return con;
    }
    //Data Insert into user table
    public static int save(Employee employee) {
        int status=0;
        try {
            Connection connection = EmployeeDao.getConnection();
            String sql="INSERT INTO employee (name,grade,address,mobile,bankacc) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1, employee.getName());
            p.setInt(2, employee.getGrade());
            p.setString(3, employee.getAddress());
            p.setString(4, employee.getMobile());
            p.setString(5, employee.getBankacc()); ;

            status = p.executeUpdate();
            connection.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return status;

    }
    public static List<Employee> getAll(){
        List<Employee> list = new ArrayList<>();
        try {
            Connection conection = EmployeeDao.getConnection();
            String sql="SELECT * FROM employee";
            PreparedStatement p = conection.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            while(rs.next()) {
                Employee u = new Employee();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setGrade(rs.getInt(3));
                u.setAddress(rs.getString(4));
                u.setMobile(rs.getString(5));
                u.setBankacc(rs.getString(6));

                list.add(u);


            }
            conection.close();

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    public static int delete(Employee u) {
        int status = 0;
        try {
            Connection connection = EmployeeDao.getConnection();
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, u.getId());
            status = p.executeUpdate();
            connection.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    public static Employee getInfoById(int id) {
        Employee u = new Employee();
        int status =0;
        try {
            Connection connection = EmployeeDao.getConnection();
            String sql = "SELECT * FROM employee WHERE id=?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            if(rs.next()) {
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setGrade(rs.getInt(3));
                u.setAddress(rs.getString(4));
                u.setMobile(rs.getString(5));
                u.setBankacc(rs.getString(6));
            }
            status = p.executeUpdate();
            connection.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return u;

    }

    public static int update(Employee employee) {
        int status = 0;
        try {
            Connection connection = EmployeeDao.getConnection();
            String sql = "update employee set name=?,grade=?,address=?,mobile=?,bankacc=? where id=?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, employee.getName());
            p.setInt(2, employee.getGrade());
            p.setString(3, employee.getAddress());
            p.setString(4, employee.getMobile());
            p.setString(5, employee.getBankacc()); ;
            p.setInt(6, employee.getId());

            status= p.executeUpdate();
            connection.close();

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }



}
