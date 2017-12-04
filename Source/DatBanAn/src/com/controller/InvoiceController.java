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
import com.entity.BanAn;
import com.entity.ChiTietHoaDon;
import com.entity.HoaDon;
import com.entity.KhuyenMai;
import com.entity.MonAn;
import com.entity.NguoiDung;
import com.entity.NhaHang;

@Transactional
@Controller
@RequestMapping("nhahang/hoadon")
public class InvoiceController {
	@Autowired
	private BanAnDAO banAnDAO;
	@Autowired
	SessionFactory factory;

	// Do du lieu ra trang quan ly
	@RequestMapping(value = "index")
	public String quanLyHoaDon(ModelMap model, HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		String hql = "FROM HoaDon where idnhahang =:idnhahang and trangthai=2 ORDER BY ngaytao DESC";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);
		@SuppressWarnings("unchecked")
		List<HoaDon> list = query.list();
		model.addAttribute("hoadon", list);

		model.addAttribute("btn_add", "nhahang/hoadon/them.html");
		model.addAttribute("tenbreadcrumb", "Quản lý hóa đơn");
		return "nhahang/hoadon/quanlyhoadon";
	}
	//Chon do an
	@RequestMapping(value = "chondoan")
	public String chondoan(ModelMap model,@RequestParam("idhd")int idhd, HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		HoaDon hd = (HoaDon) session.get(HoaDon.class, idhd);
		
		String hql = "FROM MonAn where idnhahang =:idnhahang and trangthai=0";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);
		
		@SuppressWarnings("unchecked")
		List<MonAn> list = query.list();
		model.addAttribute("monan", list);
		model.addAttribute("hoadon", hd);

		model.addAttribute("btn_add", "nhahang/monan/them.html");
		model.addAttribute("btn_back", "nhahang/hoadon/index.html");
		model.addAttribute("tenbreadcrumb", "Chọn món ăn");
		return "nhahang/hoadon/chondoan";
	}
	// Them Mon
		@RequestMapping(value = "themmon", method = RequestMethod.POST)
		public String themmon(ModelMap model, @RequestParam("idhoadonmodal") int idhoadon,
				@RequestParam("idmonanmodal") int idmon, @RequestParam("soluong") int soluong) {
			Session session = factory.openSession();
			HoaDon hd = (HoaDon) session.get(HoaDon.class, idhoadon);
			MonAn monan = (MonAn) session.get(MonAn.class, idmon);
			Transaction t = session.beginTransaction();
			
				try {
					for (int i = 0; i < soluong; i++) {
					ChiTietHoaDon cthd = new ChiTietHoaDon(1, hd, monan);
					session.save(cthd);
					}
					t.commit();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
					t.rollback();
				} finally {
					session.close();
				}
			

			return "redirect:/nhahang/hoadon/chondoan.html?idhd=" + hd.getId() + "";
		}
	//Xem danh sach mon an da goi
		@RequestMapping(value = "xemdanhsach")
		public String xemdanhsach(ModelMap model,@RequestParam("idhd")int idhd, HttpSession httpSession) {
			Session session = factory.getCurrentSession();
			NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
			NhaHang nhahang = nd.getNhahang();
			int id = nhahang.getId();
			HoaDon hd = (HoaDon) session.get(HoaDon.class, idhd);
			
			String hql = "FROM ChiTietHoaDon where idhoadon =:idhoadon and trangthai=1";
			Query query = session.createQuery(hql);
			query.setParameter("idhoadon", idhd);
			
			@SuppressWarnings("unchecked")
			List<ChiTietHoaDon> list = query.list();
			model.addAttribute("cthd", list);
			model.addAttribute("hoadon", hd);
			
			model.addAttribute("btn_add", "nhahang/hoadon/chondoan.html?idhd="+idhd+"");
			model.addAttribute("btn_back", "nhahang/hoadon/index.html");
			model.addAttribute("tenbreadcrumb", "Danh sách món đã gọi");
			return "nhahang/hoadon/danhsachmondagoi";
		}
		//Xoa Mon
		@RequestMapping(value = "deletemon/{id}")
		public String deleteTienIch(ModelMap model, @PathVariable("id") Integer id,@RequestParam("idhoadon") int idhoadon) {
			Session session = factory.openSession();
			ChiTietHoaDon ct = (ChiTietHoaDon) session.get(ChiTietHoaDon.class, id);
			HoaDon hd = (HoaDon) session.get(HoaDon.class, idhoadon);
			Transaction t = session.beginTransaction();
			
			try {

				session.delete(ct);
				t.commit();
				model.addAttribute("message", "Xoá thành công");

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Xoá thất bại!" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/nhahang/hoadon/xemdanhsach.html?idhd=" + hd.getId() + "";
		}
	// Tao giao dien them
	@RequestMapping(value = "them")
	public String themhoadon(ModelMap model, RedirectAttributes re, HttpSession httpSession) {
		Session session = factory.openSession();
		NguoiDung nguoidung = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nguoidung.getNhahang();

		Date ngaytao = new Date();
		Transaction t = session.beginTransaction();
		System.out.println(ngaytao);
		HoaDon hoadon = new HoaDon(2, new Date(), nhahang);
		try {
			session.save(hoadon);
			t.commit();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			t.rollback();
			re.addFlashAttribute("message", "Thêm thất bại");
			return "redirect:/nhahang/hoadon/index.html";
		} finally {
			session.close();
		}

		return "redirect:/nhahang/hoadon/index.html";
	}

	// Tao giao dien edit
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editFormHD(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		HoaDon hd = (HoaDon) session.get(HoaDon.class, id);

		model.addAttribute("hoadon", hd);
		model.addAttribute("hoadon", hd);
		model.addAttribute("btn_back", "nhahang/hoadon/index.html");
		model.addAttribute("tenbreadcrumb", "Sửa thông tin hóa đơn");
		model.addAttribute("tenbreadcrumb2", "Quản lý hóa đơn");
		model.addAttribute("urlbreadcrumb2", "nhahang/hoadon/index.html");
		return "nhahang/hoadon/suadon";
	}

	// Sua hoa don
	@RequestMapping(value = "suahoadon", method = RequestMethod.POST)
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
			return "redirect:/nhahang/hoadon/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			re.addFlashAttribute("message", "Chỉnh sửa thất bại!");

		} finally {
			session.close();
		}
		return "redirect:/nhahang/hoadon/edit/" + idhoadon + ".html";
	}

	// Chon ban
	@RequestMapping(value = "chonban")
	public String duyet1(ModelMap model, @RequestParam("idhd") int idhd) {
		Session session = factory.openSession();
		List<BanAn> list = banAnDAO.getListByTrangThaiTrong();
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
		return "nhahang/hoadon/chonbanmoi";
	}

	// Chon ban khi sua
	@RequestMapping(value = "chonban1")
	public String chonban1(ModelMap model, @RequestParam("idhd") int idhd) {
		Session session = factory.openSession();
		List<BanAn> list = banAnDAO.getListByTrangThaiTrong();
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
		return "nhahang/hoadon/chonbanmoikhisua";
	}

	// Chon ban moi
	@RequestMapping(value = "chonbanmoi")
	public String chonban(ModelMap model, @RequestParam("idhd") int idhd, @RequestParam("idb") int idb) {
		Session session = factory.openSession();

		HoaDon hd = (HoaDon) session.get(HoaDon.class, idhd);
		BanAn ban = (BanAn) session.get(BanAn.class, idb);
		hd.setBanan(ban);
		ban.setTrangthai(1);
		Transaction t = session.beginTransaction();
		try {
			session.update(hd);
			session.update(ban);
			t.commit();

		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}

		return "redirect:/nhahang/hoadon/index.html";
	}

	// Chon ban khi sua
	@RequestMapping(value = "chonbanmoi1")
	public String chonbankhisua(ModelMap model, @RequestParam("idhd") int idhd, @RequestParam("idb") int idb) {
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

		} catch (Exception e) {
			System.out.println(e.toString());
			t.rollback();
		} finally {
			session.close();
		}

		return "redirect:/nhahang/hoadon/edit/" + idhd + ".html";
	}

	// Xoa hoa don
	@RequestMapping(value = "delete/{id}")
	public String delete1(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.openSession();

		HoaDon hd = (HoaDon) session.get(HoaDon.class, id);
		hd.setTrangthai(4);
		if(hd.getBanan()!=null){
			BanAn ban = hd.getBanan();
			ban.setTrangthai(0);
			try {
				session.update(ban);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
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
		return "redirect:/nhahang/hoadon/index.html";
	}

	
}
