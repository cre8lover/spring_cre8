package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Cat;
import com.cre8.dto.Marketing;
import com.cre8.dto.Mem;
import com.cre8.service.AdminService;

@Controller
@RequestMapping("/master/")
public class Admincontroller {
	
	@Autowired
	private AdminService admin;
       

	@GetMapping("adminlogin")
	public String loginpage() {
		
		return "/admin/adminlogin";
	}
	
	@PostMapping("adminMain")
	public String adminpage(Mem mem, Model model, HttpSession sess) {
		
		String goView = null;
		
		String id = mem.getMemId();
		String pw = mem.getMemPw();
		
		Map<String, String> status = admin.login(id, pw);
		
		switch(status.get("login")) {
		case "ok" :
			
			sess.setAttribute("sess_id", id);
			sess.setAttribute("sess_name", status.get("name"));
			
			goView = "/admin/adminMain";
			break;
			
		case "pwfail" :
			
			model.addAttribute("err2", "ÎπÑÎ?Î≤àÌò∏Î•? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
			goView = "/admin/adminlogin";
			
			break;
			
		case "no_member" :
			
			model.addAttribute("err2", "Í∂åÌôò?ùÑ ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
			goView = "/admin/adminlogin";
			
			break;
			
		default :
			
			goView = "/admin/adminlogin.jsp";

		}
		
		return goView;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession sess) {
	
		sess.invalidate();
		
		return "redirect:/admin/adminlogin";
	}
	
	@GetMapping("category")
	public String categoryList(AdminKeyWord adkey, Model model) {
		
		List<Cat> category = admin.catelist(adkey);
		model.addAttribute("cate", category);
		model.addAttribute("key", adkey);
		
		return "/admin/category";
		
	}
	
	@GetMapping("member")
	public String memberlist(AdminKeyWord adkey, Model model) {
		
		List<Mem> member = admin.memberlist(adkey);
		model.addAttribute("member", member);
		model.addAttribute("key", adkey);
		
		return "/admin/member";
	}
	
	@GetMapping("creAd")
	public String marketingList(AdminKeyWord adkey, Model model) {
		
		List<Marketing> marketing = admin.marketinglist(adkey);
		model.addAttribute("marketing", marketing);
		model.addAttribute("key", adkey);
		
		return "/admin/creAd";
	}
/*			
		} else if(cmd.equals("creAd")) {
			AdminKeyWord adkey = new AdminKeyWord();
			
	        adkey.setKeyword(req.getParameter("keysearch"));
	        adkey.setClassification(req.getParameter("classification"));
	        adkey.setSdate(req.getParameter("sdate"));
	        adkey.setFdate(req.getParameter("fdate"));
			
			List<Marketing> marketing = admin.marketinglist(adkey);
			req.setAttribute("marketing", marketing);
	        req.setAttribute("key", adkey);

			goView(req, resp, "/admin/creAd.jsp");
			
		} else if(cmd.equals("adCheck")) {
			AdminKeyWord adkey = new AdminKeyWord();
			
	         adkey.setKeyword(req.getParameter("keysearch"));
	         adkey.setClassification(req.getParameter("classification"));
	         adkey.setSdate(req.getParameter("sdate"));
	         adkey.setFdate(req.getParameter("fdate"));

			List<Marketing> list = admin.purchase(adkey);
			req.setAttribute("key", adkey);
			req.setAttribute("list", list);
			
			List<Marketing> month = admin.month();
			req.setAttribute("month", month);
			
			List<Marketing> year = admin.year();
			req.setAttribute("year", year);
			
			goView(req, resp, "/admin/creAd2.jsp");
			
		} else if(cmd.equals("adreg")) {
			
			goView(req, resp, "/admin/admin_adreg.jsp");
			
		} else if(cmd.equals("marReg")) {
			admin.reg(req);

			goView(req, resp, "/admin/admin_adreg.jsp");
			
		} else if(cmd.equals("admodify")) {
			String seqno = req.getParameter("seqno");
			if(seqno !=null) { 
				Marketing market = admin.modify(seqno);

				req.setAttribute("market", market);
			}
			goView(req, resp, "/admin/admin_adreg2.jsp");

		} else if(cmd.equals("adupdate")) {
			admin.reg(req);
			goView(req, resp, "/master/admofiy");

		}
	}

*/
}
