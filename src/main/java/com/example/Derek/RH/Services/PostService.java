package com.example.Derek.RH.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Derek.RH.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.RH.DTOs.PostDTOs.PostPostDTO;
import com.example.Derek.RH.DTOs.PostDTOs.PostPutDTO;
import com.example.Derek.RH.Entities.PostEntity;
import com.example.Derek.RH.Mappers.PostMapper;
import com.example.Derek.RH.Repositories.PostRepository;
import com.example.Derek.RH.Repositories.UserRepository;

@Service
public class PostService {
	
	@Autowired
	public PostRepository postRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	public PostService(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}
	
	public PostGetDTO findByPostId(Long id) {
		PostEntity postEntity = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));
		return PostMapper.dtoGetEntity(postEntity);
	}
	
	public List<PostGetDTO> findAllPost(){
		List<PostEntity> listOfEntities = postRepository.findAll();
		List<PostGetDTO> listDTO = new ArrayList<PostGetDTO>();
		
		for(PostEntity post : listOfEntities) {
			listDTO.add(PostMapper.dtoGetEntity(post));
		}
		return listDTO;
	}
	
	public void updatePostTittleAndContent(PostPutDTO dto, PostEntity entity) {
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
	}
	
	public PostGetDTO createPost(PostPostDTO dto) {
		PostEntity postToCreate = PostMapper.dtoToEntity(dto, userRepository); 
		PostEntity saved = postRepository.save(postToCreate);
		return PostMapper.dtoGetEntity(saved);
	}
	
	public void deletePostById(Long id) {
		postRepository.deleteById(id);
	}
}
