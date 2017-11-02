package com.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.NguoiDung;
import com.entity.Trang;
@Transactional
@RequestMapping("trang/")
@Controller
public class TrangController {
	@Autowired
	SessionFactory factory;
	//Đổ dữ liệu ra trang quản lý
	@RequestMapping(value="index")
	public String trangquanly(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql ="FROM Trang ORDER BY ngaytao DESC";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Trang> list = query.list();
		model.addAttribute("trang",list);
		return "dashboard/quanlytrang";
	}
	//Xoá trang
	@RequestMapping(value="delete/{id}")
	public String DeleteUser(ModelMap model, @PathVariable("id") Integer id){
		Session session= factory.openSession();
		Trang trang = (Trang) session.get(Trang.class, id);
		Transaction t = session.beginTransaction();
		try {
			session.delete(trang);
			t.commit();
			model.addAttribute("message","Xoá thành công");
			
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa thất bại !" + e.getMessage());
		}finally {
			session.close();
		}
		return "redirect:/trang/index.html";
	}
	
	//Phương thức GET Để Tạo Giao Diện khi click button Thêm
	@RequestMapping(value="them",method = RequestMethod.GET)
	public String themTrang(ModelMap model) {
		model.addAttribute("tenbreadcrumb","THÊM TRANG MỚI");
		
		return "dashboard/themtrang";
	}
	@RequestMapping(value="themtrangmoi",method = RequestMethod.POST)
	public String themTrangMoi(ModelMap model,
			@RequestParam("tieude")String tieude,
			@RequestParam("title")String title,
			@RequestParam("noidung")String noidung,
			@RequestParam("content")String content,
			@RequestParam("slug")String slug,
//			@RequestParam("idnd")int idnd,
			HttpSession httpSession) {
			Session session = factory.openSession();
			//Khi đăng nhập thì chọn cái này
//			NguoiDung nd = new NguoiDung();
//			String hql= "FROM NguoiDung where id:=id";
//			Query query = session.createQuery(hql);
//			query.setParameter("id", idnd);
//			nd= (NguoiDung) query.uniqueResult();
			//Cái tạm thời
			NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, 1);
			Date ngaytao = new Date();
			Trang trang = new Trang(tieude, title, noidung, content, slug, ngaytao, nd);
			Transaction t = session.beginTransaction();
			try {
				session.save(trang);
				t.commit();
				return "redirect:/trang/index.html";
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();
				model.addAttribute("message", "Thêm trang thất bại!");
			}
			finally {
				session.close();
			}
			
		return "dashboard/themtrang";
	}
	//Tạo trang edit trang
	@RequestMapping(value="edit/{id}")
	public String editFormTrang(ModelMap model, @PathVariable("id") Integer id){
		Session session = factory.getCurrentSession();
		Trang trang = (Trang) session.get(Trang.class, id);
		model.addAttribute("trang",trang);
		
		return "dashboard/edittrang";
	}
}
