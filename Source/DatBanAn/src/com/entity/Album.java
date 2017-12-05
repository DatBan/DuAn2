package com.entity;

import javax.persistence.*;

@Entity
@Table
public class Album {
	@Id
	@GeneratedValue
	private int id;
	private String tenalbum;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhaHang;

	public Album() {
		super();
	}

	public Album(String tenalbum, NhaHang nhaHang) {
		super();
		this.tenalbum = tenalbum;
		this.nhaHang = nhaHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenalbum() {
		return tenalbum;
	}

	public void setTenalbum(String tenalbum) {
		this.tenalbum = tenalbum;
	}

	public NhaHang getNhaHang() {
		return nhaHang;
	}

	public void setNhaHang(NhaHang nhaHang) {
		this.nhaHang = nhaHang;
	}
}
