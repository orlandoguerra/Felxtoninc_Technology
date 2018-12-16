package com.example.osg.Technology.ws.entrypoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.osg.Technology.dto.TechnologyDTO;
import com.example.osg.Technology.service.TechnologyService;
import com.example.osg.Technology.ws.model.TechnologyModel;

@Path("/technology")
public class TechnologyEndPoint {

	@Autowired
	TechnologyService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TechnologyModel> get(@QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("limit") @DefaultValue("10") Integer limit) {
	    List<TechnologyDTO> listDtos = service.list(offset,limit);
	    List<TechnologyModel> list = new ArrayList<TechnologyModel>();
	    for (TechnologyDTO dto : listDtos) {
	        TechnologyModel model = new TechnologyModel();
	        BeanUtils.copyProperties(dto,model);
	        list.add(model);
	    }
	    return list;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TechnologyModel get(@PathParam("id")int id) {
	    TechnologyDTO dto = service.get(id);
	    TechnologyModel model = new TechnologyModel();
	    BeanUtils.copyProperties(dto,model);
	    return model;
	}
	
	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void post(TechnologyModel model) {
	    TechnologyDTO dto = new TechnologyDTO();
	    BeanUtils.copyProperties(model, dto);
	    service.create(dto);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void put(@PathParam("id") int id,TechnologyModel model) {
	    TechnologyDTO dto = new TechnologyDTO();
	    BeanUtils.copyProperties(model, dto);
	    dto.setTechid(id);
	    service.update(dto);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
	    service.delete(id);
	}

}
