package com.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.NguoiDung;
import com.services.EnDeCryption;

public class Mail {

	// xac nhan qua mail
	
	@Autowired
	JavaMailSender mailer;
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="=quenmkform",method = RequestMethod.GET)
	public String QuenmkForm() {
		return "register";
	}	
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZzxcvbnmasdfghjklqwertyuiop!@#$%^&*()";
    static Random rnd = new Random();

    String randomString( int len ){
       StringBuilder sb = new StringBuilder( len );
       for( int i = 0; i < len; i++ ) 
          sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
       return sb.toString();
    }
	@RequestMapping("send")
	public String send(ModelMap model, @RequestParam("email") String to,
			 HttpSession httpsession
			) {
		Session session = factory.openSession();
		String from = "moemisakii@gmail.com";
		String pass = randomString(10);
		EnDeCryption cryption = new EnDeCryption("");
		String passmahoa = cryption.encoding(pass);
		String  subject = "Lấy Lại Mật Khẩu";
		String body = "Mật Khẩu Mới :" + pass;
		Transaction t = session.beginTransaction();
		try {
			
			String hql = "from NguoiDung where email=:email";
			Query query = session.createQuery(hql);
			query.setParameter("email", to);

			NguoiDung users = (NguoiDung) query.uniqueResult();
			
			
			// tao mail
			MimeMessage mail = mailer.createMimeMessage();
			// 
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			
			

			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			// gui mial
			mailer.send(mail);
			
				users.setMatkhau(passmahoa);
				session.save(users);
				t.commit();
			
			
			model.addAttribute("message", "gui thanh cong !");
		} catch (Exception ex) {
			model.addAttribute("message", "gui that bai !");
		}
		return "user/quenmk";
	}
	
	//Check tdn co trong db hay ko
			@RequestMapping(value="kt-db-tendangnhap",method = RequestMethod.GET)
			public @ResponseBody String ktDbTendangnhap(@RequestParam("tendangnhap") String tendangnhap,
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
			//Check mail co trong db hay ko
				@RequestMapping(value="kt-db-email",method = RequestMethod.GET)
				public @ResponseBody String ktDbEmail(@RequestParam("email") String email,
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
						return "false";
					
					}else{
						return "true";
						
					}
				}

		
	
}