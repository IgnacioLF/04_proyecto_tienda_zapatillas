package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import datos.servicioWEB.ResumenPedido;
import modelo.Usuario;
import servicios.ServicioPedidos;
import servicios.ServicioUsuario;

@Controller
@RequestMapping("ServicioWebPedidos/")
public class ServicioWebPedidos {
	
	@Autowired
	private ServicioPedidos servicioPedidos;
	
	// TODO check
	@Autowired
	private ServicioUsuario servicioUsuarios;
	
	@RequestMapping("paso1")
	public ResponseEntity<String> paso1(String nombre, String direccion, String provincia,String ciudad, String cp, String idUsuario, HttpServletRequest request){
/*		String respuesta = "";
		servicioPedidos.procesarPaso1(nombre, direccion, provincia, ciudad, cp,
				(Usuario)request.getSession().getAttribute("usuario") );
		respuesta = "ok"; */
		
		String respuesta = "";
		
		servicioPedidos.procesarPaso1(nombre, direccion, provincia, ciudad, cp,
				servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idUsuario)) );
		respuesta = "ok";
		
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}

	@RequestMapping("paso2")
	public ResponseEntity<String> paso2(String titular, String numero, String idUsuario, HttpServletRequest request){
		//como este es el ultimo paso, si todo ha ido bien, aprovechamos
		//y devolvemos a la parte cliente un resumen del pedido completo, 
		//para que el usuario lo confirme
	/*	String respuesta = "";
		Usuario u = (Usuario)request.getSession().getAttribute("usuario");
		servicioPedidos.procesarPaso2(titular, numero, 
				u
				);
		respuesta = "ok";	*/	
		
		String respuesta = "";
		Usuario u = servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idUsuario));
		servicioPedidos.procesarPaso2(titular, numero, 
				u
				);
		respuesta = "ok";
		
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}//end paso2
	
	@RequestMapping("paso3")
	public ResponseEntity<String> paso1(String detalles_envio, String idUsuario, HttpServletRequest request){
		
	/*	String respuesta = "";
		Usuario u = (Usuario)request.getSession().getAttribute("usuario");
		servicioPedidos.procesarPaso3(detalles_envio,(Usuario)request.getSession().getAttribute("usuario") );
		ResumenPedido resumen = servicioPedidos.obtenerResumenDelPedido(
				u
				);
		respuesta = "ok:"+new Gson().toJson(resumen);	; */
		
		String respuesta = "";
		Usuario u = servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idUsuario));
		servicioPedidos.procesarPaso3(detalles_envio,u);
		ResumenPedido resumen = servicioPedidos.obtenerResumenDelPedido(u);
		respuesta = new Gson().toJson(resumen);
		
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	
	@RequestMapping("confirmarPedido")
	public ResponseEntity<String> confirmarPedido(String idUsuario, HttpServletRequest request){
	/*	String respuesta = "";
		servicioPedidos.confirmarPedido(
				(Usuario)request.getSession().getAttribute("usuario")
				); */
		
		String respuesta = "";
		servicioPedidos.confirmarPedido(servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idUsuario)));
		
		respuesta = "ok , pedido completado, puedes seguir comprando";
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}//end confirmar
}
