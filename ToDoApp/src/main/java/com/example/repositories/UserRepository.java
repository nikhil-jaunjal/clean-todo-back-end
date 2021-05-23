package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

}
