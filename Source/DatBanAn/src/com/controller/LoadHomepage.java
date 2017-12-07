package com.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

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
	
	@RequestMapping("quan-an-{id}")
	public String index(ModelMap model,
			@PathVariable("id") String provinceslug) {
		System.out.println("zozo ozo zo ");
		Collection<Integer> listid = this.khuyenmaiDAO.getByIdNhaHang();
		
		model.addAttribute("promotion_nh", this.nhahangDAO.getListByPromotion(listid, provinceslug+""));
		
		System.out.println("size "+this.nhahangDAO.getListByProvinceSlug(provinceslug+"").size());
		model.addAttribute("best_book", this.nhahangDAO.getListByProvinceSlug(provinceslug+""));
		model.addAttribute("current_province", provinceslug);
		return "homepage/trangchu/index";
	}
}
