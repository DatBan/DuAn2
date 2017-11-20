package com.controller;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.NhanDipDao;
import com.entity.HoaDon;
import com.entity.KhuyenMai;
import com.entity.MonAn;
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.services.Mailer;

@Transactional
@Controller
@RequestMapping("datban")
public class OpenTableController {
	@Autowired
	private NhanDipDao nhanDipDAO;
	@Autowired
	SessionFactory factory;

	// Tạo form đặt bàn
	@RequestMapping(value = "index/{id}", method = RequestMethod.GET)
	public String datban(ModelMap model, @PathVariable("id") int id, @RequestParam("idkm") int idkm) {
		Session session = factory.getCurrentSession();
		NhaHang nhahang = (NhaHang) session.get(NhaHang.class, id);
		KhuyenMai khuyenmai = (KhuyenMai) session.get(KhuyenMai.class, idkm);
		model.addAttribute("khuyenmai", khuyenmai);
		model.addAttribute("nhahang", nhahang);

		return "homepage/datban";
	}

	// Trang thông tin đặt bàn
	@RequestMapping(value = "thongtindatban")
	public String thongtindatban(ModelMap model) {

		return "user/thongtindatban";
	}

	// Đặt bàn
	@Autowired
	Mailer mailer;

	@RequestMapping(value = "xacnhandatban", method = RequestMethod.POST)
	public String xacnhandat(ModelMap model, RedirectAttributes re, @RequestParam("idnhahang") int idnhahang,
			@RequestParam("idkm") int idkm, @RequestParam("ho") String ho, @RequestParam("ten") String ten,
			@RequestParam("ngaythang") String ngaythang, @RequestParam("thoigian") String thoigian,
			@RequestParam("songuoi") int songuoi, @RequestParam("nhandip") String nhandip,
			@RequestParam("email") String email, @RequestParam("sdt") String sdt, @RequestParam("ghichu") String ghichu,
			@RequestParam(value = "check", required = false, defaultValue = "false") boolean check,
			HttpSession httpSession) {
		Session session = factory.openSession();
		String ho1 = ho.trim();
		String ten1 = ten.trim();
		String email1 = email.trim();
		String sdt1 = sdt.trim();
		String ghichu1 = ghichu.trim();

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

		NhaHang nhahang = (com.entity.NhaHang) session.get(NhaHang.class, idnhahang);
		KhuyenMai khuyenmai = (KhuyenMai) session.get(KhuyenMai.class, idkm);
		NguoiDung nguoidung = (NguoiDung) httpSession.getAttribute("nd");

		Date ngaytao = new Date();
		Transaction t = session.beginTransaction();

		HoaDon hoadon = new HoaDon(ho1, ten1, email1, sdt1, nhandip, ghichu1, songuoi, 0, check, thoigian, date,
				new Date(), khuyenmai, nhahang, nguoidung);

		try {
			session.save(hoadon);
			t.commit();
			httpSession.setAttribute("hoadon", hoadon);
			httpSession.setAttribute("nhahang", nhahang);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			t.rollback();
			re.addFlashAttribute("message", "Đặt chỗ thất bại!");
			return "redirect:/datban/index/" + idnhahang + ".html";
		} finally {
			session.close();
		}
		try {
			mailer.send(email, "Thông tin bàn ăn của bạn",
					"<div>Xin chào " + ten1
							+ " <div>Để xem thông tin bàn cũng như để gọi món vui lòng bấm vào link dưới đây!<br/><div ><a href='http://localhost:9999/DatBanAn/datban/thongtinbanan.html?email="
							+ email + "&idhoadon=" + hoadon.getId() + "'>Thông tin bàn ăn</a></div></div></div>");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/datban/thongtindatban.html";
	}

	@ModelAttribute("list-nhandip")
	public Map<String, String> getListNhanDip() {
		return nhanDipDAO.getListNhanDip();
	}

	// Thông tin
	@RequestMapping(value = "thongtin")
	public String thongtin(ModelMap model) {

		return "user/thongtin";
	}

	// Thông tin ban an
	@RequestMapping(value = "thongtinbanan", method = RequestMethod.GET)
	public String thongtinbanan(ModelMap model, @RequestParam("email") String email,
			@RequestParam("idhoadon") int idhoadon) {
		Session session = factory.getCurrentSession();

		try {
			String hqll = "FROM HoaDon where id =:id and email =:email";
			Query queryy = session.createQuery(hqll);
			queryy.setParameter("id", idhoadon);
			queryy.setParameter("email", email);
			HoaDon hd = (HoaDon) queryy.uniqueResult();
			NhaHang nhahang = hd.getNhahang();
			int idnhahang = nhahang.getId();
			String hql = "FROM MonAn where idnhahang =:idnhahang";
			Query query = session.createQuery(hql);
			query.setParameter("idnhahang", idnhahang);
			@SuppressWarnings("unchecked")
			List<MonAn> list = query.list();
			model.addAttribute("monan", list);
			model.addAttribute("hoadon", hd);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("loi", "loi");
			return "user/thongtinbanan";
		}

		return "user/thongtinbanan";
	}

	// Check tồn tại email
	@RequestMapping(value="kt-email",method = RequestMethod.GET)
	public @ResponseBody String ktemail(@RequestParam("email") String email,
			
			HttpServletResponse response,
			HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();
		
		String hql="FROM HoaDon where email =:email";
		Query query = session.createQuery(hql);
		
		query.setParameter("email", email);
		
		@SuppressWarnings("unchecked")
		List<HoaDon>list = query.list();
		
		if(list.size()>0){
			return "true";
		}else{
			return "false";
		}
	}
	// Check tồn tại hoa don
		@RequestMapping(value="kt-hoadon",method = RequestMethod.GET)
		public @ResponseBody String ktHoadon(
				@RequestParam("idhoadon") int id,
				@RequestParam("email") String email,
				HttpServletResponse response,
				HttpServletRequest request){
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				// TODO: handle exception
			}
			response.setCharacterEncoding("UTF-8");
			Session session = factory.getCurrentSession();
			
			String hql="FROM HoaDon where id =:id and email =:email ";
			Query query = session.createQuery(hql);
			
			query.setParameter("id", id);
			query.setParameter("email", email);
			HoaDon hd = (HoaDon) query.uniqueResult();
			
			if(hd!=null){
				return "true";
			}else{
				return "false";
			}
		}
	
}
