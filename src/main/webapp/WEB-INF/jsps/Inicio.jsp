<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
<script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
</head>
<body>

<spring:message code="inicio.bienvenida" />  <span style="color: blue" id="inicio_span_nombre_usuario">(usuario no identificado)</span>

<div style="text-align: right;margin: 10px">
	<a href="?lang=es">español</a>
	<a href="?lang=en">ingles</a>
	<a href="?lang=fr">frances</a>
</div>


<div>
	<a href="#" id="inicio"><spring:message code="inicio.inicio" /></a> &nbsp;&nbsp;&nbsp;
	<a href="#" id="carrito"><spring:message code="inicio.carrito" /></a> &nbsp;&nbsp;&nbsp;
	<a href="#" id="login"><spring:message code="inicio.identificarme" /></a> &nbsp;&nbsp;&nbsp;
	<a href="#" id="registrarme"><spring:message code="inicio.registrarme" /> </a> &nbsp;&nbsp;&nbsp;
	<a href="#" style="display: none" id="logout"><spring:message code="inicio.salir" /></a> &nbsp;&nbsp;&nbsp;
	
	
</div>
<div id="contenedor">

</div>
<script type="text/javascript" src="librerias_js/jquery.js"></script>
<script type="text/javascript" src="librerias_js/mustache.js" ></script>
<script type="text/javascript" src="javascript/cargar_plantillas.js"></script>
<script type="text/javascript" src="javascript/cargar_eventos.js"></script>
<script type="text/javascript" src="javascript/funciones.js"></script>
<script type="text/javascript" src="javascript/funciones_checkout.js"></script>
<script type="text/javascript" src="javascript/globales.js"></script>

</body>
</html>