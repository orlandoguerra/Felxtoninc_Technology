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

import com.example.osg.Technology.dto.UserDTO;
import com.example.osg.Technology.service.UserService;
import com.example.osg.Technology.ws.model.UserModel;

@Path("/user")
public class UserEndPoint {
	
	@Autowired
	UserService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserModel> get(@QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("limit") @DefaultValue("10") Integer limit) {
	 	List<UserDTO> listDtos = service.list(offset,limit);
	 	List<UserModel> list = new ArrayList<UserModel>();
	 	for (UserDTO dto : listDtos) {
	 		UserModel model = new UserModel();
			BeanUtils.copyProperties(dto,model);
			list.add(model);
		}
	    return list;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserModel get(@PathParam("id")int id) {
		UserDTO dto = service.get(id);
		UserModel model = new UserModel();
		BeanUtils.copyProperties(dto,model);
	    return model;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void post(UserModel model) {
	    UserDTO dto = new UserDTO();
	    BeanUtils.copyProperties(model, dto);
	    service.create(dto);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void put(@PathParam("id") int id,UserModel model) {
		UserDTO dto = new UserDTO();
	    BeanUtils.copyProperties(model, dto);
	    dto.setId(id);
	    service.update(dto);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		service.delete(id);
	}

	
}
