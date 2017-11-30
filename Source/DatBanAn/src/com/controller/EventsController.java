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

import com.entity.KhuyenMai;
import com.entity.LoaiAmThuc;
import com.entity.NguoiDung;
import com.entity.NhaHang;

@Transactional
@RequestMapping("nhahang/khuyenmai/")
@Controller
public class EventsController {
	@Autowired
	SessionFactory factory;

	// Ä�á»• dá»¯ liá»‡u ra trang quáº£n lÃ½
	@RequestMapping(value = "index")
	public String quanLyKhuyenMai(ModelMap model,HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		String hql = "FROM KhuyenMai where idnhahang =:idnhahang";
		
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);
		@SuppressWarnings("unchecked")
		List<KhuyenMai> list = query.list();
		model.addAttribute("khuyenmai", list);
		
		model.addAttribute("btn_add","nhahang/khuyenmai/them.html");
		model.addAttribute("tenbreadcrumb", "Quản lý hoạt động khuyến mãi");
		return "nhahang/khuyenmai/quanlykhuyenmai";
	}

	// PhÆ°Æ¡ng thá»©c GET Ä‘á»ƒ táº¡o giao diá»‡n khi click button ThÃªm
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model) {
		model.addAttribute("btn_back","nhahang/khuyenmai/index.html");
		model.addAttribute("tenbreadcrumb", "Thêm mới hoạt động khuyến mãi");
		model.addAttribute("tenbreadcrumb2", "Quản lý khuyến mãi");
		model.addAttribute("urlbreadcrumb2", "nhahang/khuyenmai/index.html");
		return "nhahang/khuyenmai/themkhuyenmai";
	}
	// ThÃªm khuyáº¿n mÃ£i

	@Autowired
	ServletContext context;

	@RequestMapping(value = "themkhuyenmai", method = RequestMethod.POST)
	public String themtienich(ModelMap model, @RequestParam("ngaybatdau") String ngaybatdau,
			@RequestParam("ngayketthuc") String ngayketthuc, @RequestParam("chude") String chude,
			@RequestParam("name") String name,@RequestParam("thongtin") String thongtin, HttpSession httpSession) {
		Session session = factory.openSession();

		String chude1 = chude.trim();
		String name1 = name.trim();
		String thongtin1 = thongtin.trim();	
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		
		Date ngaybd = new Date();
		Date ngaykt = new Date();
		SimpleDateFormat   df = new SimpleDateFormat ("dd/MM/yyyy");
		try {
			ngaybd = df.parse(ngaybatdau);
			ngaykt = df.parse(ngayketthuc);
			if(ngaybd.getDate() > ngaykt.getDate()||ngaybd.getMonth()>ngaykt.getMonth()||ngaybd.getYear()>ngaykt.getYear()){
				model.addAttribute("message", "NgÃ y báº¯t  Ä‘áº§u khÃ´ng Ä‘Æ°á»£c lá»›n hÆ¡n ngÃ y káº¿t thÃºc!");
				return "nhahang/khuyenmai/themkhuyenmai";
			}
			 /*String da = df.format(date);*/
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.toString());
			e1.printStackTrace();
		}
		Transaction t = session.beginTransaction();

		try {

			KhuyenMai km = new KhuyenMai(chude1,name1,thongtin1,ngaybd,ngaykt,true,nhahang);
			session.save(km);
			t.commit();

			return "redirect:/nhahang/khuyenmai/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			System.out.println(e.toString());
			model.addAttribute("message", "ThÃªm khuyáº¿n mÃ£i tháº¥t báº¡i!");
		} finally {
			session.close();
		}
		return "nhahang/khuyenmai/themkhuyenmai";
	}
	// Táº¡o giao diá»‡n edit khuyáº¿n mÃ£i
			@RequestMapping(value = "edit/{id}")
			public String editFormKhuyenMai(ModelMap model, @PathVariable("id") Integer id) {
				Session session = factory.getCurrentSession();
				KhuyenMai khuyenmai = (KhuyenMai) session.get(KhuyenMai.class, id);
				model.addAttribute("khuyenmai", khuyenmai);
				model.addAttribute("btn_back","nhahang/khuyenmai/index.html");
				model.addAttribute("tenbreadcrumb", "Sửa thông tin hoạt động khuyến mãi");
				model.addAttribute("tenbreadcrumb2", "Quản lý khuyến mãi");
				model.addAttribute("urlbreadcrumb2", "nhahang/khuyenmai/index.html");
				return "nhahang/khuyenmai/suakhuyenmai";
			}
			// Sá»­a khuyáº¿n mÃ£i
			@RequestMapping(value = "suakhuyenmai", method = RequestMethod.POST)
			public String suaAmThuc(ModelMap model, RedirectAttributes re, @RequestParam("idkhuyenmai") int id,
					@RequestParam("ngaybatdau") String ngaybatdau,
					@RequestParam("ngayketthuc") String ngayketthuc, @RequestParam("chude") String chude,
					@RequestParam("name") String name,@RequestParam("thongtin") String thongtin,
					@RequestParam("trangthai") boolean trangthai,HttpSession httpSession) {
				Session session = factory.openSession();
				KhuyenMai km = (KhuyenMai) session.get(KhuyenMai.class, id);
				String chude1 = chude.trim();
				String name1 = name.trim();
				String thongtin1 = thongtin.trim();	
				
				km.setChude(chude1);
				km.setName(name1);
				km.setThongtin(thongtin1);
				km.setTrangthai(trangthai);
				
				Date ngaybd = new Date();
				Date ngaykt = new Date();
				SimpleDateFormat   df = new SimpleDateFormat ("dd/MM/yyyy");
				try {
					ngaybd = df.parse(ngaybatdau);
					ngaykt = df.parse(ngayketthuc);
					if(ngaybd.getDate() > ngaykt.getDate()||ngaybd.getMonth()>ngaykt.getMonth()||ngaybd.getYear()>ngaykt.getYear()){
						re.addFlashAttribute("message", "NgÃ y báº¯t  Ä‘áº§u khÃ´ng Ä‘Æ°á»£c lá»›n hÆ¡n ngÃ y káº¿t thÃºc!");
						return "redirect:/nhahang/khuyenmai/edit/" + id + ".html";
					}
					 /*String da = df.format(date);*/
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.toString());
					e1.printStackTrace();
				}
				km.setNgaybatdau(ngaybd);
				km.setNgayketthuc(ngaykt);
				Transaction t = session.beginTransaction();			
				try {
					session.update(km);
					t.commit();
					model.addAttribute("message", "Chá»‰nh sá»­a thÃ nh cÃ´ng !");
					return "redirect:/nhahang/khuyenmai/index.html";
				} catch (Exception e) {
					// TODO: handle exception
					t.rollback();

				} finally {
					session.close();
				}
				return "redirect:/nhahang/khuyenmai/edit/" + id + ".html";
			}
			// Kiá»ƒm tra trÃ¹ng chá»§ Ä‘á»� 
			@RequestMapping(value = "kt-trung-chude", method = RequestMethod.GET)
			public @ResponseBody String ktTrungChude(@RequestParam("chude") String chude, @RequestParam("idkhuyenmai") int id,
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
				String hql = "FROM KhuyenMai where chude =:chude and idnhahang =:idnhahang";
				Query query = session.createQuery(hql);
				query.setParameter("chude", chude);
				query.setParameter("idnhahang", idnhahang);
				KhuyenMai km = (KhuyenMai) query.uniqueResult();
				if (km != null) {
					if (km.getId() == id) {
						return "true";
					}
					return "false";
				} else {
					return "true";
				}
			}

			// Kiá»ƒm tra trÃ¹ng name 
			@RequestMapping(value = "kt-trung-name", method = RequestMethod.GET)
			public @ResponseBody String ktTrungName(@RequestParam("name") String name, @RequestParam("idkhuyenmai") int id,
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
				String hql = "FROM KhuyenMai where name =:name and idnhahang =:idnhahang";
				Query query = session.createQuery(hql);
				query.setParameter("name", name);
				query.setParameter("idnhahang", idnhahang);
				KhuyenMai km = (KhuyenMai) query.uniqueResult();
				if (km != null) {
					if (km.getId() == id) {
						return "true";
					}
					return "false";
				} else {
					return "true";
				}
			}
}
