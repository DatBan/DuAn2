package com.interceptors;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dao.NguoiDungDAO;

@Transactional
public class CheckSessionInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private NguoiDungDAO nguoidungDAO;

	@Autowired
	private SessionFactory factory;

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {
		HttpSession httpSession = request.getSession();
		if (request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("cktdn") && httpSession.getAttribute("nd") == null) {

					httpSession.setAttribute("nd", nguoidungDAO.getByUsername(c.getValue()));

					System.out.println(c.getName() + " " + c.getValue() + " " + c.getMaxAge());
					System.out.println("Gan session");
					System.out.println("co cookie");
				}
			}
		}
		return true;
	}
}
