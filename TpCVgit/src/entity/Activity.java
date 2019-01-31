package entity;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Activity: describes by a year (mandatory), nature (mandatory), title
 * (mandatory) , description (optional), webaddress (optional); each CV has a
 * list of activities . Activity is linked with one CurriculumVitate (owner)
 * 
 * @author tsila
 *
 */

@Entity(name = "Activity")
public class Activity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne()
	private CurriculumVitae curriculumVitae;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Basic(optional = false)
	@Column(name = "year")
	private Year year;

	@Basic(optional = false)
	@Column(name = "nature", nullable = false)
	private String nature;

	@Basic(optional = false)
	@Column(name = "title", nullable = false)
	private String title;

	@Basic(optional = true)
	@Column(name = "description", nullable = true)
	private String description;

	@Basic(optional = true)
	@Column(name = "webaddress", nullable = true)
	private String webaddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebaddress() {
		return webaddress;
	}

	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}

	public CurriculumVitae getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(CurriculumVitae curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Activity(CurriculumVitae owner, Year year, String nature, String title, String description,
			String webaddress) {
		super();
		this.curriculumVitae = owner;
		this.year = year;
		this.nature = nature;
		this.title = title;
		this.description = description;
		this.webaddress = webaddress;
	}

	public Activity(long id, CurriculumVitae owner, Year year, String nature, String title, String description,
			String webaddress) {
		super();
		this.id = id;
		this.curriculumVitae = owner;
		this.year = year;
		this.nature = nature;
		this.title = title;
		this.description = description;
		this.webaddress = webaddress;
	}

}
