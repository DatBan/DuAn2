package com.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.NguoiDung;
import com.services.EnDeCryption;
@Controller
@Transactional
@RequestMapping("thongtincanhan")
public class ThongtinController {
	@Autowired
	SessionFactory factory;
	//Thong tin user
		@RequestMapping(params = "hienthi")
		public String thongtincanhan(ModelMap model,@RequestParam("id") int id,
				HttpSession httpSession){
			Session session = factory.getCurrentSession();
			NguoiDung ndht = (NguoiDung) httpSession.getAttribute("nd");
			NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, id);
			if(ndht.getId() != nd.getId()){
				return "redirect:/trang-chu.html";
			}
			model.addAttribute("nguoidung", nd);
			return "dashboard/users/thongtin";
		}
		//Doi Thong tin
		@RequestMapping(params = "editthongtin")
		public String editthongtin(ModelMap model,
				@RequestParam("ho") String ho,
				@RequestParam("ten") String ten,
				@RequestParam("matkhau") String matkhau,
				@RequestParam("diachi") String diachi,
				@RequestParam("sdt") String sdt,
				@RequestParam("id") int id,RedirectAttributes re
				) {
			Session session = factory.openSession();
			NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, id);
			nd.setHo(ho);
			nd.setTen(ten);
			nd.setDiachi(diachi);
			nd.setSdt(sdt);
			EnDeCryption mh = new EnDeCryption("sadasdasdsawqewq");
			
			if(matkhau != ""){
				String mkmh= mh.encoding(matkhau);
				nd.setMatkhau(mkmh);
			}
			Transaction t = session.beginTransaction();
			try {
				session.update(nd);
				t.commit();
				re.addFlashAttribute("updatestt", "success");
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();
				re.addFlashAttribute("updatestt", "error");
			}finally {
				session.close();
			}
			return "redirect:/thongtincanhan.html?hienthi&id="+id+"";
		}
}
