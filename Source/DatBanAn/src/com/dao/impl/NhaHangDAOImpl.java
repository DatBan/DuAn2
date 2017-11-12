package com.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.NhaHangDAO;
import com.entity.NhaHang;

@Service
@Transactional
public class NhaHangDAOImpl implements NhaHangDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public NhaHang getById(int id) {
		Session session = factory.getCurrentSession();
		NhaHang nh = (NhaHang) session.get(NhaHang.class, id);
		return nh;
	}

	

}
