package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.BanAnDAO;
import com.entity.BaiViet;
import com.entity.BanAn;
import com.entity.HoaDon;
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.entity.TienIch;

@Transactional
@Controller
@RequestMapping("nhahang/quanlydatban")
public class ManagerInvoiceController {
	@Autowired
	private BanAnDAO banAnDAO;
	@Autowired
	SessionFactory factory;

	// Do du lieu ra trang quan ly
	@RequestMapping(value = "index")
	public String quanLyDatBan(ModelMap model, HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		String hql = "FROM HoaDon where idnhahang =:idnhahang and trangthai=0 ORDER BY ngaytao DESC";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);
		@SuppressWarnings("unchecked")
		List<HoaDon> list = query.list();
		model.addAttribute("hoadon", list);
		
		model.addAttribute("btn_add", "nhahang/hoadon/them.html");
		model.addAttribute("tenbreadcrumb", "Quản lý đơn đặt bàn mới");
		return "nhahang/quanlydatban/quanlydatban";
	}
	// Do du lieu ra trang quan ly don da xac nhan
		@RequestMapping(value = "index1")
		public String donDatBanDaXacNhan(ModelMap model, HttpSession httpSession) {
			Session session = factory.getCurrentSession();
			NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
			NhaHang nhahang = nd.getNhahang();
			int id = nhahang.getId();
			String hql = "FROM HoaDon where idnhahang =:idnhahang and trangthai=1 ORDER BY ngaytao DESC";
			Query query = session.createQuery(hql);
			query.setParameter("idnhahang", id);
			@SuppressWarnings("unchecked")
			List<HoaDon> list = query.list();
			model.addAttribute("hoadon", list);
			
			model.addAttribute("btn_add", "nhahang/hoadon/them.html");
			model.addAttribute("tenbreadcrumb", "Quản lý đơn đặt bàn đã xác nhận");
			return "nhahang/hoadon/quanlydondatban";
		}
	// Xoa hoa don
		@RequestMapping(value = "delete/{id}")
		public String delete(ModelMap model, @PathVariable("id") Integer id) {
			Session session = factory.openSession();
			
			HoaDon hd = (HoaDon) session.get(HoaDon.class, id);
			hd.setTrangthai(4);
			
			Transaction t = session.beginTransaction();
			try {
				session.update(hd);
				t.commit();
				model.addAttribute("message", "Xoá thành công");
				
			} catch (Exception e) {
				System.out.println(e.toString());
				t.rollback();
			} finally {
				session.close();
			}
			return "redirect:/nhahang/quanlydatban/index.html";
		}
		// Xoa don da duyet
				@RequestMapping(value = "delete1/{id}")
				public String delete1(ModelMap model, @PathVariable("id") Integer id) {
					Session session = factory.openSession();
					
					HoaDon hd = (HoaDon) session.get(HoaDon.class, id);
					hd.setTrangthai(4);
					BanAn ban = hd.getBanan();					
					ban.setTrangthai(0);
					Transaction t = session.beginTransaction();
					try {
						session.update(hd);
						session.update(ban);
						t.commit();
						model.addAttribute("message", "Xoa thanh cong");
						
					} catch (Exception e) {
						System.out.println(e.toString());
						t.rollback();
					} finally {
						session.close();
					}
					return "redirect:/nhahang/quanlydatban/index1.html";
				}
	// Tao giao dien edit
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editForm(ModelMap model, @RequestParam("idhd") Integer id) {
		Session session = factory.getCurrentSession();
		HoaDon hd = (HoaDon) session.get(HoaDon.class, id);

		model.addAttribute("hoadon", hd);
		model.addAttribute("btn_back","nhahang/quanlydatban/index.html");
		model.addAttribute("tenbreadcrumb", "Sửa hoá đơn");
		return "nhahang/quanlydatban/suadondatban";
	}

	// tao giao dien edit
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editFormHD(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		HoaDon hd = (HoaDon) session.get(HoaDon.class, id);

		model.addAttribute("hoadon", hd);
		model.addAttribute("btn_back","nhahang/quanlydatban/index.html");
		model.addAttribute("tenbreadcrumb", "Sửa thông tin đơn đặt bàn mới");
		model.addAttribute("tenbreadcrumb2", "Đơn đặt bàn mới");
		model.addAttribute("urlbreadcrumb2", "nhahang/quanlydatban/index.html");
		return "nhahang/quanlydatban/suadondatban";
	}
	// tao giao dien edit
		@RequestMapping(value = "edit1/{id}", method = RequestMethod.GET)
		public String editFormHDedit(ModelMap model, @PathVariable("id") Integer id) {
			Session session = factory.getCurrentSession();
			HoaDon hd = (HoaDon) session.get(HoaDon.class, id);

			model.addAttribute("hoadon", hd);
			
			model.addAttribute("btn_back","nhahang/quanlydatban/index1.html");
			model.addAttribute("tenbreadcrumb", "Sửa thông tin đơn đặt bàn đã xác nhận");
			model.addAttribute("tenbreadcrumb2", "Đơn đã xác nhận");
			model.addAttribute("urlbreadcrumb2", "nhahang/quanlydatban/index1.html");
			return "nhahang/hoadon/suahoadon";
		}

	// Sua don dat ban
	@RequestMapping(value = "suadondatban", method = RequestMethod.POST)
	public String suaDon(ModelMap model, RedirectAttributes re, @RequestParam("idhoadon") int idhoadon,
			@RequestParam("songuoi") int songuoi, @RequestParam("ngaythang") String ngaythang,
			@RequestParam("thoigian") String thoigian, @RequestParam("ho") String ho, @RequestParam("ten") String ten,
			@RequestParam("email") String email, @RequestParam("sdt") String sdt, @RequestParam("ghichu") String ghichu,
			HttpSession httpSession) {
		Session session = factory.openSession();

		String ho1 = ho.trim();
		String ten1 = ten.trim();
		String email1 = email.trim();
		String sdt1 = sdt.trim();
		String ghichu1 = ghichu.trim();
		HoaDon hd = (HoaDon) session.get(HoaDon.class, idhoadon);
		hd.setSonguoi(songuoi);
		hd.setThoigian(thoigian);
		hd.setHo(ho1);
		hd.setTen(ten1);
		hd.setEmail(email1);
		hd.setDienthoai(sdt1);
		hd.setGhichu(ghichu1);

		Date date = new Date();
		System.out.println(ngaythang);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		/*
		 * String tgg =ngaythang; System.out.println(tgg);
		 */

		try {
			date = df.parse(ngaythang);
			System.out.println(date);
			/* String da = df.format(date); */

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.toString());
			e1.printStackTrace();
		}
		hd.setNgaythang(date);
		Transaction t = session.beginTransaction();
		try {
			session.update(hd);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa thành công!");
			return "redirect:/nhahang/quanlydatban/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			re.addFlashAttribute("message", "Chỉnh sửa thất bại!");

		} finally {
			session.close();
		}
		return "redirect:/nhahang/quanlydatban/edit.html?idhd=" + idhoadon;
	}
	// Sua don dat ban da duyet
		@RequestMapping(value = "suadondatban1", method = RequestMethod.POST)
		public String suaDon1(ModelMap model, RedirectAttributes re, @RequestParam("idhoadon") int idhoadon,
				@RequestParam("songuoi") int songuoi, @RequestParam("ngaythang") String ngaythang,
				@RequestParam("thoigian") String thoigian, @RequestParam("ho") String ho, @RequestParam("ten") String ten,
				@RequestParam("email") String email, @RequestParam("sdt") String sdt, @RequestParam("ghichu") String ghichu,
				HttpSession httpSession) {
			Session session = factory.openSession();

			String ho1 = ho.trim();
			String ten1 = ten.trim();
			String email1 = email.trim();
			String sdt1 = sdt.trim();
			String ghichu1 = ghichu.trim();
			HoaDon hd = (HoaDon) session.get(HoaDon.class, idhoadon);
			hd.setSonguoi(songuoi);
			hd.setThoigian(thoigian);
			hd.setHo(ho1);
			hd.setTen(ten1);
			hd.setEmail(email1);
			hd.setDienthoai(sdt1);
			hd.setGhichu(ghichu1);

			Date date = new Date();
			System.out.println(ngaythang);
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			/*
			 * String tgg =ngaythang; System.out.println(tgg);
			 */

			try {
				date = df.parse(ngaythang);
				System.out.println(date);
				/* String da = df.format(date); */

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
			hd.setNgaythang(date);
			Transaction t = session.beginTransaction();
			try {
				session.update(hd);
				t.commit();
				model.addAttribute("message", "Chỉnh sửa thành công!");
				return "redirect:/nhahang/quanlydatban/index1.html";
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();
				re.addFlashAttribute("message", "Chỉnh sửa thất bại!");

			} finally {
				session.close();
			}
			return "redirect:/nhahang/quanlydatban/edit/"+idhoadon+".html";
		}
	
	// Duyet 
	@RequestMapping(value = "duyet")
	public String duyet(ModelMap model, @RequestParam("idhd") int idhd,HttpSession httpSession) {
		Session session = factory.openSession();
		
		NguoiDung nguoidung = (NguoiDung) httpSession.getAttribute("nd");
		int idnh=nguoidung.getNhahang().getId();
		
		String hql = "FROM BanAn where nhahang.id =:idnhahang and trangthai=0";		
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", idnh);
		@SuppressWarnings("unchecked")
		List<BanAn> list = query.list();
		HoaDon hd = (HoaDon) session.get(HoaDon.class, idhd);
		
		Transaction t = session.beginTransaction();
		try {
			session.update(hd);
			t.commit();
			model.addAttribute("tenbreadcrumb", "Chọn bàn");
			model.addAttribute("idhd", idhd);
			model.addAttribute("ban", list);
		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}
		return "nhahang/quanlydatban/duyetdatban";
	}
	// Duyet ban khi khach toi
		@RequestMapping(value = "duyet2")
		public String duyetdon(ModelMap model, @RequestParam("idhd") int idhd) {
			Session session = factory.openSession();
			
			HoaDon hd = (HoaDon) session.get(HoaDon.class, idhd);
			hd.setTrangthai(2);
			Transaction t = session.beginTransaction();
			try {
				session.update(hd);
				t.commit();
				
				model.addAttribute("idhd", idhd);
			
			} catch (Exception e) {
				System.out.println(e.toString());
				t.rollback();
			} finally {
				session.close();
			}
			return "redirect:/nhahang/quanlydatban/index1.html";
		}
	// Duyet ban
		@RequestMapping(value = "duyet1")
		public String duyet1(ModelMap model, @RequestParam("idhd") int idhd,HttpSession httpSession) {
			Session session = factory.openSession();
			NguoiDung nguoidung = (NguoiDung) httpSession.getAttribute("nd");
			int idnh=nguoidung.getNhahang().getId();
			
			String hql = "FROM BanAn where nhahang.id =:idnhahang and trangthai=0";		
			Query query = session.createQuery(hql);
			query.setParameter("idnhahang", idnh);
			@SuppressWarnings("unchecked")
			List<BanAn> list = query.list();
			
			HoaDon hd = (HoaDon) session.get(HoaDon.class, idhd);
			
			Transaction t = session.beginTransaction();
			try {
				session.update(hd);
				t.commit();
				model.addAttribute("tenbreadcrumb", "Chọn bàn");
				model.addAttribute("idhd", idhd);
				model.addAttribute("ban", list);
			} catch (Exception e) {
				System.out.println(e.toString());
				t.rollback();
			} finally {
				session.close();
			}
			return "nhahang/hoadon/chonban";
		}

	// Chon Ban
	@RequestMapping(value = "chonban")
	public String chonban(ModelMap model, @RequestParam("idhd") int idhd, @RequestParam("idb") int idb) {
		Session session = factory.openSession();

		HoaDon hd = (HoaDon) session.get(HoaDon.class, idhd);
		BanAn ban = (BanAn) session.get(BanAn.class, idb);
		hd.setBanan(ban);
		hd.setTrangthai(1);
		ban.setTrangthai(1);
		Transaction t = session.beginTransaction();
		try {
			session.update(hd);
			session.update(ban);
			t.commit();
			model.addAttribute("idhd", idhd);

		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}

		return "redirect:/nhahang/quanlydatban/edit.html";
	}
	// Chon ban cho hd da duyet
		@RequestMapping(value = "chonban1")
		public String chonban1(ModelMap model, @RequestParam("idhd") int idhd, @RequestParam("idb") int idb) {
			Session session = factory.openSession();

			HoaDon hd = (HoaDon) session.get(HoaDon.class, idhd);
			BanAn ban = (BanAn) session.get(BanAn.class, idb);
			hd.getBanan().setTrangthai(0);
			hd.setBanan(ban);
			ban.setTrangthai(1);
			Transaction t = session.beginTransaction();
			try {
				session.update(hd);
				session.update(ban);
				t.commit();
				model.addAttribute("idhd", idhd);

			} catch (Exception e) {
				System.out.println(e.toString());
				t.rollback();
			} finally {
				session.close();
			}

			return "redirect:/nhahang/quanlydatban/edit1/"+idhd+".html";
		}
		
}
