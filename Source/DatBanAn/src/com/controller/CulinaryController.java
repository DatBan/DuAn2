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

import com.entity.LoaiAmThuc;
import com.entity.TienIch;

@Transactional
@RequestMapping("dashboard/amthuc/")
@Controller
public class CulinaryController {
	@Autowired
	SessionFactory factory;

	// Do du lieu ra trang quan ly
	@RequestMapping(value = "index")
	public String quanLyAmThuc(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiAmThuc where trangthai=0";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<LoaiAmThuc> list = query.list();
		model.addAttribute("amthuc", list);
		
		model.addAttribute("btn_add","dashboard/amthuc/them.html");
		model.addAttribute("tenbreadcrumb", "Quản lý loại ẩm thực");
		return "dashboard/amthuc/quanlyamthuc";
	}

	// Tao giao dien them
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model) {
		model.addAttribute("btn_back","dashboard/amthuc/index.html");
		model.addAttribute("tenbreadcrumb", "Thêm mới loại ẩm thực");
		model.addAttribute("tenbreadcrumb2", "Quản lý loại ẩm thực");
		model.addAttribute("urlbreadcrumb2", "dashboard/amthuc/index.html");
		return "dashboard/amthuc/themamthuc";
	}
	// Them am thuc

		@Autowired
		ServletContext context;

		@RequestMapping(value = "themamthuc", method = RequestMethod.POST)
		public String themtienich(ModelMap model, @RequestParam("tenloai") String tenloai,
				@RequestParam("name") String name,
				@RequestParam("mota") String mota,
				@RequestParam("description") String description, HttpSession httpSession) {
			Session session = factory.openSession();

			String tenloai1 = tenloai.trim();
			String name1 = name.trim();
			String mota1 = mota.trim();
			String description1 = description.trim();
			
			Transaction t = session.beginTransaction();
	
			try {
				
				LoaiAmThuc amthuc = new LoaiAmThuc(tenloai1, name1, mota1,description1);
				session.save(amthuc);
				t.commit();
				
				return "redirect:/dashboard/amthuc/index.html";
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();
				System.out.println(e.toString());
				model.addAttribute("message", "Thêm ẩm thực thất bại!");
			} finally {
				session.close();
			}
			return "dashboard/amthuc/themamthuc";
		}
		// Xoa am thuc
		@RequestMapping(value = "delete/{id}")
		public String deleteAmThuc(ModelMap model, @PathVariable("id") Integer id) {
			Session session = factory.openSession();
			LoaiAmThuc amthuc = (LoaiAmThuc) session.get(LoaiAmThuc.class, id);
			amthuc.setTrangthai(1);
			Transaction t = session.beginTransaction();
			try {

				session.update(amthuc);
				t.commit();
				model.addAttribute("message", "Xoá thành công");

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Xoá thất bại !" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/dashboard/amthuc/index.html";
		}
		// Tao giao dien sua
		@RequestMapping(value = "edit/{id}")
		public String editFormAmThuc(ModelMap model, @PathVariable("id") Integer id) {
			Session session = factory.getCurrentSession();
			LoaiAmThuc amthuc = (LoaiAmThuc) session.get(LoaiAmThuc.class, id);
			model.addAttribute("amthuc", amthuc);
			model.addAttribute("btn_back","dashboard/amthuc/index.html");
			model.addAttribute("tenbreadcrumb", "Sửa thông tin loại ẩm thực");
			model.addAttribute("tenbreadcrumb2", "Quản lý loại ẩm thực");
			model.addAttribute("urlbreadcrumb2", "dashboard/amthuc/index.html");
			return "dashboard/amthuc/suaamthuc";
		}
		// Sá»­a áº©m thá»±c
		@RequestMapping(value = "suaamthuc", method = RequestMethod.POST)
		public String suaAmThuc(ModelMap model, RedirectAttributes re, @RequestParam("idamthuc") int id,
				@RequestParam("tenloai") String tenloai,
				@RequestParam("name") String name,
				@RequestParam("mota") String mota,
				@RequestParam("description") String description, HttpSession httpSession) {
			Session session = factory.openSession();
			LoaiAmThuc amthuc = (LoaiAmThuc) session.get(LoaiAmThuc.class, id);
			String tenloai1 = tenloai.trim();
			String name1 = name.trim();
			String mota1 = mota.trim();
			String description1 = description.trim();
			
			amthuc.setTenloai(tenloai1);
			amthuc.setName(name1);
			amthuc.setMota(mota1);
			amthuc.setDescription(description1);
			Transaction t = session.beginTransaction();			
			try {
				session.update(amthuc);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa thành công!");
				return "redirect:/dashboard/amthuc/index.html";
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();

			} finally {
				session.close();
			}
			return "redirect:/dashboard/amthuc/edit/" + id + ".html";
		}
		// kiem tra trung ten am thuc
		@RequestMapping(value = "kt-trung-tenamthuc", method = RequestMethod.GET)
		public @ResponseBody String ktTrungTenAmThuc(@RequestParam("tenloai") String tenloai, @RequestParam("idamthuc") int id,
				HttpServletResponse response, HttpServletRequest request) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setCharacterEncoding("UTF-8");
			Session session = factory.getCurrentSession();
			
			String hql = "FROM LoaiAmThuc where tenloai =:tenloai and trangthai=0";
			Query query = session.createQuery(hql);
			query.setParameter("tenloai", tenloai);
			LoaiAmThuc amthuc = (LoaiAmThuc) query.uniqueResult();
			if (amthuc != null) {
				if (amthuc.getId() == id) {
					return "true";
				}
				return "false";
			} else {
				return "true";
			}
		}

		// kiem tra trung name am thuc
		@RequestMapping(value = "kt-trung-name", method = RequestMethod.GET)
		public @ResponseBody String ktTrungName(@RequestParam("name") String name, @RequestParam("idamthuc") int id,
				HttpServletResponse response, HttpServletRequest request) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setCharacterEncoding("UTF-8");
			Session session = factory.getCurrentSession();
			
			String hql = "FROM LoaiAmThuc where name =:name and trangthai=0";
			Query query = session.createQuery(hql);
			query.setParameter("name", name);
			LoaiAmThuc amthuc = (LoaiAmThuc) query.uniqueResult();
			if (amthuc != null) {
				if (amthuc.getId() == id) {
					return "true";
				}
				return "false";
			} else {
				return "true";
			}
		}
}
