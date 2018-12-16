package com.example.osg.Technology.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="technology")
public class TechnologyEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="techid")
	private int techid;
	@Column(name="name")
	private String name;
	@Column(name="isActive")
	private int isActive;
	

	
	public TechnologyEntity() {
	}

	public TechnologyEntity(int techid, String name, int isActive) {
		this.techid = techid;
		this.name = name;
		this.isActive = isActive;
	}
	
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
