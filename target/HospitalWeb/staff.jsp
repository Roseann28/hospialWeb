<%@ page import="com.cohort.nine.staffs.Staff"%>
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
        <th>StaffId</th>
        <th>Name</th>
        <th>Department</th>
        <th>password</th>
        </tr>
        </thead>
        <tbody>
        <%List<Staff> staff=new ArrayList<Staff>();
                                         staff=(List)request.getAttribute("staffdata");
        for (Staff staff1:staff){%>
            <tr>
            <td><%=staff1.getStaffId()%></td>
            <td><%=staff1.getName()%></td>
            <td><%=staff1.getDepartment()%></td>
            <td><%=staff1.getPassword()%></td>
            </tr>
        <%}%>
 </tbody>
</table>
</body>
</html>