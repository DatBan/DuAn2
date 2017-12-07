package com.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.entity.NhaHang;

public interface NhaHangDAO {
	public NhaHang getById(int id);

	public List<NhaHang> getListByTenNhaHang(String tenNH, String provinceslug);

	public List<NhaHang> getListByListID(Collection<Integer> id, int trang, String sapXep, String paramSX);

	public List<NhaHang> getSumListByListID(Collection<Integer> id);

	public void createNhaHang(NhaHang nh);

	public List<NhaHang> getListByTrangThai(int trangthai);

	public void updateNhaHang(NhaHang nh);

	public void deleteNhaHang(NhaHang nh);

	public List<NhaHang> getListByProvinceSlug(String provinceslug);

	public List<NhaHang> getListByPromotion(Collection<Integer> listid, String provinceid);

	public List<NhaHang> getListByProvinceId(String provinceid, int idhientai);
	
	public List<NhaHang> getListByMostRating(String provinceslug);
}
