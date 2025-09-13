package com.example.Derek.RH.DTOs.UserDTOs;

public class UserPutDTO {
	
	private String name;
	private String email;
	private String password;
	
	public UserPutDTO() {}

	public UserPutDTO(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() { return name; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }

	
}
