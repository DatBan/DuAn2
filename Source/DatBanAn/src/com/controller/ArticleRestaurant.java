package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.BaiViet;
import com.entity.BinhLuan;
import com.entity.LoaiBaiViet;
import com.entity.NguoiDung;
import com.services.DoiTenFile;

@Transactional
@RequestMapping("nhahang/baiviet/")
@Controller
public class ArticleRestaurant {
	@Autowired
	SessionFactory factory;	

	// Do du lieu ra trang quan ly
	@RequestMapping(value = "index")
	public String trangquanlyuser(ModelMap model, HttpSession httpSession) {
		Session session = factory.getCurrentSession();
		NguoiDung nguoidung = (NguoiDung) httpSession.getAttribute("nd");
		int idnd=nguoidung.getId();
		String hql = "FROM BaiViet where idnguoiviet =:idnguoiviet and trangthai=0 or trangthai=1 ORDER BY ngaytao DESC";		
		Query query = session.createQuery(hql);
		query.setParameter("idnguoiviet", idnd);
		@SuppressWarnings("unchecked")
		List<BaiViet> list = query.list();
		model.addAttribute("baiviet", list);
		
		model.addAttribute("btn_add","nhahang/baiviet/them.html");
		model.addAttribute("tenbreadcrumb", "Quản lý bài viết");
		return "nhahang/baiviet/quanlybaiviet";
	}

	// Tao giao dien them
	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String themBV(ModelMap model) {
		// Lay loai bai viet
		Session session = factory.getCurrentSession();
		String hql = "FROM LoaiBaiViet";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<LoaiBaiViet> list = query.list();
		model.addAttribute("loaibv", list);

		model.addAttribute("btn_back","nhahang/baiviet/index.html");
		model.addAttribute("tenbreadcrumb", "Thêm mới bài viết");
		model.addAttribute("tenbreadcrumb2", "Quản lý bài viết");
		model.addAttribute("urlbreadcrumb2", "nhahang/baiviet/index.html");
		return "nhahang/baiviet/thembaiviet";
	}
	// Them bai viet

	@Autowired
	ServletContext context;

	@RequestMapping(value = "thembaiviet", method = RequestMethod.POST)
	public String themBaiViet(ModelMap model, @RequestParam("tieude") String tieude, @RequestParam("name") String name,
			@RequestParam("area1") String noidung, @RequestParam("area2") String content,
			@RequestParam("slug") String slug, @RequestParam("mota") String mota, @RequestParam("idloai") int idloai,
			// @RequestParam("idnd")int idnd,
			@RequestParam("hinh") MultipartFile hinh, HttpSession httpSession) {
		Session session = factory.openSession();
		
		String td = tieude.trim();
		String n = name.trim();
		String sl = slug.trim();
		NguoiDung nd = (NguoiDung) httpSession.getAttribute("nd");

		LoaiBaiViet loaibv = (LoaiBaiViet) session.get(LoaiBaiViet.class, idloai);
		Date ngaytao = new Date();

		// lay loai bai viet khi them that bai
		String hql = "FROM LoaiBaiViet";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<LoaiBaiViet> list = query.list();
		model.addAttribute("loaibv", list);
		if (noidung.length() < 200 || content.length() < 200) {
			model.addAttribute("message", "Ná»™i dung hoáº·c content khÃ´ng há»£p lá»‡");

			return "nhahang/baiviet/thembaiviet";

		}
		String tenhinh = DoiTenFile.DoiFile(hinh.getOriginalFilename());
		String photoPath = context.getRealPath("/upload/baiviet/" +tenhinh );
		// String rootPath = context.getRealPath("/");
		// String filePath =
		// rootPath.substring(0,rootPath.indexOf(".metadata"))+
		// "WebContent\\ubload\\";
		System.out.println(photoPath);

		Transaction t = session.beginTransaction();
		String hinhanh;
		try {
			hinh.transferTo(new File(photoPath));
			hinhanh = tenhinh;			
			BaiViet baiviet = new BaiViet(td, n, noidung, content, hinhanh, sl, mota, 0, ngaytao, loaibv, nd);
			session.save(baiviet);
			t.commit();
			Thread.sleep(5000);
			return "redirect:/nhahang/baiviet/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			model.addAttribute("message", "Thêm bài viết thất bại!");
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}

		return "nhahang/baiviet/thembaiviet";
	}

	// Xoa bai viet
	@RequestMapping(value = "delete/{id}")
	public String deleteBaiviet(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.openSession();
		BaiViet bv = (BaiViet) session.get(BaiViet.class, id);
		
		bv.setTrangthai(3);

		Transaction t = session.beginTransaction();
		try {
			
			session.update(bv);
			t.commit();
			model.addAttribute("message", "Xoá thành công");

		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xoá thất bại !" + e.getMessage());
		} finally {
			session.close();
		}
		return "redirect:/nhahang/baiviet/index.html";
	}

	// Kiem tra trung ten bai viet
	@RequestMapping(value = "kt-trung-tieude", method = RequestMethod.GET)
	public @ResponseBody String ktTrungtieude(@RequestParam("tieude") String tieude, @RequestParam("idbv") int id,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();

		String hql = "FROM BaiViet  WHERE tieude =:tieude and trangthai=0 or trangthai=1";
		Query query = session.createQuery(hql);
		query.setParameter("tieude", tieude);
		BaiViet bv = (BaiViet) query.uniqueResult();
		if (bv != null) {
			if (bv.getId() == id) {
				return "true";
			}
			return "false";
		} else {
			return "true";
		}
	}

	// Kiem tra trung name bai viet
	@RequestMapping(value = "kt-trung-name", method = RequestMethod.GET)
	public @ResponseBody String ktTrungname(@RequestParam("name") String name, @RequestParam("idbv") int id,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.setCharacterEncoding("UTF-8");
		Session session = factory.getCurrentSession();

		String hql = "FROM BaiViet  WHERE name =:name and trangthai=0 or trangthai=1";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		BaiViet bv = (BaiViet) query.uniqueResult();
		if (bv != null) {
			if (bv.getId() == id) {
				return "true";
			}
			return "false";
		} else {
			return "true";
		}
	}

	// Tao giao dien sua bai viet
	@RequestMapping(value = "edit/{id}")
	public String editFormTrang(ModelMap model, @PathVariable("id") Integer id) {
		Session session = factory.getCurrentSession();
		BaiViet baiviet = (BaiViet) session.get(BaiViet.class, id);
		// lay loai bai viet
		String hql = "FROM LoaiBaiViet";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<LoaiBaiViet> list = query.list();
		model.addAttribute("loaibv", list);
		model.addAttribute("bv", baiviet);
		
		model.addAttribute("btn_back","nhahang/baiviet/index.html");
		model.addAttribute("tenbreadcrumb", "Sửa thông tin bài viết");
		model.addAttribute("tenbreadcrumb2", "Quản lý bài viết");
		model.addAttribute("urlbreadcrumb2", "nhahang/baiviet/index.html");
		return "nhahang/baiviet/editbaiviet";
	}
	
	// Sua bai viet
	@RequestMapping(value = "suabv", method = RequestMethod.POST)
	public String suaBaiviet(ModelMap model, RedirectAttributes re, @RequestParam("idbv") int id,
			@RequestParam("tieude") String tieude, @RequestParam("name") String name, @RequestParam("slug") String slug,
			@RequestParam("area1") String noidung, @RequestParam("area2") String content,
			@RequestParam("mota") String mota, @RequestParam("idloai") int idloai,
			// @RequestParam("idnd")int idnd,
			@RequestParam("hinh") MultipartFile hinh, HttpSession httpSession) {
		Date ngaysua = new Date();
		Session session = factory.openSession();
		BaiViet bv = (BaiViet) session.get(BaiViet.class, id);
		LoaiBaiViet loaibv = (LoaiBaiViet) session.get(LoaiBaiViet.class, idloai);
		String tenhinh = DoiTenFile.DoiFile(hinh.getOriginalFilename());
		String photoPath = context.getRealPath("/upload/baiviet/" +tenhinh );
		String td = tieude.trim();
		String tt = name.trim();
		String sl = slug.trim();
		bv.setTieude(td);
		bv.setName(tt);
		bv.setSlug(sl);
		bv.setNoidung(noidung);
		bv.setContent(content);
		bv.setNgaysua(ngaysua);
		bv.setLoaibv(loaibv);
		bv.setMota(mota);
		Transaction t = session.beginTransaction();
		// Lay loai bai viet
		String hql = "FROM LoaiBaiViet";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<LoaiBaiViet> list = query.list();
		model.addAttribute("loaibv", list);
		if (noidung.length() < 200 || content.length() < 200) {
			re.addFlashAttribute("message", "Nội dung hoặc content không hợp lệ");
			System.out.println(content.length());
			return "redirect:/nhahang/baiviet/edit/" + id + ".html";
		}
		String hinhanh = bv.getHinh();
		if (!hinh.isEmpty()) {
			try {
				hinh.transferTo(new File(photoPath));
				hinhanh = tenhinh;
				bv.setHinh(hinhanh);
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		try {
			session.update(bv);
			t.commit();
			model.addAttribute("message", "Chỉnh sửa thành công !");
			return "redirect:/nhahang/baiviet/index.html";
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			model.addAttribute("message", "Chỉnh sửa thất bại");
		} finally {
			session.close();
		}
		return "redirect:nhahang/baiviet/edit/" + id + ".html";
	}
}