package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BinhLuanDAO;
import com.entity.BinhLuan;

@Service
@Transactional
public class BinhLuanDAOImpl implements BinhLuanDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public void createBinhLuan(BinhLuan bl) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bl);
		} catch (Exception e) {
			System.out.println("LOI " + e.toString() + " BinhLuanDAOImpl.createBinhLuan()");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BinhLuan> getByIdBaiViet(int idbv, int trang, String sapxep, String paramsx, int idnho) {
		Session session = factory.getCurrentSession();
		int /* pageCount = 0, sumRecords = 0, */ perPage = 10;
		List<BinhLuan> list = null;
		try {
			Query query = session.createQuery(
					"FROM BinhLuan bl WHERE bl.trangthai=:trangthai AND bl.id <= :idnho AND bl.baivietbl.id=:idbv AND bl.traloi.id IS NULL ORDER BY "
							+ paramsx + " " + sapxep);
			query.setParameter("trangthai", 1);
			query.setParameter("idnho", idnho);
			query.setParameter("idbv", idbv);

			query.setFirstResult(perPage * (trang - 1));
			query.setMaxResults(perPage);

			list = query.list();
		} catch (Exception e) {
			System.out.println("LOI " + e.toString() + " BinhLuanDAOImpl.getByIdBaiViet()");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Long getSizeByIdBaiViet(int idbv) {
		Session session = factory.getCurrentSession();
		int /* pageCount = 0, sumRecords = 0, */ perPage = 10;
		Long sizeBL = (long) 0;
		try {
			Query query = session.createQuery(
					"SELECT COUNT(bl.id) FROM BinhLuan bl WHERE bl.trangthai=:trangthai AND bl.baivietbl.id=:idbv AND bl.traloi.id IS NULL");
			query.setParameter("trangthai", 1);
			query.setParameter("idbv", idbv);

			sizeBL = (Long) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("LOI " + e.toString() + " BinhLuanDAOImpl.getSizeByIdBaiViet()");
			e.printStackTrace();
		}
		return sizeBL;
	}

	@Override
	public void updateBinhLuan(BinhLuan bl) {
		Session session = factory.getCurrentSession();
		try {
			session.update(bl);
		} catch (Exception e) {
			System.out.println("LOI " + e.toString() + " BinhLuanDAOImpl.updateBinhLuan()");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BinhLuan> getByIdCha(int id) {
		Session session = factory.getCurrentSession();
		List<BinhLuan> bl = null;
		try {
			Query query = session.createQuery(
					"FROM BinhLuan bl WHERE bl.trangthai=:trangthai AND bl.traloi.id=:idbl ORDER BY bl.id ASC");
			query.setParameter("trangthai", 1);
			query.setParameter("idbl", id);

			bl = query.list();
		} catch (Exception e) {
			System.out.println("LOsI " + e.toString() + " BinhLuanDAOImpl.getByIdCha()");
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public BinhLuan getById(int id) {
		Session session = factory.getCurrentSession();
		BinhLuan bl = null;
		try {
			Query query = session.createQuery("FROM BinhLuan bl WHERE bl.trangthai=:trangthai AND bl.id=:idbl");
			query.setParameter("trangthai", 1);
			query.setParameter("idbl", id);

			bl = (BinhLuan) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("LOsI " + e.toString() + " BinhLuanDAOImpl.getById()");
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public Integer getMaxByIdBaiViet(int idbv) {
		Session session = factory.getCurrentSession();
		int maxId = 0;
		try {
			Query query = session.createQuery(
					"SELECT MAX(bl.id) FROM BinhLuan bl WHERE bl.trangthai=:trangthai AND bl.baivietbl.id=:idbv AND bl.traloi.id IS NULL ORDER BY bl.id DESC");
			query.setParameter("trangthai", 1);
			query.setParameter("idbv", idbv);

			maxId = (Integer) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("LOI " + e.toString() + " BinhLuanDAOImpl.getMaxByIdBaiViet()");
			e.printStackTrace();
		}
		return maxId;
	}

	@Override
	public void deleteBinhLuan(BinhLuan bl) {
		Session session = factory.getCurrentSession();
		try {
			session.delete(bl);
		} catch (Exception e) {
			System.out.println("LOI " + e.toString() + " BinhLuanDAOImpl.deleteBinhLuan()");
			e.printStackTrace();
		}
	}

}
