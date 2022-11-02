package servicios;

import modelo.Usuario;

public interface ServicioPedidos {

	void procesarPaso1(String nombreCompleto, String direccion, 
			String provincia,String ciudad,String cp , Usuario usuario);
	
}
