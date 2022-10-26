package serviciosimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Carrito;
import modelo.ProductoCarrito;
import modelo.Usuario;
import modelo.Zapatilla;
import servicios.ServicioCarrito;

@Service
@Transactional
public class ServicioCarritoImpl implements ServicioCarrito {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void agregarProducto(Usuario u, int idProducto, int cantidad) {
		Usuario uBaseDeDatos = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, u.getId());
		Carrito c = uBaseDeDatos.getCarrito();
		if (c == null) {
			c = new Carrito();
			c.setUsuario(uBaseDeDatos);
			uBaseDeDatos.setCarrito(c);
			sessionFactory.getCurrentSession().save(c);
		}
		boolean producto_en_carrito = false;
		for(ProductoCarrito pc_en_carrito: c.getProductosCarrito()) {
			if (pc_en_carrito.getZapatilla().getId() == idProducto) {
				producto_en_carrito = true;
				pc_en_carrito.setCantidad( pc_en_carrito.getCantidad() + cantidad);
				sessionFactory.getCurrentSession();
			}
		}
		if (!producto_en_carrito) {
			ProductoCarrito pc = new ProductoCarrito();
			pc.setCarrito(c);
			pc.setCantidad(cantidad);
			pc.setZapatilla((Zapatilla)sessionFactory.getCurrentSession().get(Zapatilla.class, idProducto));
			sessionFactory.getCurrentSession().save(pc);
		}
	}

}
