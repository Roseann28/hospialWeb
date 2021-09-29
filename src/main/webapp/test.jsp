<%@ page import="com.cohort.nine.tests.Tests"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<html>

        <head>


        <style>
                table, th, td {
                  border: 1px solid black;
                  height:50px;
                  width: 100%;
                  border-collapse: collapse;
                  background-color: white;
                }
                body{
                    background-color: green;
                }
                table{
                width: 75%;
                }
         </style>

<body>
                        <jsp:include page="navbar.jsp"/>

                        <jsp:include page="general_header.jsp"/>

<table>
        <thead>
        <tr>
        <th>Id</th>
        <th>Patient Id</th>
        <th>TestName</th>
        <th>Finding</th>
        </tr>
        </thead>
        <tbody>
        <%List<Tests> tests=new ArrayList<Tests>();
                   tests=(List)request.getAttribute("testdata");
        for (Tests tests1:tests){%>
            <tr>
            <td><%=tests1.getId()%></td>
            <td><%=tests1.getPatientId()%></td>
            <td><%=tests1.getTestName()%></td>
            <td><%=tests1.getFinding()%></td>
            </tr>
        <%}%>
  </tbody>
</table>
</body>
</html>