package com.example.osg.Technology.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsertechModel {
	
	private int id;
	private int userid;
	private int techid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTechid() {
		return techid;
	}
	public void setTechid(int techid) {
		this.techid = techid;
	}
	
	

}
