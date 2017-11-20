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

import org.hibernate.annotations.Formula;

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

	@Formula("(SELECT ROUND((SUM(c.diemdanhgia)/COUNT(*)),1) FROM danhgia c WHERE c.idnhahang = id)")
	private Double sumRating;

	@Formula("(SELECT ROUND((SUM(c.doan)/COUNT(*)),1) FROM danhgia c WHERE c.idnhahang = id)")
	private Double sumDoAn;

	@Formula("(SELECT ROUND((SUM(c.khongian)/COUNT(*)),1) FROM danhgia c WHERE c.idnhahang = id)")
	private Double sumKhongGian;

	@Formula("(SELECT ROUND((SUM(c.phucvu)/COUNT(*)),1) FROM danhgia c WHERE c.idnhahang = id)")
	private Double sumPhucVu;

	@Formula("(SELECT ROUND((SUM(c.giaca)/COUNT(*)),1) FROM danhgia c WHERE c.idnhahang = id)")
	private Double sumGiaCa;

	@Formula("(SELECT COUNT(*) FROM danhgia c WHERE c.idnhahang = id)")
	private int countRating;
	
	@Formula("(SELECT COUNT(*) FROM danhgia c WHERE c.idnhahang = id AND c.diemdanhgia = '5')") 
	private int count5;
	
	@Formula("(SELECT COUNT(*) FROM danhgia c WHERE c.idnhahang = id AND c.diemdanhgia = '4')") 
		private int count4;
	
	@Formula("(SELECT COUNT(*) FROM danhgia c WHERE c.idnhahang = id AND c.diemdanhgia = '3')") 
		private int count3;
	
	@Formula("(SELECT COUNT(*) FROM danhgia c WHERE c.idnhahang = id AND c.diemdanhgia = '2')") 
		private int count2;
	
	@Formula("(SELECT COUNT(*) FROM danhgia c WHERE c.idnhahang = id AND c.diemdanhgia = '1')") 
		private int count1;

	@Temporal(TemporalType.TIME)
	private Date giomocua;
	@Temporal(TemporalType.TIME)
	private Date giodongcua;
	@Temporal(TemporalType.TIME)
	private Date ngaytao;
	@ManyToOne
	@JoinColumn(name = "idloaiamthuc")
	private LoaiAmThuc loaiamthuc;

	public NhaHang() {
		super();
	}

	public NhaHang(String tennhahang, String name, String diachi, String address, String tinhthanh, String city,
			String quanhuyen, String district, String phuongxa, String ward, String sdt, String thumbnail,
			String gioithieu, String aboutus, String slug, int trangthai, Date giomocua, Date giodongcua, Date ngaytao,
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
		this.ngaytao = ngaytao;
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

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public int getCountRating() {
		return countRating;
	}

	public Double getSumRating() {
		System.out.println(sumRating+" 1 1");
		return sumRating == null ? 0 : sumRating;
	}

	public void setSumRating(Double sumRating) {
		this.sumRating = sumRating;
	}

	public Double getSumDoAn() {
		return sumDoAn == null ? 0 : sumDoAn;
	}

	public void setSumDoAn(Double sumDoAn) {
		this.sumDoAn = sumDoAn;
	}

	public Double getSumKhongGian() {
		return sumKhongGian == null ? 0 : sumKhongGian;
	}

	public void setSumKhongGian(Double sumKhongGian) {
		this.sumKhongGian = sumKhongGian;
	}

	public Double getSumPhucVu() {
		return sumPhucVu == null ? 0 : sumPhucVu;
	}

	public void setSumPhucVu(Double sumPhucVu) {
		this.sumPhucVu = sumPhucVu;
	}

	public Double getSumGiaCa() {
		return sumGiaCa == null ? 0 : sumGiaCa;
	}

	public void setSumGiaCa(Double sumGiaCa) {
		this.sumGiaCa = sumGiaCa;
	}

	public void setCountRating(int countRating) {
		this.countRating = countRating;
	}

	public int getCount5() {
		return count5;
	}

	public void setCount5(int count5) {
		this.count5 = count5;
	}

	public int getCount4() {
		return count4;
	}

	public void setCount4(int count4) {
		this.count4 = count4;
	}

	public int getCount3() {
		return count3;
	}

	public void setCount3(int count3) {
		this.count3 = count3;
	}

	public int getCount2() {
		return count2;
	}

	public void setCount2(int count2) {
		this.count2 = count2;
	}

	public int getCount1() {
		return count1;
	}

	public void setCount1(int count1) {
		this.count1 = count1;
	}

}
