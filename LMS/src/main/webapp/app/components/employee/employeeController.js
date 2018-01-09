app.controller('employeeLeaveController', function($scope, $location,$http,$rootScope) {
	
	$scope.submit=function(){
		
	//	alert("asdilh");
		$location.path('/applyleave');
		//alert(empId);
		 $scope.$on('handleBroadcast', function(data) {
			 alert("reached");
			 empId=data;
		    }); 
		 var empId=$rootScope.username;
		
		$.ajax({  
    		type : "GET",  
    		url : "/leave/getReportingManager",  
    		data : {"empId" : empId},
    		dataType : 'text',
    		beforeSend: function(xhr) {  
    			xhr.setRequestHeader("Accept", "application/json");  
    			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    			
    		},  
    		success : function(response) {
    			//alert("reached");
    			//alert(response);
    			$("#reportingManagerLabel").html(response);
    			
    			var url="/leave/getEmployeeBalanceLeaves?empId="+empId;
    			$http.get(url)
    		    .then(function(response) {
    		    	$("#balanceLeaves").val(response.data);

    		    });
    			
    				
    				
    			
    		},  
    		error : function(e,status) {
//    			alert(status);
    			
    		}  

    	}); 
		
		
	  //  alert("working");
	};
	$scope.appliedLeaveHomepage=function(){
		//	alert("asdilh");
			$location.path('/appliedleave');
			
		  //  alert("working");
		};
		$scope.updateProfile=function(){
			//	alert("asdilh");
				$location.path('/updateprofile');
				
			  //  alert("working");
			};
	
});
app.controller('employeeApplyLeave', function($scope, $location,$http,$rootScope) {

	
	
	function calcBusinessDays(dDate1, dDate2) {

        var weekoff1 = document.getElementById("hdnweekoffdays1").value;
        var weekoff2 = document.getElementById("hdnweekoffsays2").value;       
         
        var wo1 = weekoff1 - 1;
        var wo2 = weekoff2 - 1;
        var count = 0;
     
        var Holidays = document.getElementById("hdnHolidayDates").value;      
        
        var hldDates = Holidays.split(",");          
        for (var d = new Date(dDate1) ; d <= dDate2; d.setDate(d.getDate() + 1)){
        	
            if (d.getDay() == wo1 || d.getDay() == wo2) {
                count++;
                continue;
            }
            var enddate = new Date(d);
            var dd = enddate.getDate();
            var mm = enddate.getMonth() + 1;

            var yyyy = enddate.getFullYear();
            if (dd < 10) {
                dd = '0' + dd;
            }
            if (mm < 10) {
                mm = '0' + mm;
            }
            var enddate = mm + '-' + dd + '-' + yyyy;
            var n = hldDates.length;
            for (i = 0; i < n; i++)
            {
                var hdate = hldDates[i];
                // changing the date format 
                var hldDate = new Date(hdate);
                var dd = hldDate.getDate();
                var mm = hldDate.getMonth() + 1;

                var yyyy = hldDate.getFullYear();
                if (dd < 10) {
                    dd = '0' + dd;
                }
                if (mm < 10) {
                    mm = '0' + mm;
                }
                var hldDate = mm + '-' + dd + '-' + yyyy;
                // check for holiday
               if (hldDate == enddate)
               {
                   count++;
               }
            }
        }        
        var weekoffdays = count;        
        var totalDays = (dDate2 - dDate1) / 1000 / 60 / 60 / 24;
        var noOfdays = totalDays - weekoffdays;
       
        return noOfdays + 1;
     }
    
	
	
	function datediff(fromDate, toDate) {
		var second = 1000, minute = second * 60, hour = minute * 60, day = hour * 24, week = day * 7;
		fromDate = new Date(fromDate);
		toDate = new Date(toDate);
		
		var newstartdate = new Date();
		newstartdate.setFullYear(fromDate.getYear(), fromDate.getMonth(), fromDate.getDay());
		var newenddate = new Date();
		newenddate.setFullYear(toDate.getYear(), toDate.getMonth(), toDate.getDay());
		
		
		var days = 0;

	 var days = calcBusinessDays(fromDate, toDate);
			return days-1;
	}	
	
	function checkdates() {
		var txtfrom1 = $scope.frmdate;
		var txtto1 = $scope.todate;
		var noOfdaysValue;

				
		var rblfrom = document.querySelector('input[name="fromOptRadio"]:checked').value;
		var rblto = document.querySelector('input[name="toOptRadio"]:checked').value;
		
		var from = txtfrom1;
		var to = txtto1;		
		
		
		/*if (from == "" || to == "") {
			noOfdaysValue = "";
		}		
		*/
		
		if (from != "" && to != "") {
			var datefrom = from.split("-");
			var dateto = to.split("-");
			from = datefrom[0] + "-" + datefrom[1] + "-" + datefrom[2];
			to = dateto[0] + "-" + dateto[1] + "-" + dateto[2];
			var fromdate = new Date(from);
			var todate = new Date(to);

			//alert(fromdate+" To "+todate);
			
			
			var differece = datediff(fromdate, todate);
			//alert(differece+"   differece");
			noOfdaysValue = Math.round((differece) + 1);
			
			//alert(noOfdaysValue+"  noOfdaysValue");
			if ((rblfrom == 0) && (rblto == 0)) {
				noOfdaysValue = noOfdaysValue - 0.5;				
			} else if ((rblfrom == 0) && (rblto == 1)) {
				noOfdaysValue = noOfdaysValue - 0;				
			} else if ((rblfrom == 1) && (rblto == 0)) {
				noOfdaysValue = noOfdaysValue - 1;				
			} else if ((rblfrom == 1) && (rblto == 1)) {
				noOfdaysValue = noOfdaysValue - 0.5;			
			}

			$scope.noOfDays=noOfdaysValue;		
			
		}
			
	}
	
	
	$scope.calculateNoOfDays=function(){

		flag = checkdates();
		if (flag == false) {
			return false;
		}
		
	};
	
	/*$scope.applyLeave = function(){
		//alert($rootScope.username);
		var uid=$rootScope.username;
		var fromdate=$scope.frmdate;
		var todate=$scope.todate;
		var noOfDays=$scope.noOfDays;
		var reason=$scope.reason;
		$.ajax({  
    		type : "GET",  
    		url : "/leave/applyleave",  
    		data : {"uid" : uid,"fromdate":fromdate,"todate":todate,"noOfDays" : noOfDays,"reason":reason},
    		dataType : 'text',
    		beforeSend: function(xhr) {  
    			xhr.setRequestHeader("Accept", "application/json");  
    			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    			
    		},  
    		success : function(response) {
    			//alert("reached");
    			if(response=="passed")
    				{
    				
    				alert("leave applied successfully");
    				}
    		//	$("#reset").click();
    			window.location.assign("/login/#/employeelogin");
    				
    				
    			
    		},  
    		error : function(e,status) {
    			alert("error");
    			alert(status);
    			
    		}  

    	}); 
		
	};*/
	$scope.applyLeave = function(){
		//alert($rootScope.username);
		var eid=$rootScope.username;
		var fromDate=$scope.frmdate;
		var toDate=$scope.todate;
		var noOfDays=$scope.noOfDays;
		var reason=$scope.reason;
		var leaveData={"eid" : eid,"fromDate":fromDate,"toDate":toDate,"noOfDays" : noOfDays,"reason":reason};
		$.ajax({  
    		type : "POST",  
    		url : "/leave/applyleave",  
    		data : JSON.stringify(leaveData),
    		dataType : 'json',
    		timeout : 100000,
    		beforeSend: function(xhr) {  
    			xhr.setRequestHeader("Accept", "application/json");  
    			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    			
    		},  
    		success : function(response) {
    			//alert("reached");
    			if(response=="passed")
    				{
    				
    				alert("leave applied successfully");
    				}
    		//	$("#reset").click();
    			window.location.assign("/login/#/employeelogin");
    				
    				
    			
    		},  
    		error : function(e,status) {
    			alert("error");
    			alert(status);
    			
    		}  

    	}); 
		
	};
	
	

});
app.controller('employeeAppliedLeave', function($scope, $location,$http,$rootScope) {
	$scope.getLeaveData=function(){
		var fromDate= $scope.frmdate;
		var toDate=$scope.todate;
		var eid=$rootScope.username;
		//alert(fromDate+" "+toDate);
		$.ajax({  
    		type : "GET",  
    		url : "/leave/appliedleaves",  
    		data : {"eid" : eid,"fromDate":fromDate,"toDate":toDate},
    		dataType : 'json',
    		beforeSend: function(xhr) {  
    			xhr.setRequestHeader("Accept", "application/json");  
    			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    			
    		},  
    		success : function(response) {
    			//alert("reached");
    			//alert(response.eid);
    			var temp = '';
      			
      			temp+='<table id="dispAppliedLeaves" class="table main_table table-striped table-hover"  width="100%" cellpadding="0" cellspacing="0" border="0" > ';
      			temp+='<thead>';
      			temp+='<tr>';
      			temp+='<th>From Date</th><th>To Date</th><th>No Of Days</th><th>Reason</th><th>Status</th> ';
      			$.each(response,function(key,val){
      				temp+='<th>'
      			});
      			temp+='</tr> ';
      			temp+='</thead> ';
      			temp+='<tbody> ';
      			//var commonName = response.display_common_names;
      			$.each(response,function(key,val){
      				temp+='<tr>';
      				temp+='<td id="fromDate">' +val.fromDate+ '</td>';
      				temp+='<td id="toDate">' +val.toDate+ '</td>';
      				temp+='<td>' +val.noOfDays+ '</td>';
      				temp+='<td>' +val.reason+ '</td>';
      				//alert(val.leaveStatus);
      				if(val.leaveStatus=="0")
      					{
      					var eid=val.eid;
      					temp+='<td>Pending<button id="'+eid+'" onclick="cancelLeaveRequest(this)" class="btn btn-link">Cancel Request</button></td>';
      					}
      				else if(val.leaveStatus=="1")
  					{
  					temp+='<td>Approved</td>';
  					}
      				else if(val.leaveStatus=="2")
  					{
  					temp+='<td>Cancelled</td>';
  					}
      				else
      					{
      					temp+='<td>Rejected</td>';
      					}
      					
      				temp+='</tr>'
      			});
      			temp+='</tbody> ';
      			temp+='</table> ';
      			$('#showLeaves').html(temp);
      			$("#showLeaves").show();
	
    				
    			
    		},  
    		error : function(e,status) {
    			alert("error");
    			alert(status);
    			
    		}  

    	}); 
	}
	$scope.cancelLeaveRequest=function(){
	//alert("asjkdbg");
	}
	
	
});
function cancelLeaveRequest(ev)
{
	//alert($(ev).attr("id"));
	/*var eid=$(ev).attr("id");
	var fromDate=$("#fromDate").text();
	var toDate=$("#toDate").text();
	//alert(toDate+" "+fromDate);
	$.ajax({  
		type : "GET",  
		url : "/leave/cancelLeaves",  
		data : {"eid" : eid,"fromDate":fromDate,"toDate":toDate},
		dataType : 'text',
		beforeSend: function(xhr) {  
			xhr.setRequestHeader("Accept", "application/json");  
			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
			
		},  
		success : function(response) {
			//alert("reached");
		if(response=="passed")
			{
			alert("leave request cancelled");
			$("#showAppliedleaves").click();
			}
			

				
			
		},  
		error : function(e,status) {
			alert("error");
			alert(status);
			
		}  

	}); */
	var eid=$(ev).attr("id");
	var fromDate=$("#fromDate").text();
	var toDate=$("#toDate").text();
	//alert(toDate+" "+fromDate);
	var updateLeaveData={"eid" : eid,"fromDate":fromDate,"toDate":toDate};
	$.ajax({  
		type : "PUT",  
		url : "/leave/cancelLeaves",  
		data : JSON.stringify(updateLeaveData),
		dataType : 'json',
		timeout : 100000,
		beforeSend: function(xhr) {  
			xhr.setRequestHeader("Accept", "application/json");  
			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
			
		},  
		success : function(response) {
			//alert("reached");
		if(response=="passed")
			{
			alert("leave request cancelled");
			$("#showAppliedleaves").click();
			}
			

				
			
		},  
		error : function(e,status) {
			alert("error");
			alert(status);
			
		}  

	}); 
}
app.controller('saveEmployeeDetails', function($scope, $location,$http,$rootScope) {
	$scope.saveEmployeeDetails = function(){
		//alert($rootScope.username);
		var empId=$rootScope.username;
		var firtsName=$scope.fname;
		var lastName=$scope.lname;
		var fatherName=$scope.fatherName;
		var mobNo=$scope.mobNo;
		var alMobNo=$scope.altMobNo;
		var address=$scope.address;
		var employeeData={"empId" : empId,"firtsName":firtsName,"lastName":lastName,"fatherName" : fatherName,"mobNo":mobNo,"alMobNo":alMobNo,"address":address};
		$.ajax({  
    		type : "POST",  
    		url : "/leave/saveEmployeeDetails",  
    		data : JSON.stringify(employeeData),
    		dataType : 'json',
    		timeout : 100000,
    		beforeSend: function(xhr) {  
    			xhr.setRequestHeader("Accept", "application/json");  
    			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
    			
    		},  
    		success : function(response) {
    			//alert("reached");
    			if(response=="passed")
    				{
    				
    				alert("Employee Details Saved");
    				}
    		//	$("#reset").click();
    			window.location.assign("/login/#/employeelogin");
    				
    				
    			
    		},  
    		error : function(e,status) {
    			alert("error");
    			alert(status);
    			
    		}  

    	}); 
		
	};
	
});

