package com.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.DanhGiaDAO;
import com.dao.NhaHangDAO;
import com.dao.ProvinceDAO;
import com.entity.BaiViet;
import com.entity.KhuyenMai;
import com.entity.NguoiDung;
import com.entity.NhaHang;

@Controller
public class HomePageController {
	@Autowired
	private ProvinceDAO provinceDAO;
	@Autowired
	private DanhGiaDAO danhgiaDAO;
	@Autowired
	private NhaHangDAO nhahangDAO;
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("trang-chu")
	public String index(ModelMap model) {
		model.addAttribute("dropdown_province", this.provinceDAO.getByNhaHang());
		/*model.addAttribute("nguoidung", new NguoiDung());*/
		return "homepage/trangchu/index";
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
		return"homepage/chitietnhahang/chitietnhahang";
	}
	
	@RequestMapping("timkiem")
	public String timkiem(ModelMap model){
		model.addAttribute("nguoidung", new NguoiDung());
		return"homepage/timkiemnhahang/ketquatimkiem";
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
		
		
		return"homepage/khuyenmai";
	}
	@RequestMapping("baiviet")
	public String baiviet(ModelMap model){
		
		Session session = factory.openSession();		
		String hql ="FROM BaiViet where trangthai=1 ORDER BY ngaytao DESC";
		Query query = session.createQuery(hql);		

		
		@SuppressWarnings("unchecked")
		List<BaiViet> list = query.list();		
		
		model.addAttribute("bv", list);
		
		
		return"homepage/baiviet";
	}
	@RequestMapping("chitietbaiviet")
	public String ctbv(ModelMap model,@RequestParam("idbv")int idbc){
		
		Session session = factory.openSession();		
		BaiViet bv = (BaiViet) session.get(BaiViet.class, idbc)	;
		String hql ="FROM BaiViet where trangthai=1 ORDER BY ngaytao DESC";
		Query query = session.createQuery(hql);		

		
		@SuppressWarnings("unchecked")
		List<BaiViet> list = query.list();		
		
		model.addAttribute("bv", list);
		model.addAttribute("ctbv", bv);
		
		
		return"homepage/chitietbaiviet";
	}
}

