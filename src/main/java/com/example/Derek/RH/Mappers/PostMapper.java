package com.example.Derek.RH.Mappers;

import com.example.Derek.RH.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.RH.DTOs.PostDTOs.PostPostDTO;
import com.example.Derek.RH.DTOs.PostDTOs.PostPutDTO;
import com.example.Derek.RH.Entities.PostEntity;
import com.example.Derek.RH.Entities.UserEntity;
import com.example.Derek.RH.Repositories.UserRepository;

public class PostMapper {
	
	
	public static PostGetDTO dtoGetEntity(PostEntity postEntity) {
		return new PostGetDTO(
				postEntity.getId(),
				postEntity.getTitle(),
				postEntity.getContent(),
				postEntity.getUserAuthor().getNome(),
				postEntity.getDate());
	}
	
	public static PostEntity dtoToEntity(PostPostDTO dto, UserRepository repository){
		UserEntity author = repository.findById(dto.getAuthorId())
				.orElseThrow(() -> new RuntimeException("Id not found"));
		
		return new PostEntity(
				dto.getTitle(),
				dto.getContent(),
				author);
	}
	
	public static void dtoUpdateEntity(PostPutDTO dto, PostEntity post) {
		post.setTitle(dto.getTitle());
		post.setContent(dto.getContent());
	}
	
}
