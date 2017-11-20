package com.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.Date;
import java.util.List;

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

import com.entity.NguoiDung;
import com.entity.Trang;
@Transactional
@RequestMapping("Dashboard/Trang/")
@Controller
public class PageController {
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
		model.addAttribute("tenbreadcrumb","QUẢN LÝ TRANG");
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
		return "redirect:/Dashboard/Trang/index.html";
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
			@RequestParam("area1")String noidung,
			@RequestParam("area2")String content,
			@RequestParam("slug")String slug,
//			@RequestParam("idnd")int idnd,
			HttpSession httpSession) {
			Session session = factory.openSession();
			//Khi đăng nhập thì chọn cái này
//			NguoiDung nd = session.get(NguoiDung.class, idnd);
			//Cái tạm thời
			System.out.println(noidung.trim().length());
			String td = tieude.trim();
			String tt = title.trim();
			String sl = slug.trim();
			NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, 1);
			Date ngaytao = new Date();
			Trang trang = new Trang(td, tt, noidung, content, sl, ngaytao, nd);
			Transaction t = session.beginTransaction();
			
			if(noidung.length()<200||content.length()<200){
				model.addAttribute("message", "Nội dung hoặc content không hợp lệ");
				return "dashboard/themtrang";
				
			}
//			if(noidung.length()>1500||content.length()>1500){
//				model.addAttribute("message", "Nội dung quá dài (Content too long)");
//				return "dashboard/themtrang";
//				
//			}
			
			try {
				session.save(trang);
				t.commit();
				return "redirect:/Dashboard/Trang/index.html";
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
		model.addAttribute("tenbreadcrumb","SỬA TRANG");
		return "dashboard/edittrang";
	}
	//Sửa trang
	@RequestMapping(value="suatrang",method = RequestMethod.POST)
	public String suaTrang(ModelMap model,RedirectAttributes re, @RequestParam("idtrang") int id,
			@RequestParam("tieude")String tieude,
			@RequestParam("title")String title,
			@RequestParam("area1")String noidung,
			@RequestParam("area2")String content,
			@RequestParam("slug")String slug){
		Date ngaysua = new Date();
		Session session = factory.openSession();
		
		
		Trang trang = (Trang) session.get(Trang.class, id);
		String td = tieude.trim();
		String tt = title.trim();
		String sl = slug.trim();
		String nd = noidung.trim();
		String ct = content.trim();
		trang.setTieude(td);
		trang.setTitle(tt);
		trang.setNoidung(noidung);
		trang.setContent(content);
		trang.setSlug(sl);
		trang.setNgaysua(ngaysua);
		Transaction t = session.beginTransaction();
		
		System.err.println(nd.length());
		System.err.println(ct.length());
		if(nd.length()<400||ct.length()<400){
			re.addFlashAttribute("message", "Nội dung hoặc content không hợp lệ");
			return "redirect:/Dashboard/Trang/edit/"+id+".html";
			
		}
		try {
			session.update(trang);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa thành công !");
			return "redirect:/Dashboard/Trang/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			 model.addAttribute("message", "Chỉnh sửa thất bại !");
		}finally {
			session.close();
		}
		return "redirect:/Dashboard/Trang/edit/"+id+".html";
	}
	//kiểm tra trùng trang
	@RequestMapping(value="kt-trung-tieude",method = RequestMethod.GET)
	public @ResponseBody String ktTrungTieuDe(@RequestParam("tieude") String tieude,
			@RequestParam("idtrang") int id,
			HttpServletResponse response,
			HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();
		
			
		
		String hql="FROM Trang  WHERE tieude =:tieude";
		Query query = session.createQuery(hql);
		query.setParameter("tieude", tieude);
		
		Trang trang= (Trang) query.uniqueResult();
		
		if(trang!=null){
			if(trang.getId()==id){
				return "true";
			}
			return "false";
		}else{
			return "true";
		}
	}
	//kiểm tra trùng titile
		@RequestMapping(value="kt-trung-title",method = RequestMethod.GET)
		public @ResponseBody String ktTrungTitle(@RequestParam("title") String title,
				@RequestParam("idtrang") int id,
				HttpServletResponse response,
				HttpServletRequest request){
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setCharacterEncoding("UTF-8");
			Session session = factory.getCurrentSession();
			
			String hql="FROM Trang  WHERE title =:title";
			Query query = session.createQuery(hql);
			query.setParameter("title", title);
			
			Trang trang= (Trang) query.uniqueResult();
			
			if(trang!=null){
				if(trang.getId()==id){
					return "true";
				}
				return "false";
				
			}else{
				return "true";
			}
		}
		//kiểm tra trùng slug
				@RequestMapping(value="kt-trung-slug",method = RequestMethod.GET)
				public @ResponseBody String ktTrungSlug(@RequestParam("slug") String slug,
						@RequestParam("idtrang") int id,
						HttpServletResponse response,
						HttpServletRequest request){
					try {
						request.setCharacterEncoding("UTF-8");
					} catch (Exception e) {
						// TODO: handle exception
					}
					response.setCharacterEncoding("UTF-8");
					Session session = factory.getCurrentSession();
					
					String hql="FROM Trang  WHERE slug =:slug";
					Query query = session.createQuery(hql);
					query.setParameter("slug", slug);
					
					Trang trang= (Trang) query.uniqueResult();
					
					if(trang!=null){
						if(trang.getId()==id){
							return "true";
						}
						return "false";
					}else{
						return "true";
					}
				}
}
