package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.google.gson.Gson;

@Controller
public class HomePageController {
	@Autowired
	private DanhGiaDAO danhgiaDAO;
	@Autowired
	private NhaHangDAO nhahangDAO;
	
	@RequestMapping("trang-chu")
	public String index(ModelMap model) {
		model.addAttribute("nguoidung", new NguoiDung());
		return "index";
	}
	@RequestMapping("chitietnhahang")
	public String ctnh(ModelMap model){
		/*List<DanhGia> listDG = this.danhgiaDAO.getListDanhGiaByIdNhaHang(1, 2);*/
		NhaHang nh = this.nhahangDAO.getById(1);
		
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
	
}

