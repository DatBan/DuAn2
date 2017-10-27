package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "banan")
public class BanAn {
	@Id
	@GeneratedValue
	private int id;
	private int soban;
	private int songuoi;
	private boolean trangthai;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;

	public BanAn() {
		super();
	}

	public BanAn(int soban, int songuoi, boolean trangthai, NhaHang nhahang) {
		super();
		this.soban = soban;
		this.songuoi = songuoi;
		this.trangthai = trangthai;
		this.nhahang = nhahang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoban() {
		return soban;
	}

	public void setSoban(int soban) {
		this.soban = soban;
	}

	public int getSonguoi() {
		return songuoi;
	}

	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

}
