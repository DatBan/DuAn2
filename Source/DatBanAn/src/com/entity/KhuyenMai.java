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
public class KhuyenMai {
	@Id
	@GeneratedValue
	private int id;
	private String chude;
	private String name;
	private String thongtin;
	@Temporal(TemporalType.DATE)
	private Date ngaybatdau;
	@Temporal(TemporalType.DATE)
	private Date ngayketthuc;
	private boolean trangthai;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;

	public KhuyenMai() {
		super();
	}

	public KhuyenMai(String chude, String name, String thongtin, Date ngaybatdau, Date ngayketthuc, boolean trangthai,
			NhaHang nhahang) {
		super();
		this.chude = chude;
		this.name = name;
		this.thongtin = thongtin;
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
		this.trangthai = trangthai;
		this.nhahang = nhahang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChude() {
		return chude;
	}

	public void setChude(String chude) {
		this.chude = chude;
	}

	public String getThongtin() {
		return thongtin;
	}

	public void setThongtin(String thongtin) {
		this.thongtin = thongtin;
	}

	public Date getNgaybatdau() {
		return ngaybatdau;
	}

	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}

	public Date getNgayketthuc() {
		return ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
