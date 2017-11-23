package com.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

	@Override
	public NhaHang getById(int id) {
		Session session = factory.getCurrentSession();
		NhaHang nh = (NhaHang) session.get(NhaHang.class, id);
		return nh;
	}

	@Override
	public List<NhaHang> getListByTenNhaHang(String tenNH) {
		Session session =factory.getCurrentSession();
		String hql = "FROM NhaHang nh WHERE nh.tennhahang LIKE :tnh";
		Query query = session.createQuery(hql);
		query.setParameter("tnh", "%"+tenNH+"%");
		
		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list;
	}

	/*@Override
	public Collection<Integer> getListId(String tenNH, Date ngaythang, String thoigian, String songuoi) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NhaHang as T1 LEFT JOIN T1.listbanan as T2 LEFT JOIN T2.listhd as T3";
		String hql = "(SELECT id FROM ( "+ 
			"SELECT t1.id, t2.ngaythang, t2.thoigian, t2.songuoi as songuoi_hd, t3.songuoi "+
			"FROM NhaHang t1 "+
				"LEFT JOIN HoaDon t2 ON t1.id = t2.idnhahang "+
				"LEFT JOIN BanAn t3 ON t1.id = t3.idnhahang "+
			"WHERE t1.tennhahang LIKE '%"+tenNH+"%' "+
			"UNION ALL "+
			"SELECT t1.id, t2.ngaythang, t2.thoigian, t2.songuoi as songuoi_hd, t3.songuoi "+
			"FROM HoaDon t2 "+
				"LEFT JOIN NhaHang t1 ON t1.id = t2.idnhahang "+
				"LEFT JOIN BanAn t3 ON t2.idban = t3.id "+
			"WHERE t1.id IS NULL "+
			"UNION ALL "+
			"SELECT t1.id, t2.ngaythang, t2.thoigian, t2.songuoi as songuoi_hd, t3.songuoi "+
			"FROM BanAn t3 "+
				"LEFT JOIN NhaHang t1 ON t1.id = t3.idnhahang "+
				"LEFT JOIN HoaDon t2 ON t2.idban = t3.id "+
			"WHERE t1.id IS NULL AND t2.idnhahang IS NULL) as joinsesa "+
			"WHERE (ngaythang != '"+ngaythang+"' OR (ngaythang IS NULL) AND thoigian != '"+thoigian+"' OR (thoigian IS NULL) AND songuoi_hd != '"+songuoi+"' OR (songuoi_hd IS NULL) AND songuoi >= '"+songuoi+"') "+
			"GROUP BY id)";
		Query query = session.createSQLQuery(hql);
		@SuppressWarnings("unchecked")
		
		List<Integer> list = query.list();
		
		Collection<Integer> idl = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+" sadsadsa");
			idl.add(list.get(i));
		}
		System.out.println(list);
		System.out.println(idl + " ");
		return idl;
	}*/

	@Override
	public List<NhaHang> getListByListID(Collection<Integer> id, int trang, String sapXep, String paramSX) {	
		Session session =factory.getCurrentSession();
		int /*pageCount = 0, sumRecords = 0,*/ perPage = 2;
		String hql = "FROM NhaHang nh WHERE nh.id IN (:lid) ORDER BY "+paramSX+" "+sapXep;
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
		Session session =factory.getCurrentSession();
		String hql = "FROM NhaHang nh WHERE nh.id IN (:lid) ";
		Query query = session.createQuery(hql);
		query.setParameterList("lid", id);
		
		@SuppressWarnings("unchecked")
		List<NhaHang> list = query.list();
		return list; 
	}

	

}
