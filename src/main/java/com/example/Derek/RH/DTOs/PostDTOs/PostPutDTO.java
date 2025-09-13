package com.example.Derek.RH.DTOs.PostDTOs;

public class PostPutDTO {

	private String title;
	private String content;
		
	public PostPutDTO() {}
		
	public PostPutDTO(String title, String content) {
		this.title = title;
		this.content = content;
		}
		
	public String getTitle() { return title; }
	public String getContent() { return content; }
}

