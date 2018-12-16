package com.example.osg.Technology.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.osg.Technology.dto.UserDTO;
import com.example.osg.Technology.entity.UserEntity;
import com.example.osg.Technology.entity.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public int create(UserDTO dto) {
		dto.setId(0);
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
		return entity.getId();
	}
	
	@Override
	public List<UserDTO> list(Integer offset, Integer limit) {
		Pageable pageable = new PageRequest(offset, limit);
		Page<UserEntity> listEntity = repository.findAll(pageable);
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserEntity entity : listEntity) {
			UserDTO dto = new UserDTO();
			BeanUtils.copyProperties(entity,dto);
			list.add(dto);
		}
		return list;
	}

	@Override
	public void update(UserDTO dto) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
	}

	@Override
	public UserDTO get(int id) {
		Optional<UserEntity> entity = repository.findById(id);
		UserDTO dto = new UserDTO();
		if(entity.isPresent()) {
			BeanUtils.copyProperties(entity.get(),dto);
		}
		return dto;
	}

	@Override
	public void delete(int id) {
		Optional<UserEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
			repository.delete(entity.get());
		}
	}

}
