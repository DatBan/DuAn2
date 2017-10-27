package com.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table
public class NhaHang {
	@Id
	@GeneratedValue
	private int id;
	private String tennhahang;
	private String name;
	private String diachi;
	private String address;
	private String tinhthanh;
	private String city;
	private String quanhuyen;
	private String district;
	private String phuongxa;
	private String ward;
	private String sdt;
	private String thumbnail;
	private String gioithieu;
	private String aboutus;
	private String slug;
	private int trangthai;
	private String mota;
	@Temporal(TemporalType.TIME)
	private Date giomocua;
	@Temporal(TemporalType.TIME)
	private Date giodongcua;
	@ManyToOne
	@JoinColumn(name = "idloaiamthuc")
	private LoaiAmThuc loaiamthuc;

	public NhaHang() {
		super();
	}
	
	public NhaHang(String tennhahang, String name, String diachi, String address, String tinhthanh, String city,
			String quanhuyen, String district, String phuongxa, String ward, String sdt, String thumbnail,
			String gioithieu, String aboutus, String slug, int trangthai, Date giomocua, Date giodongcua,
			LoaiAmThuc loaiamthuc) {
		super();
		this.tennhahang = tennhahang;
		this.name = name;
		this.diachi = diachi;
		this.address = address;
		this.tinhthanh = tinhthanh;
		this.city = city;
		this.quanhuyen = quanhuyen;
		this.district = district;
		this.phuongxa = phuongxa;
		this.ward = ward;
		this.sdt = sdt;
		this.thumbnail = thumbnail;
		this.gioithieu = gioithieu;
		this.aboutus = aboutus;
		this.slug = slug;
		this.trangthai = trangthai;
		this.giomocua = giomocua;
		this.giodongcua = giodongcua;
		this.loaiamthuc = loaiamthuc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTennhahang() {
		return tennhahang;
	}

	public void setTennhahang(String tennhahang) {
		this.tennhahang = tennhahang;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getTinhthanh() {
		return tinhthanh;
	}

	public void setTinhthanh(String tinhthanh) {
		this.tinhthanh = tinhthanh;
	}

	public String getQuanhuyen() {
		return quanhuyen;
	}

	public void setQuanhuyen(String quanhuyen) {
		this.quanhuyen = quanhuyen;
	}

	public String getPhuongxa() {
		return phuongxa;
	}

	public void setPhuongxa(String phuongxa) {
		this.phuongxa = phuongxa;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getGioithieu() {
		return gioithieu;
	}

	public void setGioithieu(String gioithieu) {
		this.gioithieu = gioithieu;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Date getGiomocua() {
		return giomocua;
	}

	public void setGiomocua(Date giomocua) {
		this.giomocua = giomocua;
	}

	public Date getGiodongcua() {
		return giodongcua;
	}

	public void setGiodongcua(Date giodongcua) {
		this.giodongcua = giodongcua;
	}

	public LoaiAmThuc getLoaiamthuc() {
		return loaiamthuc;
	}

	public void setLoaiamthuc(LoaiAmThuc loaiamthuc) {
		this.loaiamthuc = loaiamthuc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getAboutus() {
		return aboutus;
	}

	public void setAboutus(String aboutus) {
		this.aboutus = aboutus;
	}

}