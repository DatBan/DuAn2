package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Quyen {
	@Id
	@GeneratedValue
	private int id;
	private String tenquyen;
	private String mota;

	public Quyen() {
		super();
	}

	public Quyen(String tenquyen, String mota) {
		super();
		this.tenquyen = tenquyen;
		this.mota = mota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenquyen() {
		return tenquyen;
	}

	public void setTenquyen(String tenquyen) {
		this.tenquyen = tenquyen;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

}
