package com.cohort.nine.staffs;


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
        name = "stafflist",
        urlPatterns = "staffs/list"
)
public class StaffList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Staff> staff = new ArrayList<Staff>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");


        try {
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from staff");
            while (resultSet.next()){
                staff.add(new Staff(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4)));
            }
            req.setAttribute("staffdata",staff);
            requestDispatcher=req.getRequestDispatcher("/staff.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
