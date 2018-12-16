package com.example.osg.Technology.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.osg.Technology.dto.UsertechDTO;
import com.example.osg.Technology.entity.UsertechEntity;
import com.example.osg.Technology.entity.UsertechRepository;

@Service
public class UsertechServiceImpl implements UsertechService{
	
	@Autowired
	private UsertechRepository repository;

	@Override
	public int create(UsertechDTO dto) {
		dto.setId(0);
		UsertechEntity entity = new UsertechEntity();
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
		return entity.getId();
	}

	@Override
	public List<UsertechDTO> list(int offset, int limit) {
		Pageable pageable = new PageRequest(offset, limit);
		Iterable<UsertechEntity> listEntity = repository.findAll(pageable);
		List<UsertechDTO> list = new ArrayList<UsertechDTO>();
		for (UsertechEntity entity : listEntity) {
		    UsertechDTO dto = new UsertechDTO();
		    BeanUtils.copyProperties(entity,dto);
		    list.add(dto);
		}
		return list;
	}

	@Override
	public void update(UsertechDTO dto) {
		UsertechEntity entity = new UsertechEntity();
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
		
	}

	@Override
	public UsertechDTO get(int id) {
		Optional<UsertechEntity> entity = repository.findById(id);
		UsertechDTO dto = new UsertechDTO();
		if(entity.isPresent()) {
		    BeanUtils.copyProperties(entity.get(),dto);
		}
		return dto;
	}

	@Override
	public void delete(int id) {
		Optional<UsertechEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
		    repository.delete(entity.get());
		}
		
	}

}
