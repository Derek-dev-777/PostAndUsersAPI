package com.example.Derek.RH.Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true )
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime date = LocalDateTime.now();
	
	@OneToMany(mappedBy = "userAuthor")
	private List<PostEntity> posts = new ArrayList<>();
	
	public UserEntity() {}

	public UserEntity (String nome, String email, String password) {
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	
	public Long getId() { return id; }
	public String getNome() { return nome; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public LocalDateTime getDate() { return date; }
	public List<PostEntity> getPosts() { return posts; }

	public void setNome(String nome) { this.nome = nome; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
