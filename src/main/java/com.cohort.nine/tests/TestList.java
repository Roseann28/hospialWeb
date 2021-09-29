package com.cohort.nine.tests;



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
        name = "Testlist",
        urlPatterns = "test/list"
)
public class TestList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tests> tests = new ArrayList<Tests>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        try {
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from test");
            while (resultSet.next()){
                tests.add(new Tests(resultSet.getInt(1),resultSet.getInt(4),resultSet.getString(2),
                        resultSet.getString(3)));
            }
            req.setAttribute("testdata",tests);
            requestDispatcher=req.getRequestDispatcher("/test.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
