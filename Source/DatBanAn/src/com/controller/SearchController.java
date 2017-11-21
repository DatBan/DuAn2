package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.MonAnDAO;
import com.dao.NhaHangDAO;
import com.entity.MonAn;
import com.entity.NhaHang;
import com.google.gson.Gson;

@Controller
public class SearchController {
	@Autowired
	private NhaHangDAO nhahangDAO;
	@Autowired
	private MonAnDAO monanDAO;
	
	@RequestMapping("tim-kiem")
	public String index(/*@RequestParam("thoigian") String lele,
			@RequestParam("ohlala") String ohlala*/){
		/*System.out.println(lele);
		System.out.println(ohlala);*/
		return "homepage/timkiemnhahang/ketquatimkiem";
	}
	
	@RequestMapping(value="search-ajax", method=RequestMethod.POST)
	public @ResponseBody void ajax_timkiem(@RequestParam(value="search", required=false, defaultValue="") String search,
			HttpServletResponse response) throws IOException, InterruptedException{
		Thread.sleep(500);
		List<NhaHang> list = nhahangDAO.getListByTenNhaHang(search);
		
		List<MonAn> listMA = this.monanDAO.getListByTenmonan(search);
		
		response.setContentType("text/html; charset=utf-8");
		Gson gson = new Gson();
		String nhahang = gson.toJson(list);
		String monan = gson.toJson(listMA);
		/*String strTrave = "";
		for (int i = 0; i < list.size(); i++) {
			strTrave += list.get(i).getId()+":"+list.get(i).getTennhahang()+",";
		}*/
		/*System.out.println(trave);*/
		response.getWriter().print("{\"nhahang\": "+nhahang+", \"monan\": "+monan+", \"showmore\": [{\"tennhahang\": \""+search+"\", \"showmore\": \"dungvay\"}]}");
//		return trave; 
	}
}
