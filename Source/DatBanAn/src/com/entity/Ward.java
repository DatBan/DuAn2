package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Ward {
	@Id
	private String wardid;
	private String name;
	private String type;
	private String location;
	private String districtid;

	public Ward() {
		super();
	}

	public Ward(String wardid, String name, String type, String location, String districtid) {
		super();
		this.wardid = wardid;
		this.name = name;
		this.type = type;
		this.location = location;
		this.districtid = districtid;
	}
	
	public String getLabelfull() {
		return type+" "+name;
	}

	public String getWardid() {
		return wardid;
	}

	public void setWardid(String wardid) {
		this.wardid = wardid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDistrictid() {
		return districtid;
	}

	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

}
