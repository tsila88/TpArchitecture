package serviceDAO;

import java.util.List;

import javax.ejb.Local;

import entity.Person;

@Local
public interface DaoPerson {

	public Person addPerson(Person p);

	public Person updatePerson(Person p);

	public void removePerson(Person p);

	public Person findPerson(long id);

	public List<Person> findAllPersons();

	public List<Person> findPersonsByFirstName(String pattern);

	public List<Person> findPersonsByLastName(String pattern);

	public List<Person> findPersonByTitre(String pattern);

	/**
	 * Return the person when logged in. Usage: return the person logged and follow
	 * it with a statefull bean
	 */
	public Person findLog(String mail, String pswd);

	/***
	 * Return a list that contains the person, used because the NoResultException
	 * can't be cacthed, but return an error Usage: to test the list if conatains a
	 * Person
	 */
	public List<Person> findLogList(String mail, String pswd);

}
