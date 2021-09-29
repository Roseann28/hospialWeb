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
                 .bodymain{

                     width: 700px;
                     height: 500px;
                     background-color: rgb(238, 238, 247,0.9);
                     display: flex;
                     margin-top: 70px;
                     margin-bottom: 50px;

                 }


                 button{
                     margin-top: 50px;
                     background-color:rgb(0, 26, 255) ;
                     border: none;
                     color: white;
                     padding: 5px 10px;
                     border-radius: 8px;


                 }


                 button :hover{
                     background-color: rgb(228, 189, 13);
                 }
                 .text {
                     display: flex;

                   }
                   .text{
                     width: 100%;
                     padding: 10px;
                     outline: none;
                   }
                   .icon{
                     margin-top: 9px;
                   }
                 .text{
                     margin: 10px;
                     padding-left: 20px;
                     border: none;
                 }

                 .bodymain img{
                     width: 400px;
                     height: 400px;

                 }
                 .fullbody{
                 display: flex;
                 justify-content: space-around;
                 }

    </style>
    <body>
        <div class="fullbody">
            <section class="bodymain">
            <div class="text">
               <h2>Welcome to RAM hosipital</h2>
             </div>
             <div class="text">
                <h1>Your most trusted specialist hosipital</h1>
              </div>
              <div class="btn-bottom">
                <a  href=./login.jsp><Button>Staff Login</Button></a>
               </div>
               <img src="./images/home.png">
             </section>
         </div>

    </body>