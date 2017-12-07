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
import com.entity.BanAn;
import com.entity.ChiTietHoaDon;
import com.entity.HoaDon;
import com.entity.KhuyenMai;
import com.entity.MonAn;
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.entity.TienIch;
import com.services.Mailer;

@Transactional
@Controller
@RequestMapping("datban")
public class OpenTableController {
	@Autowired
	private NhanDipDao nhanDipDAO;
	@Autowired
	SessionFactory factory;

	// Tao form dat ban
	@RequestMapping(value = "index/{id}", method = RequestMethod.GET)
	public String datban(ModelMap model, @PathVariable("id") int id, @RequestParam("idkm") int idkmm) {
		Session session = factory.getCurrentSession();
		NhaHang nhahang = (NhaHang) session.get(NhaHang.class, id);
		KhuyenMai khuyenmai = (KhuyenMai) session.get(KhuyenMai.class, idkmm);
		model.addAttribute("khuyenmai", khuyenmai);
		model.addAttribute("nhahang", nhahang);

		return "homepage/datban/datban";
	}

	// Tao form dat ban khi khong co khuyen mai
	@RequestMapping(value = "index1/{id}", method = RequestMethod.GET)
	public String FormDatBan(ModelMap model, @PathVariable("id") int id) {
		Session session = factory.getCurrentSession();
		NhaHang nhahang = (NhaHang) session.get(NhaHang.class, id);

		model.addAttribute("nhahang", nhahang);

		return "homepage/datban/datbankhongkhuyenmai";
	}

	// Tran thong tin dat ban
	@RequestMapping(value = "thongtindatban")
	public String thongtindatban(ModelMap model) {

		return "homepage/datban/thongtindatban";
	}

	// dat ban
	@Autowired
	Mailer mailer;

	@RequestMapping(value = "xacnhandatban", method = RequestMethod.POST)
	public String xacnhandat(ModelMap model, RedirectAttributes re, @RequestParam("idnhahang") int idnhahang,
			@RequestParam("idkhuyenm") int idkm1, @RequestParam("ho") String ho, @RequestParam("ten") String ten,
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
		Date ngaytao = new Date();
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
		KhuyenMai khuyenmai = (KhuyenMai) session.get(KhuyenMai.class, idkm1);
		NguoiDung nguoidung = (NguoiDung) httpSession.getAttribute("nd");

		Transaction t = session.beginTransaction();

		HoaDon hoadon = new HoaDon(ho1, ten1, email1, sdt1, nhandip, ghichu1, songuoi, 0, check, thoigian, date,
				ngaytao, khuyenmai, nhahang, nguoidung);

		try {
			session.save(hoadon);
			t.commit();
			httpSession.setAttribute("hoadon", hoadon);
			httpSession.setAttribute("nhahang", nhahang);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			t.rollback();
			re.addFlashAttribute("message", "Đặt bàn thất bại!");
			return "redirect:/datban/index/" + idnhahang + ".html";
		} finally {
			session.close();
		}
		try {
			/*mailer.send(email, "Thông tin bàn ăn của bạn",
					"<div>Xin Chào: " + ten1
							+ " <div>Để xem thông tin bàn ăn của bạn bấm vào link dưới đây!<br/><div ><a href='http://localhost:9999/DatBanAn/datban/thongtinbanan.html?email="
							+ email + "&idhoadon=" + hoadon.getId() + "'>Thông tin bàn ăn</a></div></div></div>");*/
			mailer.send(email, "Thông tin bàn ăn của bạn",
					"<link rel="+"'stylesheet'" +"href="+"'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'"+">"
					+"<link rel="+"'stylesheet'"+" href="+"'https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'"+">"
					
					+" <div class="+"'form-gap'"+"></div>"
					+"<div class="+"'container'"+">"
					+"	<div class="+"'row'"+">"
					+"		<div class="+"'col-md-4 col-md-offset-4'"+">"
					+"            <div class="+"'panel panel-default'"+">"
					+"              <div class="+"'panel-body'"+">"
					+"               <div class="+"'text-center'"+">"
					+"                 <h3><i class="+"'fa fa-cutlery fa-4x'"+"></i></h3>"
					+"                  <h2 class="+"'text-center'"+" style="+"'text-align: center;'"+">Thông tin bàn ăn</h2>"
					+"                 <p style="+"'text-align: center;'"+">Bạn có thể gọi món hoặc thanh toán</p>"
					+"                  <div class="+"'panel-body'"+">"
					    
					+"                   <form id="+"'register-form'" +"role="+"'form'" +"autocomplete="+"'off'" +"class="+"'form'" +"method="+"'post'"+">"
					    
					                      
					+"                      <div class="+"'form-group'"+" style="+"'text-align: center;'"+">"
					+"                        <a href='http://localhost:9999/DatBanAn/datban/thongtinbanan.html?email="
							+ email + "&idhoadon=" + hoadon.getId() + "' type="+"button" +"class="+"btn btn-lg btn-primary btn-block"  +">Xem thông tin bàn của bạn</a>"
					+"                      </div>"
					                      
					
					+"                    </form>"
					    
					 +"                 </div>"
					 +"               </div>"
					+"              </div>"
					 +"           </div>"
					+"          </div>"
					+"	</div>"
					+"</div>");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/datban/thongtindatban.html";
	}
	// dat ban khi khong co khuyen mai

	@RequestMapping(value = "xacnhandatbankokm", method = RequestMethod.POST)
	public String xacnhandatban1(ModelMap model, RedirectAttributes re, @RequestParam("idnhahang") int idnhahang,
			@RequestParam("ho") String ho, @RequestParam("ten") String ten, @RequestParam("ngaythang") String ngaythang,
			@RequestParam("thoigian") String thoigian, @RequestParam("songuoi") int songuoi,
			@RequestParam("nhandip") String nhandip, @RequestParam("email") String email,
			@RequestParam("sdt") String sdt, @RequestParam("ghichu") String ghichu,
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

		try {
			date = df.parse(ngaythang);
			System.out.println(date);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.toString());
			e1.printStackTrace();
		}

		NhaHang nhahang = (com.entity.NhaHang) session.get(NhaHang.class, idnhahang);

		NguoiDung nguoidung = (NguoiDung) httpSession.getAttribute("nd");

		Date ngaytao = new Date();
		Transaction t = session.beginTransaction();

		HoaDon hoadon = new HoaDon(ho1, ten1, email1, sdt1, nhandip, ghichu1, songuoi, 0, check, thoigian, date,
				new Date(), nhahang, nguoidung);

		try {
			session.save(hoadon);
			t.commit();
			httpSession.setAttribute("hoadon", hoadon);
			httpSession.setAttribute("nhahang", nhahang);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			t.rollback();
			re.addFlashAttribute("message", "Đặt bàn thất bại!");
			return "redirect:/datban/index/" + idnhahang + ".html";
		} finally {
			session.close();
		}
		try {
			mailer.send(email, "Thông tin bàn ăn của bạn",
					"<div>Xin Chào: " + ten1
							+ " <div>Để xem thông tin bàn ăn của bạn bấm vào link dưới đây!<br/><div ><a href='http://localhost:9999/DatBanAn/datban/thongtinbanan.html?email="
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

	// Thong tin
	@RequestMapping(value = "thongtin")
	public String thongtin(ModelMap model) {

		return "homepage/datban/thongtin";
	}

	// Thong tin ban an
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

			String hql = "FROM MonAn where idnhahang =:idnhahang and trangthai=0";
			Query query = session.createQuery(hql);
			query.setParameter("idnhahang", idnhahang);

			String hqlcthd = "FROM ChiTietHoaDon where idhoadon =:idhoadon ";
			Query querycthd = session.createQuery(hqlcthd);
			querycthd.setParameter("idhoadon", idhoadon);

			@SuppressWarnings("unchecked")
			List<MonAn> list = query.list();
			@SuppressWarnings("unchecked")
			List<ChiTietHoaDon> listcthd = querycthd.list();
			double tongtien = 0;
			for (int i = 0; i < listcthd.size(); i++) {
				ChiTietHoaDon ct = listcthd.get(i);
				if(ct.getTrangthai() == 1){
					tongtien = tongtien + ct.getMonan().getGia();

				}
			}
			model.addAttribute("tongtien", tongtien);
			model.addAttribute("monan", list);
			model.addAttribute("cthd", listcthd);
			model.addAttribute("hoadon", hd);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Xem thông tin thất bại");
			return "homepage/datban/thongtinbanan";
		}

		return "homepage/datban/thongtinbanan";
	}

	// check trung email
	@RequestMapping(value = "kt-email", method = RequestMethod.GET)
	public @ResponseBody String ktemail(@RequestParam("email") String email,

	HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();

		String hql = "FROM HoaDon where email =:email";
		Query query = session.createQuery(hql);

		query.setParameter("email", email);

		@SuppressWarnings("unchecked")
		List<HoaDon> list = query.list();

		if (list.size() > 0) {
			return "true";
		} else {
			return "false";
		}
	}

	// check hoa don
	@RequestMapping(value = "kt-hoadon", method = RequestMethod.GET)
	public @ResponseBody String ktHoadon(@RequestParam("idhoadon") int id, @RequestParam("email") String email,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();

		String hql = "FROM HoaDon where id =:id and email =:email ";
		Query query = session.createQuery(hql);

		query.setParameter("id", id);
		query.setParameter("email", email);
		HoaDon hd = (HoaDon) query.uniqueResult();

		if (hd != null) {
			return "true";
		} else {
			return "false";
		}
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
				ChiTietHoaDon cthd = new ChiTietHoaDon(0, hd, monan);
				session.save(cthd);
			}
			t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
		} finally {
			session.close();
		}

		return "redirect:/datban/thongtinbanan.html?email=" + hd.getEmail() + "&idhoadon=" + hd.getId() + "";
	}

	// Xoa Mon
	@RequestMapping(value = "delete/{id}")
	public String deletemon(ModelMap model, @PathVariable("id") Integer id,RedirectAttributes re,
			@RequestParam("idhoadon") int idhoadon) {
		Session session = factory.openSession();
		ChiTietHoaDon ct = (ChiTietHoaDon) session.get(ChiTietHoaDon.class, id);
		HoaDon hd = (HoaDon) session.get(HoaDon.class, idhoadon);
		Transaction t = session.beginTransaction();
		if(ct.getTrangthai()==1){
			re.addFlashAttribute("koxoadc", "Món đã được làm không thể xoá");
			return "redirect:/datban/thongtinbanan.html?email=" + hd.getEmail() + "&idhoadon=" + hd.getId() + "";
		}
		if(ct.getTrangthai()==2){
			re.addFlashAttribute("koxoadc", "Món đã hết bạn thông bảm");
			try {

				session.delete(ct);
				t.commit();
				model.addAttribute("message", "Xoá thành công");

			} catch (Exception e) {
				t.rollback();
				
				model.addAttribute("message", "Xoá thất bại !" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/datban/thongtinbanan.html?email=" + hd.getEmail() + "&idhoadon=" + hd.getId() + "";
		}
		try {

			session.delete(ct);
			t.commit();
			model.addAttribute("message", "Xoá thành công");

		} catch (Exception e) {
			t.rollback();
			
			model.addAttribute("message", "Xoá thất bại !" + e.getMessage());
		} finally {
			session.close();
		}
		return "redirect:/datban/thongtinbanan.html?email=" + hd.getEmail() + "&idhoadon=" + hd.getId() + "";
	}

	// Do yeu cau goi mon
	@RequestMapping(value = "yeucau")
	public String yeucau(ModelMap model, HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
		NhaHang nhahang = nd.getNhahang();
		int id = nhahang.getId();
		String hql = "FROM HoaDon where idnhahang =:idnhahang and trangthai=2";
		Query query = session.createQuery(hql);
		query.setParameter("idnhahang", id);

		@SuppressWarnings("unchecked")
		List<HoaDon> list = query.list();
		model.addAttribute("hoadon", list);

		
		model.addAttribute("tenbreadcrumb", "Yêu cầu gọi món");
		return "nhahang/hoadon/yeucaugoimon";
	}
	// Xoa yeu cau
		@RequestMapping(value = "xoayeucau/{id}")
		public String xoayeucau(ModelMap model, @PathVariable("id") Integer id
			) {
			Session session = factory.openSession();
			ChiTietHoaDon ct = (ChiTietHoaDon) session.get(ChiTietHoaDon.class, id);
			ct.setTrangthai(2);
			Transaction t = session.beginTransaction();

			try {

				session.update(ct);
				t.commit();
				model.addAttribute("message", "Xoá thành công");

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Xoá thất bại !" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/datban/yeucau.html";
		}
		// Duyet yeu cau
		@RequestMapping(value = "duyetmon/{id}")
		public String duyetyeucau(ModelMap model, @PathVariable("id") Integer id
			) {
			Session session = factory.openSession();
			ChiTietHoaDon ct = (ChiTietHoaDon) session.get(ChiTietHoaDon.class, id);
			ct.setTrangthai(1);
			Transaction t = session.beginTransaction();

			try {

				session.update(ct);
				t.commit();
				model.addAttribute("message", "Duyệt thành công");

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Duyệt thất bại !" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/datban/yeucau.html";
		}
		// gui yeu cau thanh toan
		@RequestMapping(value = "yeucauthanhtoan/{id}")
		public String yeucauthanhtoan(ModelMap model, @PathVariable("id") Integer id,RedirectAttributes re
			) {
			Session session = factory.openSession();
			HoaDon hd = (HoaDon) session.get(HoaDon.class, id);
			hd.setTrangthai(5);
			Transaction t = session.beginTransaction();

			try {

				session.update(hd);
				t.commit();
				re.addFlashAttribute("ycthanhtoan", "Bạn đã gửi yêu cầu xin vui lòng đợi");

			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "Gửi yêu cầu thất bại !" + e.getMessage());
			} finally {
				session.close();
			}
			return "redirect:/datban/thongtinbanan.html?email=" + hd.getEmail() + "&idhoadon=" + hd.getId() + "";
		}
		// Do yeu cau thanh toan
		@RequestMapping(value = "yeucauthanhtoan")
		public String yeucauthanhtoan(ModelMap model, HttpSession httpSession) {
			Session session = factory.getCurrentSession();
			NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");
			NhaHang nhahang = nd.getNhahang();
			int id = nhahang.getId();
			String hql = "FROM HoaDon where idnhahang =:idnhahang and trangthai=5";
			Query query = session.createQuery(hql);
			query.setParameter("idnhahang", id);

			@SuppressWarnings("unchecked")
			List<HoaDon> list = query.list();
			model.addAttribute("hoadon", list);

			
			model.addAttribute("tenbreadcrumb", "Yêu cầu thanh toán");
			return "nhahang/hoadon/yeucauthanhtoan";
		}
		// Duyet yeu cau
				@RequestMapping(value = "thanhtoan")
				public String thanhtoan(ModelMap model, @RequestParam("mahd") Integer id
					) {
					Session session = factory.openSession();
					HoaDon hd = (HoaDon) session.get(HoaDon.class, id);
					hd.setTrangthai(6);
					int idban = hd.getBanan().getId();
					BanAn ban = (BanAn) session.get(BanAn.class, idban);
					ban.setTrangthai(0);
					Transaction t = session.beginTransaction();

					try {

						session.update(hd);
						t.commit();
						model.addAttribute("message", "Thanh toán thành công");

					} catch (Exception e) {
						t.rollback();
						model.addAttribute("message", "Thanh toán thất bại !" + e.getMessage());
					} finally {
						session.close();
					}
					return "redirect:/datban/yeucauthanhtoan.html";
				}
				// Duyet yeu cau
				@RequestMapping(value = "hoadonthanhtoan")
				public String hoadonthanhtoan(ModelMap model, @RequestParam("mahd") Integer id
					) {
					Session session = factory.openSession();
					HoaDon hd = (HoaDon) session.get(HoaDon.class, id);
					hd.setTrangthai(6);
					int idban = hd.getBanan().getId();
					BanAn ban = (BanAn) session.get(BanAn.class, idban);
					ban.setTrangthai(0);
					Transaction t = session.beginTransaction();

					try {

						session.update(hd);
						t.commit();
						model.addAttribute("message", "Thanh toán thành công");

					} catch (Exception e) {
						t.rollback();
						model.addAttribute("message", "Thanh toán thất bại !" + e.getMessage());
					} finally {
						session.close();
					}
					return "redirect:/nhahang/hoadon/index.html";
				}
}
