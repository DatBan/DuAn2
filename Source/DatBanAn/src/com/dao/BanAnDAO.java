package com.dao;

import java.util.List;

import com.entity.BanAn;

public interface BanAnDAO {
public List<BanAn> getListByTrangThaiTrong();
public List<BanAn> getListBySoNguoiAndTenNhaHang(String songuoi, String tennh);
public List<BanAn> getListBySoNguoiAndIdNhaHang(String songuoi, String idnh);
}
