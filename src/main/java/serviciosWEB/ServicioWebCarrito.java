package serviciosWEB;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import modelo.Usuario;
import servicios.ServicioCarrito;
import servicios.ServicioUsuario;
import serviciosimpl.ServicioUsuariosImpl;

@Controller
@RequestMapping("ServicioWebCarrito/")
public class ServicioWebCarrito {
	
	@Autowired
	private ServicioCarrito servicioCarrito;
	
	@Autowired
	private ServicioUsuario servicioUsuarios;
	
	@RequestMapping("agregarZapatilla")
	public ResponseEntity<String> agregarZapatilla(String idProducto, String cantidad , String userId, HttpServletRequest request){
		String respuesta= "agregar el producto de id: " + idProducto + "cantidad : " + cantidad + 
				" al carrito del usuario: " + 
				servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(userId));
		System.out.println(respuesta);
		servicioCarrito.agregarProducto(servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(userId)), Integer.parseInt(idProducto), Integer.parseInt(cantidad));
		
		 respuesta = "producto agregado al carrito correctamente";
		
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
				
	}
	
	@RequestMapping("obtenerProductosCarrito")
	public ResponseEntity<String> obtenerProductosCarrito(String userId ,HttpServletRequest request){
		String respuesta = "";
		Usuario u = servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(userId));
		
		respuesta = new Gson().toJson( 
				servicioCarrito.obtenerProductoCarrito(u));
		
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}
	@RequestMapping("borrarProductoCarrito")
	public ResponseEntity<String> borrarProductoCarrito(String userId, String idProducto, HttpServletRequest request) {
		String respuesta = "";
						
		Usuario u = servicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(userId));
		servicioCarrito.borrarProductoCarrito(u, Integer.parseInt(idProducto));
				
		return new ResponseEntity<String>(respuesta,HttpStatus.OK);
	}

}




