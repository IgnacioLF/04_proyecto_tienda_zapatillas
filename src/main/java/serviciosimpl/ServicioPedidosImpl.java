package serviciosimpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.EstadosPedido;
import constantesSQL.ConstantesSQL;
import datos.servicioWEB.ResumenPedido;
import modelo.Carrito;
import modelo.Pedido;
import modelo.ProductoCarrito;
import modelo.ProductoPedido;
import modelo.Usuario;
import servicios.ServicioCarrito;
import servicios.ServicioPedidos;

@Service
@Transactional
public class ServicioPedidosImpl implements ServicioPedidos{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ServicioCarrito servicioCarrito;

	@Override
	public void procesarPaso1(String nombreCompleto, String direccion, String provincia, String ciudad, String cp,
			Usuario usuario) {
		Pedido p = new Pedido();
		p.setEstado("en proceso");
		p.setUsuario(usuario);
		p.setNombreCompleto(nombreCompleto);
		p.setDireccion(direccion);
		p.setProvincia(provincia);
		p.setCiudad(ciudad);
		p.setCp(cp);
		sessionFactory.getCurrentSession().save(p);	
		
	}
	
	@Override
	public void procesarPaso2(String titular, String numero, Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		p.setTitularTarjeta(titular);
		p.setNumeroTarjeta(numero);
		sessionFactory.getCurrentSession().update(p);
	}


	@Override
	public ResumenPedido obtenerResumenDelPedido(Usuario usuario) {
		ResumenPedido resumen = new ResumenPedido();
		Pedido p = obtenerPedidoActual(usuario);
		resumen.setNombreCompleto(p.getNombreCompleto());
		resumen.setDireccion(p.getDireccion());
		resumen.setProvincia(p.getProvincia());
		resumen.setCiudad(p.getCiudad());
		resumen.setCp(p.getCp());
		resumen.setTitularTarjeta(p.getTitularTarjeta());
		resumen.setNumeroTarjeta(p.getNumeroTarjeta());
		resumen.setDetalles_envio(p.getDetalles_pedido());
		
		resumen.setZapatillas(
				servicioCarrito.obtenerProductoCarrito(usuario)
				);
		
		return resumen;
	}
	
	
	private Pedido obtenerPedidoActual(Usuario usuario) {
		Usuario uBaseDatos = 
		(Usuario)
		sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());
		
		Object pedidoEnProceso = 
				sessionFactory.getCurrentSession().createCriteria(Pedido.class)
				.add(Restrictions.eq("estado", EstadosPedido.EN_PROCESO))
				.add(Restrictions.eq("usuario.id", usuario.getId())).uniqueResult();
		
		Pedido p = null;
		if(pedidoEnProceso == null) {
			p = new Pedido();
			p.setEstado(EstadosPedido.EN_PROCESO);
			p.setUsuario(uBaseDatos);
		}else {
			p = (Pedido) pedidoEnProceso;
		}
		return p;		
		
	}

	@Override
	public void confirmarPedido(Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		Usuario uBaseDatos = 
		(Usuario)
		sessionFactory.getCurrentSession().get(Usuario.class, usuario.getId());
		Carrito c = uBaseDatos.getCarrito();
		if(c != null) {
			for(ProductoCarrito pc : c.getProductosCarrito()) {
				ProductoPedido pp = new ProductoPedido();
				pp.setCantidad(pc.getCantidad());
				pp.setZapatilla(pc.getZapatilla());
				p.getProductosPedido().add(pp);
				pp.setPedido(p);
				sessionFactory.getCurrentSession().save(pp);
			}
		}
		SQLQuery query = 
				sessionFactory.getCurrentSession().createSQLQuery(
					ConstantesSQL.BORRAR_PRODUCTOS_CARRITO
				);
		query.setParameter("carrito_id", c.getId());
		query.executeUpdate();
		p.setEstado(EstadosPedido.COMPLETADO);
		sessionFactory.getCurrentSession().update(p);
	}

	@Override
	public List<Pedido> obtenerPedidos() {
		List<Pedido> pedidos = 
				sessionFactory.getCurrentSession().
				createQuery("from Pedido").list();
		return pedidos;
	}

	@Override
	public Pedido obtenerPedidoPorId(int idPedido) {
		return (Pedido)sessionFactory.getCurrentSession().get(Pedido.class, 
				idPedido);
	}

	@Override
	public void actualizarEstadoPedido(int idPedido, String estado) {
		Pedido p = obtenerPedidoPorId(idPedido);
		p.setEstado(estado);
		sessionFactory.getCurrentSession().update(p);
	}

	@Override
	public void procesarPaso3(String detalles_envio, Usuario usuario) {
		Pedido p = obtenerPedidoActual(usuario);
		p.setDetalles_pedido(detalles_envio);
		sessionFactory.getCurrentSession().update(p);
		
	}
	
}
