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

<h1> <c:out value="${dojos.name}"></c:out> Location Ninjas</h1>

	<table class="table">
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
			</tr>
		</thead>
	
		<tbody>
			<c:forEach var="oneNinja" items="${dojos.ninjas}">
				<tr>
				
					<td>
						<c:out value="${oneNinja.fname}"></c:out>
					</td>
					<td>
						<c:out value="${oneNinja.lname}"></c:out>
					</td>
					<td>
						<c:out value="${oneNinja.age}"></c:out>
					</td>
				
				</tr>
			</c:forEach>	
		
		</tbody>
	</table>
	
	<a href="/home">
	<button>Home</button>
	</a>
</body>
</html>