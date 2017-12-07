package com.dao;

import java.util.Collection;
import java.util.List;

import com.entity.KhuyenMai;

public interface KhuyenMaiDAO {
	public void deleteByIdNhaHang(int id);

	public Collection<Integer> getByIdNhaHang();

	public List<KhuyenMai> getByIdNhaHang(int idnh);
	
	public List<KhuyenMai> getByProvinceSlug(String slug);
}