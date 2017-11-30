package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.QuyenDAO;
import com.entity.Quyen;

@Service
@Transactional
public class QuyenDAOImpl implements QuyenDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Quyen> getListAllQuyen() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Quyen";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Quyen> list = query.list();

		return list;
	}

	@Override
	public Quyen getById(int quyenid) {
		Session session = factory.getCurrentSession();
		Quyen quyen = (Quyen) session.get(Quyen.class, quyenid);
		return quyen;
	}

}
