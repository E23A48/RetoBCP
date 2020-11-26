package com.example.userservice.models.service;

import com.example.userservice.models.entity.User;

public interface IUserService  {
	public User findById(Long id);
}
