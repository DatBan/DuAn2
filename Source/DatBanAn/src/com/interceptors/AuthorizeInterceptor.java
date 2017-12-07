package com.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.entity.NguoiDung;

public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception{
		System.out.println("AuthorizeInterceptor.preHandle() ==> redirect");
		HttpSession session = request.getSession();
		/*NguoiDung nd = (NguoiDung) session.getAttribute("nd");*/
		if(session.getAttribute("nd") == null){
			System.out.println("AuthorizeInterceptor.preHandle() ==> redirect");
			response.sendRedirect(request.getContextPath()+ "/trang-chu.html");
			return false;
		}/*else if(nd.getQuyennd().getId() != 1){
			response.sendRedirect(request.getContextPath()+ "/trang-chu.html");
			System.out.println("AuthorizeInterceptor.preHandle() ==> redirect");
			return false;
		}*/
		System.out.println("AuthorizeInterceptor.preHandle()");
		return true;
	}
}
