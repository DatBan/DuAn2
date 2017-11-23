package com.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.entity.NhaHang;

public interface NhaHangDAO {
public NhaHang getById(int id);
public List<NhaHang> getListByTenNhaHang(String tenNH);
/*public Collection<Integer> getListId(String tenNH, Date ngaythang, String thoigian, String songuoi);*/
public List<NhaHang> getListByListID(Collection<Integer> id, int trang, String sapXep, String paramSX);
public List<NhaHang> getSumListByListID(Collection<Integer> id);
}
