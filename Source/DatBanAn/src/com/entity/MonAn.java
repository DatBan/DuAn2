package com.entity;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

@Entity
@Table

public class MonAn {
	@Id
	@GeneratedValue
	@Expose
	private int id;
	@Expose
	private String tenmonan;
	private String name;
	@Expose
	private String hinhanh;
	private double gia;
	private int solandat;

	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;

	@ManyToOne
	@JoinColumn(name = "idloaidoan")
	private LoaiDoAn loai;
	private int trangthai;

	public MonAn() {
		super();
	}

	public MonAn(String tenmonan, String name, String hinhanh, double gia, NhaHang nhahang, LoaiDoAn loai) {
		super();
		this.tenmonan = tenmonan;
		this.name = name;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.nhahang = nhahang;
		this.loai = loai;
	}

	public MonAn(String tenmonan, String name, String hinhanh, double gia, int solandat, NhaHang nhahang,
			LoaiDoAn loai) {
		super();
		this.tenmonan = tenmonan;
		this.name = name;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.solandat = solandat;
		this.nhahang = nhahang;
		this.loai = loai;
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

	public String getTenmonan() {
		return tenmonan;
	}

	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSolandat() {
		return solandat;
	}

	public void setSolandat(int solandat) {
		this.solandat = solandat;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

	public LoaiDoAn getLoai() {
		return loai;
	}

	public void setLoai(LoaiDoAn loai) {
		this.loai = loai;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
