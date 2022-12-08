package controladores.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String guardarNuevoUsuario( @ModelAttribute("usuario") @Valid Usuario usuario, BindingResult br ,Model model ) {
		if( !br.hasErrors()) { 
			System.out.println("test ---");
			ServicioUsuarios.registrarUsuario(usuario);
			return gestionarUsuarios(model);	
		}else {
			model.addAttribute("usuario", usuario);
			return "admin/formRegistroUsuario";
		}
	}
	
	@RequestMapping("editarUsuario")
	public String editarUsuario(String idEditar, Model model){
		Usuario usuario = ServicioUsuarios.obtenerUsuarioPorId(Integer.parseInt(idEditar));
		model.addAttribute("usuario",usuario);
		return "admin/formEditarUsuario";
	}
	
	@RequestMapping("actualizarUsuario")
	public String actualizarUsuario( @ModelAttribute("usuario") @Valid Usuario usuario, BindingResult br ,Model model) {
		if( !br.hasErrors()) { 
			ServicioUsuarios.guardarCambiosUsuario(usuario);
			return gestionarUsuarios(model);
		}else {
			model.addAttribute("usuario", usuario);
			return "admin/formEditarUsuario";
		}
	}
}
