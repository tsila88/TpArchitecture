package serviceDAO;

import java.time.Year;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Activity;

@Stateless
public class DaoActivityImpl implements DaoActivity {

	@PersistenceContext(unitName = "myDataGit")
	private EntityManager em;

	@Override
	public Activity addActivity(Activity a) {
		// TODO Auto-generated method stub
		em.persist(a);
		return a;
	}

	@Override
	public Activity updateActivity(Activity a) {
		// TODO Auto-generated method stub
		a = em.merge(a);
		return a;
	}

	@Override
	public void removeActivity(Activity a) {
		// TODO Auto-generated method stub
		em.remove(a);
	}

	@Override
	public Activity findActivityById(long id) {
		// TODO Auto-generated method stub
		return em.find(Activity.class, id);
	}

	@Override
	public List<Activity> findActivityByYear(Year year) {
		// TODO Auto-generated method stub
		TypedQuery<Activity> q = em.createQuery(
				"select a.id, a.year, a.nature, a.title, a.description, a.webadress from Activity a WHERE year LIKE :year ",
				Activity.class);
		q.setParameter("year", year);
		return q.getResultList();
	}

	@Override
	public List<Activity> findActivityByNature(String nature) {
		// TODO Auto-generated method stub
		TypedQuery<Activity> q = em.createQuery(
				"select a.id, a.year, a.nature, a.title, a.description, a.webadress from Activity a WHERE lastName LIKE :nature ",
				Activity.class);
		q.setParameter("nature", nature);
		return q.getResultList();
	}

	@Override
	public List<Activity> findActivityByTitle(String title) {
		// TODO Auto-generated method stub
		TypedQuery<Activity> q = em.createQuery(
				"select a.id, a.year, a.nature, a.title, a.description, a.webadress from Activity a WHERE title LIKE :title ",
				Activity.class);
		q.setParameter("title", title);
		return q.getResultList();
	}

	// id, year, nature, title, description, webaddress
	@Override
	public List<Activity> findAllActivity() {
		// TODO Auto-generated method stub
		TypedQuery<Activity> q = em.createQuery(
				"select a.id, a.year, a.nature, a.title, a.description, a.webadress from Activity a ", Activity.class);
		return q.getResultList();

	}

}
