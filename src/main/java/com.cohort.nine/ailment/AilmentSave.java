package com.cohort.nine.ailment;

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
        name = "AilmentSave",
        urlPatterns = "ailment/save"
)
public class AilmentSave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {
                String query="insert into ailment(patientid,sickness,drugs,test,admit)values("+Integer.valueOf(req.getParameter("Id"))
                        +",'"+req.getParameter("ailment")+"',"+"'"+req.getParameter("med")+"',"+"'"+req.getParameter("test")+"',"
                        +"'"+req.getParameter("admit")+"')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
                }
            resp.sendRedirect("../staffHome.jsp");
            }else {
            resp.sendRedirect("/ailment/form");
            }

    }

}
