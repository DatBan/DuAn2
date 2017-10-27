package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ThongBao {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "idkhuyenmai")
	private KhuyenMai khuyenmai;
	@ManyToOne
	@JoinColumn(name = "idnguoidungdk")
	private NguoiDung nguoidung;

	public ThongBao() {
		super();
	}

	public ThongBao(KhuyenMai khuyenmai, NguoiDung nguoidung) {
		super();
		this.khuyenmai = khuyenmai;
		this.nguoidung = nguoidung;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public KhuyenMai getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(KhuyenMai khuyenmai) {
		this.khuyenmai = khuyenmai;
	}

	public NguoiDung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDung nguoidung) {
		this.nguoidung = nguoidung;
	}

}
