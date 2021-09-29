<html>
<head>
    <style>
        body{
            background-image: url("./images/hosipital.webp");
            background-size: 1350px 800px;
            background-repeat: no-repeat;
        }
         .bg-image{
             background-color: black;
             background-size: cover;
             background-color: rgba(0,0,0, 0.6);
         }
         #logo{
             margin-left: 50px;
             padding: 5px;
         }
         .sign-up-form{

             width: 700px;
             height: 500px;
             background-color: rgb(238, 238, 247,0.9);
             display: flex;
             margin-top: 70px;
             margin-bottom: 50px;

         }
         form{
             margin: 50px;
             margin-top: 70px;
             text-align: center;
         }
         form h3{
             margin-bottom: 70px;
         }
         form button{
             margin-top: 50px;
             background-color:rgb(0, 26, 255) ;
             border: none;
             color: white;
             padding: 5px 10px;
             border-radius: 8px;


         }

         form a{
            margin-top: 30px;
         }
         button :hover{
             background-color: rgb(228, 189, 13);
         }
         .input-container {
             display: flex;

           }
           .input-field {
             width: 100%;
             padding: 10px;
             outline: none;
           }
           .icon{
             margin-top: 9px;
           }
         input{
             margin: 10px;
             padding-left: 20px;
             border: none;
         }
         input :hover{
             border: 2px solid rgb(0, 26, 255) ;
         }
         .sign-up-form img{
             width: 400px;
             height: 400px;

         }
         .sign-form{
         display: flex;
         justify-content: space-around;
         }
   </style>
</head>
 <body>
         <div class="sign-form">
         <section class="sign-up-form">
         <form action="./login" method="POST">
               <h3>Login</h3>
               <%String invalidMessage=(String)session.getAttribute("message");
               if(invalidMessage !=null)
                    out.print(invalidMessage);%>

               <div class="input-container">
                    <input type="text" id="Id" name="Id" placeholder="ID"><br><br>
               </div>


                <div class="input-container">
                    <input type="password" id="pass" name="pass" placeholder="Password"><br>
                </div>

                <div class="btn-bottom">
                    <input type="submit" value="Submit">
                </div>
                <a href="./register">Do not have an account? Sign up</a>
          </form>
          <img src="./images/login.png">


          </section>
        </div>
</body>
</html>
