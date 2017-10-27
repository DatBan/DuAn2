package com.entity;

import javax.persistence.*;

@Entity
@Table
public class Anh {
	@Id
	@GeneratedValue
	private int id;
	private String tenhinhanh;
	private String hinhanh;
	private int trangthai;
	private String mota;
	@ManyToOne
	@JoinColumn(name = "idalbum")
	private Album albumanh;

	public Anh() {
		super();
	}

	public Anh(String tenhinhanh, String hinhanh, String mota, Album albumanh) {
		super();
		this.tenhinhanh = tenhinhanh;
		this.hinhanh = hinhanh;
		this.mota = mota;
		this.albumanh = albumanh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenhinhanh() {
		return tenhinhanh;
	}

	public void setTenhinhanh(String tenhinhanh) {
		this.tenhinhanh = tenhinhanh;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Album getAlbumanh() {
		return albumanh;
	}

	public void setAlbumanh(Album albumanh) {
		this.albumanh = albumanh;
	}

}
