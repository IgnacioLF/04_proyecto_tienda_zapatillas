package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {

	@ManyToOne(optional = false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "pedido",fetch = FetchType.EAGER)
	private List<ProductoPedido> productosPedido = 
		new ArrayList<ProductoPedido>();
	
	//se piden en el paso 1:
	private String nombreCompleto;
	
	private String direccion;
	
	private String provincia;
	
	private String ciudad;
	
	private String cp;
	
	//se piden el paso 2:
	private String titularTarjeta;
	
	private String numeroTarjeta;
	
	// paso 3
	private String detalles_pedido;
	
	//la siguiente variable indica la situacion en la 
	//que se encuentra el pedido:
	private String estado;
	
	
	@Id
	@GeneratedValue
	private int id;


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<ProductoPedido> getProductosPedido() {
		return productosPedido;
	}


	public void setProductosPedido(List<ProductoPedido> productosPedido) {
		this.productosPedido = productosPedido;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getTitularTarjeta() {
		return titularTarjeta;
	}


	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getDetalles_pedido() {
		return detalles_pedido;
	}


	public void setDetalles_pedido(String detalles_pedido) {
		this.detalles_pedido = detalles_pedido;
	}


	@Override
	public String toString() {
		return "Pedido [usuario=" + usuario + ", productosPedido=" + productosPedido + ", nombreCompleto="
				+ nombreCompleto + ", direccion=" + direccion + ", provincia=" + provincia + ", ciudad=" + ciudad
				+ ", cp=" + cp + ", titularTarjeta=" + titularTarjeta + ", numeroTarjeta=" + numeroTarjeta
				+ ", detalles_pedido=" + detalles_pedido + ", estado=" + estado + ", id=" + id + "]";
	}
	
	
	
}
