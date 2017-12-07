package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.ProvinceDAO;
import com.entity.Province;
import com.google.gson.Gson;

@Controller
public class LocationController {
	@Autowired
	private ProvinceDAO provinceDAO;
	
	@RequestMapping(value="location/switch", method=RequestMethod.POST)
	public @ResponseBody void switch_location(HttpServletResponse response, 
			HttpSession httpSession,
			HttpServletRequest request,
			@RequestParam("thanhpho") String provinceName) throws IOException{
		System.out.println(request.getContextPath());
		String status = "ko";
		String status_ck = "ko";
		String provinceslug = "nono";
		List<Object[]> lpv = this.provinceDAO.getByNhaHang();
		
		for(Object[] pv: lpv){
			System.out.println(pv[0]);
			if(provinceName.equals(pv[1])){
				status = "co";
				provinceslug = pv[0]+"";
				
				Cookie p_slug = new Cookie("write_province", "1");
				p_slug.setMaxAge(60 * 60 * 24 * 365);
				/*p_slug.setPath("/DatBanAn");*/
				response.addCookie(p_slug);
				
				break;
			}
		}
		if (request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
				if(c.getName().equals("province_slug")){
					if(c.getValue().equals(provinceslug)) {
						System.out.println(c.getValue());
						status = "written";
					}
				}else if(c.getName().equals("write_province")){
					if(c.getValue().equals("1")){
						status_ck = "daghi";
					}
				}
			}
		}
		System.out.println(provinceslug);
		Gson gson = new Gson();
		String json = gson.toJson(status);
		response.getWriter().print("{\"status\":"+json+", \"provinceslug\":"+gson.toJson(provinceslug)+", \"status_ck\":"+gson.toJson(status_ck)+"}");
	}
	
	@RequestMapping(value="location/remove-cookie", method=RequestMethod.POST)
	public @ResponseBody void remove_cookie_location(HttpServletResponse response, 
			HttpSession httpSession,
			HttpServletRequest request) throws IOException{
		Cookie cktdn = new Cookie("write_province", "");
		cktdn.setMaxAge(0);
		response.addCookie(cktdn);
		/*Cookie ckslug = new Cookie("province_slug", "");
		ckslug.setPath(request.getContextPath());
		ckslug.setMaxAge(0);
		response.addCookie(ckslug);*/
		
		Gson gson = new Gson();
		String json = gson.toJson("OK");
		response.getWriter().print(json);
	}
}
