package servicios;

import java.util.List;

import modelo.Zapatilla;

public interface ServicioZapatilla {

	public void registrarZapatilla(Zapatilla z);
	
	public int obtenerTotalDeZapatillas(String modelo);
	
	public List<Zapatilla> obtenerZapatilla(String modelo, int comienzo);
	
	public void borrarZapatilla(int id);
	
	public Zapatilla obtenerZapatillaPorID(int id);
	
	public void editarZapatilla(Zapatilla z);
	
}
