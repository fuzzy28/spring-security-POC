<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<h1>Header</h1>
<span id="menu-username">Welcome : <%=SecurityContextHolder.getContext().getAuthentication().getName()%></span>

<br style="clear:left"/>