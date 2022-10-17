package serviciosimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Zapatilla;
import servicios.ServicioZapatilla;

@Service
@Transactional
public class ServicioZapatillasImpl implements ServicioZapatilla  {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void registrarZapatilla(Zapatilla z) {
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
	public Zapatilla obtenerUsuarioPorID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editarZapatilla(Zapatilla z) {
		sessionfactory.getCurrentSession().merge(z);
	}
	
	
	
}
