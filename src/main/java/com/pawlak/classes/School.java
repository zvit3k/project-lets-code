package com.pawlak.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(mappedBy="school",cascade=CascadeType.PERSIST)
	private List<Technology> technologies = new ArrayList<>();;
	private double price;
	private int numberOfHours;
	private String description;
	@OneToMany(mappedBy="school")
	private List<Address> cities = new ArrayList<>();
	
	public List<Address> getCities() {
		return cities;
	}

	public void setCities(List<Address> cities) {
		this.cities = cities;
	}

	public School(){}
	
	public Long getId() {
		return id;
	}
	public School(String name, double price, int numberOfHours,
			String description) {
		super();
		this.name = name;
		this.price = price;
		this.numberOfHours = numberOfHours;
		this.description = description;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Technology> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumberOfHours() {
		return numberOfHours;
	}
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
