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
@RequestMapping("dashboard/user-management")
public class AccountDashboardController {
	@Autowired
	SessionFactory factory;

	//Trang danh sach nguoi dung voi param trangthai
	@RequestMapping("")
	public String index(ModelMap model, @RequestParam("trangthai") int trangthai) {
		Session session = factory.getCurrentSession();
		String hql = "FROM NguoiDung WHERE trangthai =:tthai ORDER BY id desc";
		Query query = session.createQuery(hql);
		query.setParameter("tthai", trangthai);

		@SuppressWarnings("unchecked")
		List<NguoiDung> list = query.list();

		model.addAttribute("nguoidunglist", list);
		model.addAttribute("tthai", trangthai);
		model.addAttribute("tenbreadcrumb", "quản lý người dùng");
		return "dashboard/user-mng";
	}

	//Trang load thong tin nguoi dung voi param edit
	@RequestMapping(params="edit")
	public String edit_form(ModelMap model, @RequestParam("id") int idx) {
		Session session = factory.getCurrentSession();

		/*NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);*/
		String hql = "FROM NguoiDung nd WHERE nd.id=:id AND nd.trangthai=:tthai";
		Query query = session.createQuery(hql);
		query.setParameter("id", idx);
		query.setParameter("tthai", 1);
		try {
			NguoiDung nd  = (NguoiDung) query.uniqueResult();
			System.out.println(nd.getTendangnhap());
			model.addAttribute("nguoidung", nd);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("nullll "+e.toString());
			return "redirect:/dashboard/user-management.html?trangthai=1";
		}

		return "dashboard/edit-user";
	}

	//Trang execute update thong tin nguoi dung voi param edit va method POST
	@RequestMapping(params="edit", method = RequestMethod.POST)
	public String edit_execute(ModelMap model, @RequestParam("id") int idx,
			@ModelAttribute("nguoidung") NguoiDung ndv) {
		Session session = factory.openSession();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);
		Transaction t = session.beginTransaction();
		String hql = "FROM NguoiDung nd WHERE nd.quyennd.id = '1'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<NguoiDung> countList = query.list();
		System.out.println(countList.size());
		try {
			if (ndv.getQuyennd().getId() != 1 && nd.getQuyennd().getId() == 1 && countList.size() == 1) {
				System.out.println("khong duoc doi nhe");
			} else {
				System.out.println("doi luon");
				nd.setQuyennd(ndv.getQuyennd());
			}
			nd.setDiachi(ndv.getDiachi());
			nd.setEmail(ndv.getEmail());
			nd.setHoten(ndv.getHoten());
			nd.setSdt(ndv.getSdt());
			if (!ndv.getMatkhau().equals("")) {
				nd.setMatkhau(ndv.getMatkhau());
			}

			session.update(nd);
			System.out.println("mk" + ndv.getMatkhau());
			 t.commit(); 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}
		model.addAttribute("nguoidung", nd);

		return "dashboard/edit-user";
	}
	
	//Trang execute delete nguoi dung voi param delete 
	@RequestMapping(params="delete")
	public String delete_user(ModelMap model, @RequestParam("idxoa") int idx) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);
		
		String hql = "FROM NguoiDung nd WHERE nd.quyennd.id = '1'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<NguoiDung> countList = query.list();
		
		try {
			if (nd.getQuyennd().getId() == 1 && countList.size() == 1) {
				System.out.println("Khong xoa nhe");
			}else{
				nd.setTrangthai(0);
				session.update(nd);
				t.commit();
			}
			System.out.println("id " + idx);
		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}

		return "redirect:/dashboard/user-management.html?trangthai=1";
	}
	
	//Trang execute update thong tin nguoi dung voi param restore
	@RequestMapping(params="restore")
	public String restore_user(ModelMap model, @RequestParam("idxoa") int idx) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);
		
		try {
				nd.setTrangthai(1);
				session.update(nd);
				t.commit();
			System.out.println("khoi phuc nhe " + idx);
		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}

		return "redirect:/dashboard/user-management.html?trangthai=0";
	}

	//Ham set ModelAttribute la danh sach tat ca quyen nguoi dung 
	@ModelAttribute("listquyen")
	public List<Quyen> getQuyenList() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Quyen";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Quyen> list = query.list();

		return list;
	}
}