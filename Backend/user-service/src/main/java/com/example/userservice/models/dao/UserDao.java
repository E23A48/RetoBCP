package com.example.userservice.models.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.userservice.models.entity.User;

public interface UserDao extends CrudRepository<User, Long> {
		

}
