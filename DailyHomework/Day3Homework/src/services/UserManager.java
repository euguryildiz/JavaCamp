package services;

import model.User;

public class UserManager {
	
	public void add (User user) {
		System.out.println(user.getName()+" "+user.getLastName() + " added.");

	}
	
	public void delete (User user) {
		System.out.println(user.getName()+" "+user.getLastName() + " deleted.");

	}
		

	public void update (User user) {
		System.out.println(user.getName()+" "+user.getLastName() + " updated.");

	}
	
	public User getById(int id) {
		System.out.println("User info");
		return new User();
	}

	public User[] GetAll() {
		System.out.println("all user info");
		return new User[] {};

	}
	
	

	
}
