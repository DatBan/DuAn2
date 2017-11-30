package com.controller;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.BanAnDAO;
import com.dao.HoaDonDAO;
import com.dao.MonAnDAO;
import com.dao.NhaHangDAO;
import com.entity.BanAn;
import com.entity.HoaDon;
import com.entity.MonAn;
import com.entity.NhaHang;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class SearchController {
	@Autowired
	private BanAnDAO bananDAO;
	@Autowired
	private NhaHangDAO nhahangDAO;
	@Autowired
	private HoaDonDAO hoadonDAO;
	@Autowired
	private MonAnDAO monanDAO;

	@RequestMapping("tim-kiem")
	public String index(@RequestParam(value="search", required=false, defaultValue="") String tenNH,
			/*@RequestParam("thoigian") String thoigian,*/
			@RequestParam("ngaythang") String ngaythang,
			@RequestParam("songuoi") String songuoi,
			ModelMap model) throws ParseException{
		int trang = 0;
		String sapXep = "DESC", paramSX = "nh.id";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		Date ngaythang2 = new Date();
		ngaythang2 = sdf.parse(ngaythang);
		System.out.println("sdf2 "+sdf2.format(ngaythang2));
		
		System.out.println("ngaythang "+ngaythang);
		System.out.println("ngaythang2 "+ngaythang2);
		List<BanAn> listba = this.bananDAO.getListBySoNguoiAndTenNhaHang(songuoi, tenNH);
		System.out.println("listba "+listba.size());
		NhaHang nh = new NhaHang();
		List<HoaDon> listhd = new ArrayList<>();
		List<BanAn> listbaById = new ArrayList<>();
		Collection<Integer> idl = new ArrayList<Integer>();
		if(listba.size() > 0){
			for (int i = 0; i < listba.size(); i++) {
				nh = listba.get(i).getNhahang();
				listbaById = this.bananDAO.getListBySoNguoiAndIdNhaHang(songuoi, nh.getId()+"");
				System.out.println("idnh " +nh.getId());
				listhd = this.hoadonDAO.getListByDateAndTenNhaHang(nh.getId()+"", ngaythang2, songuoi);
				System.out.println("listhd "+listhd.size());
				if(listhd.size() < listbaById.size()){
					System.out.println("De xuat" +nh.getId());
					idl.add(nh.getId());
				}
			}
		}
		idl.add(0);
		System.out.println(idl);
		List<NhaHang> list = this.nhahangDAO.getListByListID(idl, trang, sapXep, paramSX);
		List<NhaHang> sumList = this.nhahangDAO.getSumListByListID(idl);
		int sumRecords = sumList.size();
		model.addAttribute("listsize", sumRecords);
		model.addAttribute("ngaythang", ngaythang);
		model.addAttribute("songuoi", songuoi);
		model.addAttribute("tukhoa", tenNH);
		model.addAttribute("listnh", list);
		return "homepage/timkiemnhahang/ketquatimkiem";
	}
	
	@RequestMapping(value="tim-kiem-ajax", method=RequestMethod.POST)
	public @ResponseBody void index(
			@RequestParam(value="trang", required=false, defaultValue="1") int trang,
			@RequestParam(value="sapxep", defaultValue="new", required=false) String sapXep,
			@RequestParam(value="search", required=false, defaultValue="") String tenNH,
			/*@RequestParam("thoigian") String thoigian,*/
			@RequestParam("ngaythang") String ngaythang,
			@RequestParam("songuoi") String songuoi,
			ModelMap model,
			HttpServletResponse response) throws ParseException, IOException{
		String rong = "sai", sorted = "DESC", thuoctinh = "nh.id";
		
		if(sapXep.equals("old")){
			System.out.println("old");
			sorted = "ASC";
		}else if(sapXep.equals("popular")){
			System.out.println("popular");
			thuoctinh = "nh.countinvoice";
			sorted = "DESC";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		Date ngaythang2 = new Date();
		ngaythang2 = sdf.parse(ngaythang);
		System.out.println("sdf2 "+sdf2.format(ngaythang2));
		
		System.out.println("ngaythang "+ngaythang);
		System.out.println("ngaythang2 "+ngaythang2);
		List<BanAn> listba = this.bananDAO.getListBySoNguoiAndTenNhaHang(songuoi, tenNH);
		System.out.println("listba "+listba.size());
		NhaHang nh = new NhaHang();
		List<HoaDon> listhd = new ArrayList<>();
		List<BanAn> listbaById = new ArrayList<>();
		Collection<Integer> idl = new ArrayList<Integer>();
		if(listba.size() > 0){
			for (int i = 0; i < listba.size(); i++) {
				nh = listba.get(i).getNhahang();
				listbaById = this.bananDAO.getListBySoNguoiAndIdNhaHang(songuoi, nh.getId()+"");
				System.out.println("idnh " +nh.getId());
				listhd = this.hoadonDAO.getListByDateAndTenNhaHang(nh.getId()+"", ngaythang2, songuoi);
				System.out.println("listhd "+listhd.size());
				if(listhd.size() < listbaById.size()){
					System.out.println("De xuat" +nh.getId());
					idl.add(nh.getId());
				}
			}
		}
		idl.add(0);
		System.out.println(idl);
		
		int pageCount = 0, sumRecords = 0, perPage = 8;
		List<NhaHang> list = this.nhahangDAO.getListByListID(idl, trang, sorted, thuoctinh);
		List<NhaHang> sumList = this.nhahangDAO.getSumListByListID(idl);
		sumRecords = sumList.size();
		pageCount = sumRecords / perPage + (sumRecords % perPage > 0 ? 1 : 0);
		
		System.out.println("sumrecord "+ sumRecords+" pagecount "+pageCount);
		/*model.addAttribute("listsize", list.size());
		model.addAttribute("tukhoa", tenNH);
		model.addAttribute("listnh", list);*/
		NhaHang nh2 = new NhaHang();
		String strListNH = "";
		
		for (int i = 0; i < list.size(); i++) {
			nh2 = list.get(i);
			strListNH += "<div class='col-md-3'>";
			strListNH += 	"<div class='row'>";
			strListNH += 		"<a class='linknhgiamgia' href='"+nh2.getId()+"'>";
			strListNH += 			"<img class='hinhgiamgia' src='images/baochau.png' />";
			strListNH += 		"</a>";
			strListNH += 	"</div>";
			strListNH += 	"<div class='row text-center giantoptennh'>";
			strListNH += 		"<a href='"+nh2.getId()+"'><span class='tennhgiamgia'>"+nh2.getTennhahang()+"</span></a>";
			strListNH += 	"</div>";
			strListNH += 	"<div class='row text-center'>";
			strListNH += 		"<div class='col-md-1'></div>";
			strListNH += 		"<div class='col-md-10'>";
			strListNH += 			"<a href='"+nh2.getId()+"'>";
			strListNH += 				"<span class='diachinhgiamgia'>";
			strListNH += 					""+nh2.getDiachifull()+"";
			strListNH += 				"</span>";
			strListNH += 			"</a>";
			strListNH += 		"</div>";
			strListNH += 		"<div class='col-md-1'></div>";
			strListNH += 	"</div>";
			strListNH += "</div>";
		}
		Gson gson = new Gson();
		String trave = gson.toJson(strListNH);
		String trangthai = "in";
		/*System.out.println(trave);*/
		if(pageCount <= trang){
			trangthai = "out";
		}
		String chuoi = gson.toJson(trangthai);
		response.getWriter().print("{\"trave\":"+trave+",\"chuoi\":"+chuoi+", \"rong\":"+gson.toJson(rong)+", \"pagecount\":\""+pageCount+"\"}");
		/*return "homepage/timkiemnhahang/ketquatimkiem";*/
	}

	@RequestMapping(value = "search-autocomplete-ajax", method = RequestMethod.POST)
	public @ResponseBody void ajax_timkiem(
			@RequestParam(value = "search", required = false, defaultValue = "") String search,
			HttpServletResponse response) throws IOException, InterruptedException {
		Thread.sleep(500);
		List<NhaHang> list = nhahangDAO.getListByTenNhaHang(search);

		List<MonAn> listMA = this.monanDAO.getListByTenmonan(search);

		response.setContentType("text/html; charset=utf-8");
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.create();
		/*Gson gson = new Gson();*/
		String nhahang = gson.toJson(list);
		String monan = gson.toJson(listMA);
		/*
		 * String strTrave = ""; for (int i = 0; i < list.size(); i++) {
		 * strTrave += list.get(i).getId()+":"+list.get(i).getTennhahang()+",";
		 * }
		 */
		/* System.out.println(trave); */
		response.getWriter().print("{\"nhahang\": " + nhahang + ", \"monan\": " + monan
				+ ", \"showmore\": [{\"tennhahang\": \"" + search + "\", \"showmore\": \"dungvay\"}]}");
		// return trave;
	}
}
