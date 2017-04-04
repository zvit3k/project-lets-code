package com.pawlak.classes;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String technology;
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "school_id")
	private School school;

	public Technology() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
		
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Technology(String technology, School school) {
		super();
		this.technology = technology;
		this.school=school;

	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", technology=" + technology + ", school=" + school + "]";
	}
	
	
}
