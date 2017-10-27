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
public class DanhGia {
	@Id
	@GeneratedValue
	private int id;
	private String tieude;
	private String noidung;
	private int doan;
	private int khonggian;
	private int giaca;
	private int phucvu;
	private int diemdanhgia;
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

	public DanhGia(String tieude, String noidung, int doan, int khonggian, int giaca, int phucvu, int diemdanhgia,
			boolean trangthai, Date ngaytao, NhaHang nhahang, NguoiDung nguoidanhgia) {
		super();
		this.tieude = tieude;
		this.noidung = noidung;
		this.doan = doan;
		this.khonggian = khonggian;
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

	public void setId(int id) {
		this.id = id;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public int getDoan() {
		return doan;
	}

	public void setDoan(int doan) {
		this.doan = doan;
	}

	public int getKhonggian() {
		return khonggian;
	}

	public void setKhonggian(int khonggian) {
		this.khonggian = khonggian;
	}

	public int getGiaca() {
		return giaca;
	}

	public void setGiaca(int giaca) {
		this.giaca = giaca;
	}

	public int getPhucvu() {
		return phucvu;
	}

	public void setPhucvu(int phucvu) {
		this.phucvu = phucvu;
	}

	public int getDiemdanhgia() {
		return diemdanhgia;
	}

	public void setDiemdanhgia(int diemdanhgia) {
		this.diemdanhgia = diemdanhgia;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public int getSoluonglike() {
		return soluonglike;
	}

	public void setSoluonglike(int soluonglike) {
		this.soluonglike = soluonglike;
	}

	public int getBaocao() {
		return baocao;
	}

	public void setBaocao(int baocao) {
		this.baocao = baocao;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

	public NguoiDung getNguoidanhgia() {
		return nguoidanhgia;
	}

	public void setNguoidanhgia(NguoiDung nguoidanhgia) {
		this.nguoidanhgia = nguoidanhgia;
	}

}
