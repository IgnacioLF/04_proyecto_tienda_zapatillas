package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	
	private String nombre;
	private String pass;
	private String email;
	
	@OneToOne
	private Carrito carrito;
	
	@Id
	@GeneratedValue
	private int id;
	private int edad;
	private String apellidos;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombre, String pass, String email, int edad, String apellidos) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.edad = edad;
		this.apellidos = apellidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
}
