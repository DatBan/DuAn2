package com.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "banan")
public class BanAn {
	@Id
	@GeneratedValue
	@Expose
	private int id;
	@Expose
	private int soban;
	private int songuoi;
	private int trangthai;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;
	
	@OneToMany(mappedBy = "banan", fetch = FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private List<HoaDon> listhoadon;
	
	/*@OneToMany(mappedBy = "banan", fetch = FetchType.EAGER)
	private Collection<HoaDon> listhd;*/

	public BanAn() {
		super();
	}

	public BanAn(int soban, int songuoi, int trangthai, NhaHang nhahang) {
		super();
		this.soban = soban;
		this.songuoi = songuoi;
		this.trangthai = trangthai;
		this.nhahang = nhahang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoban() {
		return soban;
	}

	public void setSoban(int soban) {
		this.soban = soban;
	}

	public int getSonguoi() {
		return songuoi;
	}

	public void setSonguoi(int songuoi) {
		this.songuoi = songuoi;
	}

	

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

	/*public Collection<HoaDon> getListhd() {
		return listhd;
	}

	public void setListhd(Collection<HoaDon> listhd) {
		this.listhd = listhd;
	}*/

}
