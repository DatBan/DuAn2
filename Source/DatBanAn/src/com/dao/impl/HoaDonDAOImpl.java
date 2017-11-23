package com.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HoaDonDAO;
import com.entity.HoaDon;

@Service
@Transactional
public class HoaDonDAOImpl implements HoaDonDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public List<HoaDon> getListByDateAndTenNhaHang(String idnh, Date ngaythang, String songuoi) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM HoaDon hd WHERE hd.nhahang.id =:idnh "
				+ "AND hd.ngaythang =:ngaythang AND hd.songuoi >=:songuoi");
		query.setParameter("idnh", Integer.parseInt(idnh));
		query.setParameter("ngaythang", ngaythang);
		query.setParameter("songuoi", Integer.parseInt(songuoi));
		
		@SuppressWarnings("unchecked")
		List<HoaDon> list = query.list();
		
		return list;
	}
	
	
}
