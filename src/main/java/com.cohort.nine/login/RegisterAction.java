package com.cohort.nine.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(
        name = "Register",
        urlPatterns = "/register"
)
public class RegisterAction extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter display = resp.getWriter();
        display.print("<html>");
        display.print("<head>");
        display.print("<style>\n" +
                "        body{\n" +
                "            background-image: url(\"./images/hosipital.webp\");\n" +
                "            background-size: 1350px 800px;\n" +
                "            background-repeat: no-repeat;\n" +
                "        }\n" +
                "         .bg-image{\n" +
                "             background-color: black;\n" +
                "             background-size: cover;\n" +
                "             background-color: rgba(0,0,0, 0.6);\n" +
                "         }\n" +
                "         #logo{\n" +
                "             margin-left: 50px;\n" +
                "             padding: 5px;\n" +
                "         }\n" +
                "         .sign-up-form{\n" +
                "\n" +
                "             width: 700px;\n" +
                "             height: 500px;\n" +
                "             background-color: rgb(238, 238, 247,0.9);\n" +
                "             display: flex;\n" +
                "             margin-top: 70px;\n" +
                "             margin-bottom: 50px;\n" +
                "\n" +
                "         }\n" +
                "         form{\n" +
                "             margin: 50px;\n" +
                "             margin-top: 70px;\n" +
                "             text-align: center;\n" +
                "         }\n" +
                "         form h3{\n" +
                "             margin-bottom: 70px;\n" +
                "         }\n" +
                "         form button{\n" +
                "             margin-top: 50px;\n" +
                "             background-color:rgb(0, 26, 255) ;\n" +
                "             border: none;\n" +
                "             color: white;\n" +
                "             padding: 5px 10px;\n" +
                "             border-radius: 8px;\n" +
                "\n" +
                "\n" +
                "         }\n" +
                "\n" +
                "         form a{\n" +
                "            margin-top: 30px;\n" +
                "         }\n" +
                "         button :hover{\n" +
                "             background-color: rgb(228, 189, 13);\n" +
                "         }\n" +
                "         .input-container {\n" +
                "             display: flex;\n" +
                "\n" +
                "           }\n" +
                "           .input-field {\n" +
                "             width: 100%;\n" +
                "             padding: 10px;\n" +
                "             outline: none;\n" +
                "           }\n" +
                "           .icon{\n" +
                "             margin-top: 9px;\n" +
                "           }\n" +
                "         input{\n" +
                "             margin: 10px;\n" +
                "             padding-left: 20px;\n" +
                "             border: none;\n" +
                "         }\n" +
                "         input :hover{\n" +
                "             border: 2px solid rgb(0, 26, 255) ;\n" +
                "         }\n" +
                "         .sign-up-form img{\n" +
                "             width: 400px;\n" +
                "             height: 400px;\n" +
                "\n" +
                "         }\n" +
                "         .sign-form{\n" +
                "         display: flex;\n" +
                "         justify-content: space-around;\n" +
                "         }\n" +
                "   </style>");

        display.print("</head>");
        display.print("<body>");

        display.print("&nbsp");
        display.print("</br>");
        display.print("</br>");

        display.print("<div class=\"sign-form\">\n" +
                "         <section class=\"sign-up-form\">");

        display.print("<h3>Register</h3>\n"
                + "\n"
                + "<form action=\"./register\" method=\"POST\">\n");

        display.print("<hr/>");
        display.print("<div class=\"input-container\">");
        display.print("  <label for=\"IdLabel\">Staff ID:</label></br>\n"
                +"  <input type=\"text\" id=\"staffId\" name=\"staffId\"><br><br>\n"
                +"</div>"

                +"<div class=\"input-container\">"
                +"<label for=\"NameLabel\">Enter your name:</label></br>\n"
                +"  <input type=\"text\" id=\"name\" name=\"name\"><br><br>\n"
                +"</div>"


                +"<div class=\"input-container\">"

                + "  <label for=\"passwordlabel\">Password:</label><br>\n"
                + "  <input type=\"password\" id=\"pass\" name=\"pass\"><br>\n"
                +"</div>"
        );

        display.print("<input type=\"submit\" value=\"Submit\">\n"
                + "</form> ");
        display.print("<img src=\"./images/login.png\">\n" +
                "\n" +
                "\n" +
                "          </section>\n" +
                "        </div>");
        display.print("</body>");
        display.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");
        RequestDispatcher requestDispatcher;


        if (connection!=null){
            try {
                String q="insert into staffregister(password,name,staffid) values ("+"'"+req.getParameter("pass")+"',"+
                        "'"+req.getParameter("name")+"',"+"'"+req.getParameter("staffId")+"')";
                System.out.println(q);
                Statement statement = connection.createStatement();
                statement.executeUpdate(q);


            } catch (SQLException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("./login.jsp");

        }else {
            resp.sendRedirect("./register");
        }

    }

}
