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

	public String getCourseTypes() {
		return courseType;
	}

	public void setCourseTypes(String courseType) {
		this.courseType = courseType;
	}

}
