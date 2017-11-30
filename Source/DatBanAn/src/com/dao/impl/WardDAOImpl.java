package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.WardDAO;
import com.entity.District;
import com.entity.Ward;

@Service
@Transactional
public class WardDAOImpl implements WardDAO{
@Autowired
private SessionFactory factory;
	@Override
	public List<Ward> getListByDistrictId(String districtid) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM Ward w WHERE w.districtid=:districtid ORDER BY type, name");
		query.setParameter("districtid", districtid);
		
		@SuppressWarnings("unchecked")
		List<Ward> list = query.list();
		return list;
	}
	@Override
	public Ward getById(String wardid) {
		Session session = factory.getCurrentSession();
		Ward phuongxa = (Ward) session.get(Ward.class, wardid);
		
		return phuongxa;
	}

}
