package com.example.osg.Technology.service;

import java.util.List;

import com.example.osg.Technology.dto.UsertechDTO;

public interface UsertechService {
	
	public int create(UsertechDTO dto);
	public List<UsertechDTO> list(int offset, int limit);
	public void update(UsertechDTO dto);
	public UsertechDTO get(int id);
	public void delete(int id);

}
