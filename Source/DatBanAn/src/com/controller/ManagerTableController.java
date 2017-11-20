package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.BanAn;
import com.entity.KhuyenMai;
import com.entity.NguoiDung;
import com.entity.NhaHang;

@Transactional
@RequestMapping("nhahang/ban/")
@Controller
public class ManagerTableController {
	@Autowired
	SessionFactory factory;

	// Đổ dữ liệu ra trang quản lý
	@RequestMapping(value = "index")
	public String quanLyBan(ModelMap model,HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		String hql = "FROM BanAn where idnhahang =:idnhahang";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);
		@SuppressWarnings("unchecked")
		List<BanAn> list = query.list();
		model.addAttribute("ban", list);
		model.addAttribute("tenbreadcrumb", "QUẢN LÝ BÀN");
		return "nhahang/quanlyban";
	}

	// Phương thức GET để tạo giao diện khi click button Thêm
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model) {
		model.addAttribute("tenbreadcrumb", "THÊM BÀN");
		return "nhahang/themban";
	}
	// Thêm bàn

	@Autowired
	ServletContext context;

	@RequestMapping(value = "themban", method = RequestMethod.POST)
	public String themBan(ModelMap model, @RequestParam("soban") int soban, @RequestParam("songuoi") int songuoi,
			HttpSession httpSession) {
		Session session = factory.openSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		Transaction t = session.beginTransaction();

		try {

			BanAn ban = new BanAn(soban, songuoi, false, nhahang);
			session.save(ban);
			t.commit();

			return "redirect:/nhahang/ban/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			System.out.println(e.toString());
			model.addAttribute("message", "Thêm bàn thất bại!");
		} finally {
			session.close();
		}
		return "nhahang/themban";
	}

	// Tạo giao diện edit
	@RequestMapping(value = "edit/{id}")
	public String editForm(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		BanAn ban = (BanAn) session.get(BanAn.class, id);
		model.addAttribute("ban", ban);
		model.addAttribute("tenbreadcrumb", "SỬA BÀN");
		return "nhahang/suaban";
	}

	// Sửa bàn
	@RequestMapping(value = "suaban", method = RequestMethod.POST)
	public String suaAmThuc(ModelMap model, RedirectAttributes re, @RequestParam("idban") int id,
			@RequestParam("soban") int soban, @RequestParam("songuoi") int songuoi, HttpSession httpSession) {
		Session session = factory.openSession();
		BanAn ban = (BanAn) session.get(BanAn.class, id);
		ban.setSoban(soban);
		ban.setSonguoi(songuoi);
		Transaction t = session.beginTransaction();
		try {
			session.update(ban);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa thành công !");
			return "redirect:/nhahang/ban/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();

		} finally {
			session.close();
		}
		return "redirect:/nhahang/ban/edit/" + id + ".html";
	}

	// Kiểm tra trùng số bàn
	@RequestMapping(value = "kt-trung-soban", method = RequestMethod.GET)
	public @ResponseBody String ktTrungChude(@RequestParam("soban") int soban, @RequestParam("idban") int id,
			HttpServletResponse response, HttpServletRequest request,HttpSession httpSession) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int idnhahang = nhahang.getId();
		String hql = "FROM BanAn where soban =:soban and idnhahang =:idnhahang";
		Query query = session.createQuery(hql);
		query.setParameter("soban", soban);
		query.setParameter("idnhahang", idnhahang);
		BanAn sb = (BanAn) query.uniqueResult();
		if (sb != null) {
			if (sb.getId() == id) {
				return "true";
			}
			return "false";
		} else {
			return "true";
		}
	}
}
