package com.example.Derek.RH.DTOs.PostDTOs;

public class PostPostDTO {
	
	private String title;
	private String content;
	private Long author_id;
	
	public PostPostDTO() {}
	
	public PostPostDTO(String title, String content, Long author_id) {
		this.title = title;
		this.content = content;
		this.author_id = author_id;
	}
	public String getTitle() { return title; }
	public String getContent() { return content; }
	public Long getAuthorId() { return author_id; }

	
}
