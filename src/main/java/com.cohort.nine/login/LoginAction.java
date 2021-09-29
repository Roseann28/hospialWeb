package com.cohort.nine.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(
        name = "login",
        urlPatterns = "/login"
)
public class LoginAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        String id=req.getParameter("Id");
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkk "+id);


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from staffregister where staffid="+"'"+id+"'");
            String actualpassword = null;
            String staffName = null;
            while (resultSet.next()){
                actualpassword=resultSet.getString("password");
                staffName=resultSet.getString("name");
            }
            System.out.println("sssssssssssssssssssss  "+actualpassword);
            if (actualpassword.equals(req.getParameter("pass"))){
                session.setAttribute("staffname",staffName);
                requestDispatcher=req.getRequestDispatcher("./staffHome.jsp");
            }else{
                session.setAttribute("message","Invalid Login credentials");
                requestDispatcher=req.getRequestDispatcher("./login.jsp");
            }


        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("message","Invalid Login credentials");
            requestDispatcher=req.getRequestDispatcher("./login.jsp");
        }
        requestDispatcher.forward(req,resp);


    }
}
