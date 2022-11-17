<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	
	<div style="text-align: right;margin: 10px">
	<a href="?lang=es">español</a>
	<a href="?lang=en">ingles</a>
	<a href="?lang=fr">frances</a>
</div>
	
	<spring:message code="admin.bienvenido" />

</body>
</html>