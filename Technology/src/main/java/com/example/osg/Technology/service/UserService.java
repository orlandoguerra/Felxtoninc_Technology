package com.example.osg.Technology.service;

import java.util.List;

import com.example.osg.Technology.dto.UserDTO;

public interface UserService {

	public int create(UserDTO dto);
	public List<UserDTO> list(Integer offset, Integer limit);
	public void update(UserDTO dto);
	public UserDTO get(int id);
	public void delete(int id);

}
