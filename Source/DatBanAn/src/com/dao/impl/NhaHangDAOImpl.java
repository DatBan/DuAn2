package com.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public NhaHang getById(int id) {
		Session session = factory.getCurrentSession();
		/* NhaHang nh = (NhaHang) session.get(NhaHang.class, id); */
		Query query = session.createQuery("FROM NhaHang nh WHERE nh.id=:id");
		query.setParameter("id", id);
		NhaHang nh = (NhaHang) query.uniqueResult();
		return nh;
	}

	@Override
	public List<NhaHang> getListByTenNhaHang(String tenNH, String provinceslug) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhaHang nh WHERE nh.tennhahang LIKE :tnh AND nh.trangthai=:trangthai AND nh.tinhthanh.slug=:provinceslug";
		Query query = session.createQuery(hql);
		query.setParameter("tnh", "%" + tenNH + "%");
		query.setParameter("trangthai", 1);
		query.setParameter("provinceslug", provinceslug);

		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

	@Override
	public List<NhaHang> getListByListID(Collection<Integer> id, int trang, String sapXep, String paramSX) {
		Session session = factory.getCurrentSession();
		int /* pageCount = 0, sumRecords = 0, */ perPage = 8;
		String hql = "FROM NhaHang nh WHERE nh.id IN (:lid) ORDER BY " + paramSX + " " + sapXep;
		Query query = session.createQuery(hql);
		query.setParameterList("lid", id);

		query.setFirstResult(perPage * (trang - 1));
		query.setMaxResults(perPage);

		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

	@Override
	public List<NhaHang> getSumListByListID(Collection<Integer> id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhaHang nh WHERE nh.id IN (:lid) ";
		Query query = session.createQuery(hql);
		query.setParameterList("lid", id);

		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

	@Override
	public void createNhaHang(NhaHang nh) {
		Session session = factory.getCurrentSession();
		/* Transaction tx = session.beginTransaction(); */
		try {
			session.save(nh);
			/* tx.commit(); */
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("LOI " + e.toString() + " NhaHangDAO.createNhaHang()");
			e.printStackTrace();
			/* tx.rollback(); */
		} /*
			 * finally { session.close(); }
			 */
	}

	@Override
	public List<NhaHang> getListByTrangThai(int trangthai) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NhaHang nh WHERE trangthai=:trangthai ORDER BY nh.id desc");
		query.setParameter("trangthai", trangthai);
		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

	@Override
	public void updateNhaHang(NhaHang nh) {
		Session session = factory.getCurrentSession();
		try {
			/* tx = session.beginTransaction(); */
			session.update(nh);
			/* tx.commit(); */
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("LOI " + e.toString() + " NhaHangDAO.updateNhaHang()");
			e.printStackTrace();
			/* tx.rollback(); */
		} /*
			 * finally { session.close(); }
			 */
	}

	@Override
	public void deleteNhaHang(NhaHang nh) {
		Session session = factory.getCurrentSession();
		/* Transaction tx = session.beginTransaction(); */
		try {
			session.delete(nh);
			/* tx.commit(); */
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("LOI " + e.toString() + " NhaHangDAO.deleteNhaHang()");
			e.printStackTrace();
			/* tx.rollback(); */
		} /*
			 * finally { session.close(); }
			 */
	}

	@Override
	public List<NhaHang> getListByProvinceSlug(String provinceslug) {
		Session session = factory.getCurrentSession();
		Query query = session
				.createQuery("FROM NhaHang nh WHERE nh.tinhthanh.slug=:provinceslug AND nh.trangthai=:trangthai "
						+ "ORDER BY nh.countinvoice DESC");
		query.setParameter("provinceslug", provinceslug);
		query.setParameter("trangthai", 1);

		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

	@Override
	public List<NhaHang> getListByPromotion(Collection<Integer> listid, String provinceslug) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(
				"FROM NhaHang nh WHERE nh.tinhthanh.slug=:provinceslug AND nh.id IN (:listid) AND nh.trangthai=:trangthai");
		query.setParameter("trangthai", 1);
		query.setParameter("provinceslug", provinceslug);
		query.setParameterList("listid", listid);

		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		System.out.println("list nh " + list.size());
		return list;
	}

	@Override
	public List<NhaHang> getListByProvinceId(String provinceid, int idhientai) {
		Session session = factory.getCurrentSession();
		Query query = session
				.createQuery("FROM NhaHang nh WHERE nh.tinhthanh.provinceid=:provinceid AND nh.id !=:idhientai AND nh.trangthai=:trangthai "
						+ "ORDER BY nh.countinvoice DESC");
		query.setParameter("provinceid", provinceid);
		query.setParameter("idhientai", idhientai);
		query.setParameter("trangthai", 1);

		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

	@Override
	public List<NhaHang> getListByMostRating(String provinceslug) {
		Session session = factory.getCurrentSession();
		Query query = session
				.createQuery("FROM NhaHang nh WHERE nh.tinhthanh.slug=:provinceslug AND nh.trangthai=:trangthai "
						+ "ORDER BY nh.sumRating DESC");
		query.setParameter("provinceslug", provinceslug);
		query.setParameter("trangthai", 1);

		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

}
