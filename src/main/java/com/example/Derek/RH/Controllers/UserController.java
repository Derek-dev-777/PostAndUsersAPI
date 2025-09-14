package com.example.Derek.RH.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Derek.RH.DTOs.UserDTOs.UserGetDTO;
import com.example.Derek.RH.DTOs.UserDTOs.UserPostDTO;
import com.example.Derek.RH.DTOs.UserDTOs.UserPutDTO;
import com.example.Derek.RH.Entities.UserEntity;
import com.example.Derek.RH.Mappers.UserMapper;
import com.example.Derek.RH.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	public final UserService userService;
	
	public UserController(UserService service) {
		this.userService = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserGetDTO> findUserById(@PathVariable Long id) {
		UserGetDTO userFound = userService.findUserById(id);
		return ResponseEntity.ok(userFound);
	}
	
	@GetMapping
	public ResponseEntity<List<UserGetDTO>> findAllUsers(){
		List<UserGetDTO> allUsers = userService.findAllUsers();
		return ResponseEntity.ok(allUsers); 
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserGetDTO> createUser(UserPostDTO user){
		UserGetDTO userCreated = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserGetDTO> updateUser(UserPutDTO dto, UserEntity userToUpdate){
		UserGetDTO userUpdated = UserMapper.dtoUpdateEntity(dto, userToUpdate);
		return ResponseEntity.ok(userUpdated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserByID(@PathVariable Long id){
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}
}
