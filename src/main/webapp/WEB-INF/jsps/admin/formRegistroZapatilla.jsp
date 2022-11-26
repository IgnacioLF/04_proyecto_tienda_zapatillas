<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar zapatilla</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#00040f]">

<p
		class="text-lg text-center font-bold m-[3rem] text-[2rem] text-white">Registrar zapatilla</p>

<div class="flex justify-center w-full">
	<springform:form modelAttribute="zapatilla" action="guardarNuevaZapatilla" enctype="multipart/form-data" cssClass="flex flex-col text-white bg-gradient-to-b from-gray-900 to-gray-600 bg-gradient-to-r w-fit p-3 rounded-lg text-[1.5rem]">
	<label class="m-2 flex justify-end items-center">Talla: 
		<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="talla"/>
	</label>
	<label class="m-2 flex justify-end items-center"> Modelo: 
		<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1"  path="modelo"/>
		<span style="color: red"> <springform:errors path="modelo" /> </span> 
	</label>
	<label class="m-2 flex justify-end items-center"> Sexo:
		<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="sexo"/>
		<span style="color: red"> <springform:errors path="sexo" /> </span> 
	</label>
	<label class="m-2 flex justify-end items-center"> Color:
		<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="color"/>
		<span style="color: red"> <springform:errors path="color" /> </span> 
	</label>
	<label class="m-2 flex justify-end items-center"> Precio:
	 	<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="precio"/>
	 	<span style="color: red"> <springform:errors path="precio" /> </span> 
	</label>
	<label class="m-2 flex justify-end items-center"> Marca: 
		<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="marca"/>
		<span style="color: red"> <springform:errors path="marca" /> </span> 
	</label>
	<label class="m-2 flex justify-end items-center"> Foto:
		<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="foto" type="file"/>
	</label>
	<label class="m-2 flex justify-end items-center"> Categoria:
	 <springform:select cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="idCategoria">
					<springform:options items="${categorias}"/>
		</springform:select>
	</label>
	<label class="m-2 flex justify-end items-center"> FotoCaja: 
		<springform:input cssClass="text-[#000000] ml-[1rem] rounded-md px-2 py-1" path="fotoCaja" type="file"/>
	</label>
	<input class="py-2 px-3 bg-gradient-to-l from-indigo-500 to-indigo-800 font-bold m-auto w-fit h-fit text-[2rem] my-5 text-white hover:text-[#00040f] outline-none rounded-[10px] border-[2px] border-white hover:border-indigo-900" type="submit" value="REGISTRAR" />

</springform:form>
</div>
	
</body>
</html>