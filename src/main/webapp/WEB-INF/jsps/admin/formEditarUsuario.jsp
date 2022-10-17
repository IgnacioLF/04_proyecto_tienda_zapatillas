<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	datos del usuario a editar:

	<springform:form modelAttribute="usuario" action="actualizarUsuario">
	nombre: <springform:input path="nombre"/> <br>
	apellidos: <springform:input path="apellidos"/> <br>
	email: <springform:input a="f" type="email" path="email"/> <br>	
	pass: <springform:input path="pass"/> <br>	
	edad: <springform:input path="edad"/> <br>
	<springform:hidden path="id"/>
	<input type="submit" value="GUARDAR CAMBIOS" />

</springform:form>
	
</body>
</html>