package datos.servicioWEB;

import java.util.List;
import java.util.Map;

public class ResumenPedido {

	private List<Map<String, Object>> zapatillas;
	
	//paso1	
	private String nombreCompleto;
	private String direccion;
	private String provincia;
	private String ciudad;
	private String cp;
	
	//paso2
	private String titularTarjeta;
	private String numeroTarjeta;
	
	//paso 3 
	private String detalles_envio;
	
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
	public List<Map<String, Object>> getZapatillas() {
		return zapatillas;
	}
	public void setZapatillas(List<Map<String, Object>> zapatillas) {
		this.zapatillas = zapatillas;
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
	public String getDetalles_envio() {
		return detalles_envio;
	}
	public void setDetalles_envio(String detalles_envio) {
		this.detalles_envio = detalles_envio;
	}
}
