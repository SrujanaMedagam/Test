app.controller('managerHandleLeaveRequest', function($scope, $location,$http,$rootScope) {
	$scope.handleLeaveRequests=function()
	{
		$location.path('/leaveRequets');
		
	}
	
	
  /*  $scope.handleLeaveRequests=function(){
    	//alert("ajksb");
    	var managerEmpId=$rootScope.username;
    	$("#"+managerEmpId).hide(); // to hide generating report button
    	//alert(managerEmpId);
    	$.ajax({  
    		type : "GET",  
    		url : "/manager/handleLeaveRequests",  
    		data : {"managerEmpId" : managerEmpId},
    		dataType : 'json',
    		beforeSend: function(xhr) {  
    			xhr.setRequestHeader("Accept", "application/json");  
    			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    			
    		},  
    		success : function(response) {
    			//alert("reached");
    			//alert(response);
    			var temp = '';
      			
      			temp+='<table id="handleLeaveRequest" class="table main_table table-striped table-hover"  width="100%" cellpadding="0" cellspacing="0" border="0" > ';
      			temp+='<thead>';
      			temp+='<tr>';
      			temp+='<th>Employee ID</th><th>From Date</th><th>To Date</th><th>No Of Days</th><th>Reason</th><th>Approve/Reject</th> ';
      			
      			temp+='</tr> ';
      			temp+='</thead> ';
      			temp+='<tbody> ';
      			//var commonName = response.display_common_names;
      			$.each(response,function(key,val){
      				temp+='<tr>';
      				temp+='<td id="EmployeeID">' +val.eid+ '</td>';
      				temp+='<td id="fromDate">' +val.fromDate+ '</td>';
      				temp+='<td id="toDate">' +val.toDate+ '</td>';
      				temp+='<td>' +val.noOfDays+ '</td>';
      				temp+='<td>' +val.reason+ '</td>';
      				temp+='<td><button id="'+val.sno+'" onclick="acceptLeaveRequest(this)" class="btn btn-link">Approve</button><button id="'+val.sno+'" style="margin-left:2px;" onclick="rejectLeaveRequest(this)" class="btn btn-link">Reject</button></td>';
      				temp+='</tr>'
      					});
      				
      					
      				
      			
      			temp+='</tbody> ';
      			temp+='</table> ';
      			$('#handleLeaveRequestTable').html(temp);
      			$("#handleLeaveRequestTable").show();
      			$(document).ready(function() {
      				//alert("1");
      			    $('#handleLeaveRequest').DataTable();
      			} );
	
    				
    			
    		},  
    		error : function(e,status) {
    			alert("error");
    			alert(status);
    			
    		}  

    	}); 
    	
    
    }*/
	$scope.showReportingEmployeesDetails=function(){
		$location.path('/reportingemployeedetails');
	}
    /*$scope.showReportingEmployeesDetails=function(){
    	//alert("ajksb");
    	
    	var managerEmpId=$rootScope.username;
    	$("#generateReportBtn").attr('id',managerEmpId);
    	$("#"+managerEmpId).show();
    	//alert(managerEmpId);
    	$.ajax({  
    		type : "GET",  
    		url : "/manager/showReportingEmployeesDetails",  
    		data : {"managerEmpId" : managerEmpId},
    		dataType : 'json',
    		beforeSend: function(xhr) {  
    			xhr.setRequestHeader("Accept", "application/json");  
    			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    			
    		},  
    		success : function(response) {
    			//alert("reached");
    			//alert(response);
    			//alert(managerEmpId);
    			var temp = '';
      			
      			temp+='<table id="showReportingEmployees" class="table main_table table-striped table-hover"  width="100%" cellpadding="0" cellspacing="0" border="0" > ';
      			temp+='<thead>';
      			temp+='<tr>';
      			temp+='<th>Sno</th><th>Employee ID</th><th>From Date</th><th>To Date</th><th>No Of Days</th><th>Reason</th><th>Leave Status</th> ';
      			
      			temp+='</tr> ';
      			temp+='</thead> ';
      			temp+='<tbody> ';
      			//var commonName = response.display_common_names;
      			$.each(response,function(key,val){
      				var index=key+1;
      				temp+='<tr>';
      				temp+='<td>' +index+'</td>';
      				temp+='<td id="EmployeeID">' +val.eid+ '</td>';
      				temp+='<td id="fromDate">' +val.fromDate+ '</td>';
      				temp+='<td id="toDate">' +val.toDate+ '</td>';
      				temp+='<td>' +val.noOfDays+ '</td>';
      				temp+='<td>' +val.reason+ '</td>';
      				if(val.leaveStatus==1)
      					{
      				temp+='<td style="color:green;">Approved</td>';
      					}
      				else if(val.leaveStatus==3)
      					{
      					temp+='<td style="color:red;">Rejected</td>';
      					}
      				temp+='</tr>'
      					});
      				
      					
      				
      			
      			temp+='</tbody> ';
      			temp+='</table> ';
      			$('#handleLeaveRequestTable').html(temp);
      			$("#handleLeaveRequestTable").show();
      			$(document).ready(function() {
      				//alert("2");
      			    $('#showReportingEmployees').DataTable();
      			} );
	
    				
    			
    		},  
    		error : function(e,status) {
    			alert("error");
    			alert(status);
    			
    		}  

    	}); 
    }*/
});
/*function generateReport(ev)
{
var managerEmpId=$(ev).attr("id");
//alert(managerEmpId);
var url="/manager/managerGenerateReport?managerEmpId="+managerEmpId;
window.location.assign(url);
}*/

function acceptLeaveRequest(ev){
	//alert($(ev).attr("id"));
	var sno=$(ev).attr("id");
	$.ajax({  
		type : "GET",  
		url : "/manager/acceptLeaveRequest",  
		data : {"sno" : sno},
		dataType : 'text',
		beforeSend: function(xhr) {  
			xhr.setRequestHeader("Accept", "application/json");  
			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
			
		},  
		success : function(response) {
			//alert("reached");
		if(response=="passed")
			{
			alert("leave request Approved");
			$("#"+sno).closest("tr").remove();
			//$("#approveRejectBtn").click();
			}
			

				
			
		},  
		error : function(e,status) {
			alert("error");
			alert(status);
			
		}  

	}); 
	
}
function rejectLeaveRequest(ev){
	//alert($(ev).attr("id"));
	var sno=$(ev).attr("id");
	$.ajax({  
		type : "GET",  
		url : "/manager/rejectLeaveRequest",  
		data : {"sno" : sno},
		dataType : 'text',
		beforeSend: function(xhr) {  
			xhr.setRequestHeader("Accept", "application/json");  
			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
			
		},  
		success : function(response) {
			//alert("reached");
		if(response=="passed")
			{
			
			alert("leave request rejected");
			$("#"+sno).closest("tr").remove();
			
			//$("#approveRejectBtn").click();
			}
			

				
			
		},  
		error : function(e,status) {
			alert("error");
			alert(status);
			
		}  

	}); 
	
}

// new controller 
app.controller('leaveRequests', function($scope,$location,$http,$rootScope,$sce) {
	var managerEmpId=$rootScope.username;
	$scope.currentPage = 1; 
	$("#"+managerEmpId).hide(); // to hide generating report button
	//alert(managerEmpId);
	var url="/manager/handleLeaveRequests?managerEmpId="+managerEmpId;
	$http.get(url)
    .then(function(response) {
        $scope.leaveRequest = response.data;
        //alert($scope.leaveRequest);
     // pagination controls
    	$scope.currentPage = 1;
    	$scope.totalItems = $scope.leaveRequest.length; 
    	$scope.entryLimit = 5; // items per page
    	$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

    });
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
    
	
	
});

app.controller('showReportingEmployeesDetails', function($scope,$location,$http,$rootScope,filterFilter) {
	
	var managerEmpId=$rootScope.username;
	$scope.currentPage = 1; 
	//alert(managerEmpId);
	var url="/manager/showReportingEmployeesDetails?managerEmpId="+managerEmpId;
	$http.get(url)
    .then(function(response) {
        $scope.employeeDetails = response.data;
       // alert($scope.employeeDetails);
     // pagination controls
    	$scope.currentPage = 1;
    	$scope.totalItems = $scope.employeeDetails.length; 
    	$scope.entryLimit = 5; // items per page
    	$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

    });
	// create empty search model (object) to trigger $watch on update
	$scope.search = {};

	$scope.resetFilters = function () {
		// needs to be a function or it won't trigger a $watch
		$scope.search = {};
	};
	$scope.resetPage=function()
	{
		$scope.currentPage = 1;
	}

	/*$scope.employeeDetails=200;

	// $watch search to update pagination
	$scope.$watch('search', function (newVal, oldVal) {
		alert("reached2");
		alert(newVal);
		alert(oldVal);
		
		$scope.filtered = filterFilter($scope.employeeDetails, newVal);
		$scope.totalItems = $scope.filtered.length;
		$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
		$scope.currentPage = 1;
	}, true);*/

 
	    $scope.generateReport=function()
		{
	    	var url="/manager/managerGenerateReport?managerEmpId="+managerEmpId;
	    	window.location.assign(url);
		}

	
	
});
function displayEmployeeDataInToolTip(ev)
{
	
	
	
	var empId=$(ev).text();
	//alert(empId);
	/*$(ev).append('<div style="width:200px;position:absolute;border:1px solid red; margin-left: 61px;z-index:1000;">'+'<p>sajdg</p>'
    + '<p>sajdg</p>'+ '<p>sajdg</p>'+ '<p>sajdg</p>'+ '<p>sajdg</p>'+ '<p>sajdg</p>'+'</div>');*/
	$.ajax({  
		type : "GET",  
		url : "/manager/displayEmployeeDataInToolTip",  
		data : {"empId" : empId},
		dataType : 'json',
		beforeSend: function(xhr) {  
			xhr.setRequestHeader("Accept", "application/json");  
			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
			
		},  
		success : function(response) {
		//	alert("reached");
			var mobileNumber="";
			var alternatemobileNumber="";
			$.each(response,function(key,val){
			//	alert(val.firtsName.toUpperCase() +" " +val.lastName.toUpperCase());
			//	alert(val.fatherName);
				var phoneNumbers=val.employeePhoneNumbers;
				$.each(phoneNumbers,function(key,val){
					if(key==0)
						{
						mobileNumber=val.phoneNumber;
						}
					else if(key==1)
						{
						alternatemobileNumber=val.phoneNumber;
						}
				});
				$(ev).append('<div style="width:230px;position:absolute;border:1px solid #eee; margin-left: 61px;z-index:1000;background-color: #eee; border-radius:15px 0px 0px 0px; padding-left:10px;">'+'<p>Employee Name: '+val.firtsName.toUpperCase() +' '+val.lastName.toUpperCase()+'</p>'
					    + '<p>Mobile No: '+mobileNumber+' </p>'+ '<p>Alternate Mobile No: '+alternatemobileNumber+' </p>'+ '</div>');
			
			});
			

				
			
		},  
		error : function(e,status) {
			alert("error");
			alert(status);
			
		}  

	}); 
	
}
function removeEmployeeDataInToolTip(ev)
{
	$(ev).find('div').remove();
	
}


