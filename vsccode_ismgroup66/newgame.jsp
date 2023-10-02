<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "java.util.List,ismgroup66_java.*" %>
<%
Lesson lesson = new Lesson();
/*Student student = new Student((String)session.getAttribute("lastname"),(String)session.getAttribute("firstname),(String)session.getAttribute("email"),(String)session.getAttribute("username"))*/

GameDao gamedao = new GameDao();

Game gm = gamedao.ConnectGame(lesson);

int points = 0;
int played = 0;
List<String> listOfWords = gm.getListOfWords();
    String qu =null;
    String ans =null;
    String ret=null;

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

        a:hover {
        background-color: #ddd;
        color: black;
        }
        .previous {
         background-color: #061b94;
         text-align: center;
         font-size: 16px;
        margin: 4px 2px;
        color: white;
        }


        .next {
         background-color: #061b94;
         text-align: center;
         font-size: 16px;
        margin: 4px 2px;
        color: white;
}
      .round {
         border-radius: 50%;
        }
        .container {
        position: relative;
        text-align: center;
        background-color:#061b94;
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
        qu = listOfWords.get(gm.randomOdd());%>
<body style="background-color: #061b94;">

    <div class="container">
        <div class="row">
            <div class="column">
        
                <div class="card border-dark mb-3" style="max-width: 18rem;">
		
                    <img src="<%=request.getContextPath() %>/images/1548841621_8777.jpg" alt="game" width="500" height="600">
                    <div class="card-body centered2 column">
                        <h5 class="card-title">Write the translation of the word:</h5>
                        <h3> <%=qu%></h3>
                        
                        </div>
                </div>
            </div>
            <div class="column">
                <div class="card border-dark mb-3" style="max-width: 18rem;">
                    <img src="<%=request.getContextPath() %>/images/1548841621_8777.jpg" alt="game" width="500" height="600">
                    
                    <div class="card-body centered1 column">
                        <h5 class="card-title">Fill the gap</h5>
                        <form action= "newgame.jsp">
                            <label for=ans>Please Write the correct answer</label>
                            <input type="text" id="ans" name="ans"><br><br>
                            <input type="submit" value="submit">Submit Answer</form>
                            <!--<script>
                              function getInputValue() {
                                // Selecting the input element and get its value 
                                var inputVal = document.getElementById("ans").value;
                                document.getElementById("demo").innerHTML = inputVal;
                              }
                            </script> -->
                            <% if(request.getParameter(ans)!=null) {
                                ans = request.getParameter(ans);
                                if (ans.equals("exit")) {
                                    points = 0; 
                                    listOfWords.clear();
                                    
                                }
                                ret = gm.checkWord(qu,ans);
                            } %>
                            <h3> <%=ret%></h3>



                        
                </div>
            </div>

        <a href="#" class="next round">&#8250;</a>
    </div> 

  
</body>    
</html>
