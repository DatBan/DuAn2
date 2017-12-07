package com.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.KhuyenMaiDAO;
import com.dao.NhaHangDAO;
import com.dao.ProvinceDAO;
import com.entity.Province;
import com.google.gson.Gson;

import javassist.NotFoundException;

@Controller
public class LoadHomepage {
	@Autowired
	private NhaHangDAO nhahangDAO;
	@Autowired
	private KhuyenMaiDAO khuyenmaiDAO;
	@Autowired
	private ProvinceDAO provinceDAO;
	
	@RequestMapping("load-by-provinceid")
	public @ResponseBody void getByProvinceId(HttpServletResponse response,
			@RequestParam("provinceid") String provinceid) throws IOException {
		Province lProvince = this.provinceDAO.getById(provinceid);
		Gson gson = new Gson();
		String province = gson.toJson(lProvince);
		response.getWriter().println(province);
	}
	
	@RequestMapping("/{slug}")
	public String index(ModelMap model,
			@PathVariable("slug") String provinceslug,
			HttpServletResponse response,
			HttpSession httpSession){
		Province pv = this.provinceDAO.getBySlug(provinceslug);
		
		Cookie p_slug = new Cookie("province_slug", provinceslug);
		p_slug.setMaxAge(60 * 60 * 24 * 365);
		p_slug.setPath("/DatBanAn");
		response.addCookie(p_slug);
		
		httpSession.setAttribute("current_province", p_slug.getValue());
		if(pv == null){
			return "redirect:/error";
		}
		/*if(false == false) throw new NullPointerException();*/
		model.addAttribute("recommend", this.nhahangDAO.getListByMostRating(provinceslug));
		Collection<Integer> listid = this.khuyenmaiDAO.getByIdNhaHang();
		model.addAttribute("promotion_nh", this.nhahangDAO.getListByPromotion(listid, provinceslug));
		model.addAttribute("best_book", this.nhahangDAO.getListByProvinceSlug(provinceslug));
		return "homepage/trangchu/index";
	}
	
	@RequestMapping("redirect-trangchu")
	public String redirect_trangchu(ModelMap model,
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession httpSession){
		
		List<Object[]> listprovince = this.provinceDAO.getByNhaHang();
		Object[] macdinh = listprovince.get(0);
		String provinceslug = macdinh[0]+"";
		if (request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
				if(c.getName().equals("province_slug")){
					if(!c.getValue().equals("")) {
						provinceslug = c.getValue();
					}
				}
			}
		}
		return "redirect:/"+provinceslug+".html";
	}
}
