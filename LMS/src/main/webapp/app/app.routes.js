app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "/app/components/homepage/login.html"
    })
    .when('/adminlogin', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.adminloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/login/admindashboard.html"
       
    })
    .when('/accesspermission', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.adminloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/admin/admintemplate.html"
       
    })
     .when('/accessemployeedetails', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.adminloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/admin/adminaccessdetails.html"
       
    })
     .when('/employeelogin', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.employeeloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/login/employeedashboard.html"
       
    })
     .when('/managerlogin', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.managerloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/login/managerdashboard.html"
       
    })
    .when('/applyleave', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.employeeloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/employee/leavetemplate.html"
       
    })
    .when('/appliedleave', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.employeeloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/employee/appliedleave.html"
       
    })
    .when('/updateprofile', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.employeeloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/employee/updateprofileform.html"
       
    })
     .when('/leaveRequets', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.managerloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/manager/handleleaverequest.html"
       
    })
      .when('/reportingemployeedetails', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.managerloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/manager/reportingemployeedetails.html"
       
    })
    
    .when('/updatePasswordTemplate', {
    	resolve: {
    		"check": function($location,$rootScope){
    			if(!$rootScope.adminloggedin)
    				{
    				$location.path('/');
    				}
    		}
    	},
        templateUrl : "/app/components/admin/adminupdatepasswordtemplate.html"
       
    }) 
    .otherwise({
    	redirectTo: '/'
    });
    
    
});