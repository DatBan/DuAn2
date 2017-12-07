package com.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("location")
public class Location {
	@RequestMapping(value="/switch", method=RequestMethod.POST)
	public @ResponseBody void switch_location(HttpServletResponse response, 
			HttpSession httpSession,
			@RequestParam("provinceslug") String provinceslug) throws IOException{
		
		Cookie p_slug = new Cookie("province_slug", provinceslug);
		p_slug.setMaxAge(60 * 60 * 24 * 365);
		p_slug.setPath("/DatBanAn");
		response.addCookie(p_slug);
		
		httpSession.setAttribute("current_province", p_slug.getValue());
		Gson gson = new Gson();
		String json = gson.toJson("OK");
		response.getWriter().print(json);
	}
}
