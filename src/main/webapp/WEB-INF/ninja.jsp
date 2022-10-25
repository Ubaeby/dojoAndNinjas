<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninjas</title>
</head>
<body>

	<h1>New Ninja</h1>

	<form:form action="/new" method="post" modelAttribute="ninja">
	<p>
			<form:select path="dojo">
			<c:forEach var="oneDojo" items="${dojos}">
				<form:option value="${oneDojo.id}" path="dojo">
					<c:out value="${oneDojo.name}" />
				</form:option>
			</c:forEach>
		</form:select>
	
	</p>

		<div>
			<form:label path="fname">First Name:</form:label>
			<form:errors path="fname" />
			<form:input path="fname" />
		</div>

		<div>
			<form:label path="lname">Last Name:</form:label>
			<form:errors path="lname" />
			<form:input path="lname" />
		</div>

		<div>
			<form:label path="age">Age:</form:label>
			<form:errors path="age" />
			<form:input path="age" type="number" />
		</div>

		<button>Create</button>
	</form:form>

</body>
</html>