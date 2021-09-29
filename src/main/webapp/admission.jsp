<%@ page import="com.cohort.nine.admission.Admission"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<html>
<head>
        <style>
                table, th, td {
                    border: 1px solid black
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

        <body>
        <jsp:include page="navbar.jsp"/>

        <jsp:include page="general_header.jsp"/>

        <table>
        <thead>
        <tr>
        <th>Id</th>
        <th>Patient Id</th>
        <th>Room Number</th>
        <th>Date of admission</th>
        <th>Present Date</th>
        <th>progress</th>
        </tr>
        </thead>
        <tbody>
        <%List<Admission> admission=new ArrayList<Admission>();
                 admission=(List)request.getAttribute("admissiondata");
        for (Admission admissions:admission){%>
            <tr>
            <td><%=admissions.getId()%></td>
            <td><%=admissions.getPatientId()%></td>
            <td><%=admissions.getRoomNumber()%></td>
            <td><%=admissions.getDateOfAdmission()%></td>
            <td><%=admissions.getPresentDate()%></td>
            <td><%=admissions.getProgress()%></td>
            </tr>
        <%}%>
                </tbody>
                </table>

</body>

</html>
