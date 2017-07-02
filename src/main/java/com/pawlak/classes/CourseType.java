package com.pawlak.classes;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CourseType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String courseType;
	@ManyToMany(mappedBy = "courseTypes")
	private Set<School> schools = new HashSet<>();

	public CourseType() {
	}
	
	public CourseType(String courseType) {
		this.courseType=courseType;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	@Override
	public String toString() {
		return "" + courseType;
	}
	
	
}
