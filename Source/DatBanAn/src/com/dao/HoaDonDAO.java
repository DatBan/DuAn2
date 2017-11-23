package com.dao;

import java.util.Date;
import java.util.List;

import com.entity.HoaDon;

public interface HoaDonDAO {
public List<HoaDon> getListByDateAndTenNhaHang(String idnh, Date ngaythang, String songuoi);
}
