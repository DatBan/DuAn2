package com.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.BanAnDAO;
import com.entity.BanAn;
import com.entity.HoaDon;
import com.entity.TienIch;
@Transactional
@Controller
@RequestMapping("nhahang/quanlydatban")
public class ManagerInvoiceController {
	@Autowired
	private BanAnDAO banAnDAO;
	@Autowired
	SessionFactory factory;
	// Đổ dữ liệu ra trang quản lý
			@RequestMapping(value = "index")
			public String quanLyDatBan(ModelMap model) {
				Session session = factory.getCurrentSession();
				String hql = "FROM HoaDon where idnhahang =:idnhahang and trangthai=0";
				Query query = session.createQuery(hql);
				query.setParameter("idnhahang", 1);
				@SuppressWarnings("unchecked")
				List<HoaDon> list = query.list();
				model.addAttribute("hoadon", list);
				model.addAttribute("tenbreadcrumb", "QUẢN LÝ ĐẶT BÀN");
				return "nhahang/quanlydatban";
			}
			// Tạo giao diện edit tiện ích
			@RequestMapping(value = "edit")
			public String editForm(ModelMap model, @RequestParam("idhd") Integer id) {
				Session session = factory.getCurrentSession();
				HoaDon hd = (HoaDon) session.get(HoaDon.class, id);
				
				model.addAttribute("hoadon", hd);
				model.addAttribute("tenbreadcrumb", "SỬA HOÁ ĐƠN");
				return "nhahang/suadondatban";
			}
			@RequestMapping(value="duyet")
			public String duyet(ModelMap model,
					@RequestParam("idhd") int idhd){
				Session session = factory.openSession();
				List<BanAn> list = banAnDAO.getListByTrangThaiTrong();
				HoaDon hd= (HoaDon) session.get(HoaDon.class, idhd);
				hd.setTrangthai(1);
				Transaction t = session.beginTransaction();
				try{
					session.update(hd);
					t.commit();
					model.addAttribute("idhd", idhd);
					model.addAttribute("ban", list);
				}catch(Exception e){
					System.out.println(e.toString());
					t.rollback();
				}finally{
					session.close();
				}
				return "nhahang/duyetdatban";
			}
			@RequestMapping(value="chonban")
			public String chonban(ModelMap model,@RequestParam("idhd") int idhd,@RequestParam("idb") int idb){
				Session session = factory.openSession();
				
				HoaDon hd= (HoaDon) session.get(HoaDon.class, idhd);
				BanAn ban= (BanAn) session.get(BanAn.class, idb);
				hd.setBanan(ban);
				Transaction t = session.beginTransaction();
				try{
					session.update(hd);
					t.commit();
					model.addAttribute("idhd", idhd);
					
				}catch(Exception e){
					System.out.println(e.toString());
					t.rollback();
				}finally{
					session.close();
				}
				
				
				return "redirect:/nhahang/quanlydatban/edit.html";
			}
}
