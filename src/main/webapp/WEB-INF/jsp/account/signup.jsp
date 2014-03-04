<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form id="tab" method="post" modelAttribute="account" action="../account/signup" >
	<label>Username</label> <form:input type="text" path="username" class="input-xlarge" />
	<label>Password</label> <form:input type="password" path="password" class="input-xlarge" />
	<label>First Name</label> <form:input type="text" path="firstName"  class="input-xlarge" /> 
	<label>Last	Name</label> <form:input type="text" path="lastName"  class="input-xlarge" /> 
	<label>Email</label> <form:input type="text" path="email" class="input-xlarge" /> 
	<label>Address</label>
	<textarea value="" rows="3" class="input-xlarge"></textarea>
	<div>
		<button class="btn btn-lg btn-primary">Create Account</button>
	</div>
</form:form>