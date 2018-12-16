package com.example.osg.Technology.service;

import java.util.List;

import com.example.osg.Technology.dto.TechnologyDTO;

public interface TechnologyService {
	
	public int create(TechnologyDTO dto);
	public List<TechnologyDTO> list(Integer offset, Integer limit);
	public void update(TechnologyDTO dto);
	public TechnologyDTO get(int id);
	public void delete(int id);

}
