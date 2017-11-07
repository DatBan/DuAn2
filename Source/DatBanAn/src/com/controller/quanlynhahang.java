package com.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.LoaiAmThuc;
import com.entity.NguoiDung;
import com.entity.NhaHang;






@Transactional
@RequestMapping("nhahang/")
@Controller
public class quanlynhahang {
	
	@Autowired
	ServletContext context;

	//xoa nhahang
	@Autowired
	SessionFactory factory;
		@RequestMapping(value="delete/{id}")
		public String DeleteUser(ModelMap model, @PathVariable("id") Integer id){
			Session session= factory.openSession();
			NhaHang trang = (NhaHang) session.get(NhaHang.class, id);
			Transaction t = session.beginTransaction();
			try {
				session.delete(trang);
				t.commit();
				model.addAttribute("message","xoa thanh cong");
				
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("message", "xoa that bai !" + e.getMessage());
			}finally {
				session.close();
			}
			return "redirect:/quanlynhahang/index.html";
		}
		
		
		@RequestMapping(value="them",method = RequestMethod.GET)
		public String themTrang(ModelMap model) {
			model.addAttribute("tenbreadcrumb","them nha hang moi");
			
			return "dashboard/quanlynhahang";
		}
		@RequestMapping(value="themnhahang",method = RequestMethod.POST)
		public String themmoiNhaHang(ModelMap model,
				@RequestParam(required=false, value = "tennhahang")String tennhahang,
				@RequestParam(required=false, value ="name")String name,
				@RequestParam(required=false, value ="diachi")String diachi,
				@RequestParam(required=false, value ="address")String address,
				@RequestParam(required=false, value ="tinhthanh")String tinhthanh,
				@RequestParam(required=false, value ="city")String city,
				@RequestParam(required=false, value ="quanhuyen")String quanhuyen,
				@RequestParam(required=false, value ="district")String district,
				@RequestParam(required=false, value ="phuongxa")String phuongxa,
				@RequestParam(required=false, value ="ward")String ward,
				@RequestParam(required=false, value ="sdt")String sdt,
				@RequestParam(required=false, value ="thumbnail") MultipartFile thumbnail,
				@RequestParam(required=false, value ="gioithieu")String gioithieu,
				@RequestParam(required=false, value ="aboutus")String aboutus,
				@RequestParam(required=false, value ="trangthai")int trangthai,
				@RequestParam(required=false, value ="mota")String mota,
				@RequestParam(required=false, value ="slug")String slug,
				@RequestParam(required=false, value ="loaiamthuc")LoaiAmThuc loaiamthuc,

				
				HttpSession httpSession) {
				Session session = factory.openSession();

				String tnh = tennhahang.trim();
				String dc = diachi.trim();
				String ad = address.trim();  
				String tt = tinhthanh.trim();
				String ct = city.trim();
				String qh = quanhuyen.trim();
				String dtris = district.trim();
				LoaiAmThuc lat = loaiamthuc;
				String px = phuongxa.trim();
				String wd = ward.trim();
				String dt = sdt.trim();
				String tb = context.getRealPath("/files/imges/" + thumbnail.getOriginalFilename());
				String gt = gioithieu.trim();
				String ab = aboutus.trim();
				String nm = name.trim();
				int tt2 = trangthai;
				String mt = mota.trim();
				String sl = slug.trim();
				
				
				
				Date ngaytao = new Date();
				Date giomocua = new Date();
				Date giodongcua = new Date();

				
				Transaction t = session.beginTransaction();
				try {
					thumbnail.transferTo(new File(tb));
					NhaHang nhaHang = new NhaHang(tnh, nm, dc, ad, tt, ct, qh, dtris, px, wd, dt, tb, gt, ab, sl, tt2, giomocua, giodongcua, ngaytao, lat);
					session.save(nhaHang);
					t.commit();
					model.addAttribute("message", "Thêm  thành công !");
					// model.addAttribute("user", user);
					return "redirect:themnhahang.htm";
				} catch (Exception e) {
					t.rollback();
					model.addAttribute("message", "Thêm  thất bại !");
				} finally {
					session.close();
				}
				model.addAttribute("message", "Thêm  thành công !");
				return "";			
		}
		//tao   nha hang
		@RequestMapping(value="edit/{id}")
		public String editFormTrang(ModelMap model, @PathVariable("id") Integer id){
			Session session = factory.getCurrentSession();
			NhaHang nh = (NhaHang) session.get(NhaHang.class, id);
			model.addAttribute("nhahang",nh);
			model.addAttribute("tenbreadcrumb","sua nha hang");
			return "dashboard/edittrang";
		}
		//sua
		@RequestMapping(value="suatrang",method = RequestMethod.POST)
		public String suaTrang(ModelMap model, @RequestParam("idtrang") int id,
				@RequestParam("tennhahang")String tennhahang,
				@RequestParam("name")String name,
				@RequestParam("diachi")String diachi,
				@RequestParam("address")String address,
				@RequestParam("tinhthanh")String tinhthanh,
				@RequestParam("city")String city,
				@RequestParam("quanhuyen")String quanhuyen,
				@RequestParam("district")String district,
				@RequestParam("phuongxa")String phuongxa,
				@RequestParam("ward")String ward,
				@RequestParam("sdt")String sdt,
				@RequestParam("thumbnail") MultipartFile thumbnail,
				@RequestParam("gioithieu")String gioithieu,
				@RequestParam("aboutus")String aboutus,
				@RequestParam("trangthai")int trangthai,
				@RequestParam("mota")String mota,
				@RequestParam("slug")String slug,
				@RequestParam("loaiamthuc")LoaiAmThuc loaiamthuc

				){
			
			Date ngaytao = new Date();
			Date giomocua = new Date();
			Date giodongcua = new Date();
			
			Session session = factory.openSession();
			NhaHang nh = (NhaHang) session.get(NhaHang.class, id);
			String tnh = tennhahang.trim();
			String dc = diachi.trim();
			String ad = address.trim();  
			String tt = tinhthanh.trim();
			String ct = city.trim();
			String qh = quanhuyen.trim();
			String dtris = district.trim();
			LoaiAmThuc lat = loaiamthuc;
			String px = phuongxa.trim();
			String wd = ward.trim();
			String dt = sdt.trim();
			String tb = context.getRealPath("/files/imges/" + thumbnail.getOriginalFilename());
			String gt = gioithieu.trim();
			String ab = aboutus.trim();
			String nm = name.trim();
			int tt2 = trangthai;
			String mt = mota.trim();
			String sl = slug.trim();
		
			
			nh.setTennhahang(tennhahang);
			nh.setName(name);
			nh.setDiachi(diachi);
			nh.setAddress(address);
			nh.setTinhthanh(tinhthanh);
			nh.setCity(city);
			nh.setQuanhuyen(quanhuyen);
			nh.setDistrict(district);
			nh.setPhuongxa(phuongxa);
			nh.setWard(ward);
			nh.setSdt(sdt);
		
			nh.setGioithieu(gioithieu);
			nh.setAboutus(aboutus);
			nh.setSlug(sl);
			nh.setTrangthai(trangthai);
			nh.setMota(mota);
			nh.setGiomocua(giomocua);
			nh.setGiodongcua(giodongcua);
			nh.setNgaytao(ngaytao);
		
			Transaction t = session.beginTransaction();
			try {
				session.update(nh);
				t.commit();
				model.addAttribute("message", "chinh sua thanh cong !");
				return "redirect:/quanlynhahang/index.html";
			} catch (Exception e) {
				// TODO: handle exception
				t.rollback();
				 model.addAttribute("message", "chinh sua that bai !");
			}finally {
				
				session.close();
			}
			return "dashboard/quanlynhahang";
		}
}
