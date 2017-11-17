package com.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dao.NhanDipDao;

@Service
public class NhanDipDAOImpl implements NhanDipDao{

	@Override
	public Map<String, String> getListNhanDip() {
		Map<String, String> nhanDip = new HashMap<>();
		nhanDip.put("Kỷ niệm", "kỷ niệm");
		nhanDip.put("Kỷ niệm 2", "kỷ niệm 2");
		return nhanDip;
	}

}
