package com.cohort.nine.basicMeasurements;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(
        name = "Basic",
        urlPatterns ="/basics/save"
)
public class BasicSave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {
                String query="insert into basic(id,height,weight,bloodpressure)values("+Integer.valueOf(req.getParameter("Id"))+","+
                        Integer.valueOf(req.getParameter("height"))+","+
                        Integer.valueOf(req.getParameter("weight"))+",'"+req.getParameter("bp")+"')";
                System.out.println("@@@@@@@@@@@@ "+query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../staffHome.jsp");

        }else {
            resp.sendRedirect("/basics/form");
        }

            }


    }
