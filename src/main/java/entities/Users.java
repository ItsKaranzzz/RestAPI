package entities;

public class Users {

	String first_name;
	String last_name;
	String id;
	String createdAt;

	public Users() {
		// required while Unmarshelling

	}

		//For Initializing the Payload
	public Users(String firstname, String lastname) {

		this.first_name = firstname;
		this.last_name = lastname;

	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
