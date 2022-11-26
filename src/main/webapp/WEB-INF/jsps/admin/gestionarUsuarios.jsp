<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de usuarios</title>
<script src="https://cdn.tailwindcss.com"></script>
<script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
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
	<p class="text-lg text-center font-bold m-[3rem] text-[2rem] text-white"><spring:message code="admin.gestionUsuarios" /></p>
	
	<div class="py-3 px-3 rounded-lg flex w-4/6 mx-auto justify-center mb-10">
		<a class="py-4 px-6 bg-gradient-to-l from-indigo-500 to-indigo-800 font-bold text-[18px] text-white hover:text-[#00040f] outline-none rounded-[10px] border-[2px] border-white hover:border-indigo-900" href="nuevoUsuario"><spring:message code="admin.registrarUsuario" /></a>	
	</div>

	
	<table class="m-5 w-5/6 mx-auto text-gray-100 bg-gradient-to-l from-indigo-500 to-indigo-800" >
		<thead class="text-left border-b-2 border-indigo-300">
			<tr>
			<th class="px-4 py-3"><spring:message code="admin.foto" /></th>
				<th class="px-4 py-3">id</th>
				<th class="px-4 py-3"><spring:message code="admin.nombre" /></th>
				<th class="px-4 py-3"><spring:message code="admin.password" /></th>
				<th class="px-4 py-3"><spring:message code="admin.email" /></th>
				<th class="px-4 py-3"><spring:message code="admin.edad" /></th>
				<th class="px-4 py-3"><spring:message code="admin.apellidos" /></th>
				<th class="px-4 py-3"><spring:message code="admin.eliminar" /></th>
				<th class="px-4 py-3"><spring:message code="admin.editar" /></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="usuarios" items="${usuarios}">
				<tr class="border-b border-indigo-400">
					<td class="px-4 py-3">
			 		<object style="height:80px;"  data="../subidas/u${usuarios.id}.png">
						<img style="height: 80px" src="../subidas/nouser.png"/>
					</object> 
					</td>
					<td class="px-4 py-3">${usuarios.id}</td>
					<td class="px-4 py-3">${usuarios.nombre}</td>
					<td class="px-4 py-3">${usuarios.pass}</td>
					<td class="px-4 py-3">${usuarios.email}</td>
					<td class="px-4 py-3">${usuarios.edad}</td>
					<td class="px-4 py-3">${usuarios.apellidos}</td>
					<td class="px-4 py-3"><a class="text-[#FF6666] hover:text-[#FF1A1A] font-bold border-[2px] border-[#FF6666] hover:border-[#FF1A1A] py-1 px-2 rounded-lg bg-[#DC143C] hover:bg-[#FF6666]" onclick="return confirm('¿seguro?');" href="borrarUsuario?idBorrar=${usuarios.id}">X</a></td>
					<td class="px-4 py-3"><a class="text-[#FFBF00] hover:text-[#FFEA00] font-bold border-[2px] border-[#FFBF00] hover:border-[#FFEA00] py-1 px-2 rounded-lg bg-[#FCF55F] hover:bg-[#FFBF00]"  href="editarUsuario?idEditar=${usuarios.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>