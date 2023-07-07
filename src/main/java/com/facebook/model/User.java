package com.facebook.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(
		name="uk_sample2_fullName_email_mobile",columnNames= {"FULL_NAME","EMAIL_ID","MOBILE_NO"}))
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Column(name = "FULL_NAME",length = 10)
	@Size(min=3, max=10)
	private String fullName;
	
	@NotNull
	@Column(name = "MOBILE_NO",length = 10)
	private Long mobileNo;
	
	
	@Email
	@NotEmpty(message="email cannot be empty")
	@Column(name = "EMAIL_ID",length = 20)
	private String emailId;
	
	@NotNull
	@Column(name = "PASSWORD",length=10)
	@Size(min=3,max=10)
	private String password;
	
	@ColumnDefault("true")
	@Column(name = "USER_STATUS")
	private boolean userStatus;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Friend> friend;
	
	
	@JsonIgnore
	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL )
	private List<Timeline> timelines;	
	
	@JsonIgnore
	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL )
	private List<Like> likes;
	
	@JsonIgnore
	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Message> messages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}

	public List<Friend> getFriend() {
		return friend;
	}

	public void setFriend(List<Friend> friend) {
		this.friend = friend;
	}

	public List<Timeline> getTimelines() {
		return timelines;
	}

	public void setTimelines(List<Timeline> timelines) {
		this.timelines = timelines;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
}
