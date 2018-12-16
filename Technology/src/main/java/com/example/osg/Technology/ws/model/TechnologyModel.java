package com.example.osg.Technology.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TechnologyModel {
	
	private int techid;
	private String name;
	private int isActive;
	
	public int getTechid() {
		return techid;
	}
	public void setTechid(int techid) {
		this.techid = techid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}


}
