package com.dao;

import java.util.List;

import com.entity.District;

public interface DistrictDAO {
public List<District> getListByProvinceId(String provinceid);
public District getById(String districtid);
}
