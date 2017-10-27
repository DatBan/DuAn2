package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ChiTietTienIch {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;
	@ManyToOne
	@JoinColumn(name = "idtienich")
	private TienIch tienich;

	public ChiTietTienIch() {
		super();
	}

	public ChiTietTienIch(NhaHang nhahang, TienIch tienich) {
		super();
		this.nhahang = nhahang;
		this.tienich = tienich;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

	public TienIch getTienich() {
		return tienich;
	}

	public void setTienich(TienIch tienich) {
		this.tienich = tienich;
	}

}
