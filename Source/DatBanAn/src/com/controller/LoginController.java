package com.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.eclipse.jdt.internal.compiler.lookup.ConstraintExceptionFormula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.NguoiDungDAO;
import com.entity.NguoiDung;
import com.entity.Quyen;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.types.User;
import com.services.EnDeCryption;

@Controller
@Transactional
@RequestMapping("/")
public class LoginController {
	@Autowired
	private NguoiDungDAO userDAO;

	@Autowired
	SessionFactory factory;

	// Ham goi modal login
	@RequestMapping("modal-login")
	public String modal(ModelMap model) {
		model.addAttribute("nguoidung", new NguoiDung());
		return "homepage/modal-login";
	}

	// Dang nhap vao he thong
	/*
	 * @RequestMapping("login") public String login(ModelMap model,
	 * 
	 * @ModelAttribute("nguoidung") NguoiDung nd,
	 * 
	 * @RequestParam(value="remember", defaultValue="false", required=false)
	 * boolean rememberMe, HttpSession httpSession, HttpServletResponse
	 * response) { Session session = factory.openSession();
	 * 
	 * System.out.println(nd.getTendangnhap());
	 * response.setContentType("text/html");
	 * 
	 * NguoiDung nd2 = null; try { // Lay user theo tendangnhap nd2 =
	 * userDAO.getByUsername(nd.getTendangnhap());
	 * 
	 * // ma hoa mk EnDeCryption enDe = new EnDeCryption("sadasdasdsawqewq");
	 * String mk = enDe.encoding(nd.getMatkhau());
	 * 
	 * if (!mk.equals(nd2.getMatkhau())) { System.out.println("sai mk hihi");
	 * return "index"; } System.out.println(nd2.getHoten());
	 * 
	 * // kiem tra them vao cookie if (rememberMe) {
	 * 
	 * Cookie cktdn = new Cookie("cktdn", nd.getTendangnhap());
	 * cktdn.setPath("/"); cktdn.setMaxAge(60*60*24*365);
	 * response.addCookie(cktdn); NguoiDung ndc =
	 * this.userDAO.getByUsername(cktdn.getValue());
	 * httpSession.setAttribute("nd", ndc);
	 * 
	 * System.out.println("tru tru "+cktdn.getValue()); } else {
	 * httpSession.setAttribute("nd", nd2); } } catch (NullPointerException e) {
	 * System.out.println(e.toString()); return "index"; } return
	 * "redirect:/trang-chu.html"; }
	 */

	// phuong thuc dang xuat tai khoan. Xoa session va cookie
	@RequestMapping("logout")
	public String logout(HttpSession httpSession, HttpServletResponse response) {
		// xoa cookie va session
		Cookie cktdn = new Cookie("cktdn", "");
		cktdn.setMaxAge(0);
		Cookie ckgg = new Cookie("ckgg", "");
		ckgg.setMaxAge(0);
		Cookie ckfb = new Cookie("ckfb", "");
		ckfb.setMaxAge(0);
		response.addCookie(cktdn);
		response.addCookie(ckgg);
		response.addCookie(ckfb);
		httpSession.removeAttribute("nd");
		return "redirect:/trang-chu.html";
	}

	// Kiem tra dang nhap, ket hop voi ajax
	@RequestMapping(value = "kt-dang-nhap", method = RequestMethod.POST)
	public @ResponseBody String ktTrungTendangnhap(@RequestParam("tendangnhap") String tendangnhap,
			@RequestParam("matkhau") String mk,
			@RequestParam(value = "remember", defaultValue = "false", required = false) boolean rememberMe,
			HttpSession httpSession, HttpServletResponse response, HttpServletRequest request) {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * try { request.setCharacterEncoding("UTF-8"); } catch (Exception e) {
		 * // TODO: handle exception }
		 */
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		NguoiDung nd2 = null;
		try {
			// Lay user theo tendangnhap
			nd2 = userDAO.getByUsername(tendangnhap);

			// decode password
			EnDeCryption enDe = new EnDeCryption("sadasdasdsawqewq");
			String mkmh = enDe.encoding(mk);
			if (!mkmh.equals(nd2.getMatkhau())) {
				System.out.println("sai mk hihi");
				return "false";
			}
			if (nd2.getTrangthai() != 1) {
				return "khoa";
			}
		} catch (NullPointerException e) {
			System.out.println(e.toString());
		}
		// Kiem tra tai khoan ton tai
		if (nd2 != null) {
			if (rememberMe) {
				System.out.println("um");
				/* NguoiDung ndc = this.userDAO.getByUsername(tendangnhap); */

				Cookie cktdn = new Cookie("cktdn", tendangnhap);
				cktdn.setMaxAge(60 * 60 * 24 * 365);
				/*
				 * Cookie ckten = new Cookie("ckten", ndc.getTendangnhap());
				 * ckten.setMaxAge(60*60*365);
				 */

				response.addCookie(cktdn);
				/* response.addCookie(ckten); */
				httpSession.setAttribute("nd", nd2);

			} else {
				httpSession.setAttribute("nd", nd2);
			}
			return "true";
		} else {
			return "false";
		}
	}

	// phuong thuc dang xuat tai khoan. Xoa session va cookie
	@RequestMapping("google-login")
	public @ResponseBody void google_auth(HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "idtoken", required = false) String tokenid)
			throws GeneralSecurityException, IOException {
		if (httpSession.getAttribute("nd") != null) {
			response.getWriter().print("signedin1");
		} else {
			HttpTransport transport = new NetHttpTransport();
			JsonFactory jsonFactory = new JacksonFactory();
			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
					.setAudience(Collections
							.singletonList("400500533070-k8b9qaer0ndtklj1tblkrgqv2037bjd4.apps.googleusercontent.com"))
					// Or, if multiple clients access the backend:
					// .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2,
					// CLIENT_ID_3))
					.build();

			// (Receive idTokenString by HTTPS POST)

			GoogleIdToken idToken = verifier.verify(tokenid);
			if (idToken != null) {
				Payload payload = idToken.getPayload();

				// Print user identifier
				String userId = payload.getSubject();
				System.out.println("User ID: " + userId);

				// Get profile information from payload
				String email = payload.getEmail();
				boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
				String name = (String) payload.get("name");
				String pictureUrl = (String) payload.get("picture");
				String locale = (String) payload.get("locale");
				String familyName = (String) payload.get("family_name");
				String givenName = (String) payload.get("given_name");
				System.out.println(emailVerified);
				// Use or store profile information
				// ...
				Session session = factory.getCurrentSession();
				NguoiDung nd = userDAO.getByIdGoogle(userId);
				System.out.println("thu service nha");
				Quyen quyen = (Quyen) session.get(Quyen.class, 2);
				System.out.println("null k " + nd);
				// Kiem tra de dang ky tai khoan voi mxh
				if (nd == null) {
					NguoiDung ktEmail = this.userDAO.getByEmail(email);
					if (ktEmail != null) {
						email = null;
					}
					nd = new NguoiDung(name, null, null, email, "", "", 1, new Date(), quyen);
					nd.setIdgoogle(userId);
					// Goi ham them vao CSDL
					userDAO.createUser(nd);
					System.out.println("them them");
				}
				Cookie ckgg = new Cookie("ckgg", userId);
				ckgg.setMaxAge(60 * 60 * 24 * 365);
				response.addCookie(ckgg);
				httpSession.setAttribute("nd", nd);
			} else {
				System.out.println("Invalid ID token.");
			}
			response.getWriter().print("signedin2");
			/* response.sendRedirect("trang-chu.html"); */
		}
		/* return "signedin2"; */
	}

	@RequestMapping("facebook-login")
	public @ResponseBody void facebook_auth(HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "access_token", required = false) String tokenid)
			throws GeneralSecurityException, IOException {
		if (httpSession.getAttribute("nd") != null) {
			response.getWriter().print("signedin1");
		} else {
			Session session = factory.getCurrentSession();
			FacebookClient fbClient = new DefaultFacebookClient(tokenid, com.restfb.Version.VERSION_2_10);

			/*
			 * AccessToken exAccessToken =
			 * fbClient.obtainExtendedAccessToken("140114096632222",
			 * "a9ba61cf0fe0f9f4da49fc9e4ff99432");
			 */
			User me = fbClient.fetchObject("me", User.class,
					Parameter.with("fields", "picture,first_name,last_name,gender,name,email"));
			String hoten = me.getName();
			String email = me.getEmail();
			String idfacebook = me.getId();
			NguoiDung ktEmail = this.userDAO.getByEmail(me.getEmail());
			if (ktEmail != null) {
				email = null;
			}
			System.out.println(me);
			System.out.println(me.getName());
			System.out.println(me.getId());
			System.out.println(me.getEmail());
			NguoiDung nd = userDAO.getByIdFacebook(idfacebook);
			Quyen quyen = (Quyen) session.get(Quyen.class, 2);
			if (nd == null) {
				try {
					nd = new NguoiDung(hoten, null, null, email, "", "", 1, new Date(), quyen);
					nd.setIdfacebook(idfacebook);
					this.userDAO.createUser(nd);
				} catch (ConstraintViolationException e) {
					e.printStackTrace();
				}
			}
			Cookie ckfb = new Cookie("ckfb", idfacebook);
			ckfb.setMaxAge(60 * 60 * 24 * 365);
			response.addCookie(ckfb);
			httpSession.setAttribute("nd", nd);
			response.getWriter().print("signedin2");
		}
	}

}
