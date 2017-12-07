package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table
public class Province {
	@Id
	private String provinceid;
	@Expose
	private String name;
	private String type;
	@Expose
	private String slug;

	public Province() {
		super();
	}

	public Province(String provinceid, String name, String type) {
		super();
		this.provinceid = provinceid;
		this.name = name;
		this.type = type;
	}
	
	public String getLabelfull() {
		return type+" "+name;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

}
