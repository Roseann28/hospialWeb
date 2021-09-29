package com.cohort.nine.phamarcyClearance;


import com.cohort.nine.util.BillClearance;

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
        name = "PharmacyList",
        urlPatterns = "/pharmacy/list"
)
public class PhamarcyList extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PhamarcyClearance> phamarcyClearances = new ArrayList<PhamarcyClearance>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        try {
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from pharmacy");
            while (resultSet.next()){
                phamarcyClearances.add(new PhamarcyClearance(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),
                        resultSet.getBigDecimal(4),BillClearance.valueOf(resultSet.getString(5))));
            }
            req.setAttribute("pharmacydata",phamarcyClearances);
            requestDispatcher=req.getRequestDispatcher("/pharmacy.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
