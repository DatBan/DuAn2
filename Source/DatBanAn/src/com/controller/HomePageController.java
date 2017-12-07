package com.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.BaiVietDAO;
import com.dao.DanhGiaDAO;
import com.dao.KhuyenMaiDAO;
import com.dao.NhaHangDAO;
import com.dao.ProvinceDAO;
import com.entity.BaiViet;
import com.entity.KhuyenMai;
import com.entity.NguoiDung;
import com.entity.NhaHang;

@Controller
public class HomePageController {
	@Autowired
	private KhuyenMaiDAO khuyenmaiDAO;
	@Autowired
	private BaiVietDAO baivietDAO;
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
	@RequestMapping("/{tinhthanh}/{slug}-r{idnh}")
	public String ctnh(ModelMap model,
			@PathVariable("idnh") int idnh){
		System.out.println("zozooz");
		NhaHang nh = this.nhahangDAO.getById(idnh);
		String provinceid = nh.getTinhthanh().getProvinceid();
		
		model.addAttribute("km", this.khuyenmaiDAO.getByIdNhaHang(idnh));
		model.addAttribute("nhlienquan", this.nhahangDAO.getListByProvinceId(provinceid, idnh));
		model.addAttribute("ctnhahang", nh);
		/*model.addAttribute("listDG", listDG);*/
		model.addAttribute("nguoidung", new NguoiDung());
		return"homepage/chitietnhahang/chitietnhahang";
	}
	
	@RequestMapping("timkiem")
	public String timkiem(ModelMap model){
		model.addAttribute("nguoidung", new NguoiDung());
		return"homepage/timkiemnhahang/ketquatimkiem";
	}
	
	@RequestMapping("{tinhthanh}/nha-hang-khuyen-mai")
	public String khuyenmai(ModelMap model,
			@PathVariable("tinhthanh") String tinhthanh){
		/*List<DanhGia> listDG = this.danhgiaDAO.getListDanhGiaByIdNhaHang(1, 2);*/
				
		
		model.addAttribute("km", this.khuyenmaiDAO.getByProvinceSlug(tinhthanh));
		model.addAttribute("tinh-thanhs", tinhthanh);
		
		
		return"homepage/khuyenmai";
	}
	@RequestMapping("bai-viet")
	public String baiviet(ModelMap model){
		
		Session session = factory.openSession();		
		String hql ="FROM BaiViet where trangthai=1 ORDER BY ngaytao DESC";
		Query query = session.createQuery(hql);		
		
		@SuppressWarnings("unchecked")
		List<BaiViet> list = query.list();		
		
		model.addAttribute("bv", list);
		
		
		return"homepage/baiviet";
	}
	@RequestMapping("bai-viet/{slug}-p{id}")
	public String ctbv(ModelMap model,
			@PathVariable("id") int id){
		BaiViet bv = this.baivietDAO.getById(id);
		
		Session session = factory.openSession();		
		String hql ="FROM BaiViet where trangthai=1 ORDER BY ngaytao DESC";
		Query query = session.createQuery(hql);		

		
		@SuppressWarnings("unchecked")
		List<BaiViet> list = query.list();		
		
		model.addAttribute("bv", list);
		model.addAttribute("ctbv", bv);
		
		
		return"homepage/chitietbaiviet/chitietbaiviet";
	}
}

