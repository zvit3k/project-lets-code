package com.pawlak.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.pawlak.validation.SchoolHours;
import com.pawlak.validation.SchoolName;
import com.pawlak.validation.SchoolPrice;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@SchoolName
	@NotEmpty(message="{NotEmpty.school.name}")
	@NotBlank(message="{NotBlank.school.name}")
	private String name;
	@OneToOne(mappedBy = "school", cascade = CascadeType.PERSIST)
	private User user;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "school_technology", joinColumns = { @JoinColumn(name = "school_id") }, inverseJoinColumns = {
			@JoinColumn(name = "technology_id") })
	private Set<Technology> technologies = new HashSet<Technology>();
	
	@Min(value=0, message="{Min.school.price}")
	@SchoolPrice
	private double price;
	private double avarageRating;
	@Min(value=0, message="{Min.school.hours}")
	@SchoolHours
	private int numberOfHours;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "school_course", joinColumns = { @JoinColumn(name = "school_id") }, inverseJoinColumns = {
			@JoinColumn(name = "course_id") })
	private Set<CourseType> courseTypes = new HashSet<>();
	
	private String description;
	@OneToMany(mappedBy = "school")
	private List<Review> reviews = new ArrayList<>();
	@OneToMany(mappedBy = "school")
	private List<Address> cities = new ArrayList<>();

	public Set<CourseType> getCourseTypes() {
		return courseTypes;
	}

	public void setCourseTypes(Set<CourseType> courseTypes) {
		this.courseTypes = courseTypes;
	}

	public List<Address> getCities() {
		return cities;
	}

	public double getAvarageRating() {
		return avarageRating;
	}

	public void setAvarageRating(double avarageRating) {
		this.avarageRating = avarageRating;
	}

	public void setCities(List<Address> cities) {
		this.cities = cities;
	}

	public School() {
	}

	public School(String name, double price, int numberOfHours, String description) {
		this.name = name;
		this.price = price;
		this.numberOfHours = numberOfHours;
		this.description = description;
	}

	public Set<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Set<Technology> technologies) {
		this.technologies = technologies;
	}

	public Long getId() {
		return id;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", price=" + price + ", avarageRating=" + avarageRating
				+ ", description=" + description + "]";
	}

}
