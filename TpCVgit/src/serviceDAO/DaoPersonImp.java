package serviceDAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Person;

@Stateless
public class DaoPersonImp implements DaoPerson {

	@PersistenceContext(unitName = "myDataGit")
	private EntityManager em;

	@Override
	public Person addPerson(Person p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p;
	}

	@Override
	public Person updatePerson(Person p) {
		// TODO Auto-generated method stub
		p = em.merge(p);
		return p;
	}

	@Override
	public void removePerson(Person p) {
		// TODO Auto-generated method stub
		em.remove((em.contains(p) ? p : em.merge(p)));

	}

	/**
	 * Function to find Person by id.
	 * 
	 */
	@Override
	public Person findPerson(long id) {
		// TODO Auto-generated method stub
		return em.find(Person.class, id);
	}

	@Override
	public List<Person> findPersonsByFirstName(String pattern) {
		// TODO Auto-generated method stub
		TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE firstname LIKE :pattern", Person.class);
		q.setParameter("pattern", pattern);
		return q.getResultList();
	}

	@Override
	public List<Person> findPersonsByLastName(String pattern) {
		// TODO Auto-generated method stub
		TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE lastName LIKE :pattern", Person.class);
		q.setParameter("pattern", pattern);
		return q.getResultList();
	}

	@Override
	public List<Person> findAllPersons() {
		// TODO Auto-generated method stub
		TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p ", Person.class);
		return q.getResultList();
	}

	@Override
	public List<Person> findPersonByTitre(String pattern) {
		// TODO Auto-generated method stub
		TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE lastName LIKE :pattern", Person.class);
		q.setParameter("pattern", pattern);
		return q.getResultList();
	}

	@Override
	public Person findLog(String mail, String passwd) throws NoResultException {
		// TODO Auto-generated method stub
		TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE mail  LIKE :mail AND passwd LIKE :passwd",
				Person.class);
		q.setParameter("mail", mail);
		q.setParameter("passwd", passwd);
		return q.getSingleResult();
	}

	@Override
	public List<Person> findLogList(String mail, String passwd) {
		// TODO Auto-generated method stub
		TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p WHERE mail  LIKE :mail AND passwd LIKE :passwd",
				Person.class);
		q.setParameter("mail", mail);
		q.setParameter("passwd", passwd);
		return q.getResultList();
	}

}
