package com.cohort.nine.admission;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

@WebServlet(
        name = "AdmitSave",
        urlPatterns = "admission/save"
)

public class AdmissionSave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/dd/MM");


        if (connection!=null){
            try {
                String query="insert into admit(roomnumber,dateOfAdmission,presentdate,progress,patientId)values("
                        +"'"+req.getParameter("roomno")+"',"+"'"+ (req.getParameter("doa")) +"',"+"'"+(req.getParameter("present"))+"',"
                        +"'"+(req.getParameter("progress"))+"',"+Integer.valueOf(req.getParameter("pid"))+")";
                System.out.println("aaaaaaaaaaaaaa "+query);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect("../staffHome.jsp");
        }else {
            resp.sendRedirect("/admission/form");
        }


    }
}
