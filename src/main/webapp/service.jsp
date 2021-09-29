<%@ page import="com.cohort.nine.services.Service"%>
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
        </head>

        <body>
                        <jsp:include page="navbar.jsp"/>

                        <jsp:include page="general_header.jsp"/>


        <table>
        <thead>
        <tr>
        <th>Id</th>
        <th>Service</th>
        <th>quantity</th>
        <th>price</th>
        </tr>
        </thead>
        <tbody>
        <%List<Service> services=new ArrayList<Service>();
                        services=(List)request.getAttribute("servicedata");
        for (Service service:services){%>
            <tr>
            <td><%=service.getId()%></td>
            <td><%=service.getName()%></td>
            <td><%=service.getQuantity()%></td>
            <td><%=service.getPrice()%></td>
            </tr>
        <%}%>
 </tbody>
</table>
</body>
</html>