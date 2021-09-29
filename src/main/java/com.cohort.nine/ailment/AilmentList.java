package com.cohort.nine.ailment;



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
        name = "Ailmentlist",
        urlPatterns = "/ailment/list"
)
public class AilmentList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ailment> ailments = new ArrayList<Ailment>();
        RequestDispatcher requestDispatcher;

        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        try {
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from ailment");
            while (resultSet.next()){
                ailments.add(new Ailment(resultSet.getInt(1),resultSet.getInt(6),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5)));
            }
            req.setAttribute("ailmentdata",ailments);
            requestDispatcher=req.getRequestDispatcher("/ailment.jsp");
            System.out.println("mmmmmmmmmmmmmmmmmmmmmm "+requestDispatcher);
            requestDispatcher.forward(req,resp);

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
