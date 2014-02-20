<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<c:url value="/main/admin" var="adminUrl"/>
<c:url value="/auth/logout/success" var="logoutUrl"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Common Page</title>
</head>
<body>
<div class="menu">
	<ul>
		<!--only admin could see this  -->
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="${adminUrl}">Admin</a></li>
		</sec:authorize>
		
		<li><a href="${logoutUrl}">Logout</a></li>
	</ul>
	<span id="menu-username">Welcome : <%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>
	<br style="clear:left"/>
</div>

<h1>
Common Page</h1><p>
Everyone has access to this page.</p><p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam ac velit et ante 
laoreet eleifend. Donec vitae augue nec sem condimentum varius.</p>
</body>
</html>