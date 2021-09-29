package com.cohort.nine.services;

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
        name = "SaveService",
        urlPatterns = "/service/save"
)
public class SaveService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {
                String query = "insert into service(name,quantity,price) values("
                        + "'"+req.getParameter("service")+"'," + Integer.valueOf(req.getParameter("quantity")) + "," +
                         Integer.valueOf(req.getParameter("price")) +")";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../staffHome.jsp");

        }else {
            resp.sendRedirect("/service/add");
        }
    }
}
