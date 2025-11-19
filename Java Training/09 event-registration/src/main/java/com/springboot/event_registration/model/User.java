package com.springboot.event_registration.model;


import java.util.List;

public class User {
	private String name;
	private String email;
	private String password;
	private String comments;
	private boolean newsletters;
	private String session; // radio
	private String city; // dropdown
	private List<String> technologies; // listbox
	
	

	public User() {
	}

	public User(String name, String email, String password, String comments, boolean newsletters, String session,
			String city, List<String> technologies) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.comments = comments;
		this.newsletters = newsletters;
		this.session = session;
		this.city = city;
		this.technologies = technologies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isNewsletters() {
		return newsletters;
	}

	public void setNewsletters(boolean newsletters) {
		this.newsletters = newsletters;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", comments=" + comments
				+ ", newsletters=" + newsletters + ", session=" + session + ", city=" + city + ", technologies="
				+ technologies + "]";
	}

}