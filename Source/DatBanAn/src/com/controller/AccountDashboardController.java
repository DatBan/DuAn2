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

import com.dao.QuyenDAO;
import com.dao.NguoiDungDAO;
import com.entity.NguoiDung;
import com.entity.Quyen;

@Controller
@Transactional
@RequestMapping("dashboard/user-management")
public class AccountDashboardController {
	@Autowired
	private NguoiDungDAO userDAO;

	@Autowired
	private QuyenDAO quyenDAO;

	@Autowired
	SessionFactory factory;

	// Trang danh sach nguoi dung voi param trangthai
	@RequestMapping("")
	public String index(ModelMap model, @RequestParam("trangthai") int trangthai) {

		List<NguoiDung> list = userDAO.getListByTrangThai(trangthai);

		model.addAttribute("nguoidunglist", list);
		model.addAttribute("tthai", trangthai);
		model.addAttribute("tenbreadcrumb", "quản lý người dùng");
		return "dashboard/user-mng";
	}

	// Trang load thong tin nguoi dung voi param edit
	@RequestMapping(params = "edit")
	public String edit_form(ModelMap model, @RequestParam("id") int idx) {
		try {
			NguoiDung nd = userDAO.getByTrangThaiAndId(1, idx);
			System.out.println(nd.getTendangnhap());
			model.addAttribute("nguoidung", nd);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("nullll " + e.toString());
			return "redirect:/dashboard/user-management.html?trangthai=1";
		}

		return "dashboard/edit-user";
	}

	// Trang execute update thong tin nguoi dung voi param edit va method POST
	@RequestMapping(params = "edit", method = RequestMethod.POST)
	public String edit_execute(ModelMap model, @RequestParam("id") int idx,
			@ModelAttribute("nguoidung") NguoiDung ndv) {

		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);

		// So account quyen la admin
		List<NguoiDung> countList = userDAO.getListByIdQuyen(1);
		System.out.println(countList.size());
		try {
			// Kiem tra neu this.nd la admin va trong he thong chi con 1 tai
			// khoan admin thi
			// khong duoc doi quyen khac
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
			System.out.println("mk" + ndv.getMatkhau());
			//Goi ham sua trong CSDL
			userDAO.updateUser(nd);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		model.addAttribute("nguoidung", nd);

		return "dashboard/edit-user";
	}

	// Trang execute delete nguoi dung voi param delete
	@RequestMapping(params = "delete")
	public String delete_user(ModelMap model, @RequestParam("idxoa") int idx) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);
		
		// So account quyen la admin
		List<NguoiDung> countList = userDAO.getListByIdQuyen(1);

		try {
			// Kiem tra neu this.nd la admin va trong he thong chi con 1 tai
			// khoan admin thi
			// khong duoc xoa
			if (nd.getQuyennd().getId() == 1 && countList.size() == 1) {
				System.out.println("Khong xoa nhe");
			} else {
				nd.setTrangthai(0);
				//Goi ham sua trong CSDL
				userDAO.updateUser(nd);
			}
			System.out.println("id " + idx);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return "redirect:/dashboard/user-management.html?trangthai=1";
	}

	// Trang execute update thong tin nguoi dung voi param restore
	@RequestMapping(params = "restore")
	public String restore_user(ModelMap model, @RequestParam("idxoa") int idx) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);

		try {
			nd.setTrangthai(1);
			//Goi ham sua trong CSDL
			userDAO.updateUser(nd);
			System.out.println("khoi phuc nhe " + idx);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return "redirect:/dashboard/user-management.html?trangthai=0";
	}

	// Ham set ModelAttribute la danh sach tat ca quyen nguoi dung
	@ModelAttribute("listquyen")
	public List<Quyen> getQuyenList() {
		List<Quyen> list = quyenDAO.getListAllQuyen();

		return list;
	}
}