package com.cohort.nine.services;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@WebServlet(
        name = "serviceList",
        urlPatterns = "/service/list"
)
public class ServiceList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Service> service = new ArrayList<Service>();
        Connection connection = (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from service");
            while (resultSet.next()) {
                service.add(new Service(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getBigDecimal(4)));
            }
            req.setAttribute("servicedata",service);
            requestDispatcher=req.getRequestDispatcher("/service.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
