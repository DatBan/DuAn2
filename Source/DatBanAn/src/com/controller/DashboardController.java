package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.NguoiDung;


@RequestMapping("dashboard/")
@Controller
public class DashboardController {
	@RequestMapping("index")
	public String dashboardIndex(ModelMap model) {
		model.addAttribute("nguoidung", new NguoiDung());
		return "dashboard/dashboard";
	}
	
}
