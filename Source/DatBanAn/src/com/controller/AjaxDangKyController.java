package com.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.NguoiDung;

@Service
@Transactional
public class AjaxDangKyController {
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public NguoiDung GetNguoiDung(String ggid) {
		Session session = this.factory.getCurrentSession();
		NguoiDung nd = null;
		String hql = "FROM NguoiDung WHERE idgoogle=:ggid";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("ggid", ggid);
			nd = (NguoiDung) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi " + e.toString());
		}

		return nd;
	}
}
