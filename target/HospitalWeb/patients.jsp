<%@ page import="com.cohort.nine.patients.Patient"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<html>
<head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU crossorigin=anonymous">
      <style>
                table, th, td {
                    border: 10px solid black
                    height:50px
                    width: 100%;
                    border-collapse: collapse;
                    background-color: white;
                }
                body{
                    background-color: green;
                }
                table{
                    width: 75%
                }
      </style>
</head>

 <body>
        <jsp:include page="navbar.jsp"/>

        <jsp:include page="general_header.jsp"/>


        <table>
        <thead>
        <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>NationalId</th>
        <th>Payment Method</th>
        </tr>
        </thead>
        <tbody>
        <%List<Patient> patients=new ArrayList<Patient>();
         patients=(List)request.getAttribute("patientdata");
         for (Patient patient:patients){%>
            <tr>
            <td><%=patient.getId()%></td>
            <td><%=patient.getName()%></td>
            <td><%=patient.getEmail()%></td>
            <td><%=patient.getNationalId()%></td>
            <td><%=patient.getPaymentMethod()%></td>
            </tr>
        <%}%>
        </tbody>
        </table>

        </body>
        </html>
</html>
