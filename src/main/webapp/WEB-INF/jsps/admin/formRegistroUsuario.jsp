<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar usuario</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#00040f]">

	<p
		class="text-lg text-center font-bold m-[3rem] text-[2rem] text-white">Registrar usuario</p>
<div class="flex justify-center w-full">
	<springform:form modelAttribute="usuario" action="guardarNuevoUsuario" cssClass="flex flex-col text-white bg-gradient-to-b from-gray-900 to-gray-600 bg-gradient-to-r w-fit p-3 rounded-lg text-[1.5rem]">
		<label class="m-2 flex justify-end items-center"> Nombre de usuario: 
			<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="nombre"/> 
		</label>
		<label class="m-2 flex justify-end items-center"> Apellidos: 
			<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="apellidos"/>
		</label>
		<label class="m-2 flex justify-end items-center"> Email: 
			<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" a="f" type="email" path="email"/>
		</label>	
		<label class="m-2 flex justify-end items-center"> Pass: 
			<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="pass"/>	
		</label>
		<label class="m-2 flex justify-end items-center text-right"> Edad: 
			<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="edad"/>
		</label>
		<input class="py-2 px-3 bg-gradient-to-l from-indigo-500 to-indigo-800 font-bold m-auto w-fit h-fit text-[2rem] my-5 text-white hover:text-[#00040f] outline-none rounded-[10px] border-[2px] border-white hover:border-indigo-900" type="submit" value="REGISTRAR" />
	</springform:form>
</div>
</body>
</html>