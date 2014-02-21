<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/logout" var="logoutUrl"/>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>The Common Page</title>
</head>
<body>
<a href="${logoutUrl}">Logout</a>
<h1>Common Page</h1><p>
Everyone has access to this page.</p><p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ac velit et ante 
laoreet eleifend. Donec vitae augue nec sem condimentum varius.</p>
</body>
</html>