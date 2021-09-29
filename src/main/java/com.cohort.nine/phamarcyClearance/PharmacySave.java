package com.cohort.nine.phamarcyClearance;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet(
        name = "PharmacySave",
        urlPatterns = "pharmacy/save"
)
public class PharmacySave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {
                String query = "insert into pharmacy(id,drugservice,quantity,price,clear) values("
                        +req.getParameter("Id")+ ",'" + req.getParameter("drug") + "'," +
                        Integer.valueOf(req.getParameter("quantity")) + "," + new BigDecimal(req.getParameter("price")) +",'"+ req.getParameter("clear") + "')";
                System.out.println("ttttttttttt "+query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);


            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../staffHome.jsp");

        }else {
            resp.sendRedirect("/pharmacy/form");
        }

    }

}

