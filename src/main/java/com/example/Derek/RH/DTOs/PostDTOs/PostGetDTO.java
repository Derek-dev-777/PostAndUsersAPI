package com.example.Derek.RH.DTOs.PostDTOs;

import java.time.LocalDateTime;

public class PostGetDTO {
	
	private Long id;
	private String title;
	private String content;
	private String authorName;
	private LocalDateTime createdAt;
	
	public PostGetDTO() {}

	public PostGetDTO(Long id, String title, String content, String authorName, LocalDateTime createdAt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.authorName = authorName;
		this.createdAt = createdAt;
	}

	public Long getId() { return id ; }
	public String getTitle() { return title ;}
	public String getContent() { return content ;}
	public String getAuthorName() { return authorName ;}
	public LocalDateTime getCreatedAt() { return createdAt ;}
	
	
	
}
