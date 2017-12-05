package com.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dao.ProvinceDAO;

public class GlobalInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private ProvinceDAO provinceDAO;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("dropdown_province", this.provinceDAO.getByNhaHang());
		return true;
	}

}
