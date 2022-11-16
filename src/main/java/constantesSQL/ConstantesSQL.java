package constantesSQL;

public class ConstantesSQL {
	
	public final static String SQL_OBTENER_CATEGORIAS_PARA_DESPLEGABLE = 
			"select id, nombre from tabla_categorias order by nombre asc";
	public static final String SQL_OBTENER_PRODUCTOS_CARRITO = 
			"select zapatilla.id as zapatilla_id,  zapatilla.modelo,"
			+ "	zapatilla.precio, productocarrito.cantidad "
			+ "	from zapatilla, productocarrito "
			+ "	where productocarrito.zapatilla_id = zapatilla.id and "
			+ "	productocarrito.carrito_id = :carrito_id "
			+ "	ORDER by productocarrito.id asc";
			
	public static final String BORRAR_PRODUCTOS_CARRITO = 
			"delete from productocarrito where carrito_id = :carrito_id";
	
	public static final String OBTENER_TOTAL_ZAPATILLAS = "select count(id) from zapatilla where modelo like :modelo ";
}
