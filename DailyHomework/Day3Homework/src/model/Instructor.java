package model;

public class Instructor extends User {
	
	String info;

	public Instructor(int id, String email, String name, String lastName, String info) {
		super(id, email, name, lastName);
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	

}
