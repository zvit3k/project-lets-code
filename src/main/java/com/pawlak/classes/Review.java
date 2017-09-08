package com.pawlak.classes;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="wpisz autora!")
	@NotNull
	private String nickname;
	@NotEmpty(message="Musisz coś wpisać")
	@NotNull
	private String userReview;
	@Min(value=1, message="Jaka jest Twoja ocena? Wybierz!")
	@Max(value=5, message="Jaka jest Twoja ocena? Wybierz!")
	private int rating;

	@Column(columnDefinition = "DATE")
	private Calendar date;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	private School school;

	public Review() {
	}

	public Review(String nickname, String userReview, int rating, Calendar date) {
		this.nickname = nickname;
		this.userReview = userReview;
		this.rating = rating;
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
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

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview;
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
		return "Review [id=" + id + ", nickname=" + nickname + ", userReview=" + userReview + ", rating=" + rating
				+ ", date=" + date + "]";
	}

}
