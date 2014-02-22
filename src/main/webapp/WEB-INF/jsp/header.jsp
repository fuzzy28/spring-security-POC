<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/logout" var="logoutUrl"/>
<h1>Spring Security POC</h1>
<table>
<tr>
<td width="250">
<span id="menu-username">Welcome : <%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>
</td>
<td width="250" align="right"><a href="${logoutUrl}">Logout</a></td>
</tr>
</table>
<br style="clear:left"/>