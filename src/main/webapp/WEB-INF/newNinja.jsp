<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1 class="display-1">New Ninja</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja"> 
			<form:errors path="*"/>
			<div>
				<form:label path="dojo">Dojo:</form:label>
				<form:select path="dojo">
					<c:forEach var="oneDojo" items="${dojos}">
						<form:option value="${oneDojo.id}" path="dojo">
							<c:out value="${oneDojo.dojoName}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:label path="firstName">First Name:</form:label>
				<form:input path="firstName" type="text"/>
			</div>
			<div>
				<form:label path="lastName">Last Name:</form:label>
				<form:input path="lastName" type="text"/>
			</div>
			<div>
				<form:label path="age">Age:</form:label>
				<form:input path="age" type="number"/>
			</div>
			<button class="btn btn-success" type="submit">Create</button>
		</form:form>
	</div>
</body>
</html>