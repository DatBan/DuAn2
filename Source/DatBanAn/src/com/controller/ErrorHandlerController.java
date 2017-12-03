package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandlerController {
	@RequestMapping("errors")
	public String error404(HttpServletRequest request,
			ModelMap model) {
		String errorMsg = "";
		int httpErrorcode = getErrorCode(request);
		switch (httpErrorcode) {
			case 400: {
				errorMsg = "Http Error Code: 400. Bad Request";
				break;
			}
			case 401: {
				errorMsg = "Http Error Code: 401. Unauthorized";
				break;
			}
			case 404: {
				errorMsg = "Http Error Code: 404. Resource not found";
				break;
			}
			case 500: {
				errorMsg = "Http Error Code: 500. Internal Server Error";
				break;
			}
		}
		model.addAttribute("errorMsg", errorMsg);
		return "homepage/errorPage";
	}

	public int getErrorCode(HttpServletRequest request) {
		return (Integer) request.getAttribute("javax.servlet.error.status_code");
	}
}
