package com.entity;



import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Trang {
	@Id
	@GeneratedValue
	private int id;
	private String tieude;
	private String title;
	private String noidung;
	private String content;
	private String slug;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaysua;
	@ManyToOne
	@JoinColumn(name = "idnguoiviet")
	private NguoiDung nguoiviet;

	public Trang() {
		super();
	}

	public Trang(String tieude, String title, String noidung, String content, String slug, Date ngaytao,
			NguoiDung nguoiviet) {
		super();
		this.tieude = tieude;
		this.title = title;
		this.noidung = noidung;
		this.content = content;
		this.slug = slug;
		this.ngaytao = ngaytao;
		this.nguoiviet = nguoiviet;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
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

	public NguoiDung getNguoiviet() {
		return nguoiviet;
	}

	public void setNguoiviet(NguoiDung nguoiviet) {
		this.nguoiviet = nguoiviet;
	}

	

}
