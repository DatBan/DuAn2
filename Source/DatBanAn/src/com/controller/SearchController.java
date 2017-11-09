package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	@RequestMapping("tim-kiem")
	public String index(@RequestParam("thoigian") String lele,
			@RequestParam("ohlala") String ohlala){
		System.out.println(lele);
		System.out.println(ohlala);
		return "index";
	}
}
