package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.DanhGiaDAO;
import com.entity.DanhGia;
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.google.gson.Gson;

@Controller
@Transactional
public class RatingController {
	@Autowired
	private DanhGiaDAO danhGiaDAO;

	@Autowired
	private SessionFactory factory;

	@RequestMapping(value="danh-gia", method=RequestMethod.GET)
	@ResponseBody
	public void execute(@RequestParam("tieudedg") String tieude,
			@RequestParam("noidungdg") String noidung, 
			@RequestParam("doan") int doan,
			@RequestParam("khong-gian") int khonggian, 
			@RequestParam("giaca") int giaca,
			@RequestParam("phucvu") int phucvu,
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession httpSession) throws InterruptedException, IOException {

		Thread.sleep(1000);
		/*try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		response.setCharacterEncoding("UTF-8");
		response.setContentType("Content-Type: application/json;charset=utf-8");	    
		/*response.setHeader("Content-Type", "text/plain;charset=utf-8");*/
		
		System.out.println(tieude);
		double diemdanhgia = (doan + khonggian + giaca + phucvu) / 4;
		Session session = factory.getCurrentSession();
		
		NguoiDung nd2 = (NguoiDung) httpSession.getAttribute("nd");
		
		NhaHang nh = (NhaHang) session.get(NhaHang.class, 1);
		/*NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, 2);*/
		
		System.out.println(doan+ " " + khonggian + " "+giaca + " " +phucvu+" = "+diemdanhgia);
		 
		DanhGia dg = new DanhGia(tieude, noidung, doan, khonggian, giaca, phucvu, diemdanhgia, true, new Date(), nh,
				nd2);
		 this.danhGiaDAO.createDanhGia(dg); 

		Gson gson = new Gson();
		String trave = gson.toJson(dg);
		response.getWriter().print(trave);
	}
	
	@RequestMapping("list-danh-gia")
	@ResponseBody
	public void loadDanhGia(@RequestParam("trang") int trang,
			@RequestParam("idmoi[]") List<Integer> idmoi,
			@RequestParam(value="sapxep", defaultValue="new", required=false) String sapXep,
			HttpServletResponse response) throws IOException{
		int pageCount = 0, sumRecords = 0, perPage = 10, idNhaHang = 1, idnho = 0;
		String rong = "sai", sorted = "DESC", thuoctinh = "dg.id";
		
		if(sapXep.equals("old")){
			System.out.println("old");
			sorted = "ASC";
		}else if(sapXep.equals("popular")){
			System.out.println("popular");
			thuoctinh = "soluonglike";
			sorted = "DESC";
		}
		System.out.println(sorted + " " + thuoctinh + " " + sapXep);
		try{
			idnho = this.danhGiaDAO.getMaxByIdNhaHang(idNhaHang).getId();
		}catch(NullPointerException e){
			rong = "dung";
			System.out.println("RONG " +e.toString());
			idnho = 0;
		}
		if(idmoi.size() > 1){
			idnho = idmoi.get(1) - 1;
		}
		List<DanhGia> sumList = this.danhGiaDAO.getListDanhGiaByIdNhaHang(idNhaHang);
		sumRecords = sumList.size();
		List<DanhGia> listDG = this.danhGiaDAO.getListDanhGiaByIdNhaHang(idNhaHang, trang, idnho, sorted, thuoctinh);
		pageCount = sumRecords / perPage + (sumRecords % perPage > 0 ? 1 : 0);
		
		System.out.println(pageCount+" " + trang);
		DanhGia dg = null;
		String strListDG = "";
		
		for (int i = 0; i < listDG.size(); i++) {
			dg = listDG.get(i);
			strListDG += 
			"<div class='row'>"+
				"<div class='col-md-12 nddg'>"+
					"<div class='col-md-3' title='"+dg.getDiemdanhgia()+"/5'>"+
						"<select id='tdiem"+dg.getId()+"'>"+
							"<option value='1'>1</option>"+
							"<option value='2'>2</option>"+
							"<option value='3'>3</option>"+
							"<option value='4'>4</option>"+
							"<option value='5'>5</option>"+
						"</select>"+
					"</div>"+
					"<div class='col-md-9'>"+
						"<img src='images/userdg.png' />"
						+ "<input type='hidden' class='gio"+dg.getId()+"' value='"+dg.getNgaytao()+"' /> "
						+ "<span>"+dg.getNguoidanhgia().getHoTen()+"</span>: <span class='ngaytao"+dg.getId()+"'>3 "+
							"phút trước</span>"+
					"</div>"+
				"</div>"+
			"</div>"+
			"<div class='row'>"+
				"<div class='col-md-9 colnddg'>"+
					"<div class='col-md-12 noidungdg'>"+
						"<span>"+dg.getNoidung()+"</span>"+
					"</div>"+
				"</div>"+
				"<div class='col-md-3'>"+
					"<div class='row'>"+
						"<div class='col-md-5'>"+
							"<span>Đồ ăn </span>"+
						"</div>"+
						"<div class='col-md-7'>"+
							"<span>"+dg.getDoan()+"</span>"+
						"</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='col-md-5'>"+
							"<span>Phục vụ </span>"+
						"</div>"+
						"<div class='col-md-7'>"+
							"<span>"+dg.getPhucvu()+"</span>"+
						"</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='col-md-5'>"+
							"<span>Không gian </span>"+
						"</div>"+
						"<div class='col-md-7'>"+
							"<span>"+dg.getKhonggian()+"</span>"+
						"</div>"+
					"</div>"+
					"<div class='row'>"+
						"<div class='col-md-5'>"+
							"<span>Giá cả </span>"+
						"</div>"+
						"<div class='col-md-7'>"+
							"<span>"+dg.getGiaca()+"</span>"+
						"</div>"+
					"</div>"+
				"</div>"+
			"</div>"+
			"<hr/>"+
			"<script>" +
				"$(document).ready(function(){" +
					"var diemddg = "+dg.getDiemdanhgia()+";"+
					"$('#tdiem"+dg.getId()+"').barrating('show',{"+
						"theme: 'fontawesome-stars-o',"+
						"initialRating:diemddg"+
					"}).barrating('readonly', true);"+
				"});"+
				"var day = moment($('.gio"+dg.getId()+"').val());"+
					"$('.ngaytao"+dg.getId()+"').html(day.fromNow());" +
			"</script>" ;
		}
		Gson gson = new Gson();
		String trave = gson.toJson(strListDG);
		String trangthai = "in";
		/*System.out.println(trave);*/
		if(pageCount <= trang){
			trangthai = "out";
		}
		String chuoi = gson.toJson(trangthai);
		response.getWriter().print("{\"trave\":"+trave+",\"chuoi\":"+chuoi+", \"rong\":"+gson.toJson(rong)+", \"pagecount\":\""+pageCount+"\"}");
	}
}
