<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a administracion</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#00040f] text-white">
	<nav
		class="bg-gradient-to-l from-indigo-500 to-indigo-800 border-gray-200 px-2 sm:px-4 py-2.5">
		<div
			class="container flex flex-wrap items-center justify-between mx-auto">
			<img
				src="https://i.imgur.com/VPl04cV.png"
				class="h-6 mr-3 sm:h-9" alt="logo" />
			<div class="pl-[15rem]">
				<jsp:include page="menu.jsp"></jsp:include>
			</div>
			<div class="flex justify-center items-center">
				<a href="?lang=es" class="flex justify-center items-center mr-5 hover:text-purple-300"><img src="https://flagicons.lipis.dev/flags/1x1/es.svg" class="h-5 w-5 rounded mr-2" />Español</a> 
				<a href="?lang=en" class="flex justify-center items-center mr-5 hover:text-purple-300"><img src="https://flagicons.lipis.dev/flags/1x1/gb.svg" class="h-5 w-5 rounded mr-2" />Ingles</a> 
				<a href="?lang=fr" class="flex justify-center items-center hover:text-purple-300"><img src="https://flagicons.lipis.dev/flags/1x1/fr.svg" class="h-5 w-5 rounded mr-2" />Frances</a>
			</div>
		</div>
	</nav>
	<h1 class="m-auto w-full text-[3rem] font-bold text-center mt-[10rem]"><spring:message code="admin.bienvenido" /></h1>
</body>
</html>