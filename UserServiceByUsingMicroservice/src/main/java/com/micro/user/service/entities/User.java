package com.micro.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
@Table(name = "micro_Users")
public class User {
	@Id
	@Column(name = "ID")
	private String userId;

	@Column(name = "Name", length = 20)
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "About  ")
	private String about;

	@Transient
	private List<Rating> rating = new ArrayList<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", about=" + about + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String name, String email, String about) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
	}

	public User(String userId, String name, String email, String about, List<Rating> rating) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
		this.rating = rating;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	
	
	

}
