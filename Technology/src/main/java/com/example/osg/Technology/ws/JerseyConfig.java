package com.example.osg.Technology.ws;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

   @Autowired
    public JerseyConfig(ObjectMapper objectMapper){
	   packages("com.example.osg.Technology.ws.entrypoint");
   }
   
}