package com.cohort.nine.admission;

import com.cohort.nine.ailment.Ailment;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@WebServlet(
        name = "Admission",
        urlPatterns = "admission/list"
)
public class AdmissionList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Admission> admission = new ArrayList<Admission>();
        RequestDispatcher requestDispatcher;
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        try {
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from admit");
            while (resultSet.next()){
                admission.add(new Admission(resultSet.getInt(1),resultSet.getInt(6),resultSet.getString(2),
                        resultSet.getDate(3),resultSet.getDate(4),
                        resultSet.getString(5)));
            }
            req.setAttribute("admissiondata",admission);
            requestDispatcher=req.getRequestDispatcher("/admission.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
