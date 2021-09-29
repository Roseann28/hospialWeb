package com.cohort.nine.basicMeasurements;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "Basics",
        urlPatterns ="basics/form"
)

public class BasicForm extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter display = resp.getWriter();
        display.print("<html>");
        display.print("<head>");
        display.print("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n" +
                "     integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "     <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
        display.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">");
        display.print("<style>");
        display.print(" body{\n" +
                "            background-image: url(\"../images/hosipital.webp\");\n" +
                "            background-size: 1350px 800px;\n" +
                "            background-repeat: no-repeat;\n" +
                "        }");
        display.print(".inputform{\n" +
                "\n" +
                "             width: 700px;\n" +
                "             height: 500px;\n" +
                "             background-color: rgb(238, 238, 247,0.9);\n" +
                "             display: flex;\n" +
                "             margin-top: 70px;\n" +
                "             margin-bottom: 50px;\n" +
                "\n" +
                "         }");
        display.print("</style>");
        display.print("</head>");
        display.print("<body>");

        display.print("&nbsp");
        display.print("</br>");
        display.print("</br>");
        display.print("<section class=\"inputform\">");


        display.print("<h3>Basic Measurements</h3>\n"
                + "\n"
                + "<form action=\"./save\" method=\"POST\">\n");


            display.print("<hr/>");
            display.print("  <label for=\"IdLabel\">ID:</label></br>\n"
                    +"  <input type=\"text\" id=\"Id\" name=\"Id\"><br><br>\n"

                    + "  <label for=\"heightlabel\">Height:</label><br>\n"
                    + "  <input type=\"text\" id=\"height\" name=\"height\"><br>\n"

                    + "  <label for=\"weightLabel\">Weight:</label><br>\n"
                    + "  <input type=\"text\" id=\"weight\" name=\"weight\"><br><br>\n"

                    + "  <label for=\"bpLabel\">Blood pressure:</label><br>\n"
                    + "  <input type=\"text\" id=\"bp\" name=\"bp\"><br><br>\n");


        display.print("<input type=\"submit\" value=\"Submit\">\n"
                + "</form> ");
        display.print("</section>");
    }
}
