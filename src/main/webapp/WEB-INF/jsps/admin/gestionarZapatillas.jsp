<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
<script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
</head>
<body class="bg-[#00040f]">
<a class="py-4 px-6 bg-gradient-to-l from-indigo-500 to-indigo-800 font-bold text-[18px] text-white hover:text-[#00040f] outline-none rounded-[10px] border-[2px] border-white hover:border-indigo-900" href="nuevaZapatilla">registrar zapatillas</a>
	<p class="text-lg text-center font-bold m-[3rem] text-[2rem] text-white">Gestión de zapatillas</p>
	<jsp:include page="menu.jsp"></jsp:include>
	<table class="rounded-t-lg m-5 w-5/6 mx-auto text-gray-100 bg-gradient-to-l from-indigo-500 to-indigo-800">
		<thead class="text-left border-b-2 border-indigo-300">
			<tr>
				<th class="px-4 py-3">foto</th>
				<th class="px-4 py-3">caja</th>
				<th class="px-4 py-3">id</th>
				<th class="px-4 py-3">talla</th>
				<th class="px-4 py-3">modelo</th>
				<th class="px-4 py-3">sexo</th>
				<th class="px-4 py-3">color</th>
				<th class="px-4 py-3">precio</th>
				<th class="px-4 py-3">marca</th>
				<th class="px-4 py-3">categoria</th>
				<th class="px-4 py-3">Eliminar</th>
				<th class="px-4 py-3">Editar</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="zapatilla" items="${zapatillas}">
				<tr class="border-b border-indigo-400">
					<td class="px-4 py-3"><img style="height: 60px" src="../subidas/${zapatilla.id}.png?t=${zapatilla.fechaImagen}"/></td>
					<td class="px-4 py-3"><img style="height: 60px" src="../subidas/${zapatilla.id}-caja.png?t=${zapatilla.fechaImagen}"/></td>
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