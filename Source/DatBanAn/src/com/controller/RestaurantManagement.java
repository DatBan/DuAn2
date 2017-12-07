package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dao.BanAnDAO;
import com.dao.DistrictDAO;
import com.dao.LoaiAmThucDAO;
import com.dao.NguoiDungDAO;
import com.dao.NhaHangDAO;
import com.dao.ProvinceDAO;
import com.dao.QuyenDAO;
import com.dao.WardDAO;
import com.entity.District;
import com.entity.LoaiAmThuc;
import com.entity.NguoiDung;
import com.entity.NhaHang;
import com.entity.Province;
import com.entity.Quyen;
import com.entity.Ward;
import com.google.gson.Gson;
import com.services.DoiTenFile;
import com.services.GhiAnh;

@Transactional
@RequestMapping("dashboard/restaurants-mng")
@Controller
public class RestaurantManagement {
	@Autowired
	private QuyenDAO quyenDAO;
	@Autowired
	private NguoiDungDAO nguoidungDAO;
	@Autowired
	private BanAnDAO bananDAO;
	@Autowired
	private GhiAnh ghiAnh;
	@Autowired
	private NhaHangDAO nhahangDAO;
	@Autowired
	private LoaiAmThucDAO loaiamthucDAO;
	@Autowired
	private ProvinceDAO provinceDAO;
	@Autowired
	private DistrictDAO districtDAO;
	@Autowired
	private WardDAO wardDAO;
	@Autowired
	ServletContext context;

	@Autowired
	private SessionFactory factory;
	
	//trang danh sach nha hang
	@RequestMapping("")
	public String danhsach(ModelMap model, 
			@RequestParam(value="trangthai", defaultValue="1") int trangthai,
			HttpServletRequest httpRequest){
		
		model.addAttribute("dsnhahang", this.nhahangDAO.getListByTrangThai(trangthai));
		model.addAttribute("tenbreadcrumb", "danh sách nhà hàng đang hoạt động");
		if(trangthai == 0){
			model.addAttribute("tenbreadcrumb", "danh sách nhà hàng đã khóa");
		}
		model.addAttribute("btn_add","dashboard/restaurants-mng/them.html");
		model.addAttribute("tthai",trangthai);
		model.addAttribute("urlurl", httpRequest.getRequestURL());
		
		return "dashboard/restaurant/restaurant-mng";
	}

	@RequestMapping(value = "them", method = RequestMethod.GET)
	public String themTrang(ModelMap model,
			HttpServletRequest httpRequest) {		
		System.out.println(httpRequest.getServletMapping().getMatchValue());
		
		model.addAttribute("btn_back","dashboard/restaurants-mng.html?trangthai=1");
		model.addAttribute("tenbreadcrumb", "Thêm mới nhà hàng");
		model.addAttribute("tenbreadcrumb2", "Danh sách đang hoạt động");
		model.addAttribute("urlbreadcrumb2", "dashboard/restaurants-mng.html?trangthai=1");
		
		model.addAttribute("listnd", nguoidungDAO.getListByIdNhaHangNull());
		model.addAttribute("tinhthanh", this.provinceDAO.getListAll());
		model.addAttribute("loaiamthuc", this.loaiamthucDAO.getListAll());
		return "dashboard/restaurant/themnhahang";
	}
	
	@RequestMapping(value="select-province-ajax", method=RequestMethod.POST)
	public @ResponseBody void selectp_ajax(@RequestParam("provinceid") String provinceid,
			HttpServletResponse response) throws IOException{
		List<District> listD = this.districtDAO.getListByProvinceId(provinceid);
		String strList = "<option value=''>-Lựa chọn-</option>";
		District quan = new District();
		for (int i = 0; i < listD.size(); i++) {
			quan = listD.get(i);
			strList += "<option value='"+quan.getDistrictid()+"'>"+quan.getType()+" "+quan.getName()+"</option>";
		}
		Gson gson = new Gson();
		String gDistrict = gson.toJson(strList);
		
		response.getWriter().print(gDistrict);
	}
	
	@RequestMapping(value="select-district-ajax", method=RequestMethod.POST)
	public @ResponseBody void selectd_ajax(@RequestParam("districtid") String districtid,
			HttpServletResponse response) throws IOException{
		List<Ward> listW = this.wardDAO.getListByDistrictId(districtid);
		String strList = "<option value=''>-Lựa chọn-</option>";
		Ward phuong = new Ward();
		if(listW.size() > 0){
			for (int i = 0; i < listW.size(); i++) {
				phuong = listW.get(i);
				strList += "<option value='"+phuong.getWardid()+"'>"+phuong.getType()+" "+phuong.getName()+"</option>";
			}
		}else{
			strList = "";
		}
		
		Gson gson = new Gson();
		String gWard = gson.toJson(strList);
		
		response.getWriter().print(gWard);
	}

	@RequestMapping(value = "themnhahang", method = RequestMethod.POST)
	public String themmoiNhaHang(ModelMap model,
			@RequestParam(required = false, value = "tennhahang") String tennhahang,
			@RequestParam(required = false, value = "slug") String slug,
			@RequestParam(required = false, value = "loaiamthuc.id") int loaiamthuc,
			@RequestParam(required = false, value = "diachi") String diachi,
			@RequestParam(required = false, value = "tinhthanh.id") String tinhthanhid,
			@RequestParam(required = false, value = "quanhuyen.id") String quanhuyenid,
			@RequestParam(required = false, value = "phuongxa.id") String phuongxaid,
			@RequestParam(required = false, value = "sdt") String sdt,
			@RequestParam(required = false, value = "giomocua") String mocua,
			@RequestParam(required = false, value = "giodongcua") String dongcua,
			@RequestParam(required = false, value = "thumbnail") MultipartFile fileanh,
			@RequestParam(required = false, value = "gioithieu") String gioithieu,
			@RequestParam(required = false, value = "nguoidung.id", defaultValue="0") int nguoidungid,
			HttpSession httpSession,
			RedirectAttributes ra) {
		Session session = factory.getCurrentSession();
		try{
			String tnh = tennhahang.trim();
			String dc = diachi.trim();
			String dt = sdt.trim();
			String gt = gioithieu.trim();
			String sl = slug.trim();
		    
			/*ghi anh*/
			//Doi ten file theo chuan
		    String doifile = DoiTenFile.DoiFile(fileanh.getOriginalFilename());
		    //Tao ten file thoe chuan
		    String filename = ghiAnh.taoFileName(slug, doifile);
	
			//format thanh kieu date
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			
			Date giomocua = new Date();
			Date giodongcua = new Date();
			//ep kieu sang Date
			try {
				giodongcua = sdf.parse(dongcua);
				System.out.println("dongcua "+giodongcua);
				giomocua = sdf.parse(mocua);
				System.out.println("mocua "+giomocua);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//lay doi tuong loaiamthuc
			LoaiAmThuc loaiAT = (LoaiAmThuc) session.get(LoaiAmThuc.class, loaiamthuc);
			
			Province tinhthanh = (Province) session.get(Province.class, tinhthanhid);
			District quanhuyen = (District) session.get(District.class, quanhuyenid);
			Ward phuongxa = (Ward) session.get(Ward.class, phuongxaid);
			
			//tao doi tuong NhaHang
			NhaHang nh = new NhaHang(tnh, tnh, dc, tinhthanh, quanhuyen, phuongxa, 
					dt, filename, "", gt, gt, sl, 1, giomocua, giodongcua, new Date(), loaiAT);
			//tao moi voi doi tuong NhaHang
			this.nhahangDAO.createNhaHang(nh);
			
			//Tao duong dan anh theo chuan
		    String photoPath = ghiAnh.taoPhotoPathThumbnail(nh.getId()+"");
		    //tien hanh ghi anh
		    ghiAnh.GhiAnhTheoPathName(fileanh, photoPath, filename);
		    nh.setPhotopath(photoPath);
			this.nhahangDAO.updateNhaHang(nh);
			if(nguoidungid != 0){
				//LAy doi tuong NguoiDung
				NguoiDung nguoidung = (NguoiDung) session.get(NguoiDung.class, nguoidungid);
				Quyen quyen = (Quyen) session.get(Quyen.class, 2);
				nguoidung.setNhahang(nh);
				nguoidung.setQuyennd(quyen);
				this.nguoidungDAO.updateUser(nguoidung);
			}
			ra.addFlashAttribute("idnhmoi", nh.getId());
			ra.addFlashAttribute("addstt", "success");
		}catch(Exception e){
			System.out.println("LOI "+e.toString()+" quanlynhanhang.themmoiNhaHang()");
			e.printStackTrace();
			ra.addFlashAttribute("addstt", "error");
		}
		return "redirect:/dashboard/restaurants-mng.html";
	}
	//Phuong thuc khoa nha hang
	@RequestMapping(params="trash")
	public String removeUser(ModelMap model, 
			@RequestParam("idxoa") int id,
			HttpServletRequest httpRequest,
			RedirectAttributes ra) {	
		try{
			NhaHang nh = this.nhahangDAO.getById(id);
			nh.setTrangthai(0);
			
			this.nhahangDAO.updateNhaHang(nh);
			System.out.println("asd "+httpRequest.getRequestURL());
			
			ra.addFlashAttribute("trashstt", "success");
			ra.addFlashAttribute("tnhtrash", nh.getTennhahang());
		}catch(Exception e){
			System.out.println("LOI "+e.toString()+" RestaurantManagement.removeUser()");
			e.printStackTrace();
			ra.addFlashAttribute("trashstt", "error");
		}
		return "redirect:/dashboard/restaurants-mng.html?trangthai=0";
	}
	//Phuong thuc xoa nha hang
	@RequestMapping(params="delete")
	public String deleteUser(ModelMap model, 
			@RequestParam("idxoa") int id,
			HttpServletRequest httpRequest,
			RedirectAttributes ra) {
		Session session = factory.getCurrentSession();
		try{
			NhaHang nh = (NhaHang) session.get(NhaHang.class, id);
			this.nhahangDAO.deleteNhaHang(nh);
			
			/*this.bananDAO.deleteByIdNhaHang(id);*/
			//xoa thu muc cua nha hang
			String photoPath = context.getRealPath("/upload/"+nh.getId());
			File file = new File(photoPath);
			this.ghiAnh.xoaThuMuc(file);
			System.out.println("xoa "+httpRequest.getRequestURL());
			
			ra.addFlashAttribute("deletestt", "success");
			ra.addFlashAttribute("tnhd", nh.getTennhahang());
		}catch(Exception e){
			System.out.println("LOI "+e.toString()+" RestaurantManagement.deleteUser()");
			e.printStackTrace();
			ra.addFlashAttribute("deletestt", "error");
		}
		return "redirect:/dashboard/restaurants-mng.html?trangthai=0";
	}
	//Ham mo khoa nha hang
	@RequestMapping(params="restore")
	public String restoreUser(ModelMap model, 
			@RequestParam("idxoa") int id,
			HttpServletRequest httpRequest,
			RedirectAttributes ra) {		
		try{
			NhaHang nh = this.nhahangDAO.getById(id);
			nh.setTrangthai(1);
			this.nhahangDAO.updateNhaHang(nh);
			System.out.println("asd "+httpRequest.getRequestURL());
			
			ra.addFlashAttribute("restorestt", "success");
			ra.addFlashAttribute("tnhr", nh.getTennhahang());
		}catch(Exception e){
			System.out.println("LOI "+e.toString()+" RestaurantManagement.restoreUser()");
			e.printStackTrace();
			ra.addFlashAttribute("restorestt", "error");
		}
		return "redirect:/dashboard/restaurants-mng.html?trangthai=1";
	}
	//Ham lay thong tin nha hang
	@RequestMapping(params="edit")
	public String formEditNhaHang(ModelMap model,
			@RequestParam("idnhahang") int idnhahang) {		
		NhaHang nh = this.nhahangDAO.getById(idnhahang);
		System.out.println(nh.getNdowner());
		/*System.out.println("owner "+nh.getNdowner().getId());*/
		
		model.addAttribute("btn_back","dashboard/restaurants-mng.html?trangthai=1");
		model.addAttribute("tenbreadcrumb", "Cập nhật thông tin nhà hàng");
		model.addAttribute("tenbreadcrumb2", "Danh sách đang hoạt động");
		model.addAttribute("urlbreadcrumb2", "dashboard/restaurants-mng.html?trangthai=1");
		
		model.addAttribute("nhahango", nh);
		model.addAttribute("listnd", nguoidungDAO.getListByIdQuyenAndIdNhaHang(2, nh.getId()));
		model.addAttribute("tinhthanh", this.provinceDAO.getListAll());
		model.addAttribute("quanhuyen", this.districtDAO.getListByProvinceId(nh.getTinhthanh().getProvinceid()));
		model.addAttribute("phuongxa", this.wardDAO.getListByDistrictId(nh.getQuanhuyen().getDistrictid()));
		model.addAttribute("loaiamthuc", this.loaiamthucDAO.getListAll());
		return "dashboard/restaurant/editnhahang";
	}
	//Ham thuc hien cap nhat csdl nha hang
	@RequestMapping(value="editnhahang", method=RequestMethod.POST)
	public String editNhaHang(ModelMap model,
			@RequestParam("idnhahang") int idnhahang,
			@RequestParam("tennhahang") String tennhahang,
			@RequestParam("loaiamthuc.id") int loaiamthucid,
			@RequestParam("slug") String slug,
			@RequestParam("diachi") String diachi,
			@RequestParam("tinhthanh.provinceid") String tinhthanhid,
			@RequestParam("quanhuyen.districtid") String quanhuyenid,
			@RequestParam(value="phuongxa.wardid", required=false, defaultValue="0") String phuongxaid,
			@RequestParam("sdt") String sdt,
			@RequestParam(value="nguoidung.id", required=false, defaultValue="0") int nguoidungid,
			@RequestParam("giomocua") String strGiomocua,
			@RequestParam("giodongcua") String strGiodongcua,
			@RequestParam(value="thumbnail", required=false, defaultValue="NULL") MultipartFile fileanh,
			@RequestParam("gioithieu") String gioithieu,
			HttpServletRequest httpRequest,
			RedirectAttributes ra) {
		try{
			System.out.println("px "+phuongxaid +"\n nd"+nguoidungid);
			//Lay doi tuong TinhThanh
			Province tinhthanh = this.provinceDAO.getById(tinhthanhid);
			//Lay doi tuong QuanHuyen
			District quanhuyen = this.districtDAO.getById(quanhuyenid);
			//Lay doi tuong PhuongXa
			Ward phuongxa = this.wardDAO.getById(phuongxaid);
			System.out.println(phuongxa);
			//Lay doi tuong LoaiAmThuc
			LoaiAmThuc loaiamthuc = this.loaiamthucDAO.getById(loaiamthucid);
			
			//Tao doi tuong SimpleDateFormat
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			//Tao 2 doi tuong kieu java.util.Date()
			Date giomocua = new Date();
			Date giodongcua = new Date();
			//ep kieu sang Date
			try {
				giodongcua = sdf.parse(strGiodongcua);
				System.out.println("dongcua "+giodongcua);
				giomocua = sdf.parse(strGiomocua);
				System.out.println("mocua "+giomocua);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Lay doi tuong NhaHang theo id
			NhaHang nh = this.nhahangDAO.getById(idnhahang);
			//Thuc hien set lai gia tri
			nh.setTennhahang(tennhahang);
			nh.setSlug(slug);
			nh.setLoaiamthuc(loaiamthuc);
			nh.setDiachi(diachi);
			nh.setTinhthanh(tinhthanh);
			nh.setQuanhuyen(quanhuyen);
			nh.setPhuongxa(phuongxa);
			nh.setSdt(sdt);
			nh.setGiomocua(giomocua);
			nh.setGiodongcua(giodongcua);
			nh.setGioithieu(gioithieu);
			
			/*ghi anh*/
			if(!fileanh.getOriginalFilename().equals("")){
				//Doi ten file theo chuan
				System.out.println(fileanh.getOriginalFilename());
			    String doifile = DoiTenFile.DoiFile(fileanh.getOriginalFilename());
			    //Tao ten file thoe chuan
			    String filename = ghiAnh.taoFileName(slug, doifile);
			    nh.setThumbnail(filename);
				//Tao duong dan anh theo chuan
			    String photoPath = ghiAnh.taoPhotoPathThumbnail(nh.getId()+"");
			    //tien hanh ghi anh
			    ghiAnh.GhiAnhTheoPathName(fileanh, photoPath, filename);
			    nh.setPhotopath(photoPath);
			}
			this.nhahangDAO.updateNhaHang(nh);
			System.out.println(nguoidungid);
			if(nh.getNdowner() != null && nh.getNdowner().getId() != nguoidungid){
				NguoiDung owner = this.nguoidungDAO.getById(nh.getNdowner().getId());
				Quyen quyen = this.quyenDAO.getById(3);
				owner.setNhahang(null);
				owner.setQuyennd(quyen);
				this.nguoidungDAO.updateUser(owner);
				
				//LAy doi tuong NguoiDung
				NguoiDung nguoidung = this.nguoidungDAO.getByTrangThaiAndId(1, nguoidungid);
				//LAy doi tuong Quyen
				Quyen quyennd = this.quyenDAO.getById(2);
				nguoidung.setNhahang(nh);
				nguoidung.setQuyennd(quyennd);
				this.nguoidungDAO.updateUser(nguoidung);
			}else{
				//LAy doi tuong NguoiDung
				NguoiDung nguoidung = this.nguoidungDAO.getByTrangThaiAndId(1, nguoidungid);
				//LAy doi tuong Quyen
				Quyen quyennd = this.quyenDAO.getById(2);
				nguoidung.setNhahang(nh);
				nguoidung.setQuyennd(quyennd);
				this.nguoidungDAO.updateUser(nguoidung);
			}
			ra.addFlashAttribute("updatestt", "success");
		}catch(Exception e){
			System.out.println("LOI "+e.toString()+" quanlynhahang.editNhaHang()");
			e.printStackTrace();
			ra.addFlashAttribute("updatestt", "error");
		}
		return "redirect:/dashboard/restaurants-mng.html?edit&idnhahang="+idnhahang;
	}
}
