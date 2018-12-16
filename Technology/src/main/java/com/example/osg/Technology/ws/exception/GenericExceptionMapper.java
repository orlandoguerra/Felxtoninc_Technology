package com.example.osg.Technology.ws.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.example.osg.Technology.ws.model.ErrorMessageResponseModel;



@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessageResponseModel errorModel = 
				new ErrorMessageResponseModel(exception.getMessage(), 
						"Unexpected Error", "");
		
		return Response.status(Response.Status.BAD_REQUEST).entity(errorModel).build();
	}

}
