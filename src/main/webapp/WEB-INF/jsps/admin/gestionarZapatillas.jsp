<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion zapatillas</title>
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
	<p class="text-lg text-center font-bold m-[3rem] text-[2rem] text-white"><spring:message code="admin.gestionZapatillas" /></p>
	<div class="py-3 px-3 rounded-lg flex w-4/6 mx-auto justify-between mb-10 bg-gradient-to-l from-indigo-400 to-indigo-500">
		<div class="flex justify-center items-center">
			<form action="gestionarZapatillas" class="flex h-fit justify-center items-center text-gray-900">
				<div class="flex">
					<input type="text" name="modelo" value="${modelo}" class="rounded-l-lg" />
					<button type="submit" class="flex justify-center items-center bg-indigo-800 text-white px-2 rounded-r-lg hover:bg-indigo-600">
					  <svg
		              xmlns="http://www.w3.org/2000/svg"
		              viewBox="0 0 20 20"
		              fill="currentColor"
		              class="w-[2rem] h-[2rem]"
		            >
		              <path
		                fillRule="evenodd"
		                d="M9 3.5a5.5 5.5 0 100 11 5.5 5.5 0 000-11zM2 9a7 7 0 1112.452 4.391l3.328 3.329a.75.75 0 11-1.06 1.06l-3.329-3.328A7 7 0 012 9z"
		                clipRule="evenodd"
		              />
		            </svg>
					</button>
				</div>
			</form>
		</div>
		<div class="text-white font-semibold flex flex-col"> 
			<span class="w-full text-center"><spring:message code="admin.totalDeZapatillas" />: ${total}</span>
			<div class="flex mt-2 justify-end">
				<c:if test="${anterior >= 0}">
					<a class="px-2 py-2 bg-gradient-to-l from-indigo-500 to-indigo-800 hover:text-[#00040f] outline-none rounded-[10px] border-[2px] border-white hover:border-indigo-900 mr-5" href="gestionarZapatillas?comienzo=${anterior}">anterior</a>	
				</c:if>
				<c:if test="${siguiente < total}">
					<a class="px-2 py-2 bg-gradient-to-l from-indigo-500 to-indigo-800 hover:text-[#00040f] outline-none rounded-[10px] border-[2px] border-white hover:border-indigo-900" href="gestionarZapatillas?comienzo=${siguiente}">siguiente</a>
				</c:if>
			</div>
		</div>
		<a class="my-auto h-fit py-4 px-6 bg-gradient-to-l from-indigo-500 to-indigo-800 font-bold text-[18px] text-white hover:text-[#00040f] outline-none rounded-[10px] border-[2px] border-white hover:border-indigo-900" href="nuevaZapatilla"><spring:message code="admin.registrarZapatillas" /></a>
	</div>
	
	<table class="m-5 w-5/6 mx-auto text-gray-100 bg-gradient-to-l from-indigo-500 to-indigo-800">
		<thead class="text-left border-b-2 border-indigo-300">
			<tr>
				<th class="px-4 py-3"><spring:message code="admin.foto" /></th>
				<th class="px-4 py-3"><spring:message code="admin.caja" /></th>
				<th class="px-4 py-3">id</th>
				<th class="px-4 py-3"><spring:message code="admin.talla" /></th>
				<th class="px-4 py-3"><spring:message code="admin.modelo" /></th>
				<th class="px-4 py-3"><spring:message code="admin.sexo" /></th>
				<th class="px-4 py-3"><spring:message code="admin.color" /></th>
				<th class="px-4 py-3"><spring:message code="admin.precio" /></th>
				<th class="px-4 py-3"><spring:message code="admin.marca" /></th>
				<th class="px-4 py-3"><spring:message code="admin.categoria" /></th>
				<th class="px-4 py-3"><spring:message code="admin.eliminar" /></th>
				<th class="px-4 py-3"><spring:message code="admin.editar" /></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="zapatilla" items="${zapatillas}">
				<tr class="border-b border-indigo-400">
					<td class="px-4 py-3">
						<object style="height:60px;"  data="../subidas/${zapatilla.id}.png?t=${zapatilla.fechaImagen}">
							<img style="height: 60px" src="../subidas/defaultShoe.png"/>
						</object>
					</td>
					<td class="px-4 py-3">
						<object style="height:60px;"  data="../subidas/${zapatilla.id}-caja.png?t=${zapatilla.fechaImagen}">
							<img style="height: 60px" src="../subidas/defaultCaja.png"/>
						</object>
					</td>
					<td class="px-4 py-3">${zapatilla.id}</td>
					<td class="px-4 py-3">${zapatilla.talla}</td>
					<td class="px-4 py-3">${zapatilla.modelo}</td>
					<td class="px-4 py-3">${zapatilla.sexo}</td>
					<td class="px-4 py-3">${zapatilla.color}</td>
					<td class="px-4 py-3">${zapatilla.precio}</td>
					<td class="px-4 py-3">${zapatilla.marca}</td>
					<td class="px-4 py-3">${zapatilla.categoria.nombre}</td>
					<td class="px-4 py-3"><a class="text-[#FF6666] hover:text-[#FF1A1A] font-bold border-[2px] border-[#FF6666] hover:border-[#FF1A1A] py-1 px-2 rounded-lg bg-[#DC143C] hover:bg-[#FF6666]" onclick="return confirm('¿seguro?');" href="borrarZapatilla?idBorrar=${zapatilla.id}">X</a></td>
					<td class="px-4 py-3"><a class="text-[#FFBF00] hover:text-[#FFEA00] font-bold border-[2px] border-[#FFBF00] hover:border-[#FFEA00] py-1 px-2 rounded-lg bg-[#FCF55F] hover:bg-[#FFBF00]" href="editarZapatilla?idEditar=${zapatilla.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>