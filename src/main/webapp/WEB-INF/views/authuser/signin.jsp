<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
	<form:form action="/j_spring_security_check">
		<form:label path="username">Username or email</form:label>
		<form:input path="j_username"/>
		<form:label path="password">Password</form:label>
		<form:input path="j_password"/>
		<form:button></form:button>
	</form:form>