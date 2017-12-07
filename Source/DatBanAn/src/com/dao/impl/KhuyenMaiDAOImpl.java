package com.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.KhuyenMaiDAO;
import com.entity.KhuyenMai;

@Service
@Transactional
public class KhuyenMaiDAOImpl implements KhuyenMaiDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public void deleteByIdNhaHang(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Integer> getByIdNhaHang() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(
				"SELECT km.nhahang.id FROM KhuyenMai km WHERE km.trangthai=:trangthai GROUP BY km.nhahang.id");
		query.setParameter("trangthai", true);

		@SuppressWarnings("unchecked")
		Collection<Integer> idnh = query.list();
		idnh.add(0);
		System.out.println("lidnh " + idnh);
		return idnh;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KhuyenMai> getByIdNhaHang(int idnh) {
		Session session = factory.getCurrentSession();
		List<KhuyenMai> list = null;
		try {
			String hql = "FROM KhuyenMai km where trangthai='1' and idnhahang =:idnhahang ";
			Query query = session.createQuery(hql);

			query.setParameter("idnhahang", idnh);
			list = query.list();
		} catch (Exception e) {
			System.out.println("LOI " + e.toString() + " KhuyenMaiDAOImpl.getByIdNhaHang()");
			e.printStackTrace();
		}
		return list;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KhuyenMai> getByProvinceSlug(String slug) {
		Session session = factory.getCurrentSession();
		List<KhuyenMai> list = null;
		try {
			String hql = "FROM KhuyenMai km WHERE km.nhahang.tinhthanh.slug=:slug AND km.trangthai='1' GROUP BY km.nhahang.id ";
			Query query = session.createQuery(hql);

			query.setParameter("slug", slug);
			list = query.list();
		} catch (Exception e) {
			System.out.println("LOI " + e.toString() + " KhuyenMaiDAOImpl.getByIdNhaHang()");
			e.printStackTrace();
		}
		return list;
	}

}
