package com.dao;

import java.util.List;

import com.entity.BinhLuan;

public interface BinhLuanDAO {
	public void createBinhLuan(BinhLuan bl);

	public List<BinhLuan> getByIdBaiViet(int idbv, int trang, String sapxep, String paramsx, int idnho);

	public Long getSizeByIdBaiViet(int idbv);

	public void updateBinhLuan(BinhLuan bl);

	public List<BinhLuan> getByIdCha(int id);

	public BinhLuan getById(int id);

	public Integer getMaxByIdBaiViet(int idbv);
}
