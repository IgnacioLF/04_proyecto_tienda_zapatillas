package datos.servicioWEB;

import java.util.List;

import modelo.Zapatilla;


public class RespuestaZapatillas {

	private int total;
	private List<Zapatilla> zapatillas;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Zapatilla> getZapatillas() {
		return zapatillas;
	}
	public void setZapatillas(List<Zapatilla> zapatillas) {
		this.zapatillas = zapatillas;
	}
	
}
