package com.pawlak.classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="{NotEmpty.address.city}")
	private String city;
	@NotEmpty(message="{NotEmpty.address.street}")
	private String street;
	@NotEmpty(message="{NotEmpty.address.postalCode}")
	@Pattern(regexp="[0-9]{2}-[0-9]{3}", message="{Pattern.address.postalCode}")
	private String postalCode;
	@ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="school_id")
	private School school;
	
	public Address(){}
	
	public Address(String city, String street, String postalCode, School school) {
		super();
		this.city = city;
		this.street = street;
		this.postalCode = postalCode;
		this.school = school;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	
}
