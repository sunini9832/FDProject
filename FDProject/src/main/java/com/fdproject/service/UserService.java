package com.fdproject.service;

import com.fdproject.domain.UserDTO;

public interface UserService {
	
	public boolean registerUser(UserDTO users);
	
	public UserDTO getUserDetail(Long userId);
	
	public boolean deleteUser(UserDTO users);
	
}
