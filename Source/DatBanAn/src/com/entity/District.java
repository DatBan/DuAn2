package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table
public class District {
	@Id
	private String districtid;
	@Expose
	private String name;
	private String type;
	private String location;
	private String provinceid;

	public District() {
		super();
	}

	public District(String districtid, String name, String type, String location, String provinceid) {
		super();
		this.districtid = districtid;
		this.name = name;
		this.type = type;
		this.location = location;
		this.provinceid = provinceid;
	}
	
	public String getLabelfull() {
		return type+" "+name;
	}

	public String getDistrictid() {
		return districtid;
	}

	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
