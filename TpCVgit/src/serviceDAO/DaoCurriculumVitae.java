package serviceDAO;

import java.util.List;

import javax.ejb.Local;

import entity.CurriculumVitae;

@Local
public interface DaoCurriculumVitae {

	public CurriculumVitae addCV(CurriculumVitae cv);

	public CurriculumVitae updateCV(CurriculumVitae cv);

	public void removeCV(CurriculumVitae cv);

	public CurriculumVitae findCV(long id);

	public List<CurriculumVitae> findAllCV();

}
