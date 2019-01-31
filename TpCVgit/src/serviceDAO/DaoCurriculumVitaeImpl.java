package serviceDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.CurriculumVitae;

public class DaoCurriculumVitaeImpl implements DaoCurriculumVitae {

	@PersistenceContext(unitName = "myDataGit")
	private EntityManager em;
	
	@Override
	public CurriculumVitae addCV(CurriculumVitae cv) {
		// TODO Auto-generated method stub
		em.persist(cv);
		return cv;
	}

	@Override
	public CurriculumVitae updateCV(CurriculumVitae cv) {
		// TODO Auto-generated method stub
		cv = em.merge(cv);
		return cv;
	}

	@Override
	public void removeCV(CurriculumVitae cv) {
		// TODO Auto-generated method stub
		em.remove(cv);
	}

	@Override
	public CurriculumVitae findCV(long id) {
		// TODO Auto-generated method stub
		return em.find(CurriculumVitae.class, id);
	}

	@Override
	public List<CurriculumVitae> findAllCV() {
		// TODO Auto-generated method stub
		TypedQuery<CurriculumVitae> q = em.createQuery(
				"select cv.id from CurriculumVitae cv ", CurriculumVitae.class);
		return q.getResultList();
		
	}

}
