package com.dao;

import java.util.List;

import com.entity.Province;

public interface ProvinceDAO {
	public List<Province> getListAll();

	public Province getById(String provinceid);

	public List<Object[]> getByNhaHang();

	public void updateProvince(Province pv);

	public Province getByName(String provincename);

	public Province getBySlug(String provinceslug);
}
