package com.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class HoaDon {
	@Id
	@GeneratedValue
	private int id;
	private String hoten;
	private String email;
	private String dienthoai;
	private String nhandip;
	private String ghichu;
	private double tongtien;
	private int songuoi;
	private int trangthai;
	private boolean nhanemail;
	@Temporal(TemporalType.TIMESTAMP)
	private Date thoigian;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;
	@ManyToOne
	@JoinColumn(name = "idkhuyenmai")
	private KhuyenMai khuyenmai;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;
	@ManyToOne
	@JoinColumn(name = "idnguoidung")
	private NguoiDung nguoiDung;
	@ManyToOne
	@JoinColumn(name = "idban")
	private BanAn banan;

	public HoaDon() {
		super();
	}

	public HoaDon(String hoten, String email, String dienthoai, String nhandip, String ghichu, double tongtien,
			int songuoi, int trangthai, boolean nhanemail, Date thoigian, Date ngaytao, KhuyenMai khuyenmai,
			NhaHang nhahang, NguoiDung nguoiDung, BanAn banan) {
		super();
		this.hoten = hoten;
		this.email = email;
		this.dienthoai = dienthoai;
		this.nhandip = nhandip;
		this.ghichu = ghichu;
		this.tongtien = tongtien;
		this.songuoi = songuoi;
		this.trangthai = trangthai;
		this.nhanemail = nhanemail;
		this.thoigian = thoigian;
		this.ngaytao = ngaytao;
		this.khuyenmai = khuyenmai;
		this.nhahang = nhahang;
		this.nguoiDung = nguoiDung;
		this.banan = banan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public String getNhandip() {
		return nhandip;
	}

	public void setNhandip(String nhandip) {
		this.nhandip = nhandip;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	public int getSonguoi() {
		return songuoi;
	}

	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public boolean isNhanemail() {
		return nhanemail;
	}

	public void setNhanemail(boolean nhanemail) {
		this.nhanemail = nhanemail;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public KhuyenMai getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(KhuyenMai khuyenmai) {
		this.khuyenmai = khuyenmai;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public BanAn getBanan() {
		return banan;
	}

	public void setBanan(BanAn banan) {
		this.banan = banan;
	}

}
