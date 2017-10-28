package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.UserService.EnDeCryption;
import com.entity.NguoiDung;
import com.entity.Quyen;

import net.sf.ehcache.hibernate.HibernateUtil;




@Controller
public class RegisterController {
	@Autowired
	SessionFactory factory;
	/* Phương thức GET Để Tạo Giao Diện khi click button Đăng kÝ */
	@RequestMapping(value="RegisterForm",method = RequestMethod.GET)
	public String RegisterForm() {
		return "register";
	}
	/* Phương thức POST Để Tạo Tài Khoản khi click button Đăng kÝ */
	@Transactional
	@RequestMapping(value="RegisterForm", method = RequestMethod.POST)
	public String RegisterForm(ModelMap model,
			@RequestParam("hoten") String hoten,
			@RequestParam("tendangnhap") String tendangnhap,
			@RequestParam("matkhau")String matkhau,
			@RequestParam("email")String email,
			@RequestParam("sdt")String sdt,
			@RequestParam("diachi")String diachi,
			HttpSession httpSession){
		Session session = factory.openSession();
		Quyen quyen= (Quyen) session.get(Quyen.class, 3);
		
		Date ngaytao = new Date();
		EnDeCryption mh = new EnDeCryption("sadasdasdsawqewq");
		String mkmh= mh.encoding(matkhau);
		NguoiDung nguoidung= new NguoiDung(hoten, tendangnhap, mkmh, email, sdt, diachi, 1, ngaytao, quyen);
		Transaction t = session.beginTransaction();
		try {
			session.save(nguoidung);
			t.commit();
			httpSession.setAttribute("nguoidung", nguoidung);
			return"redirect:trang-chu.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Đăng ký thất bại !");
		}finally {
			session.close();
		}
		return "register";
	}
	

}
