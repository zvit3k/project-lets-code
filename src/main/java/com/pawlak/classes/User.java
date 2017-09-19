package com.pawlak.classes;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	@Transient
	private String confirmPassword;
	private String mail;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "school_id", unique = true)
	private School school;
	@ManyToMany
    @JoinTable(name = "user_role", 
    joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User(String username, String password, String mail) {
		this.username = username;
		this.password = password;
		this.mail=mail;
	}

	public User(String username, String password, String mail,School school) {
		this.username = username;
		this.password = password;
		this.school = school;
		this.mail=mail;
	}

	public User() {
	}

	@Override
	public String toString() {
		return ""+ username + " " + password + " " + mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
