function cargarEventos() {
  //con jquery digo que va a pasar cuando se haga click en un enlace
  $("#inicio").click(function () {
    // $("#contenedor").html(plantillas.productos);
    //		$.get("ServicioZapatillas", (res) => {
    //			var libros = JSON.parse(res)
    //			var resultado = Mustache.render(plantillas.productos, libros);
    //			$("#contenedor").html(resultado);
    //		})
    mostrar_productos();
  });

  $("#carrito").click(function () {
    mostrar_productos_carrito();
  });

  $("#login").click(function () {
    $("#contenedor").html(plantillas.login);
    $("#form_login").submit(function (e) {
      e.preventDefault();
      identificar_usuario();
    });
  });

  $("#registrarme").click(function () {
    $("#contenedor").html(plantillas.registrarme);
    $("#form_registro_usuario").submit(function (e) {
      //este codigo se ejecuta cuando se
      //pulsa el boton de submit del form
      e.preventDefault(); //se cancela el envio de form de forma tradicional
      //forma nueva para mandar directamente toda la informacion de un form
      //que tenga o no, uno o mas input type file
      let formulario = this;
      let formData = new FormData(formulario);
      $.ajax("ServicioWebUsuarios/registrarUsuario", {
        type: "POST",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        success: function (res) {
          alert(res);
        },
      });
    }); //end submit

    /* var nombre = $("#nombre").val();
      var email = $("#email").val();
      var pass = $("#pass").val();
      var edad = $("#edad").val();
      var apellidos = $("#apellidos").val();
      var usuario = { nombre, email, pass, edad, apellidos };
      var json = JSON.stringify(usuario);
      $.ajax("ServicioWebUsuarios/registrarUsuario", {
        type: "POST",
        data: "info=" + json,
        success: function (res) {
          if (res == "ok") {
            alert("registro ok, ya puedes identificarte - por hacer..");
            $("#nombre").val("");
            $("#email").val("");
            $("#pass").val("");
            $("#edad").val("");
            $("#apellidos").val("");
          }
        },
      }); */
  });

  $("#logout").click(function (e) {
    logout();
  });
} //cargar eventos
