function cargarEventos() {
	//con jquery digo que va a pasar cuando se haga click en un enlace
	$("#inicio").click(function() {
		// $("#contenedor").html(plantillas.productos);
		//		$.get("ServicioZapatillas", (res) => {
		//			var libros = JSON.parse(res)
		//			var resultado = Mustache.render(plantillas.productos, libros);
		//			$("#contenedor").html(resultado);
		//		})
		mostrar_productos();
	});

	$("#carrito").click(function() {
		$("#contenedor").html(plantillas.carrito);
	});

	$("#login").click(function() {
		$("#contenedor").html(plantillas.login);
		$("#form_login").submit(function(e) {
			e.preventDefault();
			identificar_usuario();
		});
	});

	$("#registrarme").click(function() {
		$("#contenedor").html(plantillas.registrarme);
		$("#form_registro_usuario").submit((e) => {
			e.preventDefault();
			var nombre = $("#nombre").val()
			var email = $("#email").val()
			var pass = $("#pass").val()
			var edad = $("#edad").val()
			var apellidos = $("#apellidos").val()
			var usuario = { nombre, email, pass, edad, apellidos }
			var json = JSON.stringify(usuario)
			$.ajax("ServicioWebUsuarios/registrarUsuario", {
				type: "POST",
				data: "info=" + json,
				success: function(res) {
					if (res == "ok") {
						alert("registro ok, ya puedes identificarte - por hacer..");
						$("#nombre").val("");
						$("#email").val("");
						$("#pass").val("");
						$("#edad").val("");
						$("#apellidos").val("");
					}
				}
			});
		})
	});

	$("#logout").click(function(e){
		logout();
	});

}//cargar eventos
