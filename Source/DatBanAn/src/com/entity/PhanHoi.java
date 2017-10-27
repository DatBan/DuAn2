package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class PhanHoi {
	@Id
	@GeneratedValue
	private int idphanhoi;
	@ManyToOne
	@JoinColumn(name = "idnguoidung")
	private NguoiDung nguoidung;
	@ManyToOne
	@JoinColumn(name = "idbaiviet")
	private BaiViet baiviet;
	@ManyToOne
	@JoinColumn(name = "idanh")
	private Anh hinhanh;

	public PhanHoi() {
		super();
	}

	public PhanHoi(NguoiDung nguoidung, BaiViet baiviet, Anh hinhanh) {
		super();
		this.nguoidung = nguoidung;
		this.baiviet = baiviet;
		this.hinhanh = hinhanh;
	}

	public int getIdphanhoi() {
		return idphanhoi;
	}

	public void setIdphanhoi(int idphanhoi) {
		this.idphanhoi = idphanhoi;
	}

	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}

	public BaiViet getBaiviet() {
		return baiviet;
	}

	public void setBaiviet(BaiViet baiviet) {
		this.baiviet = baiviet;
	}

	public Anh getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(Anh hinhanh) {
		this.hinhanh = hinhanh;
	}

}
