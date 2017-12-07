package com.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.entity.NguoiDung;

public class DashboardInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception{
		HttpSession session = request.getSession();
		NguoiDung nd = null;
		if(session.getAttribute("nd") != null){
			nd = (NguoiDung) session.getAttribute("nd");
			if(nd.getQuyennd().getId() != 1){
				System.out.println("DashboardInterceptor.preHandle() ==> redirect");
				response.sendRedirect(request.getContextPath()+ "/trang-chu.html");
				return false;
			}
		}
		System.out.println("DashboardInterceptor.preHandle() ==> redirect");
		return true;
	}
}
