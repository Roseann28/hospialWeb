package com.cohort.nine.basicMeasurements;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "Basicslist",
        urlPatterns = "/basics/list"
)
public class BasicList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BasicMeasurements> basicMeasurements = new ArrayList<BasicMeasurements>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        try {
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from basic");
            while (resultSet.next()){
                basicMeasurements.add(new BasicMeasurements(resultSet.getInt(1),
                        resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4)));
            }
            req.setAttribute("basicdata",basicMeasurements);
            requestDispatcher=req.getRequestDispatcher("/basic.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
        }





    }
}
