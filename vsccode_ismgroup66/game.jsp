<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">	
  <meta name="viewport" content="width=device-width, initial-scale=1">
              
  <meta name="author" content="your email">
  <link rel="icon" href="<%=request.getContextPath() %>/images/favicon.ico">
  <title>game</title>
  
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
      background-image: url("<%= request.getContextPath() %>/images/game2.png");
      background-color: #000000;
    }
    .container{
      text-align:center;
      position: absolute;
      top: 50%;
      left: 50%;
      transform: translate(-50%,-50%);

    }

  .container span{
    color:white;
    text-transform:uppercase;
    display: block;
  }
  .text1{
    font-size: 40px;
    letter-spacing: 8px;
    margin-bottom: 10px;
    position:relative;
    animation: text 3s 1;
    text-shadow: 0 0 3px #c907f0fa, 0 0 5px #63007c;
  }
  .text2{
    size:30px;
    color: #cf18c6;
    position:relative;
    text-shadow:2px 2px 5px #cf18c6;
  }

    
    @keyframes text {
      0%
      {
        color:black;
        margin-bottom : -80px;
      }
      30%{
        letter-spacing: 25px;
        margin-bottom: -80px;
      }
      85%{
        letter-spacing: 8px;
        margin-bottom: -80px;
      }
    }
    img {
      display: block;
      margin-left: auto;
      margin-right: auto;
      width: 60%;
    }
    .blur {filter: blur(4px);}
    div.outset {border-style: outset;}
  </style>

<body>

  <img src="<%= request.getContextPath() %>/images/game2.png" class="blur" alt="game" >
    <div class="container">
      <span class="text1">Welcome</span>
      <button type="button" class="btn btn-light">
        <span class="text2">Play &#8250;</span>
      </button>
    
    </div>
 


  <footer class="navbar-inverse">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <p class="text-center">&copy; Copyright 2021 by ismgroup100</p>
            </div>
        </div>
    </div>
</footer>

</body>
</html>