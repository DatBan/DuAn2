package com.services;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailer")
public class Mailer {
	@Autowired
	JavaMailSender mailer;

	public void send( String to, String subject, String body) {
		String from = "DatBan@datban.com.vn";
	
		MimeMessage mail = mailer.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail);
		try {
			helper.setFrom(from,from);
		
		helper.setTo(to);
		helper.setReplyTo(from,from);
		helper.setSubject(subject);
		helper.setText(body,true);
		mailer.send(mail);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
