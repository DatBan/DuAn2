package com.entity;



import java.util.Date;

import javax.persistence.*;

/**
 * @author TuTo
 *
 */
@Entity
@Table
public class NguoiDung {
	@Id
	@GeneratedValue
	private int id;
	private String hoten;
	private String tendangnhap;
	private String matkhau;
	private String email;
	private String sdt;
	private String diachi;
	private String idfacebook;
	private String idgoogle;
	private int trangthai;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;
	@ManyToOne
	@JoinColumn(name = "idquyen")
	private Quyen quyennd;

	public NguoiDung() {
		super();
	}

	public NguoiDung(String hoten, String tendangnhap, String matkhau, String email, String sdt, String diachi,
			int trangthai,Date ngaytao, Quyen quyennd) {
		super();
		
		this.hoten = hoten;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.email = email;
		this.sdt = sdt;
		this.diachi = diachi;
		this.trangthai = trangthai;
		this.ngaytao = (Date) ngaytao;
		this.quyennd = quyennd;
	}

	public NguoiDung(String hoten, String tendangnhap, String matkhau, String email, String sdt, int trangthai,
			Date ngaytao, Quyen quyennd) {
		super();
		this.hoten = hoten;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.email = email;
		this.sdt = sdt;
		this.trangthai = trangthai;
		this.ngaytao = ngaytao;
		this.quyennd = quyennd;
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

	public String getTendangnhap() {
		return tendangnhap;
	}

	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getIdfacebook() {
		return idfacebook;
	}

	public void setIdfacebook(String idfacebook) {
		this.idfacebook = idfacebook;
	}

	public String getIdgoogle() {
		return idgoogle;
	}

	public void setIdgoogle(String idgoogle) {
		this.idgoogle = idgoogle;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public Quyen getQuyennd() {
		return quyennd;
	}

	public void setQuyennd(Quyen quyennd) {
		this.quyennd = quyennd;
	}

}
