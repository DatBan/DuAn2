package com.dao;

import java.util.List;

import com.entity.Ward;

public interface WardDAO {
public List<Ward> getListByDistrictId(String districtid);
public Ward getById(String wardid);
}
