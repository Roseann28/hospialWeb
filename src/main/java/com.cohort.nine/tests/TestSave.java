package com.cohort.nine.tests;

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
        name = "Test",
        urlPatterns = "test/save"
)

public class TestSave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {
                String query = "insert into test(testname,findings,patientId) values("
                        + "'" + req.getParameter("test") + "',"
                        + "'" + req.getParameter("finding") + "'," + Integer.valueOf(req.getParameter("pid")) + ")";
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../staffHome.jsp");

        }else {
            resp.sendRedirect("/test/form");
        }

    }

}

