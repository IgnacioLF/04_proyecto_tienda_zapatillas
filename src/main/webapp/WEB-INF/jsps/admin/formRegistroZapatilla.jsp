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

	introduce tus datos:

	<springform:form modelAttribute="zapatilla" action="guardarNuevaZapatilla" enctype="multipart/form-data">
	talla: <springform:input path="talla"/> <br>
	modelo: <springform:input path="modelo"/> <br>	
	sexo: <springform:input path="sexo"/> <br>	
	color: <springform:input path="color"/> <br>
	precio: <springform:input path="precio"/> <br>
	marca: <springform:input path="marca"/> <br>
	foto: <springform:input path="foto" type="file"/> <br>
	fotoCaja: <springform:input path="fotoCaja" type="file"/> <br>
	<input type="submit" value="REGISTRARME" />

</springform:form>
	
</body>
</html>