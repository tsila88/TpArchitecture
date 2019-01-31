package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity Person with its description: firstName, lastName, birthDay, mdp,
 * website, mail The table Person had the same name in its column
 *
 * @author tsila
 *
 */
@Entity(name = "Person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Basic(optional = false)
	@Column(name = "firstName", length = 200, nullable = false)
	@NotNull @Size(min = 2, max = 200)
	private String firstName;

	@Basic(optional = false)
	@Column(name = "lastName", length = 200, nullable = false)
	@NotNull @Size(min = 2, max = 200)
	private String lastName;

	@Basic(optional = false)
	@Column(name = "mail", length = 200, nullable = false, unique = false)
	@NotNull @Size(min = 2, max = 200)
	private String mail;

	@Basic(optional = false)
	@Column(name = "website", length = 200, nullable = false)
	@NotNull @Size(min = 2, max = 200)
	private String website;

	@Basic(optional = false)
	@Column(name = "passwd", length = 200, nullable = false)
	@Size(min = 2, max = 200)
	private String passwd;

	@Basic(optional = false)
	@Temporal(TemporalType.DATE)
	@Column(name = "birthDay")
	private Date birthDay;

	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST })
	private CurriculumVitae cv;

	public Person() {
		super();
	}

	public Person(String firstName, Date birthDay) {
		super();
		this.firstName = firstName;
		this.birthDay = birthDay;
	}

	public Person(String firstName, String lastName, String mail, String website, String mdp, Date birthDay) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.website = website;
		this.passwd = mdp;
		this.birthDay = birthDay;
	}

	public Person(String firstName, String lastName, String mail, String website, String mdp, Date birthDay,
			CurriculumVitae cv) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.website = website;
		this.passwd = mdp;
		this.birthDay = birthDay;
		this.cv = cv;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getMdp() {
		return passwd;
	}

	public void setMdp(String passwd) {
		this.passwd = passwd;
	}

	public CurriculumVitae getCv() {
		return cv;
	}

	public void setCv(CurriculumVitae cv) {
		this.cv = cv;
	}

}
