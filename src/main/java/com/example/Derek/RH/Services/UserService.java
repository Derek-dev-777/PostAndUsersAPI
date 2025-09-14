package com.example.Derek.RH.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Derek.RH.DTOs.UserDTOs.UserGetDTO;
import com.example.Derek.RH.DTOs.UserDTOs.UserPostDTO;
import com.example.Derek.RH.DTOs.UserDTOs.UserPutDTO;
import com.example.Derek.RH.Entities.UserEntity;
import com.example.Derek.RH.Mappers.UserMapper;
import com.example.Derek.RH.Repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserGetDTO findUserById(Long id) {
		UserEntity userEntity = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
		return UserMapper.dtoGetEntity(userEntity);
	}
	
	public List<UserGetDTO> findAllUsers(){
		List<UserEntity> listOfUserEntities = userRepository.findAll();
		List<UserGetDTO> listOfUsersDTO = new ArrayList<UserGetDTO>();
		
		for(UserEntity user : listOfUserEntities){
			listOfUsersDTO.add(UserMapper.dtoGetEntity(user));
		}
		
		return listOfUsersDTO;
	}
	
	public UserGetDTO createUser(UserPostDTO user) {
		UserEntity userToCreate = UserMapper.toEntity(user);
		UserEntity saved = userRepository.save(userToCreate);
		return UserMapper.dtoGetEntity(saved);
	}
	
	public UserGetDTO updateUser(UserPutDTO user, UserEntity userToUpdate) {
		return UserMapper.dtoUpdateEntity(user, userToUpdate);
	}
	
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
