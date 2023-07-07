package com.facebook.model;


import javax.persistence.*;

@Entity
@Table(name="friend")
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	
	@ManyToOne
	@JoinColumn(name = "FRIEND_ID")
	private User friend;
	
	@OneToOne
	@JoinColumn(name = "STATUS_ID")
	private FriendStatus status;
	
	@Transient
	private String StatusCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

	public FriendStatus getStatus() {
		return status;
	}

	public void setStatus(FriendStatus status) {
		this.status = status;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(String statusCode) {
		StatusCode = statusCode;
	}
}
