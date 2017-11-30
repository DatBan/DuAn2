package com.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.KhuyenMaiDAO;
@Service
@Transactional
public class KhuyenMaiDAOImpl implements KhuyenMaiDAO{
	@Autowired
	private SessionFactory factory;
	@Override
	public void deleteByIdNhaHang(int id) {
		// TODO Auto-generated method stub
		
	}

}
