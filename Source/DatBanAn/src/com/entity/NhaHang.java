package com.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonGetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import com.google.gson.annotations.Expose;

@Entity
@Table
public class NhaHang {
	@Id
	@GeneratedValue
	@Expose
	private int id;
	@Expose
	private String tennhahang;
	private String name;
	private String diachi;
	private String sdt;
	@Expose
	private String thumbnail;
	@Expose
	private String photopath;
	private String gioithieu;
	private String aboutus;
	@Expose
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

	@Formula("(SELECT COUNT(*) FROM hoadon c WHERE c.idnhahang = id)")
	private int countinvoice;

	/* @Formula("(SELECT nd FROM nguoidung nd WHERE nd.idnhahang = id)") */
	@ManyToOne
	@JoinColumnsOrFormulas({
			@JoinColumnOrFormula(formula = @JoinFormula(value = "(SELECT nd.id FROM nguoidung nd WHERE nd.idnhahang = id AND nd.idquyen = 2)", referencedColumnName = "id")) })
	private NguoiDung ndowner;

	public NguoiDung getNdowner() {
		return ndowner;
	}

	public void setNdowner(NguoiDung ndowner) {
		this.ndowner = ndowner;
	}

	@Temporal(TemporalType.TIME)
	private Date giomocua;
	@Temporal(TemporalType.TIME)
	private Date giodongcua;
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;

	@ManyToOne
	@JoinColumn(name = "idloaiamthuc")
	private LoaiAmThuc loaiamthuc;

	@ManyToOne
	@JoinColumn(name = "tinhthanh")
	@Expose
	private Province tinhthanh;

	@ManyToOne
	@JoinColumn(name = "quanhuyen")
	@Expose
	private District quanhuyen;

	@ManyToOne
	@JoinColumn(name = "phuongxa")
	private Ward phuongxa;

	@OneToMany(mappedBy = "nhahang", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<HoaDon> listhoadon;

	@OneToMany(mappedBy = "nhahang", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BanAn> listbanan;

	@OneToMany(mappedBy = "nhahang", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<NguoiDung> listnguoidung;

	@OneToMany(mappedBy = "nhahang", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DanhGia> listdanhgia;

	@OneToMany(mappedBy = "nhahang", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MonAn> listmonan;

	@OneToMany(mappedBy = "nhahang", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TienIch> listtienich;

	@OneToMany(mappedBy = "nhahang", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<KhuyenMai> listkhuyenmai;

	public NhaHang() {
		super();
	}

	public NhaHang(String tennhahang, String name, String diachi, Province tinhthanh, District quanhuyen, Ward phuongxa,
			String sdt, String thumbnail, String photopath, String gioithieu, String aboutus, String slug,
			int trangthai, Date giomocua, Date giodongcua, Date ngaytao, LoaiAmThuc loaiamthuc) {
		super();
		this.tennhahang = tennhahang;
		this.name = name;
		this.diachi = diachi;
		this.tinhthanh = tinhthanh;
		this.quanhuyen = quanhuyen;
		this.phuongxa = phuongxa;
		this.sdt = sdt;
		this.thumbnail = thumbnail;
		this.photopath = photopath;
		this.gioithieu = gioithieu;
		this.aboutus = aboutus;
		this.slug = slug;
		this.trangthai = trangthai;
		this.giomocua = giomocua;
		this.giodongcua = giodongcua;
		this.ngaytao = ngaytao;
		this.loaiamthuc = loaiamthuc;
	}

	public String getDiachifull() {
		return diachi + ", " + phuongxa.getLabelfull() + ", " + quanhuyen.getLabelfull() + ", "
				+ tinhthanh.getLabelfull();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
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

	public String getPhotopath() {
		return photopath;
	}

	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}

	public String getGioithieu() {
		return gioithieu;
	}

	public void setGioithieu(String gioithieu) {
		this.gioithieu = gioithieu;
	}

	public String getAboutus() {
		return aboutus;
	}

	public void setAboutus(String aboutus) {
		this.aboutus = aboutus;
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

	public Double getSumRating() {
		return sumRating;
	}

	public void setSumRating(Double sumRating) {
		this.sumRating = sumRating;
	}

	public Double getSumDoAn() {
		return sumDoAn;
	}

	public void setSumDoAn(Double sumDoAn) {
		this.sumDoAn = sumDoAn;
	}

	public Double getSumKhongGian() {
		return sumKhongGian;
	}

	public void setSumKhongGian(Double sumKhongGian) {
		this.sumKhongGian = sumKhongGian;
	}

	public Double getSumPhucVu() {
		return sumPhucVu;
	}

	public void setSumPhucVu(Double sumPhucVu) {
		this.sumPhucVu = sumPhucVu;
	}

	public Double getSumGiaCa() {
		return sumGiaCa;
	}

	public void setSumGiaCa(Double sumGiaCa) {
		this.sumGiaCa = sumGiaCa;
	}

	public int getCountRating() {
		return countRating;
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

	public Integer getCountinvoice() {
		return countinvoice;
	}

	public void setCountinvoice(Integer countinvoice) {
		this.countinvoice = countinvoice;
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

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public LoaiAmThuc getLoaiamthuc() {
		return loaiamthuc;
	}

	public void setLoaiamthuc(LoaiAmThuc loaiamthuc) {
		this.loaiamthuc = loaiamthuc;
	}

	public Province getTinhthanh() {
		return tinhthanh;
	}

	public void setTinhthanh(Province tinhthanh) {
		this.tinhthanh = tinhthanh;
	}

	public District getQuanhuyen() {
		return quanhuyen;
	}

	public void setQuanhuyen(District quanhuyen) {
		this.quanhuyen = quanhuyen;
	}

	public Ward getPhuongxa() {
		return phuongxa;
	}

	public void setPhuongxa(Ward phuongxa) {
		this.phuongxa = phuongxa;
	}

	public List<HoaDon> getListhoadon() {
		return listhoadon;
	}

	public void setListhoadon(List<HoaDon> listhoadon) {
		this.listhoadon = listhoadon;
	}

	public List<BanAn> getListbanan() {
		return listbanan;
	}

	public void setListbanan(List<BanAn> listbanan) {
		this.listbanan = listbanan;
	}

	public List<NguoiDung> getListnguoidung() {
		return listnguoidung;
	}

	public void setListnguoidung(List<NguoiDung> listnguoidung) {
		this.listnguoidung = listnguoidung;
	}

	public List<KhuyenMai> getListkhuyenmai() {
		return listkhuyenmai;
	}

	public void setListkhuyenmai(List<KhuyenMai> listkhuyenmai) {
		this.listkhuyenmai = listkhuyenmai;
	}

}
