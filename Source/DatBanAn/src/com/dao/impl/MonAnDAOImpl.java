package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MonAnDAO;
import com.entity.MonAn;

@Service
@Transactional
public class MonAnDAOImpl implements MonAnDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public List<MonAn> getListByTenmonan(String tenmonan) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM MonAn WHERE tenmonan LIKE :tenmonan OR name LIKE :tenmonan");
		query.setParameter("tenmonan", "%"+tenmonan+"%");
		@SuppressWarnings("unchecked")
		List<MonAn> list = query.list();
		return list;
	}

}
