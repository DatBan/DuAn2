package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class NhaHangYeuThich {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;
	@ManyToOne
	@JoinColumn(name = "idnguoidung")
	private NguoiDung nguoidung;

	public NhaHangYeuThich() {
		super();
	}

	public NhaHangYeuThich(NhaHang nhahang, NguoiDung nguoidung) {
		super();
		this.nhahang = nhahang;
		this.nguoidung = nguoidung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}

}
