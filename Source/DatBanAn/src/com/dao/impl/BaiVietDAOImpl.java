package com.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BaiVietDAO;
import com.entity.BaiViet;

@Service
@Transactional
public class BaiVietDAOImpl implements BaiVietDAO{
	@Autowired
	private SessionFactory factory;
	
	@Override
	public BaiViet getById(int id) {
		Session session = factory.getCurrentSession();
		BaiViet bv = (BaiViet) session.get(BaiViet.class, id);
		return bv;
	}

}
