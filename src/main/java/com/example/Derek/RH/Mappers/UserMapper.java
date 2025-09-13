package com.example.Derek.RH.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.Derek.RH.DTOs.PostDTOs.PostGetDTO;
import com.example.Derek.RH.DTOs.UserDTOs.UserGetDTO;
import com.example.Derek.RH.DTOs.UserDTOs.UserPostDTO;
import com.example.Derek.RH.DTOs.UserDTOs.UserPutDTO;
import com.example.Derek.RH.Entities.PostEntity;
import com.example.Derek.RH.Entities.UserEntity;

public class UserMapper {
    
    public static UserGetDTO dtoGetEntity(UserEntity userEntity) {
        List<PostGetDTO> postDTOs = userEntity.getPosts()
            .stream()
            .map(UserMapper::mapPostToDTO)
            .collect(Collectors.toList());

        return new UserGetDTO(
            userEntity.getId(),
            userEntity.getNome(),
            userEntity.getEmail(),
            userEntity.getDate(),
            postDTOs
        );
    }

    private static PostGetDTO mapPostToDTO(PostEntity postEntity) {
        return new PostGetDTO(
            postEntity.getId(),
            postEntity.getTitle(),
            postEntity.getUserAuthor().getNome(),
            postEntity.getContent(),
            postEntity.getDate()
        );
    }
    
    private static UserEntity toEntity(UserPostDTO dto) {
    	return new UserEntity(
    			dto.getName(),
    			dto.getEmail(),
    			dto.getPassword());
    }
    
    private static void dtoUpdateEntity(UserPutDTO dto, UserEntity entity) {
    	entity.setNome(dto.getName());
    	entity.setEmail(dto.getEmail());
    	entity.setPassword(dto.getPassword());
    }
    
}
