package controllers;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;

import entity.ConnectedUserBean;
import entity.Person;
import serviceDAO.DaoPerson;

@ManagedBean(name = "log")
@SessionScoped
public class LogController {

	@EJB
	DaoPerson personManager;
	@EJB
	ConnectedUserBean userConnected;

	Person person = new Person();

	private String mail;
	private String pswd;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	@PostConstruct
	public void init() {

		if (personManager.findAllPersons().size() == 0) {

			System.out.println("Init the admin");
			person.setFirstName("adminFirtsName");
			person.setLastName("adminLastName");
			person.setMail("admin@mail.com");
			person.setMdp("admin");
			person.setBirthDay("12/12/2001");
			person.setWebsite("adminWebsite");
			personManager.addPerson(person);

		}
	}

	public String checkLog() {

		if (personManager.findLogList(this.getMail(), this.getPswd()).isEmpty()) {

			
			return "logfailled.xhtml?faces-redirect=true";

		}

		
		return "index.xhtml";
	}

}
