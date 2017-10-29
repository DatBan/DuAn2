package com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.NguoiDung;

@Controller
@Transactional
public class LoginController {
	@Autowired
	SessionFactory factory;

	//Dang nhap vao he thong
	@RequestMapping("login")
	public String login(ModelMap model, 
			@ModelAttribute("nguoidung") NguoiDung nd,
			@RequestParam(value="remember", defaultValue="false", required=false) boolean rememberMe,
			HttpSession httpSession,
			HttpServletResponse response) {
		System.out.println(nd.getTendangnhap());
		Session session = factory.getCurrentSession();
		response.setContentType("text/html");
		
		NguoiDung nd2 = null;
		try {
			String hql = "FROM NguoiDung WHERE tendangnhap=:tdn";
			Query query = session.createQuery(hql);
			query.setParameter("tdn", nd.getTendangnhap());
			nd2 = (NguoiDung) query.uniqueResult();
			if(!nd.getMatkhau().equals(nd2.getMatkhau())){
				System.out.println("sai mk hihi");
				return "index";
			}
			System.out.println(nd2.getHoten());
			
			if(rememberMe){
				Cookie cktdn = new Cookie("cktdn", nd.getTendangnhap());
				cktdn.setPath("/");
				response.addCookie(cktdn);
				httpSession.setAttribute("tdn", cktdn.getValue());
				System.out.println("tru tru "+cktdn.getValue());
			}else{
				httpSession.setAttribute("tdn", nd2.getHoten());
			}
		} catch (NullPointerException e) {
			System.out.println(e.toString());
			return "index";
		}
		/*model.addAttribute("nguoidung", nd2);*/
		return "redirect:/trang-chu.html";
	}
	@RequestMapping("logout")
	public String logout(HttpSession httpSession,
			HttpServletResponse response){
		Cookie cktdn = new Cookie("cktdn", "");
		cktdn.setMaxAge(0);
		response.addCookie(cktdn);
		httpSession.removeAttribute("tdn");
		return "redirect:/trang-chu.html";
	}
}
