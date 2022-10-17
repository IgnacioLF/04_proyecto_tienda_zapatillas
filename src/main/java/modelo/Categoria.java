package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	private String nombre;
	@Id
	@GeneratedValue
	private int id;
	
	
	
}
