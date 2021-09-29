<%@ page import="com.cohort.nine.phamarcyClearance.PhamarcyClearance"%>
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
        <th>Drug or service</th>
        <th>quantity</th>
        <th>price</th>
        <th>Bill Clearance</th>
        </tr>
        </thead>
        <tbody>
        <%List<PhamarcyClearance> phamarcyClearances=new ArrayList<PhamarcyClearance>();
                                 phamarcyClearances=(List)request.getAttribute("pharmdata");
        for (PhamarcyClearance phamarcyClearance:phamarcyClearances){%>
            <tr>
            <td><%=phamarcyClearance.getId()%></td>
            <td><%=phamarcyClearance.getDrugOrService()%></td>
            <td><%=phamarcyClearance.getQuantity()%></td>
            <td><%=phamarcyClearance.getPrice()%></td>
            <td><%=phamarcyClearance.getClearedbill()%></td>
            </tr>
        <%}%>
        </tbody>
      </table>
</body>
</html>