package serviciosimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Zapatilla> obtenerZapatilla() {
		Criteria c = sessionfactory.getCurrentSession().createCriteria(Zapatilla.class);
		
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
	
	
	
}
