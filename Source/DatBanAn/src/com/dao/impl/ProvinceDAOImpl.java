package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProvinceDAO;
import com.entity.Province;

@Service
@Transactional
public class ProvinceDAOImpl implements ProvinceDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Province> getListAll() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM Province p ORDER BY type,name");
		@SuppressWarnings("unchecked")
		List<Province> list = query.list();

		return list;
	}

	@Override
	public Province getById(String provinceid) {
		Session session = factory.getCurrentSession();
		Province tinhthanh = (Province) session.get(Province.class, provinceid);
		return tinhthanh;
	}

	@Override
	public List<Province> getByNhaHang() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("SELECT nh.tinhthanh.provinceid, nh.tinhthanh.name, nh.tinhthanh.type"
				+ " FROM NhaHang nh GROUP BY nh.tinhthanh.provinceid");
		
		@SuppressWarnings("unchecked")
		List<Province> list = query.list();
		return list;
	}

}
