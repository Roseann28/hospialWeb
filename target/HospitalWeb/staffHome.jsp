<html>
<head>
    <style>
        body{
            background-image: url("./images/hosipital.webp");
            background-size: 1350px 800px;
            background-repeat: no-repeat;
        }
        .staffhomepage{
             width: 700px;
             height: 500px;
             background-color: rgb(238, 238, 247,0.9);
             margin-top: 70px;
             margin-bottom: 50px;
        }
     </style>
</head>
            <body>
            <jsp:include page="navbar.jsp"/>
            <div class="staffhomepage">

                        <jsp:include page="general_header.jsp"/>
                        <%String name=(String)session.getAttribute("staffname");%>
                        <h3>Hello <%=name%> </h3>
             </div>
             </body>
</html>