package controladores.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Usuario;
import modelo.Zapatilla;
import servicios.ServicioCategorias;
import servicios.ServicioZapatilla;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("/admin/")
public class ZapatillasControllerAdmin {
	
	@Autowired
	private ServicioZapatilla zapatillaDAO;
	
	@Autowired
	private ServicioCategorias servicioCategorias;
	
	@RequestMapping("gestionarZapatillas")
	public String gestionarZapatillas(Model model) {
		model.addAttribute("zapatillas",zapatillaDAO.obtenerZapatilla());
		return "admin/gestionarZapatillas";
	}
	
	@RequestMapping("borrarZapatilla")
	public String borrarZapatilla(String idBorrar, Model model, HttpServletRequest request) {
		zapatillaDAO.borrarZapatilla(Integer.parseInt(idBorrar));
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");
		GestorArchivos.borrarImagenesZapatilla(idBorrar, rutaRealDelProyecto);
		return gestionarZapatillas(model);
	}

	@RequestMapping("nuevaZapatilla")
	public String nuevaZapatilla(Model model) {
		model.addAttribute("zapatilla", new Zapatilla());
		model.addAttribute("categorias", servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/formRegistroZapatilla";
	}
	
	@RequestMapping("guardarNuevaZapatilla")
	public String guardarNuevaZapatilla(Zapatilla zapatilla, Model model, HttpServletRequest request ) {
		zapatillaDAO.registrarZapatilla(zapatilla);
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");
		GestorArchivos.guardarFotoZapatilla(zapatilla, rutaRealDelProyecto);
		GestorArchivos.guardarFotoCajaZapatilla(zapatilla, rutaRealDelProyecto);
		return gestionarZapatillas(model);		
	}
	
	@RequestMapping("editarZapatilla")
	public String editarZapatilla(String idEditar, Model model) {
		Zapatilla zapatilla = zapatillaDAO.obtenerZapatillaPorID(Integer.parseInt(idEditar));
		zapatilla.setIdCategoria(zapatilla.getCategoria().getId());
		model.addAttribute("zapatilla", zapatilla);
		model.addAttribute("categorias",servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/formEditarZapatilla";
	}
	
	@RequestMapping("actualizarZapatilla")
	public String actualizarUsuario(Zapatilla zapatilla, Model model, HttpServletRequest request) {
		zapatillaDAO.editarZapatilla(zapatilla);
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");
		GestorArchivos.borrarImagenesZapatilla(Integer.toString(zapatilla.getId()), rutaRealDelProyecto);
		GestorArchivos.guardarFotoZapatilla(zapatilla, rutaRealDelProyecto);
		GestorArchivos.guardarFotoCajaZapatilla(zapatilla, rutaRealDelProyecto);
		return gestionarZapatillas(model);
	}
}
