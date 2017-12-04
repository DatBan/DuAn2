package com.dao.impl;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
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
	@Override
	public Collection<Integer> getByIdNhaHang() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("SELECT km.nhahang.id FROM KhuyenMai km WHERE km.trangthai=:trangthai GROUP BY km.nhahang.id");
		query.setParameter("trangthai", true);
		
		@SuppressWarnings("unchecked")
		Collection<Integer> idnh = query.list();
		idnh.add(0);
		System.out.println("lidnh "+idnh);
		return idnh;
	}

}
