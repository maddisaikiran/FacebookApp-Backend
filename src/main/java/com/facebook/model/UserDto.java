package com.facebook.model;


import org.springframework.util.CollectionUtils;

public class UserDto {


		private Long id;
	
		private String fullName;
		
		private Long mobileNo;
	
		private String emailId;
	
		private String password;
		

		private Boolean userStatus;

		private FriendDto friend;

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

	public Boolean getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus;
	}

	public FriendDto getFriend() {
		return friend;
	}

	public void setFriend(FriendDto friend) {
		this.friend = friend;
	}

	public static UserDto convert(User user) {
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setFullName(user.getFullName());
			userDto.setMobileNo(user.getMobileNo());
			userDto.setEmailId(user.getEmailId());
			userDto.setPassword(user.getPassword());
			if(!CollectionUtils.isEmpty(user.getFriend())) {
			userDto.setFriend(FriendDto.convert(user.getFriend().get(0)));
			}
			return userDto;
		}
}
