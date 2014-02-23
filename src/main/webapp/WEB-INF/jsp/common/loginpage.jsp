<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Security POC</title>
</head>
<body>
 
<h1>
 
Login</h1>
<div id="login-message">
 ${message}
 </div>
 
<!-- let spring-security do his thing. -->
<form action="../login-check" method="post" >

<p>
 
 
 <label for="username">Username</label>
 <input id="username" name="username" type="text" />
</p><p>
 
 
 <label for="password">Password</label>
 <input id="password" name="password" type="password" />
</p><input  type="submit" value="Login"/>        
  
</form></body>
</html>