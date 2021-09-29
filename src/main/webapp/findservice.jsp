<%@ page import="com.cohort.nine.Finance.Find" %>
<html>
<body>
            <h3>Patients Form</h3>
                  <form action="./price" method="POST">
                  <% for (<%!int i=0%>; i<Find.entrymethod;i++){%>
                        <label for="serviceLabel">SERVICE:</label></br>
                        <input type="text" id="service" name="service">
                        <label for="quantitylabel">Quantity:</label><br>
                        <input type="number" id="quantity" name="quantity"><br>
                        <label for="pricelabel">Price:</label><br>
                        <input type="number" id="price" name="price"><br><br>
                  <%}%>

                <input type="submit" value="Submit">
            </form>





