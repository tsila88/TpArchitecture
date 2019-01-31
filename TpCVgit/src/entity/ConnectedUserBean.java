package entity;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful(name="connectedUser")
public class ConnectedUserBean {
	
	 private String login = "";

	    public void login(String login, String pwd) {
	        this.login = "";
	        if (login.equals(pwd)) {
	            this.login = login;
	            System.out.printf("Login user %s on %s\n", login, this);
	        }
	    }

	    @Remove
	    public void logout() {
	        this.login = "";
	        System.out.printf("Logout on %s\n", this);
	    }

	    public String getLogin() {
	        return login;
	    }

}
