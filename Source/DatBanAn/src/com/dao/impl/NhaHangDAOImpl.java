package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	public List<NhaHang> getListByTenNhaHang(String tenNH) {
		Session session =factory.getCurrentSession();
		String hql = "FROM NhaHang nh WHERE nh.tennhahang LIKE :tnh";
		Query query = session.createQuery(hql);
		query.setParameter("tnh", "%"+tenNH+"%");
		
		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

	

}
