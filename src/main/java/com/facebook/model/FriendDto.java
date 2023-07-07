package com.facebook.model;

public class FriendDto {
private Long id;
	
	private Long userId;
	
	private Long friendId;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFriendId() {
		return friendId;
	}

	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static FriendDto convert(Friend friend) {
		FriendDto friendDto=new FriendDto();
		friendDto.setId(friend.getId());
		friendDto.setUserId(friend.getUser().getId());
		friendDto.setFriendId(friend.getFriend().getId());
		friendDto.setStatus(friend.getStatus().getCode());
		return friendDto;
	
}

}
