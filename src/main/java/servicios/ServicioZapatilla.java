package servicios;

import java.util.List;

import modelo.Zapatilla;

public interface ServicioZapatilla {

	public void registrarZapatilla(Zapatilla z);
	
	public List<Zapatilla> obtenerZapatilla(int comienzo);
	
	public void borrarZapatilla(int id);
	
	public Zapatilla obtenerZapatillaPorID(int id);
	
	public void editarZapatilla(Zapatilla z);
	
}
