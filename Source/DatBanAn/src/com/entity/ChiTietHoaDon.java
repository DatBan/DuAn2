package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ChiTietHoaDon {
	@Id
	@GeneratedValue
	private int id;

	private int trangthai;
	@ManyToOne
	@JoinColumn(name = "idhoadon")
	private HoaDon hoadon;
	@ManyToOne
	@JoinColumn(name = "idmonan")
	private MonAn monan;

	public ChiTietHoaDon() {
		super();
	}

	public ChiTietHoaDon(int trangthai, HoaDon hoadon, MonAn monan) {
		super();

		this.trangthai = trangthai;
		this.hoadon = hoadon;
		this.monan = monan;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public MonAn getMonan() {
		return monan;
	}

	public void setMonan(MonAn monan) {
		this.monan = monan;
	}

}
