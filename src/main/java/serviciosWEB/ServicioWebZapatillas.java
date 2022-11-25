package serviciosWEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import datos.servicioWEB.RespuestaZapatillas;
import servicios.ServicioZapatilla;

@Controller
@RequestMapping("ServicioZapatillas/")
public class ServicioWebZapatillas {

	@Autowired
	private ServicioZapatilla zapatillasDAO;
	
	@RequestMapping("obtenerZapatillas")
	public ResponseEntity<String> obtenerzapatillas(@RequestParam(defaultValue = "") String modelo, @RequestParam(defaultValue = "0" ) String comienzo) {
		
		int comienzo_int = Integer.parseInt(comienzo);
		
		RespuestaZapatillas rz = new RespuestaZapatillas();
		rz.setZapatillas(zapatillasDAO.obtenerZapatilla(modelo,comienzo_int));
		rz.setTotal(zapatillasDAO.obtenerTotalDeZapatillas(modelo));

		String respuesta = new Gson().toJson(rz);
		
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
	
	@RequestMapping("obtenerZapatillaPorId")
	public ResponseEntity<String> obtenerZapatillaPorId(String id){
		String json = 
			new Gson().toJson(zapatillasDAO.obtenerZapatillaPorID(Integer.parseInt(id)));
		return new ResponseEntity<String>(json,HttpStatus.OK);		
	}
	
	@RequestMapping("obtenerUltimasZapatillas")
	public ResponseEntity<String> obtenerzUltimasapatillas() {
		
		String json = 
				new Gson().toJson(zapatillasDAO.obtenerUltimasZapatillas());
		
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}
	
}
