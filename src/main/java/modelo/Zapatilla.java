package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Zapatilla {
	
	@Id
	@GeneratedValue
	private int id;
	private int talla;
	
	@NotEmpty
	@Size( min = 1, max = 40)
	@Pattern(regexp = "^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9]{1,40}$")
	private String modelo;
	
	@NotEmpty
	@Size( min = 1, max = 40)
	@Pattern(regexp = "^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9]{1,40}$")
	private String sexo;
	
	@NotEmpty
	@Size( min = 1, max = 40)
	@Pattern(regexp = "^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9]{1,40}$")
	private String color;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,###.###")
	@Min(value = 1, message = "el precio minimo es un euro")
	@Max(value = 999, message = "el precio maximo es 999 euros")
	private double precio;
	
	@NotEmpty
	@Size( min = 1, max = 40)
	@Pattern(regexp = "^[a-zA-Z áéíóúÁÉÍÓÚñÑ0-9]{1,40}$")
	private String marca;
	
	@Column(nullable = true)
	private Date fechaImagen;
	
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
	
	
	
	public Zapatilla(int talla, String modelo, String sexo, String color, double precio, String marca,
			Categoria categoria) {
		super();
		this.talla = talla;
		this.modelo = modelo;
		this.sexo = sexo;
		this.color = color;
		this.precio = precio;
		this.marca = marca;
		this.categoria = categoria;
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

	public Date getFechaImagen() {
		return fechaImagen;
	}

	public void setFechaImagen(Date fechaImagen) {
		this.fechaImagen = fechaImagen;
	}

	@Override
	public String toString() {
		return "Zapatilla [id=" + id + ", talla=" + talla + ", modelo=" + modelo + ", sexo=" + sexo + ", color=" + color
				+ ", precio=" + precio + ", marca=" + marca + ", fechaImagen=" + fechaImagen + ", categoria="
				+ categoria + ", idCategoria=" + idCategoria + ", foto=" + foto + ", fotoCaja=" + fotoCaja + "]";
	}
	
	
	
}
