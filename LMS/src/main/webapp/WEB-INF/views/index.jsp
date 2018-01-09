<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>  
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!-- angular pagination start -->
<link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular.min.js" type="text/javascript"></script>
		<script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.10.0.js" type="text/javascript"></script>
		   
<!-- angular pagination end -->


<!-- Angular ui tooltip start -->
<!-- <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-sanitize.js"></script>
<!--     <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script> --> 
    
     <!-- Angular ui tooltip end -->

<link href="/app/assets/css/style.css" rel="stylesheet" />
<link href="/app/assets/css/login_form_style.css" rel="stylesheet" />
<link href="/app/assets/css/jquery-ui.min.css" rel="stylesheet" />
<!-- <link href="/res/css/style.css" rel="stylesheet" />
<link href="/res/css/jquery-ui.min.css" rel="stylesheet" /> -->
  <script type="text/javascript" src="/app/assets/js/angular.min.js" /></script> 
 
 <script type="text/javascript" src="/app/assets/js/dirPagination.js" /></script>
  <script type="text/javascript" src="/app/assets/js/angular-route.min.js" /></script>
   <!--   <script type="text/javascript" src="/res/js/angular.min.js" /></script>
     <script type="text/javascript" src="/res/js/angular-route.min.js"></script> -->
    <!--  <script type="text/javascript" src="/res/controller/loginController.js"></script> --> 
    <script type="text/javascript" src="/app/app.module.js"></script>
    <script type="text/javascript" src="/app/app.routes.js"></script>
    <script type="text/javascript" src="/app/components/admin/adminController.js"></script>
    <script type="text/javascript" src="/app/components/employee/employeeController.js"></script>
    <script type="text/javascript" src="/app/components/login/loginController.js"></script>
    <script type="text/javascript" src="/app/components/manager/managerController.js"></script>
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
	<script src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
	<script type="text/javascript" src="/app/assets/js/jquery.js" /></script>
	<script type="text/javascript" src="/app/assets/js/jquery-ui.js" /></script>
	<!-- <script src="/res/js/jquery.js"></script>
	<script src="/res/js/jquery-ui.js"></script> -->
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function searchBoxStyleChange(){
	  $("#searchBox").attr("style","z-index:-1;");
	  $("#searchBox1").attr("style","z-index:-1;");
	  
  }
  function restoreSearchBoxStyleChange(){
	  $("#searchBox").removeAttr("style");
	  $("#searchBox1").removeAttr("style");
	  
  }
  </script>
  
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
<body ng-app="myApp" >
<div id="navbar" class="hide">

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><img alt="logo" src="/app/assets/images/valuelabs-logo.gif"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li  ><a id="home" href="http://localhost:8088/login/#/employeelogin" data-toggle="dropdown"></span><span style="color:black;">Home</span></a></li>
         <li id="services" class="dropdown" onmouseover="searchBoxStyleChange()" onmouseout="restoreSearchBoxStyleChange()">
        <a class="dropdown" data-toggle="dropdown" ><span style="color:black;">Services</span>
        <span class="caret"></span></a>
         <div class="dropdown-content" ng-controller="employeeLeaveController" >
    <a id="applyLeaveLink" class="hide" ng-click="submit()">Apply Leave</a>
    <a href="http://localhost:8088/login/#/appliedleave" id="appliedLeavesLink" class="hide">Applied Leaves</a>
    <a href="http://localhost:8088/login/#/updateprofile" id="updateProfileLink" class="hide">Update profile</a>
    <a href="http://localhost:8088/login/#/accesspermission" id="accessPermissionLink" class="hide">Access Permission </a>
    <a href="http://localhost:8088/login/#/accessemployeedetails" id="accessDetailsLink" class="hide">Access Details</a>
    <a href="http://localhost:8088/login/#/updatePasswordTemplate" id="updatePasswordLink" class="hide">Update Password</a>
    <a href="http://localhost:8088/login/#/leaveRequets" id="approveRejectLeavesLink" class="hide">Approve/Reject Leaves</a>
    <a href="http://localhost:8088/login/#/reportingemployeedetails" id="EmployeesReportingLink" class="hide">Employees Reporting</a>
  </div>
      </li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a  href="" style="color:black;" onclick="logout()"><span class="glyphicon glyphicon-log-out"></span>Logout </a></li>
      </ul>
    </div>
  </div>
</nav>

</div>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav" id="leftSideNav" style="background-color: white;" >
    <div id="sideNavbar">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      </div>
    </div>
    <div class="col-sm-8 text-left"> 
      <div ng-view></div>
    </div>
    <!-- <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div> -->
  </div>
</div>

<!-- <footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer> -->

</body>
</html>
