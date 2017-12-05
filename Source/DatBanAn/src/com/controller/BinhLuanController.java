package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.BaiVietDAO;
import com.dao.BinhLuanDAO;
import com.dao.NguoiDungDAO;
import com.entity.BaiViet;
import com.entity.BinhLuan;
import com.entity.NguoiDung;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("binh-luan")
public class BinhLuanController {
	@Autowired
	private BinhLuanDAO binhluanDAO;
	@Autowired
	private BaiVietDAO baivietDAO;
	@Autowired
	private NguoiDungDAO nguoidungDAO;
	@Autowired
	private SessionFactory factory;

	@RequestMapping("")
	public @ResponseBody void createBinhLuan(HttpSession httpSession,
			HttpServletResponse response,
			@RequestParam("idbaiviet") int idbv,
			@RequestParam("noidung") String noidung) throws IOException{
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		
		BaiViet bv = this.baivietDAO.getById(idbv);
		
		BinhLuan blm = new BinhLuan(noidung, 1, new Date(), nd, bv);
		
		this.binhluanDAO.createBinhLuan(blm);
		BinhLuan bl = this.binhluanDAO.getById(blm.getIdbinhluan());
		String strBL = "";
		strBL += "<div class='media'>";
		strBL += 	"<div class='media-left'>";
		strBL += 		"<img src='images/userdg.png' class='media-object' style='width: 45px'>";
		strBL += 	"</div>";
		strBL += 	"<div class='media-body'>";
		strBL += 		"<h4 class='media-heading'>";
		strBL += 		"<input type='hidden' class='ngaytao"+bl.getIdbinhluan()+"' value='"+bl.getNgaytao()+"' />";
		strBL+= 		bl.getNguoibl().getHoTen()+" <small><i>Posted on <span class='display-ngaytao"+bl.getIdbinhluan()+"'>"+bl.getNgaytao()+"<span></i></small>";
		strBL += 		"</h4>";
		strBL += 		"<p>"+bl.getNoidung()+"</p>";
		strBL += 		"<a href='javascript:;' data-toggle='collapse' data-target='#reply"+bl.getIdbinhluan()+"'>Trả lời</a>&nbsp;";
		strBL += 		"<a href='#'> Thích</a>&nbsp;&nbsp;";
		strBL += 		"<a href='#' class='fa fa-flag'></a><br />";
		strBL += 		"<div id='reply"+bl.getIdbinhluan()+"' class='collapse'>";
		strBL += 			"........";
		strBL += 		"</div>";
		strBL += 	"</div>";
		strBL += 	"<div class='media-right'>";
		strBL += 		"<div class='dropdown'>";
		strBL += 			"<a href='javascript:;' class='fa fa-ellipsis-v' data-toggle='dropdown'></a>";
		strBL += 			"<ul class='dropdown-menu'>";
		strBL += 				"<li><a href='#'>Chỉnh sửa</a></li>";
		strBL += 				"<li><a href='#'>Xóa</a></li>";
		strBL += 			"</ul>";
		strBL += 		"</div>";
		strBL += 	"</div>";
		strBL += "</div>";
		strBL += "<script>";
		strBL += 	"$(document).ready(function(){";
		strBL +=		"var day = moment($('.ngaytao"+bl.getIdbinhluan()+"').val());";
		strBL +=		"$('.display-ngaytao"+bl.getIdbinhluan()+"').html(day.fromNow());";
		strBL += 	"});";
		strBL +="</script>" ;
		
		Gson gson = new Gson();
		String strGson = gson.toJson(strBL);
		response.getWriter().print("{\"blmoi\":"+strGson+", \"idm\":"+bl.getIdbinhluan()+"}");
	}
	
	@RequestMapping(value="/load-ajax", method=RequestMethod.POST)
	public @ResponseBody void loadBinhLuan(HttpSession httpSession,
			HttpServletResponse response,
			@RequestParam("idbv") int idbv,
			@RequestParam("trang") int trang,
			@RequestParam("idmoi[]") List<Integer> idmoi,
			@RequestParam("sapxep") String sapxep) throws IOException{
		
		System.out.println("idmoi "+idmoi+" size "+idmoi.size()+" 1 "+ idmoi.get(0));
		int pageCount = 0, perPage = 1, idnho = 0;
		String rong = "sai", paramsx = "bl.ngaytao";
		if(sapxep.equals("popular")){
			sapxep = "DESC";
			paramsx = "bl.soluonglike";
		}
		try{
			idnho = this.binhluanDAO.getMaxByIdBaiViet(idbv);
		}catch(NullPointerException e){
			rong = "dung";
			System.out.println("RONG " +e.toString());
		}
		if(idmoi.size() > 1){
			System.out.println("tru "+(idmoi.get(1) - 1));
			idnho = (idmoi.get(1) - 1);
		}
		System.out.println("idnho "+idnho);
		List<BinhLuan> lbl = this.binhluanDAO.getByIdBaiViet(idbv, trang, sapxep, paramsx, idnho);	
		Long sumRecords = this.binhluanDAO.getSizeByIdBaiViet(idbv);
		pageCount = (int) (sumRecords / perPage + (sumRecords % perPage > 0 ? 1 : 0));
		System.out.println("size "+sumRecords+" pagecount "+pageCount+" trang "+trang);
		System.out.println(lbl);
		
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.create();
		String strLbl = "";
		for (BinhLuan bl: lbl) {
			strLbl += "<div class='media'>";
			strLbl += 	"<div class='media-left'>";
			strLbl += 		"<img src='images/userdg.png' class='media-object' style='width: 45px'>";
			strLbl += 	"</div>";
			strLbl += 	"<div class='media-body'>";
			strLbl += 		"<h4 class='media-heading'>";
			strLbl += 		"<input type='hidden' class='ngaytao"+bl.getIdbinhluan()+"' value='"+bl.getNgaytao()+"' />";
			strLbl+= 		bl.getNguoibl().getHoTen()+" <small><i>Posted on <span class='display-ngaytao"+bl.getIdbinhluan()+"'>"+bl.getNgaytao()+"<span></i></small>";
			strLbl += 		"</h4>";
			strLbl += 		"<p>"+bl.getNoidung()+"</p>";
			strLbl += 		"<a href='javascript:;' data-toggle='collapse' data-target='#reply"+bl.getIdbinhluan()+"'>Trả lời</a>&nbsp;";
			strLbl += 		"<a href='#'> Thích</a>&nbsp;&nbsp;";
			strLbl += 		"<a href='#' class='fa fa-flag'></a><br />";
			strLbl += 		"<div id='reply"+bl.getIdbinhluan()+"' class='collapse'>";
			strLbl += 			"........";
			strLbl += 		"</div>";
			if(bl.getBlcap().size() > 0){
				strLbl += 		"<a  style='cursor: pointer;' class='load-reply' data-bl='"+bl.getIdbinhluan()+"'><i class='fa fa-chevron-down'></i> Xem "+bl.getBlcap().size()+" câu trả lời</a>";
				strLbl += 		"<div class='cmts-reply"+bl.getIdbinhluan()+" collapse'><br/>";
				strLbl += 		"</div>";
			}
			strLbl += 	"</div>";
			strLbl += 	"<div class='media-right'>";
			strLbl += 		"<div class='dropdown'>";
			strLbl += 			"<a href='javascript:;' class='fa fa-ellipsis-v' data-toggle='dropdown'></a>";
			strLbl += 			"<ul class='dropdown-menu'>";
			strLbl += 				"<li><a href='#'>Chỉnh sửa</a></li>";
			strLbl += 				"<li><a href='#'>Xóa</a></li>";
			strLbl += 			"</ul>";
			strLbl += 		"</div>";
			strLbl += 	"</div>";
			strLbl += "</div>";
			strLbl += "<script>";
			strLbl += 	"$(document).ready(function(){";
			strLbl +=		"var day = moment($('.ngaytao"+bl.getIdbinhluan()+"').val());";
			strLbl +=		"$('.display-ngaytao"+bl.getIdbinhluan()+"').html(day.fromNow());";
			strLbl += 	"});";
			strLbl +="</script>" ;
		}
		String trangthai = "in";
		if(idmoi.size() >  1){
			pageCount = pageCount - 1;
		}
		if(pageCount <= trang){
			trangthai = "out";
		}
		String chuoi = gson.toJson(trangthai);
		String gsonLbl = gson.toJson(strLbl);
		response.getWriter().print("{\"trave\":"+gsonLbl+", \"chuoi\":"+chuoi+", \"rong\":"+gson.toJson(rong)+", \"pagecount\":\""+pageCount+"\"}");
	}
	
	@RequestMapping(value="/load-reply-ajax", method=RequestMethod.POST)
	public @ResponseBody void loadBinhLuan_reply(HttpSession httpSession,
			HttpServletResponse response,
			@RequestParam("idbl") int idbl) throws IOException{
		
		List<BinhLuan> lbl = this.binhluanDAO.getByIdCha(idbl);
		System.out.println(lbl);
		
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.create();
		String strLbl = "";
		for (BinhLuan bl: lbl) {
			strLbl += "<div class='media'>";
			strLbl += 	"<div class='media-left'>";
			strLbl += 		"<img src='images/userdg.png' class='media-object' style='width: 45px'>";
			strLbl += 	"</div>";
			strLbl += 	"<div class='media-body'>";
			strLbl += 		"<h4 class='media-heading'>";
			strLbl += 		"<input type='hidden' class='ngaytao"+bl.getIdbinhluan()+"' value='"+bl.getNgaytao()+"' />";
			strLbl+= 		bl.getNguoibl().getHoTen()+" <small><i>Posted on <span class='display-ngaytao"+bl.getIdbinhluan()+"'>"+bl.getNgaytao()+"<span></i></small>";
			strLbl += 		"</h4>";
			strLbl += 		"<p>"+bl.getNoidung()+"</p>";
			strLbl += 		"<a href='javascript:;' data-toggle='collapse' data-target='#reply"+bl.getIdbinhluan()+"'>Trả lời</a>&nbsp;";
			strLbl += 		"<a href='#'> Thích</a>&nbsp;&nbsp;";
			strLbl += 		"<a href='#' class='fa fa-flag'></a><br />";
			strLbl += 		"<div id='reply"+bl.getIdbinhluan()+"' class='collapse'>";
			strLbl += 			"........";
			strLbl += 		"</div>";
			strLbl += 	"</div>";
			strLbl += 	"<div class='media-right'>";
			strLbl += 		"<div class='dropdown'>";
			strLbl += 			"<a href='javascript:;' class='fa fa-ellipsis-v' data-toggle='dropdown'></a>";
			strLbl += 			"<ul class='dropdown-menu'>";
			strLbl += 				"<li><a href='#'>Chỉnh sửa</a></li>";
			strLbl += 				"<li><a href='#'>Xóa</a></li>";
			strLbl += 			"</ul>";
			strLbl += 		"</div>";
			strLbl += 	"</div>";
			strLbl += "</div>";
			strLbl += "<script>";
			strLbl += 	"$(document).ready(function(){";
			strLbl +=		"var day = moment($('.ngaytao"+bl.getIdbinhluan()+"').val());";
			strLbl +=		"$('.display-ngaytao"+bl.getIdbinhluan()+"').html(day.fromNow());";
			strLbl += 	"});";
			strLbl +="</script>" ;
		}
		String gsonLbl = gson.toJson(strLbl);
		response.getWriter().print("{\"trave\":"+gsonLbl+"}");
	}

	@RequestMapping("traloi")
	public String traloi(ModelMap model, @RequestParam("traloi") String noidung,
			@RequestParam("idbaiviet") int idbaiviet, @RequestParam("idbinhluan") int id,
			@RequestParam("iduser") int iduser, @Validated @ModelAttribute("loi") BinhLuan bll, BindingResult errors) {
		Session session = factory.openSession();
		NguoiDung nguoidung = (NguoiDung) session.get(NguoiDung.class, iduser);
		BaiViet baiviet = (BaiViet) session.get(BaiViet.class, idbaiviet);
		BinhLuan bl = (BinhLuan) session.get(BinhLuan.class, id);
		Transaction t = null;
		try {
			BinhLuan binhluan = new BinhLuan(nguoidung, baiviet, bl);
			session.save(binhluan);
			/* t.commit(); */
		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}
		return "redirect:/baiviet/chitiet/" + idbaiviet + ".htm";
	}
}
