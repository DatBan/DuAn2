package com.dao;

import java.util.List;

import com.entity.LoaiAmThuc;

public interface LoaiAmThucDAO {
public List<LoaiAmThuc> getListAll();
public LoaiAmThuc getById(int idloaiamthuc);
}
