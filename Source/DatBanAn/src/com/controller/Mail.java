package com.controller;

import java.io.File;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.HoaDon;
import com.entity.NguoiDung;
import com.services.EnDeCryption;

@Controller
@RequestMapping("user/mailer/")
public class Mail {

	@Autowired
	JavaMailSender mailer;
	@Autowired
	SessionFactory factory;

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZzxcvbnmasdfghjklqwertyuiop!@#$%^&*()";
	static Random rnd = new Random();

	String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	@RequestMapping("quenmk")
	public String quenmk(ModelMap model) {

		return "homepage/quenmk";
	}

	@RequestMapping("doimk")
	public String doimk(ModelMap model) {

		return "homepage/doimatkhau";
	}

	@RequestMapping("laylaimk")
	public String send(ModelMap model, @RequestParam("email") String to, RedirectAttributes re,
			HttpSession httpsession) {
		Session session = factory.openSession();
		String from = "thanhlmpk00630@fpt.edu.vn";
		String hql = "from NguoiDung where email=:email";
		Query query = session.createQuery(hql);
		query.setParameter("email", to);

		NguoiDung nd = (NguoiDung) query.uniqueResult();
		EnDeCryption mh = new EnDeCryption("sadasdasdsawqewq");

		String mkmh = mh.decoding(nd.getMatkhau());
		String pass = mkmh;

		String subject = "Lấy Lại Mật Khẩu";
		String body = "Mật Khẩu Mới Của Bạn :" + pass;
		Transaction t = session.beginTransaction();
		try {

			// Tạo mail
			MimeMessage mail = mailer.createMimeMessage();
			// Sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);

			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);

			// Gửi mail
			mailer.send(mail);

			re.addFlashAttribute("message", "Mật khẩu mới đã được gửi tới email của bạn !");
		} catch (Exception ex) {
			model.addAttribute("message", "Gửi email thất bại. Mail Không Có !");
		}
		return "redirect:/user/mailer/doimk.html";
	}

	@RequestMapping(value = "doimaikhau", method = RequestMethod.POST)
	public String UpdateUserPwd(ModelMap model, @RequestParam("taikhoan") String taikhoan,
			@RequestParam("matkhaucu") String matkhaucu, @RequestParam("matkhaumoi") String matkhaumoi,
			RedirectAttributes re) {
		Session session = factory.openSession();

		EnDeCryption mh = new EnDeCryption("sadasdasdsawqewq");
		String mkmh = mh.encoding(matkhaumoi);
		String mkcu = mh.encoding(matkhaucu);
		Transaction t = session.beginTransaction();
		//

		String hql = "FROM NguoiDung  WHERE tendangnhap=:tendangnhap and matkhau=:matkhau";
		Query query = session.createQuery(hql);
		query.setParameter("tendangnhap", taikhoan);
		query.setParameter("matkhau", mkcu);
		
		NguoiDung nd = (NguoiDung) query.uniqueResult();
		System.out.println(mkcu);
		System.out.println(taikhoan);
		System.out.println(nd);
		System.out.println(nd.getTendangnhap());
		try {

			nd.setMatkhau(mkmh);
			session.update(nd);
			t.commit();
			re.addFlashAttribute("message", "Đổi mật khẩu thành công !");

		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			re.addFlashAttribute("message", "Đổi mật khẩu thất bại !");
		} finally {
			session.close();
		}

		return "redirect:/user/mailer/doimk.html";
	}
	/*
	 * @RequestMapping(value="kt-email",method = RequestMethod.GET)
	 * public @ResponseBody String ktemail(@RequestParam("email") String email,
	 * 
	 * HttpServletResponse response, HttpServletRequest request){ try {
	 * request.setCharacterEncoding("UTF-8"); } catch (Exception e) { // TODO:
	 * handle exception } response.setCharacterEncoding("UTF-8"); Session
	 * session = factory.getCurrentSession();
	 * 
	 * String hql="FROM NguoiDung where email =:email"; Query query =
	 * session.createQuery(hql);
	 * 
	 * query.setParameter("email", email);
	 * 
	 * @SuppressWarnings("unchecked") List<HoaDon>list = query.list();
	 * 
	 * if(list.size()>0){ return "true"; }else{ return "false"; } }
	 * 
	 * @RequestMapping(value="kt-tendangnhap",method = RequestMethod.GET)
	 * public @ResponseBody String kttdn(@RequestParam("tendangnhap") String
	 * tdn,
	 * 
	 * HttpServletResponse response, HttpServletRequest request){ try {
	 * request.setCharacterEncoding("UTF-8"); } catch (Exception e) { // TODO:
	 * handle exception } response.setCharacterEncoding("UTF-8"); Session
	 * session = factory.getCurrentSession();
	 * 
	 * String hql="FROM NguoiDung where tendangnhap =:tendangnhap"; Query query
	 * = session.createQuery(hql);
	 * 
	 * query.setParameter("tendangnhap", tdn);
	 * 
	 * @SuppressWarnings("unchecked") List<HoaDon>list = query.list();
	 * 
	 * if(list.size()>0){ return "true"; }else{ return "false";
	 * 
	 * } }
	 */

	// Check trùng tên đăng nhập
	@RequestMapping(value = "kt-tendangnhap", method = RequestMethod.GET)
	public @ResponseBody String ktTrungTendangnhap(@RequestParam("tendangnhap1") String tendangnhap,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.openSession();

		String hql = "FROM NguoiDung  WHERE tendangnhap =:tendangnhap";
		Query query = session.createQuery(hql);
		query.setParameter("tendangnhap", tendangnhap);

		@SuppressWarnings("unchecked")
		List<NguoiDung> list = query.list();

		if (list.size() > 0) {
			return "true";
		} else {
			return "false";
		}
	}
	// Check trùng tên đăng nhập
		@RequestMapping(value = "kt-tendangnhap1", method = RequestMethod.GET)
		public @ResponseBody String tendangnhap1(@RequestParam("taikhoan") String tendangnhap,
				HttpServletResponse response, HttpServletRequest request) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setCharacterEncoding("UTF-8");
			Session session = factory.openSession();

			String hql = "FROM NguoiDung  WHERE tendangnhap =:tendangnhap";
			Query query = session.createQuery(hql);
			query.setParameter("tendangnhap", tendangnhap);

			@SuppressWarnings("unchecked")
			List<NguoiDung> list = query.list();

			if (list.size() > 0) {
				return "true";
			} else {
				return "false";
			}
		}

	// Check trùng email
	@RequestMapping(value = "kt-email", method = RequestMethod.GET)
	public @ResponseBody String ktemail(@RequestParam("email") String email,
			@RequestParam("tendangnhap1") String tendangnhap, HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.openSession();

		String hql = "FROM NguoiDung where email =:email and tendangnhap =:tendangnhap ";
		Query query = session.createQuery(hql);

		query.setParameter("tendangnhap", tendangnhap);
		query.setParameter("email", email);
		NguoiDung hd = (NguoiDung) query.uniqueResult();
		System.out.println(email);
		System.out.println(tendangnhap);
		if (hd != null) {
			return "true";
		} else {
			return "false";
		}
	}
}
