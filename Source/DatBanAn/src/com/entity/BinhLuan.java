package com.entity;


import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class BinhLuan {
	@Id
	@GeneratedValue
	private int idbinhluan;
	private String noidung;

	private int trangthai;
	private int soluonglike;
	private int baocao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaysua;
	@ManyToOne
	@JoinColumn(name = "idnguoibl")
	private NguoiDung nguoibl;
	@ManyToOne
	@JoinColumn(name = "idbaiviet")
	private BaiViet baivietbl;
	@ManyToOne
	@JoinColumn(name = "idanh")
	private Anh anhbl;
	@ManyToOne
	@JoinColumn(name = "idmonan")
	private MonAn monanbl;
	@ManyToOne
	@JoinColumn(name = "idtraloi")
	private BinhLuan traloi;
	@OneToMany(mappedBy = "traloi", fetch = FetchType.EAGER)
	private Collection<BinhLuan> blcap;

	public BinhLuan() {
		super();
	}

	public BinhLuan(String noidung, Date ngaytao, NguoiDung nguoibl, BaiViet baivietbl, Anh anhbl, MonAn monanbl,
			BinhLuan traloi) {
		super();
		this.noidung = noidung;
		this.ngaytao = ngaytao;
		this.nguoibl = nguoibl;
		this.baivietbl = baivietbl;
		this.anhbl = anhbl;
		this.monanbl = monanbl;
		this.traloi = traloi;
	}

	public int getIdbinhluan() {
		return idbinhluan;
	}

	public void setIdbinhluan(int idbinhluan) {
		this.idbinhluan = idbinhluan;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
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

	public Date getNgaysua() {
		return ngaysua;
	}

	public void setNgaysua(Date ngaysua) {
		this.ngaysua = ngaysua;
	}

	public NguoiDung getNguoibl() {
		return nguoibl;
	}

	public void setNguoibl(NguoiDung nguoibl) {
		this.nguoibl = nguoibl;
	}

	public BaiViet getBaivietbl() {
		return baivietbl;
	}

	public void setBaivietbl(BaiViet baivietbl) {
		this.baivietbl = baivietbl;
	}

	public Anh getAnhbl() {
		return anhbl;
	}

	public void setAnhbl(Anh anhbl) {
		this.anhbl = anhbl;
	}

	public MonAn getMonanbl() {
		return monanbl;
	}

	public void setMonanbl(MonAn monanbl) {
		this.monanbl = monanbl;
	}

	public BinhLuan getTraloi() {
		return traloi;
	}

	public void setTraloi(BinhLuan traloi) {
		this.traloi = traloi;
	}

	public Collection<BinhLuan> getBlcap() {
		return blcap;
	}

	public void setBlcap(Collection<BinhLuan> blcap) {
		this.blcap = blcap;
	}

}
