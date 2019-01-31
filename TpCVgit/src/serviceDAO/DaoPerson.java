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

}
