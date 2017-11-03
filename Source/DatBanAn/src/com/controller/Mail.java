package com.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.NguoiDung;
import com.services.EnDeCryption;




public class Mail {

	// xac nhan qua mail
	
	@Autowired
	JavaMailSender mailer;
	@Autowired
	SessionFactory factory;
	
	
	
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
			
				users.setMatkhau(passmahoa);
				session.save(users);
				t.commit();
			
			
			model.addAttribute("message", "Gửi email thành công !");
		} catch (Exception ex) {
			model.addAttribute("message", "Gửi email thất bại !");
		}
		return "user/quenmk";
	}
	

		
	
}