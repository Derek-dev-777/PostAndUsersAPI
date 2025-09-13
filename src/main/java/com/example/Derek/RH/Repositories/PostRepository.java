package com.example.Derek.RH.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Derek.RH.Entities.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{
	
	
}
