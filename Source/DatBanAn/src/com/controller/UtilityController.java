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
import com.entity.TienIch;

@Transactional
@RequestMapping("nhahang/tienich/")
@Controller
public class UtilityController {
	@Autowired
	SessionFactory factory;

	// Đổ dữ liệu ra trang quản lý
	@RequestMapping(value = "index")
	public String quanlytienich(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TienIch";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<TienIch> list = query.list();
		model.addAttribute("tienich", list);
		model.addAttribute("tenbreadcrumb", "QUẢN LÝ TIỆN ÍCH");
		return "nhahang/quanlytienich";
	}

	// Phương thức GET để tạo giao diện khi click button Thêm
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model) {
		model.addAttribute("tenbreadcrumb", "THÊM TIỆN ÍCH");
		return "nhahang/themtienich";
	}
	// Thêm tiện ích

	@Autowired
	ServletContext context;

	@RequestMapping(value = "themtienich", method = RequestMethod.POST)
	public String themtienich(ModelMap model, @RequestParam("tentienich") String tentienich,
			@RequestParam("name") String name,
			// @RequestParam("idnhahang") int idnhahang,
			@RequestParam("hinh") MultipartFile hinh, HttpSession httpSession) {
		Session session = factory.openSession();
		// Lấy id nhà hàng để thêm vào đồ ăn
		// NhaHang nhahang = (NhaHang) session.get(NhaHang.class, idnhahang);

		String tentienich1 = tentienich.trim();
		String name1 = name.trim();
		String photoPath = context.getRealPath("/upload/tienich/" + hinh.getOriginalFilename());
		Transaction t = session.beginTransaction();
		String hinhanh;
		try {
			hinh.transferTo(new File(photoPath));
			hinhanh = hinh.getOriginalFilename();
			TienIch tienich = new TienIch(tentienich1, name1, hinhanh);
			session.save(tienich);
			t.commit();
			Thread.sleep(5000);
			return "redirect:/nhahang/tienich/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			System.out.println(e.toString());
			model.addAttribute("message", "Thêm tiện ích thất bại!");
		} finally {
			session.close();
		}
		return "nhahang/themtienich";
	}

	// Xoá tiện ích
	@RequestMapping(value = "delete/{id}")
	public String deleteTienIch(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.openSession();
		TienIch tienich = (TienIch) session.get(TienIch.class, id);

		Transaction t = session.beginTransaction();
		try {

			session.delete(tienich);
			t.commit();
			model.addAttribute("message", "Xoá thành công");

		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa thất bại !" + e.getMessage());
		} finally {
			session.close();
		}
		return "redirect:/nhahang/tienich/index.html";
	}

	// Tạo giao diện edit tiện ích
	@RequestMapping(value = "edit/{id}")
	public String editFormTienIch(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		TienIch tienich = (TienIch) session.get(TienIch.class, id);
		model.addAttribute("tienich", tienich);
		model.addAttribute("tenbreadcrumb", "SỬA TIỆN ÍCH");
		return "nhahang/suatienich";
	}

	// Sửa tiện ích
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

		// Sửa hình
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
			model.addAttribute("message", "Chỉnh sửa thành công !");
			return "redirect:/nhahang/tienich/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();

		} finally {
			session.close();
		}
		return "redirect:/nhahang/tienich/edit/" + id + ".html";
	}

	// Kiểm tra trùng tên tiện ích
	@RequestMapping(value = "kt-trung-tentienich", method = RequestMethod.GET)
	public @ResponseBody String ktTrungTenTienIch(@RequestParam("tentienich") String tentienich, @RequestParam("idtienich") int id,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();
		// Where thêm id nhà hàng để kiểm tra trùng tên đồ ăn riêng nhà hàng đó
		String hql = "FROM TienIch where tentienich =:tentienich";
		Query query = session.createQuery(hql);
		query.setParameter("tentienich", tentienich);
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

	// Kiểm tra trùng name tiện ích
	@RequestMapping(value = "kt-trung-name", method = RequestMethod.GET)
	public @ResponseBody String ktTrungName(@RequestParam("name") String name, @RequestParam("idtienich") int id,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();
		// Where thêm id nhà hàng để kiểm tra trùng name đồ ăn riêng nhà hàng đó
		String hql = "FROM TienIch where name =:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
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
