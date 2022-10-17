package servicios;

import java.util.List;

import modelo.Zapatilla;

public interface ServicioZapatilla {

	public void registrarZapatilla(Zapatilla z);
	
	public List<Zapatilla> obtenerZapatilla();
	
	public void borrarZapatilla(int id);
	
	public Zapatilla obtenerUsuarioPorID(int id);
	
	public void editarZapatilla(Zapatilla z);
	
}
