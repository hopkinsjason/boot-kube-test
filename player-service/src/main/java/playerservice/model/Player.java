package playerservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	private String username;

	public Player() {
		/* empty */
	}
	
	/**
	 * Create a player
	 * 
	 * @param username the username of the player
	 */
	public Player(String username) {
		super();
		this.username = username;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	
}
