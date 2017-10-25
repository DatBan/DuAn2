package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("dashboard/")
@Controller
public class DashboardController {
	@RequestMapping("index")
	public String dashboardIndex() {
		return "dashboard/dashboard";
	}
}
