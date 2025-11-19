package com.springboot.first_webmvc.model;

import java.util.List;

public class User {

	private String name;
	private String email;
	private Integer age;
	private String password;
	private String about;
	private boolean subscribed;
	private List<String> interests;
	private String gender; // radio
	private String country; // dropdownlist
	private List<String> languagesSelected; // listbox

	public User() {
	}


	public User(String name, String email, Integer age, String password, String about, boolean subscribed,
			List<String> interests, String gender, String country, List<String> languagesSelected) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.password = password;
		this.about = about;
		this.subscribed = subscribed;
		this.interests = interests;
		this.gender = gender;
		this.country = country;
		this.languagesSelected = languagesSelected;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public String isGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getLanguagesSelected() {
		return languagesSelected;
	}

	public void setLanguagesSelected(List<String> languagesSelected) {
		this.languagesSelected = languagesSelected;
	}

	public String getGender() {
		return gender;
	}
	

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", age=" + age + ", password=" + password + ", about="
				+ about + ", subscribed=" + subscribed + ", interests=" + interests + ", gender=" + gender
				+ ", country=" + country + ", languagesSelected=" + languagesSelected + "]";
	}

}
