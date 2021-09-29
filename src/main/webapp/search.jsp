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
        <th>Name</th>
        <th>Test name</th>
        <th>Test results</th>
        <th>Admit</th>
        <th>Date of Admission</th>
        </tr>
        </thead>
        <tbody>
        <tr>
        <%List<String> patient=new ArrayList<String>();
                     patient=(List)request.getAttribute("searchdata");
        for (int i=0;i<patient.size();i++){%>
            <td><%=patient.get(i)%></td>


        <%}%>
        </tr>
        </tbody>
      </table>
</body>
</html>