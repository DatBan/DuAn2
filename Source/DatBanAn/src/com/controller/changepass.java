package com.controller;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.entity.NguoiDung;
import com.services.EnDeCryption;

public class changepass {

	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "doimaikhau", method = RequestMethod.POST)
	public String UpdateUserPwd(ModelMap model,
			@RequestParam("userid") int id, @RequestParam("pwdold") String pwdold, @RequestParam("pwdnew") String matkhau,RedirectAttributes re,
			@RequestParam("pwdnewr") String pwdnewr) {
		Session session = factory.openSession();
		NguoiDung user = (NguoiDung) session.get(NguoiDung.class, id);

		EnDeCryption cryption = new EnDeCryption("");
		String passmahoa = cryption.encoding(pwdold);
		String passmahoa1 = cryption.encoding(pwdnewr);
		Transaction t = session.beginTransaction();
		//

		try {
			if (!user.getMatkhau().equals(pwdold)) {
				model.addAttribute("message", "sai mk !");

			} else {
				user.setMatkhau(matkhau);
				session.update(user);
				t.commit();
				re.addFlashAttribute("message", "Đổi mật khẩu thành công !");

			}
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "chinh that bai !" + e.getMessage());
		} finally {
			session.close();
		}

		return "redirect:/user/mailer/doimk.html";
	}

	@RequestMapping("fogotpass")
	public String forgotPass() {

		return "user/fogotpass";
	}
}
