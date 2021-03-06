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
import com.entity.TienIch;

@Transactional
@RequestMapping("nhahang/ban/")
@Controller
public class ManagerTableController {
	@Autowired
	SessionFactory factory;

	// Do du lieu
	@RequestMapping(value = "index")
	public String quanLyBan(ModelMap model,HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		String hql = "FROM BanAn where nhahang.id =:idnhahang and (trangthai=0 or trangthai=1)";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);
		@SuppressWarnings("unchecked")
		List<BanAn> list = query.list();
		model.addAttribute("ban", list);
		
		model.addAttribute("btn_add","nhahang/ban/them.html");
		model.addAttribute("tenbreadcrumb", "Quản lý bàn ăn");
		return "nhahang/banan/quanlyban";
	}

	// Tao giao dien them
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model) {
		
		model.addAttribute("btn_back","nhahang/ban/index.html");
		model.addAttribute("tenbreadcrumb", "Thêm mới bàn ăn");
		model.addAttribute("tenbreadcrumb2", "Quản lý bàn ăn");
		model.addAttribute("urlbreadcrumb2", "nhahang/ban/index.html");
		return "nhahang/banan/themban";
	}
	// Them ban

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

			BanAn ban = new BanAn(soban, songuoi, 0, nhahang);
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
		return "nhahang/banan/themban";
	}
	// Xoa ban
		@RequestMapping(value = "delete/{id}")
		public String deleteTienIch(ModelMap model,RedirectAttributes re, @PathVariable("id") Integer id) {
			Session session = factory.openSession();
			BanAn ban = (BanAn) session.get(BanAn.class, id);
			System.out.println(id);
			if(ban.getTrangthai()==1){
				
				re.addFlashAttribute("message", "Bàn đang sử dụng không thể xoá!");
				return "redirect:/nhahang/ban/index.html";
			}else{
				
				ban.setTrangthai(2);
			}
			
			Transaction t = session.beginTransaction();
			try {

				session.update(ban);
				t.commit();
				model.addAttribute("message", "Xoa thanh cong");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				t.rollback();
				model.addAttribute("message", "Xoá thất bại!" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/nhahang/ban/index.html";
		}
	// Tao giao dien edit
	@RequestMapping(value = "edit/{id}")
	public String editForm(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		BanAn ban = (BanAn) session.get(BanAn.class, id);
		model.addAttribute("ban", ban);
		
		model.addAttribute("btn_back","nhahang/ban/index.html");
		model.addAttribute("tenbreadcrumb", "Sửa thông tin bàn ăn");
		model.addAttribute("tenbreadcrumb2", "Quản lý bàn ăn");
		model.addAttribute("urlbreadcrumb2", "nhahang/ban/index.html");
		return "nhahang/banan/suaban";
	}

	// Sua ban
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
			model.addAttribute("message", "Chỉnh sửa thành công!");
			return "redirect:/nhahang/ban/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();

		} finally {
			session.close();
		}
		return "redirect:/nhahang/ban/edit/" + id + ".html";
	}

	// kiem tra trung so san
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
