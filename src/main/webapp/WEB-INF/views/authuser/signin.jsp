<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<c:if test="${error == true }">
		<span>Invalid value username or password</span>
	</c:if>
	<c:url value="/j_spring_security_check" var="signinUrl" />
	<form:form action="${signinUrl}">
		<label for="username">Username or email</label>
		<input type="text" name="j_username" id="username" />
		<label for="password">Password</label>
		<input type="password" name="j_password" id="password" />
		<input type="submit">Signin</input>
	</form:form>
</body>
</html>