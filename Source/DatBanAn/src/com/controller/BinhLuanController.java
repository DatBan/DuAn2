package com.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.BaiViet;
import com.entity.BinhLuan;
import com.entity.NguoiDung;



@Controller
public class BinhLuanController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("comments")
	public String comment(ModelMap model, @RequestParam("noidung") String noidung,
			@RequestParam("idbaiviet") int id, @RequestParam("iduser") int iduser
			) {

		Session session = factory.openSession();
		
		

		NguoiDung nguoidung = (NguoiDung) session.get(NguoiDung.class, iduser);

		BaiViet baiviet = (BaiViet) session.get(BaiViet.class, id);
		Transaction t = null;
		try {

			BinhLuan binhluan = new BinhLuan();
			session.save(binhluan);

			/* t.commit(); */
		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}

		return "redirect:/baiviet/chitietbaiviet/" + id + ".htm";

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
			BinhLuan binhluan = new BinhLuan(nguoidung,baiviet,bl);
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
