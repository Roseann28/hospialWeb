package com.cohort.nine.Finance;


import com.cohort.nine.patients.Patient;
import com.cohort.nine.services.Service;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "findservices",
        urlPatterns = "/findservice"
)
public class FindService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter display = resp.getWriter();

        display.print("<html>");
        display.print("<body>");
        display.print("<h3>Service</h3>");
        display.print("<form action=\"./findservice\" method=\"POST\">");
            display.print("<label for=\"patientLabel\">Patient ID:</label></br>");
            display.print("<input type=\"text\" id=\"pid\" name=\"pid\"></br></br>");
            display.print("<label for=\"serviceLabel\">SERVICE:</label></br>");
            display.print("<input type=\"text\" id=\"service\" name=\"service\"></br></br>");
            display.print("<label for=\"quantitylabel\">Quantity:</label><br>");
            display.print("<input type=\"text\" id=\"quantity\" name=\"quantity\"><br></br>");

        display.print("<input type=\"submit\" value=\"Submit\">");
        display.print("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String services=req.getParameter("service");
        String amount=req.getParameter("quantity");
        int patientId=Integer.valueOf(req.getParameter("pid"));
        List<List<Finances>> bill=new ArrayList<>();
        List<Finances> financesList = new ArrayList<Finances>();
        String[]serviceArray=services.split(",");
        String[]quantityArray=amount.split(",");

        Connection connection= (Connection) req.getServletContext().getAttribute("sqlcon");

        for (int i=0;i<serviceArray.length;i++){
            try {
                Statement statement= connection.createStatement();
                ResultSet resultSet= statement.executeQuery("select * from service where name="+"'"+serviceArray[i]+"'");
                while (resultSet.next()){
                    System.out.println("hhhhhhhhhhhhhhh "+quantityArray[i]);
                    financesList.add(new Finances(resultSet.getString(2),
                            resultSet.getInt(3),resultSet.getBigDecimal(4).multiply(new BigDecimal(quantityArray[i]))));
                }
                bill.add(financesList);
                /*createReceipt(bill);*/

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        System.out.println(bill.get(0).get(0).getFee());
        System.out.println(bill.get(1).get(1).getFee());
        BigDecimal sum= new BigDecimal(0.00);
        List<List<BigDecimal>> finaltotal=new ArrayList<>();
        List<BigDecimal>sumList=new ArrayList<BigDecimal>();
        /*PrintWriter printWriter=resp.getWriter();
        printWriter.println("<html>");

        printWriter.println("<head>");
        printWriter.println("<style>"
                + "table, th, td {"
                + "  border: 1px solid black"
                + "  height:50px"
                + "  width: 100%;"
                + "  border-collapse: collapse;"
                + "  background-color: white;"
                + "}"
                +"body{"
                +"background-color: green;"
                +"}"
                +"table{"
                +"width: 75%"
                +"}"
                + "</style>");
        printWriter.println("</head>");

        printWriter.println("<body>");
        printWriter.println("<h1>RAM Hospital</h1>");
        printWriter.println("<h2>Service to all</h2>");
        printWriter.println("<table>");
        printWriter.println("<thead>");
        printWriter.println("<tr>");
        printWriter.println("<th>Service</th>");
        printWriter.println("<th>quantity</th>");
        printWriter.println("<th>Price</th>");
        printWriter.println("<th>Total bill</th>");
        printWriter.println("</tr>");
        printWriter.println("</thead>");
        printWriter.println("<tbody>");*/

        Files.deleteIfExists(Paths.get("C:\\Users\\NJENGA\\IdeaProjects\\HospitalWeb\\src\\main\\java\\com.cohort.nine\\Finance\\receipts.txt"));
        File filename=new File("C:\\Users\\NJENGA\\IdeaProjects\\HospitalWeb\\src\\main\\java\\com.cohort.nine\\Finance\\receipts.txt");
        filename.createNewFile();
        FileWriter fileWriter=new FileWriter(filename,true);
        fileWriter.write("Service quantity price total");
        fileWriter.write('\n');
        for (int i=0;i<bill.size();i++){
            /*printWriter.println("<tr>");
            printWriter.println("<td>"+bill.get(i).get(i).getService()+"</td>");
            printWriter.println("<td>"+quantityArray[i]+"</td>");
            printWriter.println("<td>"+bill.get(i).get(i).getFee()+"</td>");*/
            /*printWriter.println("<td>"+sum+"</td>");
            printWriter.println("</tr>");*/

            sum=(bill.get(i).get(i).getFee().add(sum));
            fileWriter.write(bill.get(i).get(i).getService());
            fileWriter.write("  ");
            fileWriter.write(quantityArray[i]);
            fileWriter.write("  ");
            fileWriter.write(String.valueOf(bill.get(i).get(i).getFee()));
            fileWriter.write("  ");
            fileWriter.write(String.valueOf(sum));
            fileWriter.write('\n');
            sumList.add(sum);
            finaltotal.add(sumList);
        }
        System.out.println("lllllllllllllll "+bill);

        fileWriter.close();
        req.setAttribute("billlist",bill);
        req.setAttribute("id",patientId);
        req.setAttribute("totallist",finaltotal);
        requestDispatcher=req.getRequestDispatcher("/bill.jsp");
        requestDispatcher.forward(req,resp);


        /*printWriter.println("</tbody>");
        printWriter.println("</table>");
        printWriter.println("<a href=\"http://localhost:8080/HospitalWeb/patients\">\n" +
                "       <button>Next</button>\n" +
                "     </a>");
        printWriter.println("</body>");
        printWriter.println("</html>");*/

    }
    public void createReceipt(List<List<Service>> receipt){
        try {
            File filename=new File("receipt.txt");
            FileWriter fileWriter=new FileWriter(filename);
            for (int i=0;i<receipt.size();i++){
                Service serve=new Service(receipt.get(i).get(i).getId(),receipt.get(i).get(i).getName(),receipt.get(i).get(i).getQuantity(),
                        receipt.get(i).get(i).getPrice());
                for (int j=0;j<serve.toString().length();j++){
                    System.out.println("jjjj  "+serve.toString().charAt(j));
                    fileWriter.write(serve.toString().charAt(j));
                }
                char newLine = '\n';
                fileWriter.write(newLine);
                fileWriter.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
