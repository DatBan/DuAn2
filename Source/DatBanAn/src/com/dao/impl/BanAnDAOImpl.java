package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BanAnDAO;
import com.entity.BanAn;

@Service
public class BanAnDAOImpl implements BanAnDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public List<BanAn> getListByTrangThaiTrong() {
		Session session =factory.getCurrentSession();
		String hql ="FROM BanAn where trangthai=0";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BanAn> list = query.list();		
		return list;
	}
	
}
