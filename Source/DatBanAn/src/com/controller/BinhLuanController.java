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
		String symbol = "";
		if(nd.getQuyennd().getId() == 1){
			symbol = "<small class='badge'><i class='fa fa-get-pocket'></i> Admin</small>";
		}
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
		strBL+= 		bl.getNguoibl().getHoTen()+" "+symbol+" <small><i>Posted on <span class='display-ngaytao"+bl.getIdbinhluan()+"'>"+bl.getNgaytao()+"<span></i></small>";
		strBL += 		"</h4>";
		strBL += 		"<p id='noidung-cmt"+bl.getIdbinhluan()+"'>"+bl.getNoidung()+"</p>";
		strBL += 		"<a href='javascript:;' data-toggle='collapse' data-target='#reply"+bl.getIdbinhluan()+"'>Trả lời</a>&nbsp;";
		strBL += 		"<a href='javascript:;'> Thích</a>&nbsp;&nbsp;";
		strBL += 		"<a href='javascript:;' class='fa fa-flag'></a><br />";
		strBL += 		"<div class='cmts-reply"+bl.getIdbinhluan()+" collapse' data-empty='1'>";
		strBL += 		"</div>";
		strBL += 		"<div id='reply"+bl.getIdbinhluan()+"' class='collapse clearfix'>";
		strBL += 			"<form class='reply-cmt'>";
		strBL += 				"<input type='hidden' name='idreply' value='"+bl.getIdbinhluan()+"' />";
		strBL += 				"<div class='form-group col-md-12'>";
		strBL += 					"<textarea rows='1' placeholder='Viết bình luận của bạn' name='noidung' class='form-control'></textarea>";
		strBL += 				"</div>";
		strBL += 				"<div class='form-group col-md-12'>";
		strBL += 					"<button type='button' data-huy='reply"+bl.getIdbinhluan()+"' class='btn btn-default btn-huy'>Hủy</button> ";
		strBL += 					"<button type='submit' class='btn btn-info'>Trả lời</button>";
		strBL += 				"</div>";
		strBL += 			"</form>";
		strBL += 		"</div>";
		strBL += 	"</div>";
		strBL += 	"<div class='media-right'>";
		strBL += 		"<div class='dropdown'>";
		strBL += 			"<a href='javascript:;' class='fa fa-ellipsis-v hanh-dong' data-toggle='dropdown'></a>";
		strBL += 			"<ul class='dropdown-menu'>";
		strBL += 				"<li><a href='#' class='edit-cmt' data-idbl='"+bl.getIdbinhluan()+"'><i class='fa fa-wrench'></i> Chỉnh sửa</a></li>";
		strBL += 				"<li><a href='#' class='delete-cmt' data-idx='"+bl.getIdbinhluan()+"'><i class='fa fa-remove'></i> Xóa</a></li>";
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
		int pageCount = 0, perPage = 10, idnho = 0;
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
		String symbol = "";
		for (BinhLuan bl: lbl) {
			if(bl.getNguoibl().getQuyennd().getId() == 1){
				symbol = "<small class='badge'><i class='fa fa-get-pocket'></i> Admin</small>";
			}
			strLbl += "<div class='media'>";
			strLbl += 	"<div class='media-left'>";
			strLbl += 		"<img src='images/userdg.png' class='media-object' style='width: 45px'>";
			strLbl += 	"</div>";
			strLbl += 	"<div class='media-body'>";
			strLbl += 		"<h4 class='media-heading'>";
			strLbl += 		"<input type='hidden' class='ngaytao"+bl.getIdbinhluan()+"' value='"+bl.getNgaytao()+"' />";
			strLbl+= 		bl.getNguoibl().getHoTen()+" "+symbol+" <small><i>Posted on <span class='display-ngaytao"+bl.getIdbinhluan()+"'>"+bl.getNgaytao()+"<span></i></small>";
			strLbl += 		"</h4>";
			strLbl += 		"<p id='noidung-cmt"+bl.getIdbinhluan()+"'>"+bl.getNoidung()+"</p>";
			strLbl += 		"<a href='javascript:;' class='taolao' data-toggle='collapse' data-target='#reply"+bl.getIdbinhluan()+"'>Trả lời</a>&nbsp;";
			strLbl += 		"<a href='javascript:;'> Thích</a>&nbsp;&nbsp;";
			strLbl += 		"<a href='javascript:;' class='fa fa-flag'></a><br />";
			if(bl.getBlcap().size() > 0){
				strLbl += 		"<a  style='cursor: pointer;' class='load-reply' data-bl='"+bl.getIdbinhluan()+"'><i class='fa fa-chevron-down'></i> Xem "+bl.getBlcap().size()+" câu trả lời</a>";
				strLbl += 		"<div class='cmts-reply"+bl.getIdbinhluan()+" collapse' data-empty='0'>";
			} else {
				strLbl += 		"<div class='cmts-reply"+bl.getIdbinhluan()+" collapse' data-empty='1'>";
			}
			strLbl += 		"</div>";
			strLbl += 		"<div id='reply"+bl.getIdbinhluan()+"' class='collapse clearfix'>";
			strLbl += 			"<form class='reply-cmt'>";
			strLbl += 				"<input type='hidden' name='idreply' value='"+bl.getIdbinhluan()+"' />";
			strLbl += 				"<div class='form-group col-md-12'>";
			strLbl += 					"<textarea rows='1' placeholder='Viết bình luận của bạn' name='noidung' class='form-control'></textarea>";
			strLbl += 				"</div>";
			strLbl += 				"<div class='form-group col-md-12'>";
			strLbl += 					"<button type='button' data-huy='reply"+bl.getIdbinhluan()+"' class='btn btn-default btn-huy'>Hủy</button> ";
			strLbl += 					"<button type='submit' class='btn btn-info'>Trả lời</button>";
			strLbl += 				"</div>";
			strLbl += 			"</form>";
			strLbl += 		"</div>";
			strLbl += 	"</div>";
			strLbl += 	"<div class='media-right'>";
			strLbl += 		"<div class='dropdown'>";
			strLbl += 			"<a href='javascript:;' class='fa fa-ellipsis-v' data-toggle='dropdown'></a>";
			strLbl += 			"<ul class='dropdown-menu'>";
			strLbl += 				"<li><a href='#' class='edit-cmt' data-idbl='"+bl.getIdbinhluan()+"'><i class='fa fa-wrench'></i> Chỉnh sửa</a></li>";
			strLbl += 				"<li><a href='#' class='delete-cmt' data-idx='"+bl.getIdbinhluan()+"'><i class='fa fa-remove'></i> Xóa</a></li>";
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
		String symbol = "";
		for (BinhLuan bl: lbl) {
			if(bl.getNguoibl().getQuyennd().getId() == 1){
				symbol = "<small class='badge'><i class='fa fa-get-pocket'></i> Admin</small>";
			}
			strLbl += "<div class='media'>";
			strLbl += 	"<div class='media-left'>";
			strLbl += 		"<img src='images/userdg.png' class='media-object' style='width: 45px'>";
			strLbl += 	"</div>";
			strLbl += 	"<div class='media-body'>";
			strLbl += 		"<h4 class='media-heading'>";
			strLbl += 		"<input type='hidden' class='ngaytao"+bl.getIdbinhluan()+"' value='"+bl.getNgaytao()+"' />";
			strLbl+= 		bl.getNguoibl().getHoTen()+" "+symbol+" <small><i>Posted on <span class='display-ngaytao"+bl.getIdbinhluan()+"'>"+bl.getNgaytao()+"<span></i></small>";
			strLbl += 		"</h4>";
			strLbl += 		"<p id='noidung-cmt"+bl.getIdbinhluan()+"'>"+bl.getNoidung()+"</p>";
			strLbl += 		"<a href='javascript:;' data-toggle='collapse' data-target='#reply"+bl.getTraloi().getIdbinhluan()+"'>Trả lời</a>&nbsp;";
			strLbl += 		"<a href='javascript:;'> Thích</a>&nbsp;&nbsp;";
			strLbl += 		"<a href='javascript:;' class='fa fa-flag'></a><br />";
			strLbl += 	"</div>";
			strLbl += 	"<div class='media-right'>";
			strLbl += 		"<div class='dropdown'>";
			strLbl += 			"<a href='javascript:;' class='fa fa-ellipsis-v' data-toggle='dropdown'></a>";
			strLbl += 			"<ul class='dropdown-menu'>";
			strLbl += 				"<li><a href='#' class='edit-cmt' data-idbl='"+bl.getIdbinhluan()+"'><i class='fa fa-wrench'></i> Chỉnh sửa</a></li>";
			strLbl += 				"<li><a href='#' class='delete-cmt' data-idx='"+bl.getIdbinhluan()+"'><i class='fa fa-remove'></i> Xóa</a></li>";
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

	@RequestMapping(value="tra-loi", method=RequestMethod.POST)
	public @ResponseBody void traloi(@RequestParam("noidung") String noidung,
			@RequestParam("idreply") int idreply,
			HttpServletResponse response,
			HttpSession httpSession) throws IOException {
		//Lay nguoi binh luan hien tai
		NguoiDung nguoibl = (NguoiDung) httpSession.getAttribute("nd");
		//Lay binh luan cha theo id
		BinhLuan reply = this.binhluanDAO.getById(idreply);
		//LAy bai viet bl
		BaiViet baivietbl = reply.getBaivietbl();
		//Tao doi tuong Binhluan moi
		BinhLuan blm = new BinhLuan(noidung, 1, new Date(), nguoibl, baivietbl, reply);
		//Thuc hien them vao csdl
		this.binhluanDAO.createBinhLuan(blm);
			
		BinhLuan bl = this.binhluanDAO.getById(blm.getIdbinhluan());
		String symbol = "";
		if(nguoibl.getQuyennd().getId() == 1){
			symbol = "<small class='badge'><i class='fa fa-get-pocket'></i> Admin</small>";
		}
		String strBL = "";
		strBL += "<div class='media'>";
		strBL += 	"<div class='media-left'>";
		strBL += 		"<img src='images/userdg.png' class='media-object' style='width: 45px'>";
		strBL += 	"</div>";
		strBL += 	"<div class='media-body'>";
		strBL += 		"<h4 class='media-heading'>";
		strBL += 		"<input type='hidden' class='ngaytao"+bl.getIdbinhluan()+"' value='"+bl.getNgaytao()+"' />";
		strBL+= 		bl.getNguoibl().getHoTen()+" "+symbol+" <small><i>Posted on <span class='display-ngaytao"+bl.getIdbinhluan()+"'>"+bl.getNgaytao()+"<span></i></small>";
		strBL += 		"</h4>";
		strBL += 		"<p id='noidung-cmt"+bl.getIdbinhluan()+"'>"+bl.getNoidung()+"</p>";
		strBL += 		"<a href='javascript:;' data-toggle='collapse' data-target='#reply"+bl.getTraloi().getIdbinhluan()+"'>Trả lời</a>&nbsp;";
		strBL += 		"<a href='javascript:;'> Thích</a>&nbsp;&nbsp;";
		strBL += 		"<a href='javascript:;' class='fa fa-flag'></a><br />";
		strBL += 	"</div>";
		strBL += 	"<div class='media-right'>";
		strBL += 		"<div class='dropdown'>";
		strBL += 			"<a href='javascript:;' class='fa fa-ellipsis-v' data-toggle='dropdown'></a>";
		strBL += 			"<ul class='dropdown-menu'>";
		strBL += 				"<li><a href='#' class='edit-cmt' data-idbl='"+bl.getIdbinhluan()+"'><i class='fa fa-wrench'></i> Chỉnh sửa</a></li>";
		strBL += 				"<li><a href='#' class='delete-cmt' data-idx='"+bl.getIdbinhluan()+"'><i class='fa fa-remove'></i> Xóa</a></li>";
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
		String json = gson.toJson(strBL);
		response.getWriter().print("{\"blmoi\":"+json+"}");
	}
	
	@RequestMapping("sua-binh-luan")
	public @ResponseBody void updateBinhLuan(HttpSession httpSession,
			HttpServletResponse response,
			@RequestParam("idbl") int idbl,
			@RequestParam("noidung") String noidung) throws IOException{
		/*NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");*/
		
		BinhLuan bl = this.binhluanDAO.getById(idbl);
		bl.setNoidung(noidung);
		bl.setNgaysua(new Date());
		this.binhluanDAO.updateBinhLuan(bl);
		Gson gson = new Gson();
		String json = gson.toJson("OK");
		response.getWriter().print(json);
	}
	
	@RequestMapping(value="xoa-binh-luan", method=RequestMethod.POST)
	public @ResponseBody void deleteBinhLuan(HttpSession httpSession,
			HttpServletResponse response,
			@RequestParam("idbl") int idbl) throws IOException{
		/*NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");*/
		
		BinhLuan bl = this.binhluanDAO.getById(idbl);
		this.binhluanDAO.deleteBinhLuan(bl);
		Gson gson = new Gson();
		String json = gson.toJson("OK");
		response.getWriter().print(json);
	}
}
