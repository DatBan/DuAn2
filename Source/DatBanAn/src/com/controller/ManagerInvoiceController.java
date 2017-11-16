package com.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.HoaDon;
@Transactional
@Controller
@RequestMapping("nhahang/quanlydatban")
public class ManagerInvoiceController {
	@Autowired
	SessionFactory factory;
	// Đổ dữ liệu ra trang quản lý
			@RequestMapping(value = "index")
			public String quanLyDatBan(ModelMap model) {
				Session session = factory.getCurrentSession();
				String hql = "FROM HoaDon where idnhahang =:idnhahang";
				Query query = session.createQuery(hql);
				query.setParameter("idnhahang", 1);
				@SuppressWarnings("unchecked")
				List<HoaDon> list = query.list();
				model.addAttribute("hoadon", list);
				model.addAttribute("tenbreadcrumb", "QUẢN LÝ ĐẶT BÀN");
				return "nhahang/quanlydatban";
			}
}
