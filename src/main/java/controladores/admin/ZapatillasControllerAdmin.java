package controladores.admin;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constantes.Paginacion;
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
	public String gestionarZapatillas(Model model,@RequestParam(defaultValue = "") String modelo, @RequestParam(defaultValue = "0" ) String comienzo) {
		
		int comienzo_int = Integer.parseInt(comienzo);
		
		System.out.println("mostrar datos desde "+ comienzo);
		
		model.addAttribute("zapatillas",zapatillaDAO.obtenerZapatilla(modelo,comienzo_int));
		model.addAttribute("modelo",modelo);
		model.addAttribute("siguiente",comienzo_int + Paginacion.RESULTADOS_POR_PAGINA);
		model.addAttribute("anterior", comienzo_int - Paginacion.RESULTADOS_POR_PAGINA);
		model.addAttribute("total",zapatillaDAO.obtenerTotalDeZapatillas(modelo));
		return "admin/gestionarZapatillas";
	}
	
	@RequestMapping("borrarZapatilla")
	public String borrarZapatilla(String idBorrar, Model model, HttpServletRequest request) {
		zapatillaDAO.borrarZapatilla(Integer.parseInt(idBorrar));
		String rutaRealDelProyecto = 
				request.getServletContext().getRealPath("");
		GestorArchivos.borrarImagenesZapatilla(idBorrar, rutaRealDelProyecto);
		return gestionarZapatillas(model,"","0");
	}

	@RequestMapping("nuevaZapatilla")
	public String nuevaZapatilla(Model model) {
		model.addAttribute("zapatilla", new Zapatilla());
		model.addAttribute("categorias", servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/formRegistroZapatilla";
	}
	
	@RequestMapping("guardarNuevaZapatilla")
	public String guardarNuevaZapatilla(@ModelAttribute("zapatilla") @Valid Zapatilla zapatilla, BindingResult br , Model model, HttpServletRequest request ) {
		if( !br.hasErrors()) { 
			zapatilla.setFechaImagen(new Date());
			zapatillaDAO.registrarZapatilla(zapatilla);
			String rutaRealDelProyecto = 
					request.getServletContext().getRealPath("");
			GestorArchivos.guardarFotoZapatilla(zapatilla, rutaRealDelProyecto);
			GestorArchivos.guardarFotoCajaZapatilla(zapatilla, rutaRealDelProyecto);
			return gestionarZapatillas(model,"","0");	
		}else {
			model.addAttribute("zapatilla", zapatilla);
			model.addAttribute("categorias", servicioCategorias.obtenerCategoriasParaDesplegable());
			return "admin/formRegistroZapatilla";
		}
	}
	
	@RequestMapping("editarZapatilla")
	public String editarZapatilla( String idEditar, Model model) {
		Zapatilla zapatilla = zapatillaDAO.obtenerZapatillaPorID(Integer.parseInt(idEditar));
		zapatilla.setIdCategoria(zapatilla.getCategoria().getId());
		model.addAttribute("zapatilla", zapatilla);
		model.addAttribute("categorias",servicioCategorias.obtenerCategoriasParaDesplegable());
		return "admin/formEditarZapatilla";
	}
	
	@RequestMapping("actualizarZapatilla")
	public String actualizarUsuario(@ModelAttribute("zapatilla") @Valid Zapatilla zapatilla, BindingResult br , Model model, HttpServletRequest request) {
		if( !br.hasErrors()) { 
			zapatilla.setFechaImagen(new Date());
			zapatillaDAO.editarZapatilla(zapatilla);
			String rutaRealDelProyecto = 
					request.getServletContext().getRealPath("");
			GestorArchivos.borrarImagenesZapatilla(Integer.toString(zapatilla.getId()), rutaRealDelProyecto);
			GestorArchivos.guardarFotoZapatilla(zapatilla, rutaRealDelProyecto);
			GestorArchivos.guardarFotoCajaZapatilla(zapatilla, rutaRealDelProyecto);
			return gestionarZapatillas(model,"","0");
		}else {
			model.addAttribute("zapatilla", zapatilla);
			model.addAttribute("categorias", servicioCategorias.obtenerCategoriasParaDesplegable());
			return "admin/formEditarZapatilla";
		}
	}
}
