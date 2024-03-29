//funciones de js para los pasos del checkout
function checkout_paso_1() {
  //datos de envio del pedido
  $("#contenedor").html(plantillas.checkout_1);
  $("#aceptar_paso_1").click(function () {
    let nombre = $("#campo_nombre").val();
    let direccion = $("#campo_direccion").val();
    let provincia = $("#campo_provincia").val();
    let ciudad = $("#campo_ciudad").val();
    let cp = $("#campo_cp").val();

    $.post("ServicioWebPedidos/paso1", {
      nombre: nombre,
      direccion: direccion,
      provincia: provincia,
      ciudad,
      cp,
    }).done(function (res) {
      if (res == "ok") {
        //mostrar la plantilla del paso 2
        checkout_paso_2();
      } else {
        alert(res);
      }
    }); //end done
  }); //end click
} //end checkout_paso_1
function checkout_paso_2() {
  $("#contenedor").html(plantillas.checkout_2);
  $("#aceptar_paso_2").click(function () {
    $.post("ServicioWebPedidos/paso2", {
      titular: $("#titular_tarjeta").val(),
      numero: $("#numero_tarjeta").val(),
    }).done(function (res) {
      if (res == "ok") {
        checkout_paso_3();
      } else {
        alert(res);
      }
    }); //done
  }); //end click aceptar_paso_2
} //end checkout_paso_2

function checkout_paso_3() {
  $("#contenedor").html(plantillas.checkout_3);
  $("#aceptar_paso_3").click(function () {
    $.post("ServicioWebPedidos/paso3", {
      detalles_envio: $("#detalles_envio").val(),
    }).done(function (res) {
      if (res.substring(0, 2) == "ok") {
        let json = JSON.parse(res.substring(3, res.length));
        let html = Mustache.render(plantillas.checkout_4, json);
        $("#contenedor").html(html);
        $("#boton_confirmar_pedido").click(checkout_confirmar);
      }
    }); //done
  }); //end click aceptar_paso_2
}

function checkout_confirmar() {
  $.ajax("ServicioWebPedidos/confirmarPedido", {
    success: function (res) {
      alert(res);
      mostrar_productos();
    },
  });
} //end checkout_confirmar
