package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TienIch {
	@Id
	@GeneratedValue
	private int id;
	private String tentienich;
	private String name;
	private String icon;
	@ManyToOne
	@JoinColumn(name = "idnhahang")
	private NhaHang nhahang;
	public TienIch() {
		super();
	}

	public TienIch(String tentienich, String name, String icon, NhaHang nhahang) {
		super();
		this.tentienich = tentienich;
		this.name = name;
		this.icon = icon;
		this.nhahang = nhahang;
	}

	public TienIch(String tentienich, String name, String icon) {
		super();
		this.tentienich = tentienich;
		this.name = name;
		this.icon = icon;
	}

	public NhaHang getNhahang() {
		return nhahang;
	}

	public void setNhahang(NhaHang nhahang) {
		this.nhahang = nhahang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTentienich() {
		return tentienich;
	}

	public void setTentienich(String tentienich) {
		this.tentienich = tentienich;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
