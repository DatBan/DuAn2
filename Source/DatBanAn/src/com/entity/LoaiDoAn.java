package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LoaiDoAn {
	@Id
	@GeneratedValue
	private int id;
	private String tenloaidoan;
	private String name;
	private String mota;
	private String description;

	public LoaiDoAn() {
		super();
	}

	public LoaiDoAn(String tenloaidoan, String name, String mota, String description) {
		super();
		this.tenloaidoan = tenloaidoan;
		this.name = name;
		this.mota = mota;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenloaidoan() {
		return tenloaidoan;
	}

	public void setTenloaidoan(String tenloaidoan) {
		this.tenloaidoan = tenloaidoan;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
