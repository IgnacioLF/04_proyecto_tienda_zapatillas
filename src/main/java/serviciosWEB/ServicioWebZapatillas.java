package serviciosWEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import servicios.ServicioZapatilla;

@Controller
public class ServicioWebZapatillas {

	@Autowired
	private ServicioZapatilla zapatillasDAO;
	
	@RequestMapping("ServicioZapatillas")
	public ResponseEntity<String> obtenerzapatillas() {
		
		String respuesta = new Gson().toJson(zapatillasDAO.obtenerZapatilla());
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
}
