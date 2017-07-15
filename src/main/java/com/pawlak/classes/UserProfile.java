package com.pawlak.classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String user;
	private String password;
	private String mail;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "school_id", unique = true)
	private School school;

	public Long getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public UserProfile(String user, String password, String mail) {
		super();
		this.user = user;
		this.password = password;
		this.mail=mail;
	}

	public UserProfile(String user, String password, String mail,School school) {
		super();
		this.user = user;
		this.password = password;
		this.school = school;
		this.mail=mail;
	}

	public UserProfile() {
	}

	@Override
	public String toString() {
		return ""+ user + " " + password + "" + mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
