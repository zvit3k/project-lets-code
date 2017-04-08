package com.pawlak.classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String technology;
	@ManyToMany(mappedBy="technologies")
	private Set<School> schools = new HashSet<School>();

	public Technology() {
	}

	public Technology(String technology) {
		this.technology = technology;
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

	public Set<School> getSchools() {
		return schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", technology=" + technology + ", schools=" + schools + "]";
	}


	
	
}
