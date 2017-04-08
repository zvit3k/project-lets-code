package com.pawlak.classes;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nickname;
	private String review;
	private double rating;
	@Column(columnDefinition="DATE")
	private Calendar date;
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="school_id")
	private School school;
	
	public Review(){}

	public Review(String nickname, String review, double rating, Calendar date) {
		this.nickname = nickname;
		this.review = review;
		this.rating=rating;
		this.date = date;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", nickname=" + nickname + ", review=" + review + ", rating=" + rating + ", date="
				+ date + ", school=" + school + "]";
	}
	
	
	
	
	
}
