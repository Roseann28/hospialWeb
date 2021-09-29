<%@ page import="com.cohort.nine.basicMeasurements.BasicMeasurements"%>
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
                    width: 75%
                }
       </style>

      <body>
                <jsp:include page="navbar.jsp"/>

                <jsp:include page="general_header.jsp"/>

        <table>
        <thead>
        <tr>
        <th>Id</th>
        <th>Height</th>
        <th>Weight</th>
        <th>Blood Pressure</th>
        </tr>
        </thead>
        <tbody>
        <%List<BasicMeasurements> basicMeasurements=new ArrayList<BasicMeasurements>();
                         basicMeasurements=(List)request.getAttribute("basicdata");
        for (BasicMeasurements measurements:basicMeasurements){%>
            <tr>
            <td><%=measurements.getId()%></td>
            <td><%=measurements.getHeight()%></td>
            <td><%=measurements.getWeight()%></td>
            <td><%=measurements.getBloddPressure()%></td>
            </tr>
        <%}%>
        </tbody>
        </table>

</body>
</html>