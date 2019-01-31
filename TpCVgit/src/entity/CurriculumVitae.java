package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * CurriculumVitae is attached with  one person, and CurriculumVitae contains a list of
 * activity
 * @author tsila
 *
 */
@Entity(name = "curriculumVitae")
public class CurriculumVitae implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(cascade = { CascadeType.MERGE,
			CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "curriculumVitae")
	private List<Activity> activities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CurriculumVitae() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurriculumVitae(long id, List<Activity> activities) {
		super();
		this.id = id;
		this.activities = activities;
	}

}
