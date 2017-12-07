package com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.ProvinceDAO;
import com.entity.NguoiDung;
import com.entity.Province;
import com.google.gson.Gson;

@Controller
@RequestMapping("province")
public class AjaxDangKyController {
	@Autowired
	private ProvinceDAO provinceDAO;

	@RequestMapping("sua-slug")
	public @ResponseBody void sua_slug(HttpServletResponse response,
			@RequestParam("provincename") String provincename,
			@RequestParam("slug") String slug) throws IOException {
		Province province = this.provinceDAO.getByName(provincename);
		province.setSlug(slug);
		this.provinceDAO.updateProvince(province);
		Gson gson = new Gson();
		String json = gson.toJson("sad");
		response.getWriter().print(json);
	}
	/*
	 * public NguoiDung GetNguoiDung(String ggid) { Session session =
	 * this.factory.getCurrentSession(); NguoiDung nd = null; String hql =
	 * "FROM NguoiDung WHERE idgoogle=:ggid"; try { Query query =
	 * session.createQuery(hql); query.setParameter("ggid", ggid); nd =
	 * (NguoiDung) query.uniqueResult(); } catch (Exception e) { // TODO: handle
	 * exception System.out.println("loi " + e.toString()); }
	 * 
	 * return nd; }
	 */
}
