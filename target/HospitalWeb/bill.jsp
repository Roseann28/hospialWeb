<%@ page import="com.cohort.nine.Finance.Finances"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="java.math.BigDecimal"%>

<jsp:useBean id = "bills" class = "com.cohort.nine.Finance.Finances">
    <% int patientId=(Integer)request.getAttribute("id");%>
    <jsp:setProperty name="bills" property="patientId" value="<%=patientId%>"/>
    <jsp:getProperty name="bills" property="patientId"/><br/>
    <% List<List<Finances>> finances=new ArrayList<>();
    List<Finances> finance=new ArrayList<Finances>();
    finances.add(finance);
    finances=(List)request.getAttribute("billlist");
    List<List<BigDecimal>> finaltotallist=new ArrayList<>();
        List<BigDecimal> total=new ArrayList<BigDecimal>();
        finaltotallist.add(total);
        finaltotallist=(List)request.getAttribute("totallist");

    for (int i=0;i<finances.size();i++){%>

            <jsp:setProperty name="bills" property="service" value="<%=finances.get(i).get(i).getService()%>"/>
            <jsp:setProperty name="bills" property="fee" value="<%=finances.get(i).get(i).getFee()%>"/>
            <jsp:setProperty name="bills" property="totalfee" value="<%=finaltotallist.get(i).get(i)%>"/>
            <jsp:getProperty name="bills" property="service"/>
            <jsp:getProperty name="bills" property="fee"/>
            <jsp:getProperty name="bills" property="totalfee"/><br/>
            <%}%>
</jsp:useBean>
