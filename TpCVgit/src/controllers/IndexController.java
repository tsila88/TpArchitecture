package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.ConnectedUserBean;
import entity.Person;
import serviceDAO.DaoPerson;

@ManagedBean(name = "course")
@SessionScoped
public class IndexController {

	@EJB
	DaoPerson personManager;
	
	
	@EJB
	ConnectedUserBean userConnected;

	Person person = new Person();

	// firstName, lastName, birthDay, mdp, website, mail
	/**
	 * Method to create the admin if not exist
	 * 
	 * @throws ParseException
	 */
	public void init() throws ParseException {

		if (personManager.findAllPersons().size() == 0) {

			System.out.println("Init the admin");
			person.setFirstName("adminFirtsName");
			person.setLastName("adminLastName");
			person.setMail("admin@mail.com");
			person.setMdp("admin");
			Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse("22/07/1999");
			person.setBirthDay(birthDate);
			person.setWebsite("adminWebsite");

		}

	}

	List<Person> getPerons() {
		return personManager.findAllPersons();

	}

}
