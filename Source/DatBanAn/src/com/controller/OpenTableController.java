package com.controller;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.NhanDipDao;
import com.entity.HoaDon;
import com.entity.KhuyenMai;
import com.entity.NguoiDung;
import com.entity.NhaHang;

@Transactional
@Controller
@RequestMapping("datban")
public class OpenTableController {
	@Autowired
	private NhanDipDao nhanDipDAO;
	@Autowired
	SessionFactory factory;
	//Tạo form đặt bàn
	@RequestMapping(value = "index/{id}", method = RequestMethod.GET)
	public String datban(ModelMap model, @PathVariable("id") int id) {
		Session session = factory.getCurrentSession();
		NhaHang nhahang = (NhaHang) session.get(NhaHang.class, id);
		model.addAttribute("nhahang", nhahang);

		return "homepage/datban";
	}
	//Trang thông tin đặt bàn
	@RequestMapping(value = "thongtindatban")
	public String thongtindatban(ModelMap model) {
		
		return "user/thongtindatban";
	}
	//Đặt bàn
	@RequestMapping(value = "xacnhandatban", method = RequestMethod.POST)
	public String xacnhandat(ModelMap model, RedirectAttributes re, 
			@RequestParam("idnhahang") int idnhahang,
			//@RequestParam("idnguoidung") int idnguoidung, 
			@RequestParam("ho") String ho,
			@RequestParam("ten") String ten,
			@RequestParam("ngaythang") String ngaythang,
			@RequestParam("thoigian") String thoigian,
			@RequestParam("songuoi") int songuoi,
			@RequestParam("nhandip") String nhandip,
			@RequestParam("email") String email, 
			@RequestParam("sdt") String sdt, 
			@RequestParam("ghichu") String ghichu,
			@RequestParam(value="check",required=false, defaultValue="false") boolean check,
			HttpSession httpSession) {
		Session session = factory.openSession();
		String ho1 = ho.trim();
		String ten1 = ten.trim();
		
		String email1 = email.trim();
		String sdt1 = sdt.trim();
		String ghichu1 = ghichu.trim();
		
		Date date = new Date();
		System.out.println(ngaythang);
		SimpleDateFormat   df = new SimpleDateFormat ("dd/MM/yyyy");
		/*String tgg =ngaythang;
		System.out.println(tgg);*/
		
		try {
			 date = df.parse(ngaythang);
			 System.out.println(date);
			 /*String da = df.format(date);*/
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.toString());
			e1.printStackTrace();
		}		
		
		
		NhaHang nhahang = (com.entity.NhaHang) session.get(NhaHang.class, 1);
		KhuyenMai khuyenmai = (KhuyenMai) session.get(KhuyenMai.class, 1);
		NguoiDung nguoidung = (NguoiDung) httpSession.getAttribute("nd");
		
		Date ngaytao = new Date();
		Transaction t = session.beginTransaction();
		
		
		HoaDon hoadon = new HoaDon(ho1, ten1, email1, sdt1, nhandip, ghichu1, songuoi, 0, check, thoigian, date, new Date(), khuyenmai, nhahang, nguoidung);
		
		try {
			session.save(hoadon);
			t.commit();			
			httpSession.setAttribute("hoadon",hoadon);
			httpSession.setAttribute("nhahang",nhahang);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			t.rollback();
			re.addFlashAttribute("message", "Đặt chỗ thất bại!");
			return "redirect:/datban/index/"+1+".html";
		} finally {
			session.close();
		}

		return "redirect:/datban/thongtindatban.html";
	}
	@ModelAttribute("list-nhandip")
	public Map<String, String> getListNhanDip(){
		return nhanDipDAO.getListNhanDip();
	}
}
