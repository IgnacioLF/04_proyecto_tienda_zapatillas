package modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Zapatilla {
	
	@Id
	@GeneratedValue
	private int id;
	private int talla;
	private String modelo;
	private String sexo;
	private String color;
	private double precio;
	private String marca;
	
	@ManyToOne(targetEntity = Categoria.class, optional = false, fetch = FetchType.EAGER)
	private Categoria categoria;
	
	@Transient
	private int idCategoria;
	
	@Transient
	private MultipartFile foto;
	@Transient
	private MultipartFile fotoCaja;
	

	public Zapatilla() {
		// TODO Auto-generated constructor stub
	}
	
	public Zapatilla(int talla, String modelo, String sexo, String color, double precio, String marca) {
		super();
		this.talla = talla;
		this.modelo = modelo;
		this.sexo = sexo;
		this.color = color;
		this.precio = precio;
		this.marca = marca;
	}
	
	public Zapatilla(int id, int talla, String modelo, String sexo, String color, double precio, String marca) {
		super();
		this.id = id;
		this.talla = talla;
		this.modelo = modelo;
		this.sexo = sexo;
		this.color = color;
		this.precio = precio;
		this.marca = marca;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTalla() {
		return talla;
	}
	public void setTalla(int talla) {
		this.talla = talla;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public MultipartFile getFoto() {
		return foto;
	}

	public void setFoto(MultipartFile foto) {
		this.foto = foto;
	}

	public MultipartFile getFotoCaja() {
		return fotoCaja;
	}

	public void setFotoCaja(MultipartFile fotoCaja) {
		this.fotoCaja = fotoCaja;
	}
	
}
