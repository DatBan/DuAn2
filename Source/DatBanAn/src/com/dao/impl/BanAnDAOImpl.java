package com.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BanAnDAO;
import com.entity.BanAn;

@Service
@Transactional
public class BanAnDAOImpl implements BanAnDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public List<BanAn> getListByTrangThaiTrong() {
		Session session = factory.getCurrentSession();
		String hql = "FROM BanAn where trangthai=0";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BanAn> list = query.list();
		return list;
	}

	@Override
	public List<BanAn> getListBySoNguoiAndTenNhaHang(String songuoi, String tennh) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(
				"FROM BanAn b WHERE b.songuoi >=:songuoi AND b.nhahang.tennhahang LIKE :tennh GROUP BY b.nhahang.id");
		query.setParameter("songuoi", Integer.parseInt(songuoi));
		query.setParameter("tennh", "%" + tennh + "%");

		@SuppressWarnings("unchecked")
		List<BanAn> list = query.list();
		return list;
	}

	@Override
	public List<BanAn> getListBySoNguoiAndIdNhaHang(String songuoi, String idnh) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM BanAn b WHERE b.songuoi >=:songuoi AND b.nhahang.id =:idnh");
		query.setParameter("songuoi", Integer.parseInt(songuoi));
		query.setParameter("idnh", Integer.parseInt(idnh));

		@SuppressWarnings("unchecked")
		List<BanAn> list = query.list();
		return list;
	}

	@Override
	public void deleteByIdNhaHang(int id) {
		Session session = factory.getCurrentSession();
		/*Transaction t = session.beginTransaction();*/
		try {
			String hql = "DELETE BanAn ba WHERE ba.nhahang.id=:id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			query.executeUpdate();
			/*t.commit();*/
		} catch (Exception e) {
			System.out.println("LOI "+e.toString()+" BanAnDAOImpl.deleteByIdNhaHang()");
			e.printStackTrace();
			/*t.rollback();*/
		}
	}

}
