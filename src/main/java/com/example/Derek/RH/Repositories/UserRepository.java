package com.example.Derek.RH.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Derek.RH.Entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	
}
