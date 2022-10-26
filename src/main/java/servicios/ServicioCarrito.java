package servicios;

import modelo.Usuario;

public interface ServicioCarrito {
	
	void agregarProducto(Usuario u, int idProducto, int cantidad);

}
