<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>  
<link href="/res/css/style.css" rel="stylesheet" />
<link href="/res/css/jquery-ui.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular.min.js" type="text/javascript"></script>
		<script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js" type="text/javascript"></script>
     <script type="text/javascript" src="/res/js/angular.min.js" /></script>
     <script type="text/javascript" src="/res/js/dirPagination.js" /></script>
     <script type="text/javascript" src="/res/js/angular-route.min.js"></script>
     
     
     <script type="text/javascript" src="/res/controller/loginController.js"></script> 
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/res/js/jquery.js"></script>
	<script type="text/javascript" src="/res/js/jquery-ui.js"></script>
	
	<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src=" https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
 
 <script type="text/javascript" src="/res/js/bootstrap.min.js"></script>
 
 
	<style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
      width : 100%;
      
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body ng-app="myApp">
<div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
   <!--    <a class="navbar-brand" href="#">Logo</a> -->
    </div>
    
  </div>
</nav>
<div class="container-fluid" >    
  <div class="row content" >
   
    <div class="col-sm-12" > 
    <h1 style="font-family:Georgia;text-align: center;">Online Banking System</h1>
     <div ng-view></div>
     
    </div>
  </div>
</div>
<footer class="footer">
      <div class="container">
        <p style="margin-left:180px;width : 100%;" class="text-muted">Copyright � 2017-2024 OnlineBanking, Inc. All rights reserved. "Banking" is a registered trademark of Banking, Inc</p>
      </div>
    </footer>
</div>
</body>

</html>