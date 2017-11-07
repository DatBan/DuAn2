package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.NguoiDung;
import com.entity.Quyen;
import com.services.EnDeCryption;

import net.sf.ehcache.hibernate.HibernateUtil;



@Transactional
@Controller
public class RegisterController {
	@Autowired
	SessionFactory factory;
	/* PhÆ°Æ¡ng thá»©c GET Ä�á»ƒ Táº¡o Giao Diá»‡n khi click button Ä�Äƒng kÃ� */
	@RequestMapping(value="RegisterForm",method = RequestMethod.GET)
	public String RegisterForm() {
		return "register";
	}
	/* PhÆ°Æ¡ng thá»©c POST Ä�á»ƒ Táº¡o TÃ i Khoáº£n khi click button Ä�Äƒng kÃ� */
	
	@RequestMapping(value="RegisterForm", method = RequestMethod.POST)
	public String RegisterForm(ModelMap model,
			@RequestParam("hoten") String hoten,
			@RequestParam("tendangnhap") String tendangnhap,
			@RequestParam("matkhau")String matkhau,
			@RequestParam("email")String email,
			@RequestParam("sdt")String sdt,
			@RequestParam("diachi")String diachi,
			HttpSession httpSession,
			HttpServletResponse response){
		Session session = factory.openSession();
		Quyen quyen= (Quyen) session.get(Quyen.class, 3);
		
		String ht= hoten.trim();
		Date ngaytao = new Date();
		EnDeCryption mh = new EnDeCryption("sadasdasdsawqewq");
		String mkmh= mh.encoding(matkhau);
		NguoiDung nguoidung= new NguoiDung(ht, tendangnhap, mkmh, email, sdt, diachi, 1, ngaytao, quyen);
		Transaction t = session.beginTransaction();
		try {
			session.save(nguoidung);
			t.commit();
			httpSession.setAttribute("nguoidung", nguoidung);
			
			Cookie cktdn = new Cookie("cktdn", nguoidung.getTendangnhap());
			cktdn.setPath("/");
			response.addCookie(cktdn);
			httpSession.setAttribute("tdn", cktdn.getValue());
			return"redirect:trang-chu.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Ä�Äƒng kÃ½ tháº¥t báº¡i !");
		}finally {
			session.close();
		}
		return "register";
	}
	//Check trÃ¹ng tÃªn Ä‘Äƒng nháº­p
	@RequestMapping(value="kt-trung-tendangnhap",method = RequestMethod.GET)
	public @ResponseBody String ktTrungTendangnhap(@RequestParam("tendangnhap") String tendangnhap,
			HttpServletResponse response,
			HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();
		
		String hql="FROM NguoiDung nd WHERE nd.tendangnhap =:tendangnhap";
		Query query = session.createQuery(hql);
		query.setParameter("tendangnhap", tendangnhap);
		
		NguoiDung nd= (NguoiDung) query.uniqueResult();
		
		if(nd!=null){
			return "false";
		}else{
			return "true";
		}
	}
	//Check trÃ¹ng email
		@RequestMapping(value="kt-trung-email",method = RequestMethod.GET)
		public @ResponseBody String ktTrungEmail(@RequestParam("email") String email,
				@RequestParam(value="tdn", defaultValue="null",required=false) String tdn,
				HttpServletResponse response,
				HttpServletRequest request){
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setCharacterEncoding("UTF-8");
			Session session = factory.getCurrentSession();
			
			String hql="FROM NguoiDung nd WHERE nd.email =:email";
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			
			NguoiDung nd= (NguoiDung) query.uniqueResult();
			
			
			if(nd!=null){
				try{
				if(nd.getTendangnhap().equals(tdn)){
					return "true";
				}
				}catch(Exception e){
					System.out.println("ERROR! "+e.toString());
					return "true";
				}
				return "false";
			}else{
				return "true";
			}
		}
}
