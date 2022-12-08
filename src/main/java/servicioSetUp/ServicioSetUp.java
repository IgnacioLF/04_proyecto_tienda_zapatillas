package servicioSetUp;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Categoria;
import modelo.SetUp;
import modelo.Usuario;
import modelo.Zapatilla;


@Service
@Transactional
public class ServicioSetUp implements InterfazSetUp {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void setUp() {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(SetUp.class);
		if (c.list().size() == 0) {
			sessionFactory.getCurrentSession().save(new Usuario("ares", "123", "ares@gmail.com", 19, "lol"));
			sessionFactory.getCurrentSession().save(new Usuario("pepe", "123", "pepe@gmail.com", 16, "lal"));
			sessionFactory.getCurrentSession().save(new Usuario("juan", "123", "juan@gmail.com", 13, "lolas"));
			Categoria montana = new Categoria("montaña", "categoria zapatillas de montana");
			sessionFactory.getCurrentSession().save(montana);
			Categoria deporte = new Categoria("deporte", "categoria zapatillas de deporte");
			sessionFactory.getCurrentSession().save(deporte);
			Categoria verano = new Categoria("verano", "categoria zapatillas de verano");
			sessionFactory.getCurrentSession().save(verano);
			sessionFactory.getCurrentSession().save(new Zapatilla(42, "air", "hombre", "rojo", 12.2, "nike", deporte));
			sessionFactory.getCurrentSession().save(new Zapatilla(43, "air2", "mujer", "azul", 12.2, "addidas", verano));
			sessionFactory.getCurrentSession().save(new Zapatilla(44, "air3", "hombre", "rojo", 16.2, "nike", montana));
		
			SetUp setUp = new SetUp();
			setUp.setCompleto(true);
			sessionFactory.getCurrentSession().save(setUp);

		}

	}

}
