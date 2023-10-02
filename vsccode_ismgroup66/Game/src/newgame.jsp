<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "java.util.List,ismgroup66_java.*" %>
<jsp:include page = "checkauthentication.jsp"/>
<% 

Lesson lesson = new Lesson(2,"italian","juber");


GameDao gamedao = new GameDao();
Game gm = gamedao.ConnectGame(lesson);
if (session.getAttribute("gm") == null) {
    session.setAttribute("gm",gm) ; 

}




List<String> listOfWords = gm.getListOfWords();
    if (session.getAttribute("listOfWords") == null) {
    session.setAttribute("listOfWords",listOfWords);}

    String ans =" ";
    String ret="hi";
    String qu;
    Integer points;

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">	
    <meta name="viewport" content="width=device-width, initial-scale=1">
                
    <meta name="author" content="your email">
    <link rel="icon" href="<%=request.getContextPath() %>/images/favicon.ico">
    
    
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.min.css">
  
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/theme_8190162.css" rel="stylesheet">
  
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  
    <style>
        a {
        text-decoration: none;
        display: inline-block;
        padding: 8px 16px;
        }
        body {
        background-image: url("<%= request.getContextPath() %>/images/game2.png");
        background-color: #000000;
        }

        a:hover {
        background-color: #ddd;
        color: black;
        }
        .button {
        display: inline-block;
        border-radius: 4px;
        background-color: #b01ef4;
        border: none;
        color: #FFFFFF;
        text-align: center;
        font-size: 28px;
        padding: 20px;
        width: 200px;
        transition: all 0.5s;
        cursor: pointer;
        margin: 5px;
        }

        .button span {
        cursor: pointer;
        display: inline-block;
        position: relative;
        transition: 0.5s;
        }

        .button span:after {
        content: '\00bb';
        position: absolute;
        opacity: 0;
        top: 0;
        right: -20px;
        transition: 0.5s;
        }

        .button:hover span {
        padding-right: 25px;
        }

        .button:hover span:after {
        opacity: 1;
        right: 0;
        }
     
        .container {
        position: relative;
        text-align: center;
        
        }
        .centered1 {
        position: absolute;
        top: 40%;
        left: 71.3%;
        transform: translate(-50%, -50%);
        }
        .centered2 {
        position: absolute;
        top: 40%;
        left: 21.3%;
        transform: translate(-50%, -50%);
        }

        
        /* Three image containers (use 25% for four, and 50% for two, etc) */
        .column {
        float: left;
        width: 50%;
        padding: 5px;
        }

        /* Clear floats after image containers */
        .row::after {
        content: "";
        clear: both;
        display: table;
        }
        .card-body {
            
            color:black;
        }

    </style>

</head>  
        
<body>
<%  List<String> listof = (List<String>) session.getAttribute("listOfWords");
qu = listof.get(gm.randomOdd(listof)); %>



    <div class="container">
        <div class="row">
            <div class="column">
        
                <div class="card border-dark mb-3" style="max-width: 18rem;">
                    <img src="<%=request.getContextPath() %>/images/black.jpg" alt="game" width="500" height="600" style="border-radius:25px;">
                    <div class="card-body centered2 column">
                        <h5 class="card-title" style="color:rgb(226, 188, 241);">Write the translation of the word:</h5>
                        <h3 style="color:rgb(226, 188, 241);"> <%=qu%></h3>
                          
                        </div>
                </div>
            </div>
            <div class="column">
                <div class="card border-dark mb-3" style="max-width: 18rem;">
                    <img src="<%=request.getContextPath() %>/images/black.jpg" alt="game" width="500" height="600" style="border-radius:25px;">
                    <div class="card-body centered1 column">
                        <% session.setAttribute("qu",qu);%>
                       
                        <form method="post" action= "anscontroller.jsp">
                            
                            <label for=ans style="color:rgb(226, 188, 241);">Please Write the correct answer in english</label><br>
                            <input type="text" id="ans" name="ans"><br><br>
                            <button class="button" style="vertical-align:middle" type="submit"><span>Submit</span></button>
                        </form>
                        <% ret = (String) session.getAttribute("ret"); %>
                        <% points = (Integer) session.getAttribute("points"); %>
                        <% if (ret!=null){ %>
                            <h3 style="color:rgb(226, 188, 241);"><%=ret%> </h3>
                        <% } %>



                        
                </div>
            </div>

        
    </div> 

  
</body>    
</html>
