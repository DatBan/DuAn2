package com.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.NguoiDung;
import com.entity.Quyen;

@Controller
@Transactional
@RequestMapping("dashboard/")
public class AccountDashboardController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("user-management")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NguoiDung";
		Query query = session.createQuery(hql);

		@SuppressWarnings("unchecked")
		List<NguoiDung> list = query.list();
		
		model.addAttribute("nguoidunglist", list);
		return "dashboard/user-mng";
	}
	
	@RequestMapping("edit-user")
	public String edit_form(ModelMap model,
			@RequestParam("id") int idx) {
		Session session = factory.getCurrentSession();
		
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);
		model.addAttribute("nguoidung", nd);
		
		return "dashboard/edit-user";
	}
	
	@RequestMapping(value="edit-user", method=RequestMethod.POST)
	public String edit_execute(ModelMap model,
			@RequestParam("id") int idx,
			@ModelAttribute("nguoidung") NguoiDung ndv) {
		Session session = factory.openSession();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);
		Transaction t = session.beginTransaction();
		try {
			nd.setDiachi(ndv.getDiachi());
			nd.setEmail(ndv.getEmail());
			nd.setHoten(ndv.getHoten());
			nd.setQuyennd(ndv.getQuyennd());
			nd.setSdt(ndv.getSdt());
			nd.setMatkhau(ndv.getMatkhau());
			
			session.update(nd);
			System.out.println(nd.getTendangnhap()+" sss " +nd.getNgaytao() +" q "+ nd.getQuyennd().getId());
			/*t.commit();*/
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			t.rollback();
		}finally{
			session.close();
		}
		model.addAttribute("nguoidung", nd);
		
		return "dashboard/edit-user";
	}
	
	@RequestMapping("delete-user")
	public String delete_user(ModelMap model, 
			@RequestParam("idxoa") int idx) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);
		try {
			session.delete(nd);
			/*t.commit();*/
			System.out.println("xoa nhe "+idx);
		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		}finally{
			session.close();
		}
		
		return "redirect:/dashboard/user-management.html";
	}
	@ModelAttribute("listquyen")
	public List<Quyen> getQuyenList(){
		Session session = factory.getCurrentSession();
		String hql= "FROM Quyen";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Quyen> list = query.list();
		
		return list;
	}
}
