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
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.services.DoiTenFile;

@Transactional
@RequestMapping("nhahang/monan/")
@Controller
public class FoodController {
	@Autowired
	SessionFactory factory;
	//Do du lieu ra trang quan ly
	@RequestMapping(value="index")
	public String quanlydoan(ModelMap model,HttpSession httpSession){
		Session session = factory.getCurrentSession();
		
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		String hql ="FROM MonAn where idnhahang =:idnhahang and trangthai=0";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);
		@SuppressWarnings("unchecked")
		List<MonAn> list = query.list();
		model.addAttribute("monan",list);

		model.addAttribute("btn_add","nhahang/monan/them.html");
		model.addAttribute("tenbreadcrumb", "Quản lý món ăn");
		return "nhahang/monan/quanlymonan";
	}
	// Tao giao dien them
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model){
		// Lay loai do an
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiDoAn";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<LoaiDoAn> list = query.list();
		model.addAttribute("loaidoan",list);
		
		model.addAttribute("btn_back","nhahang/monan/index.html");
		model.addAttribute("tenbreadcrumb", "Thêm mới món ăn");
		model.addAttribute("tenbreadcrumb2", "Quản lý món ăn");
		model.addAttribute("urlbreadcrumb2", "nhahang/monan/index.html");
		return "nhahang/monan/themdoan";
	}
	// Them do an

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
			
//			NhaHang nhahang = (NhaHang) session.get(NhaHang.class, idnhahang);
			
			String tendoan1 = tendoan.trim();
			String name1 = name.trim();
			
			LoaiDoAn loaidoan = (LoaiDoAn) session.get(LoaiDoAn.class, idloaidoan);
			NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
			NhaHang nhahang = nd.getNhahang();
			// Lay loai do an khi them that bai
			String hql = "FROM LoaiDoAn";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<LoaiDoAn> list = query.list();
			model.addAttribute("loaidoan",list);
			String tenhinh = DoiTenFile.DoiFile(hinh.getOriginalFilename());
			String photoPath = context.getRealPath("/upload/monan/" + tenhinh);
			Transaction t = session.beginTransaction();
			String hinhanh;
			try {
				hinh.transferTo(new File(photoPath));
				hinhanh = tenhinh;
				MonAn mon = new MonAn(tendoan1,name1,hinhanh,gia,nhahang,loaidoan);
				session.save(mon);
				t.commit();
				Thread.sleep(5000);
				return "redirect:/nhahang/monan/index.html";
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();
				System.out.println(e.toString());
				model.addAttribute("message", "Thêm đồ ăn thất bại!");
			}finally {
				session.close();
			}
			return "nhahang/monan/themdoan";
		}
		// Xoa do an
		@RequestMapping(value = "delete/{id}")
		public String deleteBaiviet(ModelMap model, @PathVariable("id") Integer id) {
			Session session = factory.openSession();
			MonAn monan = (MonAn) session.get(MonAn.class, id);
			
			monan.setTrangthai(1);

			Transaction t = session.beginTransaction();
			try {
				
				
				session.update(monan);
				t.commit();
				model.addAttribute("message", "Xoá thành công");

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Xoá thất bại !" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/nhahang/monan/index.html";
		}
		//Tao giao dien sua
		@RequestMapping(value = "edit/{id}")
		public String editFormMonAn(ModelMap model, @PathVariable("id") Integer id){
			Session session = factory.getCurrentSession();
			MonAn monan = (MonAn) session.get(MonAn.class, id);
			//Lay loai do an
			String hql = "FROM LoaiDoAn";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<LoaiDoAn> list = query.list();
			model.addAttribute("loaidoan",list);
			model.addAttribute("monan",monan);
			
			model.addAttribute("btn_back","nhahang/monan/index.html");
			model.addAttribute("tenbreadcrumb", "Sửa thông tin món ăn");
			model.addAttribute("tenbreadcrumb2", "Quản lý món ăn");
			model.addAttribute("urlbreadcrumb2", "nhahang/monan/index.html");
			return "nhahang/monan/suamonan";
		}
		//Sua do an
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
			String tenhinh = DoiTenFile.DoiFile(hinh.getOriginalFilename());
			String photoPath = context.getRealPath("/upload/monan/" + tenhinh);
			String tendoan1 = tendoan.trim();
			String name1 = name.trim();
			
			monan.setTenmonan(tendoan1);
			monan.setName(name1);
			monan.setGia(gia);
			monan.setLoai(loaidoan);
			Transaction t = session.beginTransaction();
			// Lay loai do an
			String hql = "FROM LoaiDoAn";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<LoaiDoAn> list = query.list();
			model.addAttribute("loaidoan",list);
			
			String hinhanh = monan.getHinhanh();
			if (!hinh.isEmpty()) {
				try {
					hinh.transferTo(new File(photoPath));
					hinhanh = tenhinh;
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
		//kiem tra trung ten do an
		@RequestMapping(value = "kt-trung-tendoan", method = RequestMethod.GET)
		public @ResponseBody String ktTrungTenDoAn(@RequestParam("tendoan") String tendoan,@RequestParam("idmonan") int id,
				HttpServletResponse response, HttpServletRequest request,HttpSession httpSession){
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
			
			String hql ="FROM MonAn where tenmonan =:tenmonan and idnhahang =:idnhahang and trangthai=0";
			Query query = session.createQuery(hql);
			query.setParameter("tenmonan", tendoan);
			query.setParameter("idnhahang", idnhahang);
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
		//kiem tra trung name
				@RequestMapping(value = "kt-trung-name", method = RequestMethod.GET)
				public @ResponseBody String ktTrungName(@RequestParam("name") String name,@RequestParam("idmonan") int id,
						HttpServletResponse response, HttpServletRequest request,HttpSession httpSession){
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
					
					String hql ="FROM MonAn where name =:name and idnhahang =:idnhahang and trangthai=0";
					Query query = session.createQuery(hql);
					query.setParameter("name", name);
					query.setParameter("idnhahang", idnhahang);
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
