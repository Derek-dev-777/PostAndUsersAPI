package com.example.Derek.RH.DTOs.UserDTOs;

import java.time.LocalDateTime;
import java.util.List;

import com.example.Derek.RH.DTOs.PostDTOs.PostGetDTO;

public class UserGetDTO {
	
	private Long id;
	private String username;
	private String email;
	private LocalDateTime date;
	
	private List<PostGetDTO> postList;
	
	public UserGetDTO() {}
	
	public UserGetDTO(Long id, String username, String email, LocalDateTime date, List<PostGetDTO> postList ) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.date = date;
		this.postList = postList;
	}

	public Long getId() { return id; }
	public String getUsername() { return username; }
	public String getEmail() { return email; }
	public LocalDateTime getDate() { return date; }
	public List<PostGetDTO> getPostList() { return postList; }
}
