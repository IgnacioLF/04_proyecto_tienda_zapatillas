package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductoCarrito {

	@ManyToOne
	private Carrito carrito;
	
	@ManyToOne
	private Zapatilla zapatilla;
	
	private int cantidad;
	
	@Id
	@GeneratedValue
	private int id;

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
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
