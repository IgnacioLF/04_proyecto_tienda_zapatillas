package serviciosimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantes.Paginacion;
import constantes.UltimasZapatillas;
import constantesSQL.ConstantesSQL;
import modelo.Categoria;
import modelo.Zapatilla;
import servicios.ServicioZapatilla;

@Service
@Transactional
public class ServicioZapatillasImpl implements ServicioZapatilla  {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void registrarZapatilla(Zapatilla z) {
		Categoria c =
				(Categoria)
				sessionfactory.getCurrentSession().get(Categoria.class, z.getIdCategoria());
		z.setCategoria(c);
		sessionfactory.getCurrentSession().save(z);
	}

	@Override
	public List<Zapatilla> obtenerZapatilla(String modelo ,int comienzo) {
		Criteria c = sessionfactory.getCurrentSession().createCriteria(Zapatilla.class);
		c.add(Restrictions.like("modelo", "%"+modelo+"%"));
		c.addOrder(Order.asc("id"));
		c.setFirstResult(comienzo);
		c.setMaxResults(Paginacion.RESULTADOS_POR_PAGINA);
		
		return c.list();
	}

	@Override
	public void borrarZapatilla(int id) {
		Zapatilla z =(Zapatilla) sessionfactory.getCurrentSession().get(Zapatilla.class, id);
		sessionfactory.getCurrentSession().delete(z);
	}

	@Override
	public Zapatilla obtenerZapatillaPorID(int id) {
		return (Zapatilla) sessionfactory.getCurrentSession().get(Zapatilla.class, id);
	}

	@Override
	public void editarZapatilla(Zapatilla z) {
		Categoria c =
				(Categoria)
				sessionfactory.getCurrentSession().get(Categoria.class, z.getIdCategoria());
		z.setCategoria(c);
		sessionfactory.getCurrentSession().merge(z);
	}

	@Override
	public int obtenerTotalDeZapatillas(String modelo) {
		SQLQuery query = sessionfactory.getCurrentSession().createSQLQuery(ConstantesSQL.OBTENER_TOTAL_ZAPATILLAS);
		query.setParameter("modelo", "%" + modelo + "%");
		return Integer.parseInt(query.list().get(0).toString());
	}

	@Override
	public List<Zapatilla> obtenerUltimasZapatillas() {
		Criteria c = sessionfactory.getCurrentSession().createCriteria(Zapatilla.class);
		// TODO change order
		c.addOrder(Order.desc("id"));
		c.setMaxResults(UltimasZapatillas.HOME_SLIDER);
		return c.list();
	}
	
	
	
}
