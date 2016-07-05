
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="register" method="POST">
	<lable for="username">Username</lable>
	<input type="text" name="username" id="username"/>
	
	<lable for="email">Email</lable>
	<input type="text" name="email" id="email"/>
	
	<lable for="password">Password</lable>
	<input type="password" name="password" id="password"/>
	
	<input type="submit" value="register"/>

</form:form>