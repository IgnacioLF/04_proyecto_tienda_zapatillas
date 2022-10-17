package servicios;

import java.util.List;

import modelo.Usuario;

public interface ServicioUsuario {
	
	public void registrarUsuario(Usuario u);
	
	public List<Usuario> obtenerUsuarios();
	
	void borrarUsuario(int id);
	
	Usuario obtenerUsuarioPorId(int idUsuario);
	
	void guardarCambiosUsuario(Usuario u);
}
