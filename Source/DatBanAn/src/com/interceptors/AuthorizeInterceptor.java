package com.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			response.sendRedirect(request.getContextPath()+ "/trang-chu.html");
			System.out.println("AuthorizeInterceptor.preHandle() ==> redirect");
			return false;
		}
		System.out.println("AuthorizeInterceptor.preHandle()");
		return true;
	}
}
