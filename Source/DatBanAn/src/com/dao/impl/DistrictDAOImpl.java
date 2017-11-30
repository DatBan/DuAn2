package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DistrictDAO;
import com.entity.District;
import com.entity.Province;

@Service
@Transactional
public class DistrictDAOImpl implements DistrictDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public List<District> getListByProvinceId(String provinceid) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM District d WHERE d.provinceid=:provinceid ORDER BY type, name");
		query.setParameter("provinceid", provinceid);

		@SuppressWarnings("unchecked")
		List<District> list = query.list();

		return list;
	}

	@Override
	public District getById(String districtid) {
		Session session = factory.getCurrentSession();
		District quanhuyen = (District) session.get(District.class, districtid);
		
		return quanhuyen;
	}

}
