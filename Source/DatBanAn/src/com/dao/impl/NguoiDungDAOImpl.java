package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.NguoiDungDAO;
import com.entity.NguoiDung;

@Service
@Transactional
public class NguoiDungDAOImpl implements NguoiDungDAO {
	@Autowired
	private SessionFactory factory;

	@Override
	public NguoiDung getByUsername(String username) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung WHERE tendangnhap=:tdn");
		query.setParameter("tdn", username);
		NguoiDung nd = (NguoiDung) query.uniqueResult();

		return nd;
	}

	@Override
	public NguoiDung getByIdFacebook(String idfb) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung WHERE idfacebook=:idfb");
		query.setParameter("idfb", idfb);
		NguoiDung nd = (NguoiDung) query.uniqueResult();
		return nd;
	}

	@Override
	public NguoiDung getByIdGoogle(String idgg) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung WHERE idgoogle=:idgg");
		query.setParameter("idgg", idgg);
		NguoiDung nd = (NguoiDung) query.uniqueResult();
		return nd;
	}

	@Override
	public void createUser(NguoiDung nd) {
		Session session = factory.getCurrentSession();
		/*Transaction t = session.beginTransaction();*/
		try {
			session.save(nd);
			/*t.commit();*/
			System.out.println("Success!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("LOI "+e.toString()+" NguoiDungDAOImpl.createUser()");
			e.printStackTrace();
			/*t.rollback();*/
		} /*finally {
			session.close();
		}*/

	}

	@Override
	public void updateUser(NguoiDung nd) {
		Session session = factory.getCurrentSession();
		/* Transaction t = session.beginTransaction(); */
		try {
			session.update(nd);
			/* t.commit(); */
			System.out.println("Saved!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			/* t.rollback(); */
		} /*
			 * finally { session.close(); }
			 */
	}

	@Override
	public List<NguoiDung> getListByTrangThai(int trangthai) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung nd WHERE nd.trangthai=:tt ORDER BY nd.id DESC");
		query.setParameter("tt", trangthai);

		@SuppressWarnings("unchecked")
		List<NguoiDung> nd = query.list();
		return nd;
	}

	@Override
	public NguoiDung getByTrangThaiAndId(int trangthai, int id) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung nd WHERE nd.id=:id AND nd.trangthai=:tthai");
		query.setParameter("tthai", trangthai);
		query.setParameter("id", id);
		NguoiDung nd = null;
		try {
			nd = (NguoiDung) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nd;
	}

	@Override
	public List<NguoiDung> getListByIdQuyen(int idq) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung nd WHERE nd.quyennd.id=:idq");
		query.setParameter("idq", idq);
		@SuppressWarnings("unchecked")
		List<NguoiDung> nd = query.list();
		return nd;
	}

	@Override
	public void deleteUser(NguoiDung nd) {
		// TODO Auto-generated method stub

	}

	@Override
	public NguoiDung getByEmail(String email) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung nd WHERE nd.email=:email");
		query.setParameter("email", email);

		NguoiDung nd = (NguoiDung) query.uniqueResult();
		return nd;
	}

	@Override
	public List<NguoiDung> getListByIdNhaHangNull() {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung nd WHERE nd.trangthai = 1 AND nd.quyennd.id !=:ten AND nd.nhahang.id IS NULL ");
		query.setParameter("ten", 1);
		@SuppressWarnings("unchecked")
		List<NguoiDung> list = query.list();
		return list;
	}

	@Override
	public List<NguoiDung> getListByIdQuyenAndIdNhaHang(int quyenid, int idnhahang) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("FROM NguoiDung nd WHERE nd.trangthai = 1 AND nd.quyennd.id != 1 AND "
				+ "nd.nhahang.id IS NULL OR (nd.quyennd.id =:quyen AND nd.nhahang.id=:idnhahang)");
		query.setParameter("quyen", quyenid);
		query.setParameter("idnhahang", idnhahang);
		
		@SuppressWarnings("unchecked")
		List<NguoiDung> list = query.list();
		return list;
	}

	@Override
	public NguoiDung getById(int id) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, id);
		return nd;
	}

}
