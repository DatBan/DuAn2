package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class LoaiBaiViet {
	@Id
	@GeneratedValue
	private int id;
	private String tenloai;
	private String name;
	private String mota;
	private String description;

	public LoaiBaiViet() {
		super();
	}

	public LoaiBaiViet(String tenloai, String name, String mota, String description) {
		super();
		this.tenloai = tenloai;
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

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
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