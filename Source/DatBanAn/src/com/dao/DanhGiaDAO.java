package com.dao;

import java.util.List;

import com.entity.DanhGia;

public interface DanhGiaDAO {
public void createDanhGia(DanhGia dg);
public List<DanhGia> getListDanhGiaByIdNhaHang(int idNhaHang, int trang, int idnho, String sapXep, String paramSX);
public DanhGia getMaxByIdNhaHang(int idNhaHang);
public List<DanhGia> getListDanhGiaByIdNhaHang(int idNhaHang);
}
