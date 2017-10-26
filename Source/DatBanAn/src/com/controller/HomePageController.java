package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	@RequestMapping("trang-chu")
	public String index() {
		return "index";
	}
	@RequestMapping("chitietnhahang")
	public String ctnh(){
		return"chitietnhahang";
	}
	@RequestMapping("timkiem")
	public String timkiem(){
		return"ketquatimkiem";
	}
}

