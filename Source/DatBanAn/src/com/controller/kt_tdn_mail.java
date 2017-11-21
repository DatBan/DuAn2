package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.NguoiDung;

public class kt_tdn_mail {
	
	@Autowired
	SessionFactory factory;
	
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
