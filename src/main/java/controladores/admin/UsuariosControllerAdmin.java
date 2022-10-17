package controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Usuario;
import servicios.ServicioUsuario;

@Controller
@RequestMapping("/admin/")
public class UsuariosControllerAdmin {
	
	@Autowired
	private ServicioUsuario ServicioUsuarios;

	@RequestMapping("gestionarUsuarios")
	public String gestionarUsuarios(Model model) {
		//pedir los usuarios al dao y meterlos en model para que le llegen a la vista
		model.addAttribute("usuarios",ServicioUsuarios.obtenerUsuarios());
		return "admin/gestionarUsuarios";
	}
	
	@RequestMapping("borrarUsuario")
	public String borrarUsuario(String idBorrar, Model model) {
		ServicioUsuarios.borrarUsuario(Integer.parseInt(idBorrar));
		return gestionarUsuarios(model);
	}
	
	@RequestMapping("nuevoUsuario")
	public String nuevoUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "admin/formRegistroUsuario";
	}
	
	@RequestMapping("guardarNuevoUsuario")
	public String guardarNuevoUsuario(Usuario usuario, Model model) {
		ServicioUsuarios.registrarUsuario(usuario);
		return gestionarUsuarios(model);		
	}
	
	@RequestMapping("editarUsuario")
	public String editarUsuario(String idEditar, Model model){
		Usuario usuario = ServicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idEditar));
		model.addAttribute("usuario",usuario);
		return "admin/formEditarUsuario";
	}
	
	@RequestMapping("actualizarUsuario")
	public String actualizarUsuario(Usuario usuario, Model model) {
		ServicioUsuarios.guardarCambiosUsuario(usuario);
		return gestionarUsuarios(model);
	}
}
