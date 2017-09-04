$(document).ready(function(){
	
	$("#showRegister").click(function(){
		if($('#registerForm').is(':visible')){
			$('#registerForm').hide();
		}else{
			hideAll();
			$('#registerForm').show();
		}
	});
	
	$("#showLogin").click(function(){
		if($('#loginForm').is(':visible')){
			$('#loginForm').hide();
		}else{
			hideAll();
			$('#loginForm').show();
		}
	});
	
	function hideAll(){
		$('#registerForm').hide();
		$('#loginForm').hide();	
	}
	
	
	
	
    $("#registerButton").click(function(){
    	var userPassword = document.getElementById('userPassword').value;
    	var userName = document.getElementById('userName').value;
    	var Data={"name": userName, "password": userPassword};
    	
    	$.ajax({
    	    type: "POST",
    	    url: "http://localhost:8080/twitter-rest/register",
    	    data: JSON.stringify(Data),
    	    processData: false,
    	    cache: false,
    	    async: true,
    	    contentType: "application/json; charset=utf-8",
    	    dataType: "json",
    	    success: function(data){
    	    	console.log(data);
    	    	$("#registerFormMessage").text(data.message);
    	    	},
    	    failure: function(errMsg) {
    	        alert(errMsg);
    	    }
    	});
    });
    
    
    
    $("#loginButton").click(function(){
    	var userPassword = document.getElementById('loginUserPassword').value;
    	var userName = document.getElementById('loginUserName').value;
    	var Data={"password": userPassword, "name": userName};
    	
    	$.ajax({
    	    type: "POST",
    	    url: "http://localhost:8080/twitter-rest/login",
    	    data: JSON.stringify(Data),
    	    processData: false,
    	    cache: false,
    	    async: true,
    	    contentType: "application/json; charset=utf-8",
    	    dataType: "json",
    	    success: function(data){
    	    	console.log(data);
    	    	$("#loginFormMessage").text(data.message);

    	    	if(data.message.indexOf("Logged In") !== -1){
    	    		window.location.replace("http://localhost:8080/twitter-rest/user/"+userName);
    	    	}
    	    	},
    	    failure: function(errMsg) {
    	        alert(errMsg);
    	    }
    	});
    });
    
    
    $("#FollowButton").click(function(){
    	var userName = document.getElementById('FollowButton').value;
    	var Data={"name": userName};
    	
    	$.ajax({
    	    type: "POST",
    	    url: "http://localhost:8080/twitter-rest/follow",
    	    data: JSON.stringify(Data),
    	    processData: false,
    	    cache: false,
    	    async: true,
    	    contentType: "application/json; charset=utf-8",
    	    dataType: "json",
    	    success: function(data){
    	    	console.log(data);
    	    	},
    	    failure: function(errMsg) {
    	        alert(errMsg);
    	    }
    	});
    });
    
    
    
    
    
    
    
    
    $("#messageButton").click(function(){
    	var textMessage = document.getElementById('messageText').value;
    	var Data={"text": textMessage};
    	
    	console.log(textMessage);
    	
    	$.ajax({
    	    type: "POST",
    	    url: "http://localhost:8080/twitter-rest/message",
    	    data: JSON.stringify(Data),
    	    processData: false,
    	    cache: false,
    	    async: true,
    	    contentType: "application/json; charset=utf-8",
    	    dataType: "json",
    	    success: function(data){
    	    	console.log(data);
    	    	},
    	    failure: function(errMsg) {
    	        alert(errMsg);
    	    }
    	});
    });
    
});