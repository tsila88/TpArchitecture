package entity;

import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 * Statefull bean represents the state of a connected user Take in charge the
 * connected user
 * 
 * @author tsila
 *
 */
@Stateful(name = "connectedUser")
public class ConnectedUserBean {

	@EJB
	private Person personConnected;
	
	private boolean state = false;

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Person getPersonConnected() {
		return personConnected;
	}

	public void setPersonConnected(Person personConnected) {
		this.personConnected = personConnected;
	}

	
}
