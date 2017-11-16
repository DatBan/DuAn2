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

import com.entity.BinhLuan;
import com.entity.LoaiDoAn;
import com.entity.MonAn;
import com.entity.NhaHang;

@Transactional
@RequestMapping("nhahang/monan/")
@Controller
public class FoodController {
	@Autowired
	SessionFactory factory;
	//Đổ dữ liệu ra trang quản lý
	@RequestMapping(value="index")
	public String quanlydoan(ModelMap model){
		Session session = factory.getCurrentSession();
		String hql ="FROM MonAn";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<MonAn> list = query.list();
		model.addAttribute("monan",list);
		model.addAttribute("tenbreadcrumb","QUẢN LÝ MÓN ĂN");
		return "nhahang/quanlymonan";
	}
	// Phương thức GET để tạo giao diện khi click button Thêm
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model){
		// Đổ dữ liệu ra combobox
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiDoAn";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<LoaiDoAn> list = query.list();
		model.addAttribute("loaidoan",list);
		model.addAttribute("tenbreadcrumb", "THÊM ĐỒ ĂN");
		return "nhahang/themdoan";
	}
	// Thêm đồ ăn

		@Autowired
		ServletContext context;
		
		@RequestMapping(value = "themdoan", method = RequestMethod.POST)
		public String themdoan(ModelMap model, @RequestParam("tendoan") String tendoan,
				@RequestParam("name") String name,
				@RequestParam("gia") double gia,
				@RequestParam("idloaidoan") int idloaidoan,
//				@RequestParam("idnhahang") int idnhahang,
				@RequestParam("hinh") MultipartFile hinh,
				 HttpSession httpSession){
			Session session = factory.openSession();
			//Lấy id nhà hàng để thêm vào đồ ăn
//			NhaHang nhahang = (NhaHang) session.get(NhaHang.class, idnhahang);
			
			String tendoan1 = tendoan.trim();
			String name1 = name.trim();
			
			LoaiDoAn loaidoan = (LoaiDoAn) session.get(LoaiDoAn.class, idloaidoan);
			
			// Đổ lại dữ liệu ra combobox nếu như thêm thất bại
			String hql = "FROM LoaiDoAn";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<LoaiDoAn> list = query.list();
			model.addAttribute("loaidoan",list);
			
			String photoPath = context.getRealPath("/upload/monan/" + hinh.getOriginalFilename());
			Transaction t = session.beginTransaction();
			String hinhanh;
			try {
				hinh.transferTo(new File(photoPath));
				hinhanh = hinh.getOriginalFilename();
				MonAn mon = new MonAn(tendoan1,name1,hinhanh,gia,loaidoan);
				session.save(mon);
				t.commit();
				Thread.sleep(5000);
				return "redirect:/nhahang/monan/index.html";
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();
				System.out.println(e.toString());
				model.addAttribute("message", "Thêm món ăn thất bại!");
			}finally {
				session.close();
			}
			return "nhahang/themdoan";
		}
		// Xoá món ăn
		@RequestMapping(value = "delete/{id}")
		public String deleteBaiviet(ModelMap model, @PathVariable("id") Integer id) {
			Session session = factory.openSession();
			MonAn monan = (MonAn) session.get(MonAn.class, id);
			
			//Xoá bình luận món ăn
			String hql = "FROM BinhLuan where idmonan =:idmonan";
			Query query = session.createQuery(hql);
			query.setParameter("idmonan", id);
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
				session.delete(monan);
				t.commit();
				model.addAttribute("message", "Xoá thành công");

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Xóa thất bại !" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/nhahang/monan/index.html";
		}
		//Tạo giao diện edit món ăn
		@RequestMapping(value = "edit/{id}")
		public String editFormMonAn(ModelMap model, @PathVariable("id") Integer id){
			Session session = factory.getCurrentSession();
			MonAn monan = (MonAn) session.get(MonAn.class, id);
			// Đổ lại dữ liệu ra combobox 
			String hql = "FROM LoaiDoAn";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<LoaiDoAn> list = query.list();
			model.addAttribute("loaidoan",list);
			model.addAttribute("monan",monan);
			model.addAttribute("tenbreadcrumb", "SỬA ĐỒ ĂN");
			return "nhahang/suamonan";
		}
		//Sửa món ăn
		@RequestMapping(value = "suadoan", method = RequestMethod.POST)
		public String suaMonAn(ModelMap model, RedirectAttributes re,
				@RequestParam("idmonan") int id,
				@RequestParam("tendoan") String tendoan,
				@RequestParam("name") String name,
				@RequestParam("gia") double gia,
				@RequestParam("idloaidoan") int idloaidoan,
				@RequestParam("hinh") MultipartFile hinh, HttpSession httpSession){
			
			Session session = factory.openSession();
			MonAn monan = (MonAn) session.get(MonAn.class, id);
			LoaiDoAn loaidoan = (LoaiDoAn) session.get(LoaiDoAn.class, idloaidoan);
			String photoPath = context.getRealPath("/upload/monan/" + hinh.getOriginalFilename());
			String tendoan1 = tendoan.trim();
			String name1 = name.trim();
			
			monan.setTenmonan(tendoan1);
			monan.setName(name1);
			monan.setGia(gia);
			monan.setLoai(loaidoan);
			Transaction t = session.beginTransaction();
			// Đổ lại dữ liệu ra combobox nếu sửa thất bại
			String hql = "FROM LoaiDoAn";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<LoaiDoAn> list = query.list();
			model.addAttribute("loaidoan",list);
			//Sửa hình
			String hinhanh = monan.getHinhanh();
			if (!hinh.isEmpty()) {
				try {
					hinh.transferTo(new File(photoPath));
					hinhanh = hinh.getOriginalFilename();
					monan.setHinhanh(hinhanh);
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
					return "redirect:/nhahang/monan/edit/" + id + ".html";
				}

			}
			try {
				session.update(monan);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa thành công !");
				return "redirect:/nhahang/monan/index.html";
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();
				
			}finally {
				session.close();
			}
			return "redirect:/nhahang/monan/edit/" + id + ".html";
		}
		//Kiểm tra trùng tên đồ ăn
		@RequestMapping(value = "kt-trung-tendoan", method = RequestMethod.GET)
		public @ResponseBody String ktTrungTenDoAn(@RequestParam("tendoan") String tendoan,@RequestParam("idmonan") int id,
				HttpServletResponse response, HttpServletRequest request){
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setCharacterEncoding("UTF-8");
			Session session = factory.getCurrentSession();
			//Where thêm id nhà hàng để kiểm tra trùng tên đồ ăn riêng nhà hàng đó
			String hql ="FROM MonAn where tenmonan =:tenmonan";
			Query query = session.createQuery(hql);
			query.setParameter("tenmonan", tendoan);
			MonAn monan = (MonAn) query.uniqueResult();
			if (monan != null) {
				if (monan.getId() == id) {
					return "true";
				}
				return "false";
			} else {
				return "true";
			}
		}
		//Kiểm tra trùng name đồ ăn
				@RequestMapping(value = "kt-trung-name", method = RequestMethod.GET)
				public @ResponseBody String ktTrungName(@RequestParam("name") String name,@RequestParam("idmonan") int id,
						HttpServletResponse response, HttpServletRequest request){
					try {
						request.setCharacterEncoding("UTF-8");
					} catch (Exception e) {
						// TODO: handle exception
					}
					response.setCharacterEncoding("UTF-8");
					Session session = factory.getCurrentSession();
					//Where thêm id nhà hàng để kiểm tra trùng name đồ ăn riêng nhà hàng đó
					String hql ="FROM MonAn where name =:name";
					Query query = session.createQuery(hql);
					query.setParameter("name", name);
					MonAn monan = (MonAn) query.uniqueResult();
					if (monan != null) {
						if (monan.getId() == id) {
							return "true";
						}
						return "false";
					} else {
						return "true";
					}
				}
}
