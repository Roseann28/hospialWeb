package com.cohort.nine.staffs;

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
        name ="Staffsave",
        urlPatterns ="staffs/save"
)

public class StaffSave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {

                String query = "insert into staff(name,department,password) values("
                         + "'" + req.getParameter("name") + "'," +
                        "'" + req.getParameter("department")+ "'," + "'" + req.getParameter("password") + "')";
                System.out.println("ttttttttttttttttttttttttttttttt "+query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../staffHome.jsp");

        }else {
            resp.sendRedirect("/staffs/form");
        }
    }

}
