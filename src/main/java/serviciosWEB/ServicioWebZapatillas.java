package serviciosWEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import servicios.ServicioZapatilla;

@Controller
@RequestMapping("ServicioZapatillas/")
public class ServicioWebZapatillas {

	@Autowired
	private ServicioZapatilla zapatillasDAO;
	
	@RequestMapping("obtenerZapatillas")
	public ResponseEntity<String> obtenerzapatillas() {
		
		String respuesta = new Gson().toJson(zapatillasDAO.obtenerZapatilla(0));
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping("obtenerZapatillaPorId")
	public ResponseEntity<String> obtenerZapatillaPorId(String id){
		String json = 
			new Gson().toJson(zapatillasDAO.obtenerZapatillaPorID(Integer.parseInt(id)));
		return new ResponseEntity<String>(json,HttpStatus.OK);		
	}
}
