package com.example.Derek.RH.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_posts")
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime date = LocalDateTime.now();
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "author_id", nullable = false)
	private UserEntity userAuthor;
	
	public PostEntity() {}

	public PostEntity(String title, String content, UserEntity author) {
		this.title = title;
		this.content = content;
		this.userAuthor = author;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDate() {
		return date;
	}
	
	public UserEntity getUserAuthor() {
		return userAuthor;
	}

	
	
	
	
}
