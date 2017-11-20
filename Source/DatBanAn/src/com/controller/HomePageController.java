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
		
		String hql ="FROM KhuyenMai where trangthai =:trangthai and idnhahang =:idnhahang";
		Query query = session.createQuery(hql);
		query.setParameter("trangthai", true);
		query.setParameter("idnhahang", 1);
		@SuppressWarnings("unchecked")
		List<KhuyenMai> list = query.list();
		model.addAttribute("km", list);
		model.addAttribute("ctnhahang", nh);
		/*model.addAttribute("listDG", listDG);*/
		model.addAttribute("nguoidung", new NguoiDung());
		return"chitietnhahang";
	}
	
	@RequestMapping("timkiem")
	public String timkiem(ModelMap model){
		model.addAttribute("nguoidung", new NguoiDung());
		return"ketquatimkiem";
	}
	@SuppressWarnings({ "unchecked", "null" })
	@RequestMapping("khuyenmai")
	public String khuyenmai(ModelMap model){
		/*List<DanhGia> listDG = this.danhgiaDAO.getListDanhGiaByIdNhaHang(1, 2);*/
		Session session = factory.openSession();		
		
		String hql ="FROM KhuyenMai where trangthai =:trangthai";
		Query query = session.createQuery(hql);
		query.setParameter("trangthai", true);
		
		
		List<KhuyenMai> list = query.list();
		List<KhuyenMai> listkhuyenmai = null;
		List<NhaHang> listnhahang =null;
		for(int i=0;i<list.size();i++){
			KhuyenMai km = list.get(i);			
			NhaHang nhahang= km.getNhahang();
			listnhahang.add(nhahang);
			/*int idnh= nhahang.getId();
			System.out.println(idnh);
			String hqll ="FROM NhaHang where id =:id";
			Query queryy = session.createQuery(hqll);
			queryy.setParameter("id", idnh);*/
						
			
		}
		for(int i=0;i<listnhahang.size();i++){
			NhaHang nh = listnhahang.get(i);			
			int idnhahang= nh.getId();
			String hqlll ="FROM KhuyenMai where idnhahang =:idnhahang";
			Query queryyy = session.createQuery(hqlll);
			queryyy.setParameter("idnhahang", idnhahang);
			listkhuyenmai =queryyy.list();
			System.out.println("ID nhà hàng là: "+idnhahang);
		}
		model.addAttribute("nh", listnhahang);
		model.addAttribute("km", listkhuyenmai);
		
		/*model.addAttribute("listDG", listDG);*/
		
		return"khuyenmai";
	}
	
}

