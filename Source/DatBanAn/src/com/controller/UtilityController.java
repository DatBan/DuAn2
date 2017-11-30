package com.controller;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.MonAn;
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.entity.TienIch;

@Transactional
@RequestMapping("nhahang/tienich/")
@Controller
public class UtilityController {
	@Autowired
	SessionFactory factory;

	// Ä�á»• dá»¯ liá»‡u ra trang quáº£n lÃ½
	@RequestMapping(value = "index")
	public String quanlytienich(ModelMap model,HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		String hql = "FROM TienIch where idnhahang =:idnhahang";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);
		@SuppressWarnings("unchecked")
		List<TienIch> list = query.list();
		model.addAttribute("tienich", list);
		
		model.addAttribute("btn_add","nhahang/tienich/them.html");
		model.addAttribute("tenbreadcrumb", "Quản lý tiện ích");
		return "nhahang/tienich/quanlytienich";
	}

	// PhÆ°Æ¡ng thá»©c GET Ä‘á»ƒ táº¡o giao diá»‡n khi click button ThÃªm
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model) {
		
		model.addAttribute("btn_back","nhahang/tienich/index.html");
		model.addAttribute("tenbreadcrumb", "Thêm mới tiện ích");
		model.addAttribute("tenbreadcrumb2", "Quản lý tiện ích");
		model.addAttribute("urlbreadcrumb2", "nhahang/tienich/index.html");
		return "nhahang/tienich/themtienich";
	}
	// ThÃªm tiá»‡n Ã­ch

	@Autowired
	ServletContext context;

	@RequestMapping(value = "themtienich", method = RequestMethod.POST)
	public String themtienich(ModelMap model, @RequestParam("tentienich") String tentienich,
			@RequestParam("name") String name,
			// @RequestParam("idnhahang") int idnhahang,
			@RequestParam("hinh") MultipartFile hinh, HttpSession httpSession) {
		Session session = factory.openSession();
		// Láº¥y id nhÃ  hÃ ng Ä‘á»ƒ thÃªm vÃ o Ä‘á»“ Äƒn
		// NhaHang nhahang = (NhaHang) session.get(NhaHang.class, idnhahang);
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		String tentienich1 = tentienich.trim();
		String name1 = name.trim();
		String photoPath = context.getRealPath("/upload/tienich/" + hinh.getOriginalFilename());
		Transaction t = session.beginTransaction();
		String hinhanh;
		try {
			hinh.transferTo(new File(photoPath));
			hinhanh = hinh.getOriginalFilename();
			TienIch tienich = new TienIch(tentienich1, name1, hinhanh,nhahang);
			session.save(tienich);
			t.commit();
			Thread.sleep(5000);
			return "redirect:/nhahang/tienich/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			System.out.println(e.toString());
			model.addAttribute("message", "ThÃªm tiá»‡n Ã­ch tháº¥t báº¡i!");
		} finally {
			session.close();
		}
		return "nhahang/tienich/themtienich";
	}

	// XoÃ¡ tiá»‡n Ã­ch
	@RequestMapping(value = "delete/{id}")
	public String deleteTienIch(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.openSession();
		TienIch tienich = (TienIch) session.get(TienIch.class, id);

		Transaction t = session.beginTransaction();
		try {

			session.delete(tienich);
			t.commit();
			model.addAttribute("message", "XoÃ¡ thÃ nh cÃ´ng");

		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "XÃ³a tháº¥t báº¡i !" + e.getMessage());
		} finally {
			session.close();
		}
		return "redirect:/nhahang/tienich/index.html";
	}

	// Táº¡o giao diá»‡n edit tiá»‡n Ã­ch
	@RequestMapping(value = "edit/{id}")
	public String editFormTienIch(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		TienIch tienich = (TienIch) session.get(TienIch.class, id);
		model.addAttribute("tienich", tienich);
		
		model.addAttribute("btn_back","nhahang/tienich/index.html");
		model.addAttribute("tenbreadcrumb", "Sửa thông tin tiện ích");
		model.addAttribute("tenbreadcrumb2", "Quản lý tiện ích");
		model.addAttribute("urlbreadcrumb2", "nhahang/tienich/index.html");
		return "nhahang/tienich/suatienich";
	}

	// Sá»­a tiá»‡n Ã­ch
	@RequestMapping(value = "suatienich", method = RequestMethod.POST)
	public String suaTienIch(ModelMap model, RedirectAttributes re, @RequestParam("idtienich") int id,
			@RequestParam("tentienich") String tentienich, @RequestParam("name") String name,
			@RequestParam("hinh") MultipartFile hinh, HttpSession httpSession) {
		Session session = factory.openSession();
		TienIch tienich = (TienIch) session.get(TienIch.class, id);
		String photoPath = context.getRealPath("/upload/tienich/" + hinh.getOriginalFilename());
		String tentienich1 = tentienich.trim();
		String name1 = name.trim();

		tienich.setTentienich(tentienich1);
		tienich.setName(name1);

		Transaction t = session.beginTransaction();

		// Sá»­a hÃ¬nh
		String hinhanh = tienich.getIcon();
		if (!hinh.isEmpty()) {
			try {
				hinh.transferTo(new File(photoPath));
				hinhanh = hinh.getOriginalFilename();
				tienich.setIcon(hinhanh);
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
				return "redirect:/nhahang/tienich/edit/" + id + ".html";
			}

		}
		try {
			session.update(tienich);
			t.commit();
			model.addAttribute("message", "Chá»‰nh sá»­a thÃ nh cÃ´ng !");
			return "redirect:/nhahang/tienich/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();

		} finally {
			session.close();
		}
		return "redirect:/nhahang/tienich/edit/" + id + ".html";
	}

	// Kiá»ƒm tra trÃ¹ng tÃªn tiá»‡n Ã­ch
	@RequestMapping(value = "kt-trung-tentienich", method = RequestMethod.GET)
	public @ResponseBody String ktTrungTenTienIch(@RequestParam("tentienich") String tentienich, @RequestParam("idtienich") int id,
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
		// Where thÃªm id nhÃ  hÃ ng Ä‘á»ƒ kiá»ƒm tra trÃ¹ng tÃªn Ä‘á»“ Äƒn riÃªng nhÃ  hÃ ng Ä‘Ã³
		String hql = "FROM TienIch where tentienich =:tentienich and idnhahang =:idnhahang";
		Query query = session.createQuery(hql);
		query.setParameter("tentienich", tentienich);
		query.setParameter("idnhahang", idnhahang);
		TienIch tienich = (TienIch) query.uniqueResult();
		if (tienich != null) {
			if (tienich.getId() == id) {
				return "true";
			}
			return "false";
		} else {
			return "true";
		}
	}

	// Kiá»ƒm tra trÃ¹ng name tiá»‡n Ã­ch
	@RequestMapping(value = "kt-trung-name", method = RequestMethod.GET)
	public @ResponseBody String ktTrungName(@RequestParam("name") String name, @RequestParam("idtienich") int id,
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
		// Where thÃªm id nhÃ  hÃ ng Ä‘á»ƒ kiá»ƒm tra trÃ¹ng name Ä‘á»“ Äƒn riÃªng nhÃ  hÃ ng Ä‘Ã³
		String hql = "FROM TienIch where name =:name and idnhahang =:idnhahang";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("idnhahang", idnhahang);
		TienIch tienich = (TienIch) query.uniqueResult();
		if (tienich != null) {
			if (tienich.getId() == id) {
				return "true";
			}
			return "false";
		} else {
			return "true";
		}
	}
}
