package com.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("{id}")
	public String index(ModelMap model,
			@PathVariable("id") String provinceid) {
		Collection<Integer> listid = this.khuyenmaiDAO.getByIdNhaHang();
		
		model.addAttribute("promotion_nh", this.nhahangDAO.getListByPromotion(listid, provinceid));
		
		model.addAttribute("dropdown_province", this.provinceDAO.getByNhaHang());
		/*model.addAttribute("nguoidung", new NguoiDung());*/
		System.out.println("size "+this.nhahangDAO.getListByProvinceId(provinceid).size());
		model.addAttribute("best_book", this.nhahangDAO.getListByProvinceId(provinceid));
		model.addAttribute("current_province", provinceid);
		return "homepage/trangchu/index";
	}
}
