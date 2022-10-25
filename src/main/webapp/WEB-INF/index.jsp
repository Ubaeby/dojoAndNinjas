<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>

	<h1>Dojos and Ninjas</h1>

	<a class="btn btn-primary" href="/dojos/new">Create a Dojo</a>
	<a class="btn btn-success" href="/ninjas/new">Create a Ninja</a>

	<div class="d-flex flex-column">
		<c:forEach var="dojo" items="${dojos}">
			<a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"></c:out></a>
		</c:forEach>
	</div>



</body>
</html>