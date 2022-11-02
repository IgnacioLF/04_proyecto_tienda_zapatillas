package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductoPedido {

	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Zapatilla zapatilla;
	
	private int cantidad;
	
	@Id
	@GeneratedValue
	private int id;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Zapatilla getZapatilla() {
		return zapatilla;
	}

	public void setZapatilla(Zapatilla zapatilla) {
		this.zapatilla = zapatilla;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
