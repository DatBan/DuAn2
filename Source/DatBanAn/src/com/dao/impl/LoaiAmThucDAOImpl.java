package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LoaiAmThucDAO;
import com.entity.LoaiAmThuc;

@Service
@Transactional
public class LoaiAmThucDAOImpl implements LoaiAmThucDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public List<LoaiAmThuc> getListAll() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM LoaiAmThuc");

		@SuppressWarnings("unchecked")
		List<LoaiAmThuc> list = query.list();

		return list;
	}

	@Override
	public LoaiAmThuc getById(int idloaiamthuc) {
		Session session = factory.getCurrentSession();
		LoaiAmThuc loaiamthuc = (LoaiAmThuc) session.get(LoaiAmThuc.class, idloaiamthuc);
		return loaiamthuc;
	}

}
