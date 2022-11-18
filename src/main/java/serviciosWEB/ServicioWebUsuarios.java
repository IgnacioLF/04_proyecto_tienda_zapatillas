package serviciosWEB;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import modelo.Usuario;
import servicios.ServicioUsuario;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("ServicioWebUsuarios/")
public class ServicioWebUsuarios {

	@Autowired
	private ServicioUsuario servicioUsuarios;
	
	@RequestMapping("registrarUsuario")
	public ResponseEntity<String> registrarUsuario(@RequestParam Map<String,Object> formData, @RequestParam("foto") CommonsMultipartFile foto, HttpServletRequest request){
		String respuesta = "ok";
		System.out.println("test");
		System.out.println(formData.toString());
		Gson gson = new Gson();
		JsonElement json = gson.toJsonTree(formData);
		Usuario u = gson.fromJson(json, Usuario.class);
		System.out.println("Usuario a registrar " + u.toString());
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");	
		
		servicioUsuarios.registrarUsuario(u);
		if (foto != null) {
			GestorArchivos.guardarFotoUsuario(u, foto, rutaRealDelProyecto);	
		}
		
		// @RequestParam("info") String json
//		Usuario u = new Gson().fromJson(json, Usuario.class);
//		servicioUsuarios.registrarUsuario(u);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	@RequestMapping("identificarUsuario")
	public ResponseEntity<String> 
		identificarUsuario(String email, String pass, HttpServletRequest request){
		System.out.println("email : " + email);
		System.out.println("pass : " + pass);
		String respuesta = "";
		HttpStatus codeHttp = HttpStatus.OK;
		//comprobar en bd si el conjunto email pass es correcto
		Usuario u = servicioUsuarios.obtenerUsuarioPorEmailYPass(email, pass);
		
		if( u != null ) {
			request.getSession().setAttribute("usuario", u);
			respuesta = "ok," + u.getId();
		}else {
			respuesta = "error, email o pass incorrectos";
			
		}
		return new ResponseEntity<String>(respuesta,codeHttp);
	}
	
	@RequestMapping("logout")
	public ResponseEntity<String> logout(HttpServletRequest request){
		request.getSession().invalidate();
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}//end logout
}
