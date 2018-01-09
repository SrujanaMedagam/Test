// Admin controller
app.controller('adminAccessPermissionController', function($scope, $location,
		$http, $rootScope) {
	$.ajax({
		type : "GET",
		url : "/admin/getAllManagerIds",
		dataType : 'json',
		timeout : 100000,
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type",
					"application/json;charset=utf-8");

		},
		success : function(response) {
			var managerDropDownList = "";
			$.each(response, function(key, val) {
				managerDropDownList += "<option value=" + val.empId + ">"
						+ val.empId + "</option>";

			});
			$("#managerIds").append(managerDropDownList);

		},
		error : function(e, status) {
			alert("error");
			alert(status);

		}

	});

	$scope.adminAccessPermissionData = function() {
		var role = $scope.role;
		var empName = $scope.empName;
		var empId = $scope.empId;
		var password = $scope.password;
		var email = $scope.email;
		var manager = $scope.manager;
		var employeeData = {
			"role" : role,
			"empName" : empName,
			"empId" : empId,
			"password" : password,
			"email" : email,
			"manager" : manager
		};

		/*if((role=="admin") || (role=="manager")){
			$scope.manager="";			
		}	
		var manager=$scope.manager;
		alert(role+" "+empName+" "+empId+" "+password+" "+email+" "+manager);
		 */

		if (role == null || role == "") {
			alert("Please select Role");
			return false;
		} else if (empName == null || empName == "") {
			alert("Please Enter Valid Employee Name");
			return false;
		} else if (empId == null || empId == "") {
			alert("Please Enter Valid Employee Id");
			return false;
		} else if (password == null || password == "") {
			alert("Please Enter Valid password");
			return false;
		} else if (email == null || email == "") {
			alert("Please Enter Valid Email Address");
			return false;
		}

		else if (manager == null || manager == "") {
			alert("Please Enter Valid Manager Id");
			return false;
		}

		/*if(role=="employee"){
		if(manager==null || manager==""){			
			alert("Please Select/Enter Manager Id");
			return false;
		}
		alert(role+" role : mananager id"+manager);
		}	*/

		$.ajax({
			type : "POST",
			url : "/admin/adminleave",
			data : JSON.stringify(employeeData),
			dataType : 'json',
			timeout : 100000,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");

			},
			success : function(response) {
				//alert("reached");
				if (response == "passed") {

					alert("Employee Registered successfully");
					//$("#reset").click();
				}
				window.location.assign("/login/#/adminlogin");

			},
			error : function(e, status) {
				alert("error");
				alert(status);

			}

		});

	};

	/*function Controller ($scope) {
	    $scope.role = 'employee';
	}*/

	$scope.checkEmployeeId = function() {

		var empId = $scope.empId;

		$.ajax({
			type : "GET",
			url : "/admin/checkEmployeeId",
			data : {
				"empId" : empId
			},
			dataType : 'text',
			timeout : 100000,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");

			},
			success : function(response) {
				//alert("reached");
				alert(response);
				if (response == "failed") {

					/*alert("Employee Registered successfully");
					$("#reset").click();*/
					$("#checkEmpIderrorMessage").show();
					$("#reset").click();
				} else if (response == "passed") {
					$("#checkEmpIderrorMessage").hide();
					/*alert("Employee Registered successfully");
					$("#reset").click();*/
				}
			},
			error : function(e, status) {
				alert("error");
				alert(status);

			}

		});

	};

	/*	
	 $scope.resetForm = function(adminform) {
	 alert("reset button");
	 $scope.adminform.$dirty = false;
	 $scope.adminform.$pristine = true;
	 $scope.adminform.$submitted = false;
	
	 adminform.$setPristine();
	 adminform.$setUntouched();
	 $scope.resetCount++;
	 };*/

});
//All the details of employees from admin
app.controller('showAllDetailsFromAdminController',
				function($scope, $location, $http, $rootScope) {

					$scope.init = function() {

						$http({
							method : "GET",
							url : "/admin/showdetails"
						})
								.then(
										function mySucces(response) {
											var check = $scope.employeeList = response.data;
											// pagination controls
									    	$scope.currentPage = 1;
									    	$scope.totalItems = $scope.employeeList.length; 
									    	$scope.entryLimit = 5; // items per page
									    	$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
											
										},
										function myError(response) {
											var check = $scope.employeeList = response.statusText;
											// alert("Error"+check);
										});

					}
					// create empty search model (object) to trigger $watch on update
					$scope.search = {};

					$scope.resetFilters = function () {
						alert("reached1");
						// needs to be a function or it won't trigger a $watch
						$scope.search = {};
					};
					$scope.resetPage=function()
					{
						$scope.currentPage = 1;
					}
					$scope.selectPage=function(pageNumber)
					{
						alert(pageNumber);
					}

					$scope.deleteRow = function(empId) {

						//alert("remove id");
						//alert("remove id" + empId);

						$.ajax({
							type : "GET",
							url : "/admin/deleteRecord",
							data : {
								"empId" : empId
							},
							dataType : 'text',
							timeout : 100000,
							beforeSend : function(xhr) {
								xhr.setRequestHeader("Accept",
										"application/json");
								xhr.setRequestHeader("Content-Type",
										"application/json;charset=utf-8");

							},
							success : function(response) {
								//alert("reached");
								alert(response);
								if (response == "failed") {
									alert("failed");
								} else if (response == "passed") {
									alert("Row Deleted Successfully");
									/*$http({
									    method : "GET",
									    url : "/admin/showdetails"
									  })
									  .then(function mySucces(response) {
										   var check = $scope.employeeList = response.data;	     
									    }, function myError(response) {
									    	 var check = $scope.employeeList = response.statusText;
									     // alert("Error"+check);
									  });*/
									$scope.init();

								}
							},
							error : function(e, status) {
								alert("error");
								alert(status);

							}

						});
					}

					$scope.updateRow = function() {
						var empId = document.getElementById("form").elements["empIdInput"].value;
						var empName = document.getElementById("form").elements["employeeNameInput"].value;
						var role = document.getElementById("form").elements["roleInput"].value;
						var email = document.getElementById("form").elements["emailInput"].value;
						var manager = document.getElementById("form").elements["managerInput"].value;
						/*alert(empId + " " + empName + " " + role + " " + email
								+ " " + manager);*/

						if (empId == null || empId == "" || empName == null
								|| empName == "" || role == null || role == ""
								|| email == null || email == ""
								|| manager == null || manager == "") {
							alert("Required fields : Please Enter Valid Data");
						} else {

							$.ajax({
								type : "GET",
								url : "/admin/updateEmployeeDetails",
								data : {
									"empId" : empId,
									"empName" : empName,
									"role" : role,
									"email" : email,
									"manager" : manager
								},
								dataType : 'text',
								timeout : 100000,
								beforeSend : function(xhr) {
									xhr.setRequestHeader("Accept",
											"application/json");
									xhr.setRequestHeader("Content-Type",
											"application/json;charset=utf-8");

								},
								success : function(response) {
									//alert("reached");

									if (response == "failed") {
										alert(response);
									} else if (response == "passed") {
										alert("Employee Details Successfully Updated");
										$scope.init();
									}
								},
								error : function(e, status) {
									alert("error");
									alert(status);

								}

							});
						}

						/*
						var empId = document.getElementById("form").elements["empIdInput"].value;			
						var empName = document.getElementById("form").elements["employeeNameInput"].value;
						var role = document.getElementById("form").elements["roleInput"].value;
						var email = document.getElementById("form").elements["emailInput"].value;
						var manager = document.getElementById("form").elements["managerInput"].value;
						var employeeData={"empId" : empId, "empName" : empName, "role" : role, "email" : email, "manager" : manager};
						alert(empId+" "+empName+" "+role+" "+email+" "+manager);				
						
								
						$.ajax({  
							type : "POST",  
							url : "/admin/updateEmployeeDetails",  
							data : JSON.stringify(employeeData),
							dataType : 'json',
							timeout : 100000,
							beforeSend: function(xhr) {  
								xhr.setRequestHeader("Accept", "application/json");  
								xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
								
							},  
							success : function(response) {
								alert("response________"+response);
								//alert("reached");
								if(response=="pass")
									{
									
									alert("Employee Details updated successfully");
									//$("#reset").click();
									}   
								//window.location.assign("/login/#/accesspermission");
								
								
							},  
							error : function(e,status) {
								alert("$$$$$$$$$$$$error");
								//window.location.assign("/login/#/accesspermission");
								alert("********"+status);
								
							}  

						}); */

					}

					$scope.showEditForm = function(emp) {
						var empId = emp.empId;
						var empName = emp.empName;
						var role = emp.role;
						var email = emp.email;
						var manager = emp.manager;
						/*alert(empId + " " + empName + " " + role + " " + email
								+ " " + manager);*/

						document.getElementById("empIdInput").value = empId;
						document.getElementById("employeeNameInput").value = empName;
						document.getElementById("roleInput").value = role;
						document.getElementById("emailInput").value = email;
						document.getElementById("managerInput").value = manager;
					}				

				});

app.controller('adminGetAllEmployeeDetailsController', function($scope,	$location, $http, $rootScope) {
	$scope.getAllEmployeeDetails = function() {
	};

});
app.controller('adminDashBoardController', function($scope, $location, $http,
		$rootScope) {
	$scope.accessPermissionSubmit = function() {
		//alert("accessPermissionSubmit");
		$location.path('/accesspermission');

		//alert("working");
	};

	$scope.accessEmpDetails = function() {
		$location.path('/accessemployeedetails');
		//alert("working");
	};

	$scope.updatePassword = function() {
		//alert("passed");
		$location.path('/updatePasswordTemplate');
	}
});

app.controller('adminUpdatePasswordController', function($scope, $location,	$http, $rootScope) {

	$.ajax({
		type : "GET",
		url : "/admin/getAllEmpIds",
		dataType : 'json',
		timeout : 100000,
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type",
					"application/json;charset=utf-8");

		},
		success : function(response) {
			//alert("getAll Employee Ids");
			var EmployeeIdDropDownList = "";
			$.each(response, function(key, val) {
				EmployeeIdDropDownList += "<option value=" + val.empId + ">"
						+ val.empId + "</option>";
				//	alert(val.empId);

			});
			$("#employeeIds").append(EmployeeIdDropDownList);

		},
		error : function(e, status) {
			alert("error");
			alert(status);

		}

	});

	$scope.adminCheckEmployeeId = function() {

		var empId = $scope.empId;

		$.ajax({
			type : "GET",
			url : "/admin/checkEmployeeId",
			data : {
				"empId" : empId
			},
			dataType : 'text',
			timeout : 100000,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");

			},
			success : function(response) {
				if (response == "failed") {
					$("#checkEmpIderrorMessage").hide();

				} else if (response == "passed") {
					$("#checkEmpIderrorMessage").show();
					$("#empId").val("");
					$scope.empId="";

				}
			},
			error : function(e, status) {

				alert("error" + status);
				return false;

			}

		});

	};

	$scope.adminUpdatePassword = function() {
		var empId = $scope.empId;
		var newPassword = $scope.newPassword;
		var reEnterPassword = $scope.reEnterPassword;
		//alert("empId : " + empId + "  Password : " + newPassword);
		if (empId == null || empId == "" || newPassword == null
				|| newPassword == "" || reEnterPassword == null
				|| reEnterPassword == "") {

			alert("fields should not be null: Plese Enter Valid Data");
			return false;

		} else {
			if (newPassword == reEnterPassword) {

				$.ajax({
					type : "GET",
					url : "/admin/updatePassword",
					data : {
						"empId" : empId,
						"newPassword" : newPassword
					},
					dataType : 'text',
					timeout : 100000,
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Content-Type",
								"application/json;charset=utf-8");

					},
					success : function(response) {
						if (response == "failed") {
							alert(response);
						} else if (response == "passed") {
							alert("password Successfully Updated ");
							window.location.assign("/login/#/adminlogin");
						}
					},
					error : function(e, status) {
						alert("error");
						alert(status);

					}

				});

			} else {
				alert("password missmathched");
				return false;
			}
		}
	};

});
