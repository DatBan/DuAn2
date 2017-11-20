package com.entity;

import java.util.Date;

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
public class DanhGia {
	@Id
	@GeneratedValue
	private int id;
	private String tieude;
	private String noidung;
	private int doan;
	private int khongian;
	private int giaca;
	private int phucvu;
	private double diemdanhgia;
	private boolean trangthai;
	private int soluonglike;
	private int baocao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;
	@ManyToOne
	@JoinColumn(name = "idnguoidungdanhgia")
	private NguoiDung nguoidanhgia;

	public DanhGia() {
		super();
	}

	public DanhGia(String tieude, String noidung, int doan, int khonggian, int giaca, int phucvu, double diemdanhgia,
			boolean trangthai, Date ngaytao, NhaHang nhahang, NguoiDung nguoidanhgia) {
		super();
		this.tieude = tieude;
		this.noidung = noidung;
		this.doan = doan;
		this.khongian = khonggian;
		this.giaca = giaca;
		this.phucvu = phucvu;
		this.diemdanhgia = diemdanhgia;
		this.trangthai = trangthai;
		this.ngaytao = ngaytao;
		this.nhahang = nhahang;
		this.nguoidanhgia = nguoidanhgia;
	}

	public int getId() {
		return id;
	}

	public String getTieude() {
		return tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public int getDoan() {
		return doan;
	}

	public int getKhonggian() {
		return khongian;
	}

	public int getGiaca() {
		return giaca;
	}

	public int getPhucvu() {
		return phucvu;
	}

	public double getDiemdanhgia() {
		return diemdanhgia;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public int getSoluonglike() {
		return soluonglike;
	}

	public int getBaocao() {
		return baocao;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public NguoiDung getNguoidanhgia() {
		return nguoidanhgia;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public void setDoan(int doan) {
		this.doan = doan;
	}

	public void setKhonggian(int khonggian) {
		this.khongian = khonggian;
	}

	public void setGiaca(int giaca) {
		this.giaca = giaca;
	}

	public void setPhucvu(int phucvu) {
		this.phucvu = phucvu;
	}

	public void setDiemdanhgia(double diemdanhgia) {
		this.diemdanhgia = diemdanhgia;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public void setSoluonglike(int soluonglike) {
		this.soluonglike = soluonglike;
	}

	public void setBaocao(int baocao) {
		this.baocao = baocao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

	public void setNguoidanhgia(NguoiDung nguoidanhgia) {
		this.nguoidanhgia = nguoidanhgia;
	}

}
