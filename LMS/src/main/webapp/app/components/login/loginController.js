app.controller('loginController', function($scope, $location,$http,$rootScope) {
	
	
    $scope.login=function(){
    	var flag;
    	var username=$scope.uname;
    	
    	var uid=$rootScope.username=username;
    	 $rootScope.$broadcast('handleBroadcast',username);
    //	alert(uid);
    	var pass=$scope.password;
    	var role=$scope.role;
    //	alert(role);
    	/*if($scope.uname=="raja" && $scope.password=="raja1234")
    		{
    		alert("success");
    		$location.path('/login');
    	//	$scope.$apply();
    		}
    	else
    		{
    		alert("Please provide correct username and password")
    		}*/
    	$.ajax({  
    		type : "GET",  
    		url : "userlogin",  
    		data : {"uname" : username,"pass":pass,"role":role},
    		dataType : 'text',
    		beforeSend: function(xhr) {  
    			xhr.setRequestHeader("Accept", "application/json");  
    			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    			
    		},  
    		success : function(response) {
    			//alert("reached");
    			if(response=="passed")
    				{
    				
    			//	alert("passed");
    				flag=true;
    				$("#navbar").removeAttr("class");
    				//$("#leftSideNav").removeAttr("style");
    				if(role=="Employee")
    					{ 
    					$rootScope.employeeloggedin=flag;
    				window.location.assign("/login/#/employeelogin");
    				$("#applyLeaveLink").removeAttr("class");
					$("#appliedLeavesLink").removeAttr("class");
					$("#updateProfileLink").removeAttr("class");
    					}
    				else if(role=="Manager")
					{
    					$rootScope.managerloggedin=flag;
				window.location.assign("/login/#/managerlogin");
				$("#home").attr("href","http://localhost:8088/login/#/managerlogin");
				$("#approveRejectLeavesLink").removeAttr("class");
				$("#EmployeesReportingLink").removeAttr("class");
					}
    				else if(role=="Admin")
					{
    					$rootScope.adminloggedin=flag;
				window.location.assign("/login/#/adminlogin");
				$("#home").attr("href","http://localhost:8088/login/#/adminlogin");
				$("#accessPermissionLink").removeAttr("class");
				$("#accessDetailsLink").removeAttr("class");
				$("#updatePasswordLink").removeAttr("class");
					}
    				}
    			else
    				{
    				
    				//alert("failed");
    				flag=false;
    				$rootScope.employeeloggedin=flag;
    				$rootScope.managerloggedin=flag;
    				$rootScope.adminloggedin=flag;
    				alert("Please enter correct credentials");
    				}
    			//alert($rootScope.loggedin);	
    			
    		},  
    		error : function(e,status) {
    			alert("error");
    			alert(status);
    			
    		}  

    	}); 
    	/*$http({
    		  method: 'GET',
    		  url: 'login',
    		data : {"uname" : username,"pass":pass},
    	    dataType : 'text',
    	    headers : {'Content-Type':'application/json;charset=utf-8','Accept':'application/json'}
    		}).then(function successCallback(response) {
    		    alert("success");
    		  }, function errorCallback(response) {
    		    // called asynchronously if an error occurs
    		    // or server returns response with an error status.
    			  alert(response.status);
    		  });*/
    	
   	 	//alert($rootScope.loggedin);
    	
    };
});

window.onhashchange = function() {
	var currentLocation = window.location;
	if(currentLocation=="http://localhost:8088/login/#/")
		{
		window.location="http://localhost:8088/login/";
		}
	}

function logout()
{
	window.location="http://localhost:8088/login/";	
}
