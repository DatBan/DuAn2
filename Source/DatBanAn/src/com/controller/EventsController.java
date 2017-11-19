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

	// Đổ dữ liệu ra trang quản lý
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
		model.addAttribute("tenbreadcrumb", "QUẢN LÝ KHUYẾN MÃI");
		return "nhahang/quanlykhuyenmai";
	}

	// Phương thức GET để tạo giao diện khi click button Thêm
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String them(ModelMap model) {
		model.addAttribute("tenbreadcrumb", "THÊM KHUYẾN MÃI");
		return "nhahang/themkhuyenmai";
	}
	// Thêm khuyến mãi

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
				model.addAttribute("message", "Ngày bắt  đầu không được lớn hơn ngày kết thúc!");
				return "nhahang/themkhuyenmai";
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
			model.addAttribute("message", "Thêm khuyến mãi thất bại!");
		} finally {
			session.close();
		}
		return "nhahang/themkhuyenmai";
	}
	// Tạo giao diện edit khuyến mãi
			@RequestMapping(value = "edit/{id}")
			public String editFormKhuyenMai(ModelMap model, @PathVariable("id") Integer id) {
				Session session = factory.getCurrentSession();
				KhuyenMai khuyenmai = (KhuyenMai) session.get(KhuyenMai.class, id);
				model.addAttribute("khuyenmai", khuyenmai);
				model.addAttribute("tenbreadcrumb", "SỬA KHUYẾN MÃI");
				return "nhahang/suakhuyenmai";
			}
			// Sửa khuyến mãi
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
						re.addFlashAttribute("message", "Ngày bắt  đầu không được lớn hơn ngày kết thúc!");
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
					model.addAttribute("message", "Chỉnh sửa thành công !");
					return "redirect:/nhahang/khuyenmai/index.html";
				} catch (Exception e) {
					// TODO: handle exception
					t.rollback();

				} finally {
					session.close();
				}
				return "redirect:/nhahang/khuyenmai/edit/" + id + ".html";
			}
			// Kiểm tra trùng chủ đề 
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

			// Kiểm tra trùng name 
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
