<%@ page import="com.cohort.nine.ailment.Ailment"%>
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
        </head>

<body>
                <jsp:include page="navbar.jsp"/>

                <jsp:include page="general_header.jsp"/>

        <table>
        <thead>
        <tr>
        <th>Id</th>
        <th>Patient Id</th>
        <th>ailment</th>
        <th>Medicine</th>
        <th>test</th>
        <th>admitted</th>
        </tr>
        </thead>
        <tbody>
        <%List<Ailment> ailments=new ArrayList<Ailment>();
                 ailments=(List)request.getAttribute("ailmentdata");
        for (Ailment ailment:ailments){%>
            <tr>
            <td><%=ailment.getId()%></td>
            <td><%=ailment.getPatientId()%></td>
            <td><%=ailment.getAilment()%></td>
            <td><%=ailment.getMedicine()%></td>
            <td><%=ailment.getTest()%></td>
            <td><%=ailment.getAdmitted()%></td>
            </tr>
        <%}%>
        </tbody>
        </table>

</body>
</html>