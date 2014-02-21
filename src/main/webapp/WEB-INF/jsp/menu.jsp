<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<p>Menu</p>
<c:url value="/main/admin" var="adminUrl"/>
<div class="menu">
	<ul>
		<!--only admin could see this  -->
		<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="${adminUrl}">Admin</a></li>
		</sec:authorize>
	</ul>
</div>