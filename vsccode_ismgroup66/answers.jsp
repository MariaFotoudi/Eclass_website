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
    body {
      margin: 0;
      background-color: #000000;
    }

    img {
      display: block;
      margin-left: auto;
      margin-right: auto;
      width: 65%;
      }
    .hero-text {
      text-align: center;
      top: 50%;
      width: 100%;
      color: white;
      letter-spacing: 8px;
      margin-bottom: 20px; 
      animation: text 3s 1;
      text-shadow: 2px 2px 5px rgb(140, 0, 255);
    }
    @keyframes text {
      0%
      {
        color:black;
        margin-bottom : -40px;
      }
      30%{
        letter-spacing: 25px;
        margin-bottom: -40px;
      }
      85%{
        letter-spacing: 8px;
        margin-bottom: -40px;
      }
    }
    div.outset {border-style: outset;}
    
    </style>

  </head>
  <body>
    <div class="outset">
        <img src="<%= request.getContextPath() %>/images/gatsby.gif" width=60% >
        <h2 class="hero-text"><b>YOU SCORED: 19/20</b></h2>
        <h2 class="hero-text">WELL DONE</h2>
    </div>


    <footer class="navbar-inverse">
      <div class="container">
          <div class="row">
              <div class="col-xs-12">
                  <p class="text-center">&copy; Copyright 2021 by ismgroup100</p>
              </div>
          </div>
      </div>



  </body>
</html>