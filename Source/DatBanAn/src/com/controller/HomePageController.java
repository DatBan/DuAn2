package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.DanhGiaDAO;
import com.dao.NhaHangDAO;
import com.entity.DanhGia;
import com.entity.KhuyenMai;
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.entity.Trang;
import com.google.gson.Gson;

@Controller
public class HomePageController {
	@Autowired
	private DanhGiaDAO danhgiaDAO;
	@Autowired
	private NhaHangDAO nhahangDAO;
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("trang-chu")
	public String index(ModelMap model) {
		model.addAttribute("nguoidung", new NguoiDung());
		return "index";
	}
	@RequestMapping("chitietnhahang")
	public String ctnh(ModelMap model){
		/*List<DanhGia> listDG = this.danhgiaDAO.getListDanhGiaByIdNhaHang(1, 2);*/
		Session session = factory.openSession();
		
		NhaHang nh = this.nhahangDAO.getById(1);
		
		String hql ="FROM KhuyenMai km where trangthai='1' and idnhahang =:idnhahang ";
		Query query = session.createQuery(hql);
		
		query.setParameter("idnhahang", 1);
		@SuppressWarnings("unchecked")
		List<KhuyenMai> list = query.list();
		model.addAttribute("km", list);
		model.addAttribute("ctnhahang", nh);
		System.out.println("khuyeenx mai cua nha hang"+list);
		/*model.addAttribute("listDG", listDG);*/
		model.addAttribute("nguoidung", new NguoiDung());
		return"chitietnhahang";
	}
	
	@RequestMapping("timkiem")
	public String timkiem(ModelMap model){
		model.addAttribute("nguoidung", new NguoiDung());
		return"ketquatimkiem";
	}
	
	@RequestMapping("khuyenmai")
	public String khuyenmai(ModelMap model){
		/*List<DanhGia> listDG = this.danhgiaDAO.getListDanhGiaByIdNhaHang(1, 2);*/
		Session session = factory.openSession();		
		String hql ="FROM KhuyenMai km WHERE km.trangthai='1' GROUP BY km.nhahang.id";
		Query query = session.createQuery(hql);		

		
		@SuppressWarnings("unchecked")
		List<KhuyenMai> listkhuyenmai = query.list();		
		
		model.addAttribute("km", listkhuyenmai);
		
		
		return"khuyenmai";
	}
	
}

