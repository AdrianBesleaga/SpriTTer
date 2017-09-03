<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/twitter-rest/resources/static/style.css">
<title>Profile Page</title>
</head>
<body>

<ul>
  <li><a class="btn active" href="/twitter-rest/">Home</a></li>
  <% if (session.getAttribute("userName") == null) { %>
  <li><button id="showLogin" class="btn">Login</button></li>
  <li><button id="showRegister" class="btn">Register</button></li>
  <% } %>
  <% if (session.getAttribute("userName") != null) { %>
  <li><a id="myProfile" class="btn" href="/twitter-rest/user/<%= session.getAttribute("userName") %>">Profile</a></li>
  <li><a id="logout" class="btn" href="/twitter-rest/logout">Logout</a></li>
  <% } %>
</ul>

<div id="registerForm" class="form">
<p> Register </p>

<input type="text" id="userName" class="input" placeholder="name"/>
<input type="password" id="userPassword" class="input" placeholder="password"/>
<p id="registerFormMessage"></p>

<button id="registerButton" class="btn">Register</button>
</div>


<div id="loginForm" class="form">
<p> Login </p>

<input type="text" id="loginUserName" class="input" placeholder="name"/>
<input type="password" id="loginUserPassword" class="input" placeholder="password"/>
<p id="loginFormMessage"></p>

<button id="loginButton" class="btn">Login</button>
</div>

<!-- End of Header -->
<%if (session.getAttribute("userName") != null) {%>

<h1>${userName}</h1>
<p>Id : ${userId}</p>
<p>Password : ${userPassword}</p>




<c><button id="${followButton}Button" value="${userName}" class="btn">${followButton}</button> </c>

<%}else{ %>
<p>Please login to see user info</p>
<%} %>

</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/twitter-rest/resources/javascript/functions.js"></script>
</html>