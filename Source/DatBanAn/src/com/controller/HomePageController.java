package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.NguoiDung;

@Controller
public class HomePageController {
	
	@RequestMapping("trang-chu")
	public String index(ModelMap model) {
		model.addAttribute("nguoidung", new NguoiDung());
		return "index";
	}
	@RequestMapping("chitietnhahang")
	public String ctnh(ModelMap model){
		model.addAttribute("nguoidung", new NguoiDung());
		return"chitietnhahang";
	}
	@RequestMapping("timkiem")
	public String timkiem(ModelMap model){
		model.addAttribute("nguoidung", new NguoiDung());
		return"ketquatimkiem";
	}
	
}

