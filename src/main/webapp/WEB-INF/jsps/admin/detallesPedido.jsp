<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar pedido</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#00040f]">

		<p
		class="text-lg text-center font-bold my-[2rem] text-[2rem] text-white">Editar pedido</p>

<div class="flex justify-center w-full text-white">
	<div class="flex flex-col justify-center text-white bg-gradient-to-b from-gray-900 to-gray-600 bg-gradient-to-r w-fit p-3 rounded-lg text-[1.5rem]">
		<span class="text-[1.7rem] font-semibold">Detalles del pedido:</span>
		<span class="m-2 text-center"> nombre: ${pedido.nombreCompleto} </span>
		<span class="m-2 text-center"> direccion: ${pedido.direccion} </span>
		<span class="m-2 text-center"> provincia: ${pedido.provincia} </span>
		<span class="m-2 text-center"> ciudad: ${pedido.ciudad} </span>
		<span class="m-2 text-center"> cp: ${pedido.cp} </span>
		<span class="m-2 text-center">titular tarjeta: ${pedido.titularTarjeta} </span>
		<span class="m-2 mb-5 text-center">numero de tarjeta: ${pedido.numeroTarjeta} </span>
		
		<span class="text-[1.7rem] font-semibold">Productos del pedido:</span>
		<c:forEach var="pp" items="${pedido.productosPedido}">
			<div class="my-2 bg-gradient-to-b from-gray-700 to-gray-500 bg-gradient-to-r rounded-lg p-2">
				<span class="m-2">modelo: ${pp.zapatilla.modelo}</span>
				<span class="m-2">precio/unidad: ${pp.zapatilla.precio}</span>
				<span class="m-2">cantidad: ${pp.cantidad}</span>
			</div>
		</c:forEach>
		
		<label class="m-2 mt-7 flex justify-end items-center text-right">  ESTADO DEL PEDIDO:
			<select id="select_estado" class="text-gray-900 p-2 m-1 rounded-lg ml-2">
				<c:forEach var="estado" items="${estados}">
					<option 
					
						<c:if test="${ estado.key == pedido.estado }">
							selected
						</c:if>
					
						value="${estado.key}"
					> ${estado.value} </option>
				</c:forEach>
			</select>
		</label>
	</div>
</div>
	
<input type="hidden" id="id_pedido" value="${pedido.id}"/>
	
<script type="text/javascript" src="../librerias_js/jquery.js" ></script>
<script type="text/javascript">
	$("#select_estado").change(function(e){
		//obtener el estado seleccionado y mandarlo a un servicio web
		let estado = $(this).find(":selected").val();
		let idPedido = $("#id_pedido").val();
		$.post("ServicioWebPedidosAdmin/actualizarEstadoPedido",
				{
					id: idPedido,
					estado : estado
				}
		).done(function(res){
			alert(res);
		});
	});//end change
</script>

</body>
</html>




