package com.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Formula;

@Entity
@Table
public class BaiViet {
	@Id
	@GeneratedValue
	private int id;
	private String tieude;
	private String name;
	private String noidung;
	private String content;
	private String hinh;
	private String slug;
	private String mota;
	private int trangthai;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaysua;
	@ManyToOne
	@JoinColumn(name = "idloaibaiviet")
	private LoaiBaiViet loaibv;
	@ManyToOne
	@JoinColumn(name = "idnguoiviet")
	private NguoiDung nguoiviet;
	@Formula("(SELECT COUNT(*) FROM binhluan bl WHERE bl.idbaiviet = id)")
	private int countcmt;

	public BaiViet() {
		super();
	}

	public BaiViet(String tieude, String name, String noidung, String content, String hinh, String slug, String mota,
			int trangthai, Date ngaytao, LoaiBaiViet loaibv, NguoiDung nguoiviet) {
		super();
		this.tieude = tieude;
		this.name = name;
		this.noidung = noidung;
		this.content = content;
		this.hinh = hinh;
		this.slug = slug;
		this.mota = mota;
		this.trangthai = trangthai;
		this.ngaytao = ngaytao;
		this.loaibv = loaibv;
		this.nguoiviet = nguoiviet;
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

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
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

	public LoaiBaiViet getLoaibv() {
		return loaibv;
	}

	public void setLoaibv(LoaiBaiViet loaibv) {
		this.loaibv = loaibv;
	}

	public NguoiDung getNguoiviet() {
		return nguoiviet;
	}

	public void setNguoiviet(NguoiDung nguoiviet) {
		this.nguoiviet = nguoiviet;
	}

	public Integer getCountcmt() {
		return countcmt;
	}

	public void setCountcmt(Integer countcmt) {
		this.countcmt = countcmt;
	}

}
