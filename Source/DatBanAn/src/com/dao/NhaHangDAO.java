package com.dao;

import java.util.List;

import com.entity.NhaHang;

public interface NhaHangDAO {
public NhaHang getById(int id);
public List<NhaHang> getListByTenNhaHang(String tenNH);
}
