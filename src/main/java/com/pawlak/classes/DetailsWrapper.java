package com.pawlak.classes;

import java.util.List;

public class DetailsWrapper {
	private List<Technology> technologies;
	private List<CourseType> courseTypes;
	
	public DetailsWrapper(){}
	
	public DetailsWrapper(List<Technology> technologies, List<CourseType> courseTypes) {
		this.technologies = technologies;
		this.courseTypes = courseTypes;
	}
	public List<Technology> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}
	public List<CourseType> getCourseTypes() {
		return courseTypes;
	}
	public void setCourseTypes(List<CourseType> courseTypes) {
		this.courseTypes = courseTypes;
	}
	
	
}
