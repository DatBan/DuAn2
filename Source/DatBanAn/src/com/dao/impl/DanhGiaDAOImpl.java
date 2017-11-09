package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DanhGiaDAO;
import com.entity.DanhGia;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

@Service
@Transactional
public class DanhGiaDAOImpl implements DanhGiaDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public void createDanhGia(DanhGia dg) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(dg);
			t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public List<DanhGia> getListDanhGiaByIdNhaHang(int idNhaHang, int trang, int idnho) {
		Session session = factory.getCurrentSession();
		int pageCount = 0, sumRecords = 0, perPage = 10;
		String hql = "FROM DanhGia dg WHERE dg.nhahang.id=:idnhahang AND dg.id <=:idnho ORDER BY id desc";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", idNhaHang);
		query.setParameter("idnho", idnho);
		query.setFirstResult(perPage * (trang - 1));
		query.setMaxResults(perPage);
		
		@SuppressWarnings("unchecked")
		List<DanhGia> list = query.list();
		sumRecords = list.size();
		pageCount = sumRecords / perPage + (sumRecords % perPage > 0 ? 1 : 0);
		return list;
	}

	@Override
	public DanhGia getMaxByIdNhaHang(int idNhaHang) {
		Session session = factory.getCurrentSession();
		String hql = "FROM DanhGia dg WHERE dg.nhahang.id=:idnhahang ORDER BY id desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		query.setParameter("idnhahang", idNhaHang);
		
		DanhGia dg = (DanhGia) query.uniqueResult();
		return dg;
	}

	@Override
	public List<DanhGia> getListDanhGiaByIdNhaHang(int idNhaHang) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM DanhGia dg WHERE dg.nhahang.id=:idnh");
		query.setParameter("idnh", idNhaHang);
		@SuppressWarnings("unchecked")
		List<DanhGia> list = query.list();
		return list;
	}

}
