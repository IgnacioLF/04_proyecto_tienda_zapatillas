package serviciosimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Pedido;
import modelo.ProductoCarrito;
import modelo.ProductoPedido;
import modelo.Usuario;
import servicios.ServicioUsuario;

@Service
@Transactional
public class ServicioUsuariosImpl implements ServicioUsuario {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void registrarUsuario(Usuario u) {
		sessionFactory.getCurrentSession().save(u);
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		
		return c.list();
	}

	@Override
	public void borrarUsuario(int id) {
		Usuario u = (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, id);
		
		if(u.getCarrito() != null) {
			List<ProductoCarrito> pcs = u.getCarrito().getProductosCarrito();
			for (ProductoCarrito productoCarrito : pcs) {
				sessionFactory.getCurrentSession().delete(productoCarrito);
			}
			sessionFactory.getCurrentSession().delete(u.getCarrito());
		}
		Criteria c = 
				sessionFactory.getCurrentSession().createCriteria(Pedido.class);
		Criteria cMod= c.createCriteria("usuario").add(
				Restrictions.eq("id", u.getId()));
		List<Pedido> pedidosDelUsuario = cMod.list();
		for (Pedido pedido : pedidosDelUsuario) {
			List<ProductoPedido> pps = pedido.getProductosPedido();
			for (ProductoPedido pp : pps) {
				sessionFactory.getCurrentSession().delete(pp);
			}
			sessionFactory.getCurrentSession().delete(pedido);
		}	
		sessionFactory.getCurrentSession().delete(u);
	}

	@Override
	public Usuario obtenerUsuarioPorId(int idUsuario) {
		return (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, idUsuario);
	}

	@Override
	public void guardarCambiosUsuario(Usuario u) {
		sessionFactory.getCurrentSession().merge(u);
	}
	
	@Override
	public Usuario obtenerUsuarioPorEmailYPass(String email, String pass) {
		Criteria c = 
				sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		c.add(Restrictions.eq("email", email));
		c.add(Restrictions.eq("pass", pass));
		Usuario u = null;
		if(c.uniqueResult()!=null) {
			u = (Usuario)c.uniqueResult();
		}
		return u;
	}
	
}
