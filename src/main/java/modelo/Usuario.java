package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario {
	
	@NotEmpty
	@Size( min = 1, max = 40)
	@Pattern(regexp = "^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9]{1,40}$")
	private String nombre;
	
	@NotEmpty
	@Size( min = 1, max = 40)
	private String pass;
	
	@NotEmpty
	@Size( min = 1, max = 40)
	private String email;
	
	@OneToOne
	private Carrito carrito;
	
	@Id
	@GeneratedValue
	private int id;

	private int edad;
	
	@NotEmpty
	@Size( min = 1, max = 40)
	private String apellidos;
	
	public Usuario() {
	}
	
	public Usuario(String nombre, String pass, String email, int edad, String apellidos) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.edad = edad;
		this.apellidos = apellidos;
	}
	
	
	
	public Usuario(String nombre, String pass, String email, Carrito carrito, int id, int edad, String apellidos) {
		super();
		this.nombre = nombre;
		this.pass = pass;
		this.email = email;
		this.carrito = carrito;
		this.id = id;
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
