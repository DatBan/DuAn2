package com.dao;

import java.util.List;

import com.entity.Province;

public interface ProvinceDAO {
	public List<Province> getListAll();

	public Province getById(String provinceid);

	public List<Province> getByNhaHang();

	public void updateProvince(Province pv);
	
	public Province getByName(String provincename);
}
