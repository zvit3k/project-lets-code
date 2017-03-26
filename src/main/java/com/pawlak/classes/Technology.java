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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private TECHNOLOGIES technology;
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "school_id")
	private School school;

	public Technology(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TECHNOLOGIES getTechnology() {
		return technology;
	}

	public void setTechnology(TECHNOLOGIES technology) {
		this.technology = technology;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Technology(TECHNOLOGIES technology, School school) {
		super();
		this.technology = technology;
		this.school = school;
	}

}
