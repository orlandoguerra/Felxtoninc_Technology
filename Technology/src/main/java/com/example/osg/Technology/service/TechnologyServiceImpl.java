package com.example.osg.Technology.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.osg.Technology.dto.TechnologyDTO;
import com.example.osg.Technology.entity.TechnologyEntity;
import com.example.osg.Technology.entity.TechnologyRepository;

@Service
public class TechnologyServiceImpl implements TechnologyService{

	@Autowired
	private TechnologyRepository repository;
	
	@Override
	public int create(TechnologyDTO dto) {
		dto.setTechid(0);
		TechnologyEntity entity = new TechnologyEntity();
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
		return entity.getTechid();
	}

	@Override
	public List<TechnologyDTO> list(Integer offset, Integer limit) {
		Pageable pageable = new PageRequest(offset, limit);
		Iterable<TechnologyEntity> listEntity = repository.findAll(pageable);
		List<TechnologyDTO> list = new ArrayList<TechnologyDTO>();
		for (TechnologyEntity entity : listEntity) {
		    TechnologyDTO dto = new TechnologyDTO();
		    BeanUtils.copyProperties(entity,dto);
		    list.add(dto);
		}
		return list;
	}

	@Override
	public void update(TechnologyDTO dto) {
		TechnologyEntity entity = new TechnologyEntity();
		BeanUtils.copyProperties(dto, entity);
		repository.save(entity);
	}

	@Override
	public TechnologyDTO get(int id) {
		Optional<TechnologyEntity> entity = repository.findById(id);
		TechnologyDTO dto = new TechnologyDTO();
		if(entity.isPresent()) {
		    BeanUtils.copyProperties(entity.get(),dto);
		}
		return dto;
	}

	@Override
	public void delete(int id) {
		Optional<TechnologyEntity> entity = repository.findById(id);
		if(entity.isPresent()) {
		     repository.delete(entity.get());
		}
	}

}
