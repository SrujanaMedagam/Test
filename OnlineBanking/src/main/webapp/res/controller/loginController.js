var app = angular.module("myApp", [ 'ngRoute', 'ui.bootstrap' ]);
app.filter('startFrom', function() {
	return function(input, start) {
		if (input) {
			start = +start;
			return input.slice(start);
		}
		return [];
	};
});
app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "/res/views/welcome.html"
	}).when('/homepage', {
		templateUrl : "/res/views/homepage.html"
	}).when('/userlogin1', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/homepage.html"

	}).when('/newuserurl', {

		templateUrl : "/res/views/newuser.html"

	}).when('/newUserPermission', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/welcome.html"
	}).when('/accountDetails', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/accountDetails.html"
	}).when('/noAccountDetails', {
		/*
		 * resolve : { "check" : function($location, $rootScope) { if
		 * (!$rootScope.loggedin) { $location.path('/'); } } },
		 */
		templateUrl : "/res/views/noAccountDetailRecords.html"
	})

	.when('/depositMoney', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/depositMoney.html"
	}).when('/withdrawMoney', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/withdrawMoney.html"
	}).when('/deposited', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/homepage.html"
	}).when('/fundsTransfer', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/fundsTransfer.html"
	}).when('/transfered', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/homepage.html"
	}).when('/transactionHistory', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/TransactionHistory.html"
	}).when('/noTransactionHistory', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/noAccountDetailRecords.html"
	}).when('/myProfile', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/myProfile.html"
	}).when('/updateProfile', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/updateProfile.html"
	}).when('/logout', {
		resolve : {
			"check" : function($location, $rootScope) {
				if (!$rootScope.loggedin) {
					$location.path('/');
				}
			}
		},
		templateUrl : "/res/views/welcome.html",
		controller : 'logoutCtrl'
	}).when('/profileUpdate', {

		templateUrl : "/res/views/homepage.html"

	})
} ]);
app.controller('LogoutController', function($location, $scope, $window) {
	$window.localStorage.clear();
	$location.path('/');
	$window.location.reload();
});

app.controller('loginController',
		function($scope, $location, $http, $rootScope) {

			$scope.submit = function() {
				var flag;
				var username = $scope.username;
				var uid = $rootScope.username = username;

				var password = $scope.password;
				var pass = $rootScope.password = password;
				$.ajax({
					type : "GET",
					url : "userlogin",
					data : {
						"username" : username,
						"password" : password
					},
					dataType : 'text',
					beforeSend : function(xhr) {
						xhr.setRequestHeader("Accept", "application/json");
						xhr.setRequestHeader("Content-Type",
								"application/json;charset=utf-8");

					},
					success : function(response) {
						if (response == "passed") {
							flag = true;
							$rootScope.loggedin = flag;
							window.location.assign("/login/#/userlogin1");
						} else {
							alert("Enter valid UserID and Password.");
						}
					},
					error : function(e, status) {
						alert("Enter valid UserID and Password.");
					}

				});
			};
			$scope.urlSubmit = function() {

				$location.path('/newuserurl');

			};

		});

// NewUserAccess controller
app.controller('newUserAccessPermissionController', function($scope, $location,
		$http, $rootScope) {
	$scope.onSubmit = function() {
		var accountNumber = $scope.accountNumber;
		var accountName = $scope.accountName;
		var username = $scope.username;
		var password = $scope.password;
		var address = $scope.address;
		var emailId = $scope.emailId;
		var phoneNumber = $scope.phoneNumber;
		var panNumber = $scope.panNumber;
		var aadharNumber = $scope.aadharNumber;
		var accountType = $scope.accountType;
		var accType = $rootScope.accountType = accountType;
		var date = $scope.date;
		var accOpenDate = $rootScope.date = date;

		if (accountNumber == null || accountNumber == "") {
			alert("Please Enter Valid Account Number");
			return false;
		} else if (accountName == null || accountName == "") {
			alert("Please Enter Valid Account Name");
			return false;
		} else if (username == null || username == "") {
			alert("Please Enter Valid UserID");
			return false;
		} else if (password == null || password == "") {
			alert("Please Enter Valid password");
			return false;
		} /*
			 * else if (emailId == null || emailId == "") { alert("Please Enter
			 * Valid Email Address"); return false; } else if (phoneNumber ==
			 * null || phoneNumber == "") { alert("Please Enter Valid Phone
			 * number"); return false; }
			 *//*
				 * else if (panNumber == null || panNumber == "") {
				 * alert("Please Enter Valid PAN Number"); return false; }
				 *//*
				 * else if (aadharNumber == null || aadharNumber == "") {
				 * alert("Please Enter Valid Aadhar Number"); return false; }
				 * else if (accountType == null || accountType == "") {
				 * alert("Please select AccountType"); return false; } else if
				 * (date == null || date == "") { alert("Please Enter Valid
				 * Date"); return false; }
				 */

		$.ajax({
			type : "GET",
			url : "/login/newUserPermission",
			data : {
				"accountNumber" : accountNumber,
				"accountName" : accountName,
				"username" : username,
				"password" : password,
				"address" : address,
				"emailId" : emailId,
				"phoneNumber" : phoneNumber,
				"panNumber" : panNumber,
				"aadharNumber" : aadharNumber,
				"accountType" : accountType,
				"date" : date
			},
			dataType : 'text',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");
			},
			success : function(response) {
				if (response == "passed") {
					window.location.assign("/login/#/newUserPermission");
				}
			},
			error : function(e, status) {
				alert("Not able Register new account.");
			}
		});
	};

	// checkAccountNumber
	$scope.checkAccountNumber = function() {
		var accountNumber = $scope.accountNumber;

		$.ajax({
			type : "GET",
			url : "/login/checkAccountNumber",
			data : {
				"accountNumber" : accountNumber
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
					$("#checkEmpIderrorMessage").show();
					$("#reset").click();
				} else if (response == "passed") {
					$("#checkEmpIderrorMessage").hide();
				}
			},
			error : function(e, status) {
				alert("fail to check accountNumber.");
			}
		});
	};

	// checkuserID
	$scope.checkuserID = function() {
		var username = $scope.username;
		$.ajax({
			type : "GET",
			url : "/login/checkUserID ",
			data : {
				"username" : username
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
					$("#checkUserIderrorMessage").show();

				} else if (response == "passed") {
					$("#checkUserIderrorMessage").hide();
				}
			},
			error : function(e, status) {
				alert("fail to check userid.");
			}
		});
	};
});

// Homepage Controller
app.controller('homePageController', function($scope, $location, $http,
		$rootScope, $window) {
	$scope.accDetails = function() {
		var name = $window.prompt('Enter Your Name');
		$window.alert("Checking services in homepage controller from window"
				+ name);
		alert("Checking services in homepage controller from alert" + name);
		var username = $scope.username;
		var password = $scope.password;
		$.ajax({
			type : "GET",
			url : "/login/userlogin",
			data : {
				"username" : username,
				"password" : password
			},
			dataType : 'text',
			timeout : 100000,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");
			},
			success : function(response) {
				if (response == "passed") {
					$.ajax({
						type : "GET",
						url : "/homepage/accountDetails",
						data : {
							"username" : username,
							"password" : password
						},
						dataType : 'text',
						timeout : 100000,
						beforeSend : function(xhr) {
							xhr.setRequestHeader("Accept", "application/json");
							xhr.setRequestHeader("Content-Type",
									"application/json;charset=utf-8");
						},
						success : function(response) {
							if (response == "passed") {
								window.location
										.assign("/login/#/accountDetails");
							} else {
								window.location
										.assign("/login/#/noAccountDetails");
							}
						},
						error : function(e, status) {
							alert("Not able to found account Details.");
						}
					});
				}
			},
			error : function(e, status) {
				alert("Not able to found account Details.");
			}
		});
	};

	$scope.onDeposit = function() {
		window.location.assign("/login/#/depositMoney");
	}
	$scope.onWithdraw = function() {
		window.location.assign("/login/#/withdrawMoney");
	}
	$scope.onTransfer = function() {
		window.location.assign("/login/#/fundsTransfer");
	}
	$scope.myProfile = function() {
		window.location.assign("/login/#/myProfile");
	}
	$scope.logout = function() {

		window.location.assign("/login/#/logout");
	}
	$scope.onTransactionHistory = function() {
		var username = $scope.username;
		var password = $scope.password;

		$.ajax({
			type : "GET",
			url : "/history/transactonHistory",
			data : {
				"username" : username,
				"password" : password
			},
			dataType : 'text',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");
			},
			error : function(e, status) {
				window.location.assign("/login/#/deposited");
			},
			success : function(response) {
				if (response == "passed") {
					window.location.assign("/login/#/transactionHistory");
				} else {
					alert("No record found.");
					window.location.assign("/login/#/homepage");
				}
			}
		});
	}
});
// showAccountDetailsController
app.controller('showAccountDetailsController', function($scope, $location,
		$http, $rootScope) {
	var username = $scope.username;
	var password = $scope.password;

	$.ajax({
		method : "GET",
		url : "/homepage/showdetails",
		data : {

			"username" : username,
			"password" : password
		},
		dataType : 'json',
		timeout : 100000,
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type",
					"application/json;charset=utf-8");
		},
		success : function(response) {
			$.each(response, function(key, val) {
				$("#accountNumber").html(val.accNumber);
				$("#accountName").html(val.accName);
				$("#amount").html(val.totalAmount);
				$("#accountType").html(val.accountType);
				$("#accountOpenDate").html(val.accountOpenDate);
			});
		},
		error : function(e, status) {
			alert("Records not found.");
		}
	});
});

// DepositMoneyController
app.controller('depositMoneyController', function($scope, $location, $http,
		$rootScope) {
	$scope.onDeposit = function() {
		var accountNumber = $scope.accountNumber;
		var amount = $scope.amount;
		var remarks = $scope.remarks;
		
		var accountData = {
				"accountNumber" : accountNumber,
				"amount" : amount,
				"remarks" : remarks
			};
		
		if (accountNumber == null || accountNumber == "") {
			alert("Please Enter Valid Account Number");
			return false;
		} else if (amount == null || amount == "") {
			alert("Please Enter Amount");
			return false;
		}
		$.ajax({
			type : "GET",
			url : "/amount/deposit",
			data : {
				"accountNumber" : accountNumber,
				"amount" : amount,
				"remarks" : remarks
			},
			dataType : 'text',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");
			},
			success : function(response) {
				if (response == "passed") {
					window.location.assign("/login/#/deposited");
				}
			},
			error : function(e, status) {
				alert("Enter Date and Remarks");
			}
		});
	};

	$scope.isValidAccountNumber = function() {
		var accountNumber = $scope.accountNumber;

		$.ajax({
			type : "GET",
			url : "/funds/isvalidaccountNumber",
			data : {
				"accountNumber" : accountNumber
			},
			dataType : 'json',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");
			},
			error : function(e, status) {
				window.location.assign("/login/#/deposited");
			},
			success : function(response) {
				if (response == "false") {
					$("#checkAccNumberIderrorMessage").show();
					$("#reset").click();
				} else if (response == "true") {
					$("#checkAccNumberIderrorMessage").hide();
				}
			}
		});
	}
});
// WithdrawMoneyController
app
		.controller(
				'WithdrawMoneyController',
				function($scope, $location, $http, $rootScope) {
					$scope.onwithdraw = function() {
						var accountNumber = $scope.accountNumber;
						var remarks = $scope.remarks;
						var amount = $scope.amount;
						var transactionDate = $scope.date;

						if (accountNumber == null || accountNumber == "") {
							alert("Please Enter Valid Account Number");
							return false;
						} else if (amount == null || amount == "") {
							alert("Please Enter Amount");
							return false;
						}
						$
								.ajax({
									type : "GET",
									url : "/amount/withdraw",
									data : {
										"accountNumber" : accountNumber,
										"amount" : amount,
										"transactionDate" : transactionDate,
										"remarks" : remarks
									},
									dataType : 'text',
									beforeSend : function(xhr) {
										xhr.setRequestHeader("Accept",
												"application/json");
										xhr
												.setRequestHeader(
														"Content-Type",
														"application/json;charset=utf-8");
									},
									success : function(response) {

										if (response == "pass") {
											window.location
													.assign("/login/#/deposited");
										} else {
											alert("Sufficent amount not available on your account to withdraw ");
											window.location
													.assign("/login/#/deposited");
										}
									},
									error : function(e, status) {
										alert("Enter WithdrawDate and Remarks");
									}
								});
					};

					$scope.isValidAccountNumber = function() {
						var accountNumber = $scope.accountNumber;

						$
								.ajax({
									type : "GET",
									url : "/funds/isvalidaccountNumber",
									data : {
										"accountNumber" : accountNumber
									},
									dataType : 'text',
									beforeSend : function(xhr) {
										xhr.setRequestHeader("Accept",
												"application/json");
										xhr
												.setRequestHeader(
														"Content-Type",
														"application/json;charset=utf-8");
									},

									error : function(e, status) {
										alert("Sufficent amount not available on your account to transfer  ");
										window.location
												.assign("/login/#/deposited");
									},
									success : function(response) {
										if (response == "false") {
											$("#checkAccNumberIderrorMessage")
													.show();
											$("#reset").click();
										} else if (response == "true") {
											$("#checkAccNumberIderrorMessage")
													.hide();
										}
									}
								});
					}
				});
// fundsTransferController
app.controller('fundsTransferController', function($scope, $location, $http,
		$rootScope) {
	$scope.onTransferfunds = function() {
		var username = $scope.username;
		var password = $scope.password;
		var accountNumber = $scope.accountNumber;
		var amount = $scope.amount;
		var transactionDate = $scope.date;
		var remarks = $scope.remarks;
		var fundsTransferBean={
				"username" : "username",
				"password" : "password",
				"accountNumber" : "accountNumber",
				"amount" : "amount",
				"transactionDate" : "transactionDate",
				"remarks": "remarks"
		}

		if (accountNumber == null || accountNumber == "") {
			alert("Please Enter Valid Account Number");
			return false;
		} else if (amount == null || amount == "") {
			alert("Please Enter Amount");
			return false;
		}
		$.ajax({
			type : "GET",
			url : "/funds/transfer",
			data: {"username" : username,
				"password" : password,
				"accountNumber" : accountNumber,
				"amount" : amount,
				"transactionDate" : transactionDate,
				"remarks": remarks},
			dataType : 'json',
			contentType: 'application/json; charset=utf-8',
			success : function(response) {
				if (response == "pass") {
					window.location.assign("/login/#/deposited");
				} else {
					alert("Sufficent amount not available");
					window.location.assign("/login/#/deposited");
				}
			},
			error : function(e, status) {
				alert(status);

			}
		});
	};

	$scope.isValidAccountNumber = function() {
		var accountNumber = $scope.accountNumber;

		$.ajax({
			type : "GET",
			url : "/funds/isvalidaccountNumber",
			data : {
				"accountNumber" : accountNumber
			},
			dataType : 'text',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");
			},
			error : function(e, status) {
				window.location.assign("/login/#/deposited");
			},
			success : function(response) {
				if (response == "false") {
					$("#checkAccNumberIderrorMessage").show();
					$("#reset").click();
				} else if (response == "true") {
					$("#checkAccNumberIderrorMessage").hide();
				}
			}
		});
	}
});
// transactionHistoryController

app.controller('transactionHistoryController', function($scope, $location,
		$http, $rootScope, filterFilter) {
	$scope.onTransferfunds = function() {
		var username = $scope.username;
		var password = $scope.password;
		$.ajax({
			type : "GET",
			url : "/history/transactonHistory",
			data : {
				"username" : username,
				"password" : password
			},
			dataType : 'text',
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");
			},
			success : function(response) {
				if (response == "passed") {
					window.location.assign("/login/#/transactionHistory");
				}
			},
			error : function(e, status) {
				alert("No Record Found.");
			}
		});
	};
});
// showTransactionHistoryDetailsController
app.controller('showTransactionHistoryDetailsController', function($scope,
		$location, $http, $rootScope, filterFilter) {
	var username = $scope.username;
	var password = $scope.password;
	$scope.currentPage = 1;
	$http({
		method : "GET",
		url : "/history/showhistory",
		params : {
			username : username,
			password : password
		}
	}).then(function(response) {
		var transactions = $scope.transactionHistory = response.data;
		alert(transactions);
		$scope.currentPage = 1;
		$scope.pageSize = 2;
		$scope.totalItems = $scope.transactionHistory.length;
		$scope.entryLimit = 8; // items per page
		noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

	});
	$scope.search = {};

	$scope.resetFilters = function() {
		alert("reached1");
		// needs to be a function or it won't trigger a $watch
		$scope.search = {};
	};

	$scope.resetPage = function() {
		$scope.currentPage = 1;
	}

});

app.controller('myProfileController', function($scope, $location, $http,
		$rootScope, filterFilter) {
	var username = $scope.username;
	var password = $scope.password;

	$http({
		method : "GET",
		url : "/profile/myProfile",
		params : {
			username : username,
			password : password
		}
	}).then(function(response) {
		alert($scope.accountNumber = response.data);

	});

	$.ajax({
		method : "GET",
		url : "/profile/myProfile",
		data : {
			"username" : username,
			"password" : password
		},
		dataType : 'json',
		timeout : 100000,
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type",
					"application/json;charset=utf-8");
		},
		success : function(response) {
			$.each(response,
					function(key, val) {
						var accountnumber = $("#accountNumber").html(
								val.accountNumber);
						var accountNumber = $scope.accountNumber = response;
						alert(accountNumber);
						$("#accountNumber").html(val.accountNumber);
						$("#accountName").html(val.accountName);
						$("#address").html(val.address);
						$("#emailId").html(val.emailId);
						$("#phoneNumber").html(val.phoneNumber);
						$("#panNumber").html(val.panNumber);
						$("#aadharNumber").html(val.aadharNumber);
						$("#accountOpenDate").html(val.accountOpenDate);
					});
		},
		error : function(e, status) {
			alert("error");
		}
	});
	$scope.title = "2";
	$scope.editorEnabled = false;
	$scope.enableEditor = function() {
		$scope.editorEnabled = true;
		$scope.editableTitle = $scope.title;
	};
	$scope.disableEditor = function() {
		$scope.editorEnabled = false;
	};

	$scope.updateAddress = function() {
		alert("updateAddress");
		window.location.assign("/login/#/updateProfile");
	}
});

app.controller('ProfileUpdateController', function($scope, $location, $http,
		$rootScope, filterFilter) {
	alert("myProfileUpdateController");
	var username = $scope.username;
	var password = $scope.password;
	$http({
		method : "GET",
		url : "/profile/myProfile",
		params : {
			username : username,
			password : password
		}
	}).then(function mySucces(response) {
		alert(response);
		var  check = $scope.profiledata = response.data;

	}, function myError(response) {
		alert("Error" + check);
	});
	$scope.enableEditor = function() {
		$scope.editorEnabled = true;
		$scope.editableTitle = $scope.title;

	}

	$scope.onProfileUpdate = function() {
		var username = $scope.username;
		var password = $scope.password;
		var address = $scope.data.address;
		var emailId = $scope.emailId;
		var phoneNumber = $scope.phoneNumber;
		var panNumber = $scope.panNumber;
		var aadharNumber = $scope.aadharNumber;

		$ajax({
			method : "GET",
			url : "/profile/update",
			data : {
				"username" : username,
				"password" : password,
				"address" : address,
				"emailId" : emailId,
				"phoneNumber" : phoneNumber,
				"panNumber" : panNumber,
				"aadharNumber" : aadharNumber
			},
			dataType : 'json',
			timeout : 100000,
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type",
						"application/json;charset=utf-8");
			},
			success : function(response) {
				if (response == "passed") {
					window.location.assign("/login/#/profileUpdate");
				}
			},
			error : function(e, status) {
				alert("not Updated");
			}
		});
	};
});

/*
 * app.controller('myProfileUpdateController', function($scope, $location,
 * $http, $rootScope) {
 * 
 * });
 */
