package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.BaiViet;
import com.entity.BinhLuan;

@Transactional
@RequestMapping("Dashboard/BaiViet/")
@Controller
public class ArticleAdminController {
	@Autowired
	SessionFactory factory;

	// Đổ dữ liệu ra trang quản lý
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String trangquanly(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM BaiViet ORDER BY ngaytao DESC";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<BaiViet> list = query.list();
		model.addAttribute("baiviet", list);
		model.addAttribute("tenbreadcrumb", "QUẢN LÝ BÀI VIẾT");
		return "dashboard/quanlybaiviet";
	}
	// Xoá nhiều bài viết

	@RequestMapping(value = "deletemulti", method = RequestMethod.POST)
	public String deletemulti(ModelMap model, HttpServletRequest request) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			if (request.getParameterValues("idbaiviet") != null) {
				for (String idbv : request.getParameterValues("idbaiviet")) {
					int id = Integer.parseInt(idbv);
					
					BaiViet bv = (BaiViet) session.get(BaiViet.class, id);
					//Lấy list bình luận để xoá
					String hql = "FROM BinhLuan where idbaiviet =:idbaiviet";
					Query query = session.createQuery(hql);
					query.setParameter("idbaiviet", id);
					@SuppressWarnings("unchecked")
					List<BinhLuan> list = query.list();
					int idbl;
					if (list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							idbl = list.get(i).getIdbinhluan();
							BinhLuan bl = (BinhLuan) session.get(BinhLuan.class, idbl);
							session.delete(bl);
						}
					}
					session.delete(bv);
				}
				t.commit();
			}
			model.addAttribute("message", "Xoá thành công");
			return "redirect:/Dashboard/BaiViet/index.html";

		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Xóa thất bại !" + e.getMessage());
		} finally {
			session.close();
		}
		return "redirect:/Dashboard/BaiViet/index.html";

	}

	// Duyệt bài viết của quản trị
	@RequestMapping(value = "duyet/{id}")
	public String duyetbv(ModelMap model, @PathVariable("id") Integer id){
		Session session = factory.openSession();		
		BaiViet bv = (BaiViet) session.get(BaiViet.class, id);
		bv.setTrangthai(1);
		Transaction t = session.beginTransaction();
		try {			
			session.saveOrUpdate(bv);
			t.commit();				
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();			
		} finally {
			session.close();
		}		
		return "redirect:/Dashboard/BaiViet/index.html";
	}
	//Xem bài viết
	@RequestMapping(value = "xem/{id}")
	public String xem(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		BaiViet baiviet = (BaiViet) session.get(BaiViet.class, id);		
		model.addAttribute("bv", baiviet);
		return "chitietbaiviet";
	}
	// Xoá bài viết của quản trị
	@RequestMapping(value = "deletee/{id}") public String deleteBaivietquantri(ModelMap model,
			@PathVariable("id") Integer id) {
		Session session = factory.openSession();
		// Lấy bình luận để xoá
		BaiViet bv = (BaiViet) session.get(BaiViet.class, id);
		String hql = "FROM BinhLuan where idbaiviet =:idbaiviet";
		Query query = session.createQuery(hql);
		query.setParameter("idbaiviet", id);
		@SuppressWarnings("unchecked")
		List<BinhLuan> list = query.list();

		Transaction t = session.beginTransaction();
		try {
			int idbl;
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					idbl = list.get(i).getIdbinhluan();
					BinhLuan bl = (BinhLuan) session.get(BinhLuan.class, idbl);
					session.delete(bl);
				}
			}
			session.delete(bv);
			t.commit();
			model.addAttribute("message", "Xoá thành công");

		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa thất bại !" + e.getMessage());
		} finally {
			session.close();
		}
		return "redirect:/Dashboard/BaiViet/index.html";
	}
}
