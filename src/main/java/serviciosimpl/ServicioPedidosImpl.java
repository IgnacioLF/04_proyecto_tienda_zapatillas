package serviciosimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Pedido;
import modelo.Usuario;
import servicios.ServicioPedidos;

@Service
@Transactional
public class ServicioPedidosImpl implements ServicioPedidos{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void procesarPaso1(String nombreCompleto, String direccion, String provincia, String ciudad, String cp,
			Usuario usuario) {
		Pedido p = new Pedido();
		p.setEstado("en proceso");//mas adelante solo podra 
								//haber un pedido en proceso 
								//para un mismo usuario
		p.setUsuario(usuario);
		p.setNombreCompleto(nombreCompleto);
		p.setDireccion(direccion);
		p.setProvincia(provincia);
		p.setCiudad(ciudad);
		p.setCp(cp);
		sessionFactory.getCurrentSession().save(p);	
		
	}
	
}
