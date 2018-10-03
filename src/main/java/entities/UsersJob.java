package entities;

public class UsersJob {

	String name;
	String job;
	
	public UsersJob(String name, String job){
		this.name=name;
		this.job=job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
