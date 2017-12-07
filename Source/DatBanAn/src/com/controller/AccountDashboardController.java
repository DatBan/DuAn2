package com.controller;

import java.util.Date;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.QuyenDAO;
import com.dao.NguoiDungDAO;
import com.entity.NguoiDung;
import com.entity.Quyen;
import com.services.EnDeCryption;

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
		
		model.addAttribute("btn_add","dashboard/user-management/them.html");
		model.addAttribute("tenbreadcrumb", "Danh sách người dùng đang sử dụng");
		if(trangthai == 0){
			model.addAttribute("tenbreadcrumb", "Danh sách người dùng đã khóa");
		}
		return "dashboard/users/user-mng";
	}
	
	// Trang load form nhap thong tin nguoi dung
	@RequestMapping(value="them")
	public String add_form(ModelMap model) {
		model.addAttribute("nguoidung", new NguoiDung());
			
		model.addAttribute("btn_back","dashboard/user-management.html?trangthai=1");
		model.addAttribute("tenbreadcrumb", "Thêm mới người dùng");
		model.addAttribute("tenbreadcrumb2", "Danh sách đang sử dụng");
		model.addAttribute("urlbreadcrumb2", "dashboard/user-management.html?trangthai=1");

		return "dashboard/users/add-user";
	}
	
	// Trang load form nhap thong tin nguoi dung
	@RequestMapping(value="them", method=RequestMethod.POST)
	public String add_execute(ModelMap model, 
			@ModelAttribute("nguoidung") NguoiDung mND,
			RedirectAttributes ra) {
		try{
			System.out.println(mND.getTendangnhap()+" "+ mND.getMatkhau()+" "+mND.getId());
			Quyen quyen = this.quyenDAO.getById(3);
			/*nd.setNgaytao(new Date());*/
			EnDeCryption mh = new EnDeCryption("sadasdasdsawqewq");
			String mkmh= mh.encoding(mND.getMatkhau());
			NguoiDung nd = new NguoiDung(mND.getHo(), mND.getTen(), mND.getTendangnhap(), mkmh, mND.getEmail(), mND.getSdt(), mND.getDiachi(), 1, new Date(), quyen);
			this.userDAO.createUser(nd);
			ra.addFlashAttribute("idndmoi", nd.getId());
			model.addAttribute("nguoidung", nd);
		}catch(Exception e){
			System.out.println("LOI "+e.toString()+" AccountDashboardController.add_execute()");
			e.printStackTrace();
		}
		/*model.addAttribute("btn_back","dashboard/user-management.html?trangthai=1");
		model.addAttribute("tenbreadcrumb", "Thêm mới người dùng");
		model.addAttribute("tenbreadcrumb2", "Danh sách đang sử dụng");
		model.addAttribute("urlbreadcrumb2", "dashboard/user-management.html?trangthai=1");*/

		return "redirect:/dashboard/user-management.html?trangthai=1";
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
		
		model.addAttribute("btn_back","dashboard/user-management.html?trangthai=1");
		model.addAttribute("tenbreadcrumb", "Cập nhật thông tin người dùng");
		model.addAttribute("tenbreadcrumb2", "Danh sách đang sử dụng");
		model.addAttribute("urlbreadcrumb2", "dashboard/user-management.html?trangthai=1");

		return "dashboard/users/edit-user";
	}

	// Trang execute update thong tin nguoi dung voi param edit va method POST
	@RequestMapping(params = "edit", method = RequestMethod.POST)
	public String edit_execute(ModelMap model, @RequestParam("id") int idx,
			@ModelAttribute("nguoidung") NguoiDung ndv,
			RedirectAttributes ra) {

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
			nd.setHo(ndv.getHo());
			nd.setTen(ndv.getTen());
			nd.setSdt(ndv.getSdt());
			if (!ndv.getMatkhau().equals("")) {
				nd.setMatkhau(ndv.getMatkhau());
			}
			System.out.println("mk" + ndv.getMatkhau());
			//Goi ham sua trong CSDL
			userDAO.updateUser(nd);
			ra.addFlashAttribute("updatestt", "success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("LOI "+e.toString()+" AccountDashboardController.edit_execute()");
			e.printStackTrace();
			ra.addFlashAttribute("updatestt", "error");
		}
		model.addAttribute("nguoidung", nd);

		return "redirect:/dashboard/user-management.html?edit&id="+idx;
	}

	// Trang execute delete nguoi dung voi param delete
	@RequestMapping(params = "delete")
	public String delete_user(ModelMap model, 
			@RequestParam("idxoa") int idx,
			RedirectAttributes ra) {
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
				ra.addFlashAttribute("deletestt", "error1");
			} else {
				nd.setTrangthai(0);
				//Goi ham sua trong CSDL
				userDAO.updateUser(nd);
				ra.addFlashAttribute("deletestt", "success");
				ra.addFlashAttribute("emailx", nd.getEmail());
			}
			System.out.println("id " + idx);
		} catch (Exception e) {
			System.out.println("LOI "+e.toString()+" AccountDashboardController.delete_user()");
			e.printStackTrace();
			ra.addFlashAttribute("deletestt", "error");
		}

		return "redirect:/dashboard/user-management.html?trangthai=1";
	}

	// Trang execute update thong tin nguoi dung voi param restore
	@RequestMapping(params = "restore")
	public String restore_user(ModelMap model, 
			@RequestParam("idxoa") int idx,
			RedirectAttributes ra) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, idx);

		try {
			nd.setTrangthai(1);
			//Goi ham sua trong CSDL
			userDAO.updateUser(nd);
			System.out.println("khoi phuc nhe " + idx);
			ra.addFlashAttribute("restorestt", "success");
			ra.addFlashAttribute("emailr", nd.getEmail());
		} catch (Exception e) {
			System.out.println("LOI "+e.toString()+" AccountDashboardController.restore_user()");
			e.printStackTrace();
			ra.addFlashAttribute("restorestt", "error");
		}

		return "redirect:/dashboard/user-management.html?trangthai=0";
	}

	// Ham set ModelAttribute la danh sach tat ca quyen nguoi dung
	@ModelAttribute("listquyen")
	public List<Quyen> getQuyenList() {
		List<Quyen> list = quyenDAO.getListAllQuyen();

		return list;
	}
	//Thong tin user
	@RequestMapping(value = "thongtincanhan")
	public String thongtincanhan(ModelMap model){
		
		return "dashboard/users/thongtin";
	}
}