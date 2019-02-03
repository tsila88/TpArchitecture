package jpatest.entities;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import entity.Person;
import serviceDAO.DaoPerson;

@Transactional
public class TestDaoPerson {
	// public Person(String firstName, String lastName, String mail, String website,
	// String mdp, Date birthDay)

	/*
	 * Une classe de teste par entité, faire tout les test sur les fonctions
	 * implementées dans le dao, n'oublie pas de suivre la logique = pas de cv sans
	 * personne, par d'activité sans cv
	 */
	/*
	 * A vérifier= mettre à false dans l'annotation column (@Column) l'attribut
	 * unique = true, donc mettre unique = false, pour pouvoir mettre la meme
	 * personne, sinon ça renvoi une erreur de duplicité dans la base en locale ==>
	 * c'est pour ça que j'ai pas sauvegarder en locale pour le test mais
	 * directement en mémoire regarde dans MET-INF/resources.xm ce qu'il faut
	 * modifier
	 */

	@EJB
	DaoPerson dao;

	@Before
	public void setUp() throws Exception {
		EJBContainer.createEJBContainer().getContext().bind("inject", this);
	}

	@After
	public void tearDown() throws Exception {
		EJBContainer.createEJBContainer().close();
	}

	@Ignore
	@Test
	public void testAddPerson() throws NoResultException {

		Person p1 = new Person("Lenon1", "John", "johnlenon@mail.com", "johnlenon-website.com", "mdp1", "27/10/1998");
		dao.addPerson(p1);
		Person p2 = new Person("Lebron", "James", "LebronJames@mail.com", "LebronJames-website.com", "mdp2",
				"12/10/2001");
		dao.addPerson(p2);

		Assert.assertTrue(p1 instanceof Person);
		Assert.assertTrue(p2 instanceof Person);

	}

	@Test
	public void testPersonLog() {

		Person p1 = new Person("Lenon1", "John", "johnlenon@mail.com", "johnlenon-website.com", "mdp1", "27/10/1998");
		dao.addPerson(p1);
		Assert.assertTrue(p1 instanceof Person);
		Assert.assertTrue(dao.findLog("johnlenon@mail.com", "mdp1") instanceof Person);
		Assert.assertEquals(p1.getLastName(), dao.findLog("johnlenon@mail.com", "mdp1").getLastName());
		/**
		 * Test the list of person returned by the method findLogList when the mail and
		 * pswd don't match
		 * 
		 */

		Assert.assertTrue(dao.findLogList("johnlenon@mail.com", "mdp1") instanceof List<?>);
		Assert.assertEquals(0, dao.findLogList("johnlenon@mail.com", "").size());
		/**
		 * Test the list of person returned by the method findLogList when the mail and
		 * pswd match
		 * 
		 */

		Assert.assertTrue(dao.findLogList("johnlenon@mail.com", "mdp1") instanceof List<?>);
		Assert.assertEquals(1, dao.findLogList("johnlenon@mail.com", "mdp1").size());
	}

	@Ignore
	@Test
	public void testFindPersonByFirstName() {

		Person p1 = new Person("Lenon1", "John", "johnlenon@mail.com", "johnlenon-website.com", "mdp1", "27/10/1998");
		dao.addPerson(p1);
		List<Person> listPerson = new ArrayList<Person>();
		listPerson.add(p1);
		Assert.assertTrue(dao.findPersonsByFirstName("Lenon1") instanceof List<?>);
		Assert.assertEquals(listPerson.size(), dao.findPersonsByFirstName("Lenon1").size());
	}

	@Ignore
	@Test
	public void testFindPerson() throws ParseException {

		Person p1 = new Person("Lenon1", "John", "johnlenon@mail.com", "johnlenon-website.com", "mdp1", "27/10/1998");
		dao.addPerson(p1);
		Person p2 = new Person("Lebron", "James", "LebronJames@mail.com", "LebronJames-website.com", "mdp2",
				"12/10/2001");
		dao.addPerson(p2);

		Assert.assertTrue(dao.findPerson(p1.getId()) instanceof Person);
		Assert.assertTrue(dao.findPerson(p2.getId()) instanceof Person);
	}

	@Ignore
	@Test
	public void testFindAllPersons() throws ParseException, IllegalArgumentException {

		Person p1 = new Person("Lenon1", "John", "johnlenon@mail.com", "johnlenon-website.com", "mdp1", "27/10/1998");
		dao.addPerson(p1);
		Person p2 = new Person("Lebron", "James", "LebronJames@mail.com", "LebronJames-website.com", "mdp2",
				"12/10/2001");
		dao.addPerson(p2);
		List<Person> listPerson = new ArrayList<Person>();
		listPerson.add(p1);
		listPerson.add(p2);

		Assert.assertEquals(2, listPerson.size());
		Assert.assertEquals(listPerson.size(), dao.findAllPersons().size());

		dao.removePerson(p1);

		Assert.assertEquals(null, dao.findPerson(p1.getId()));

		p1.setFirstName("Lenonbis");

		dao.updatePerson(p1);

		Assert.assertTrue(dao.findPersonsByFirstName("Lenonbis") instanceof List<?>);
		dao.findPersonsByFirstName("Lenonbis").contains(p1);

		List<Person> listPersonTestFindByFirstName = new ArrayList<Person>();
		listPersonTestFindByFirstName.add(p1);
		// boolean b =
		// listPersonTestFindByFirstName.equals(dao.findPersonsByFirstName("Lenonbis"));
		// Assert.assertEquals(true,b);

	}

}
