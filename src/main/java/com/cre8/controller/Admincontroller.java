package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
			
			model.addAttribute("err2", "비�?번호�? ?��?��?��주세?��");
			goView = "/admin/adminlogin";
			
			break;
			
		case "no_member" :
			
			model.addAttribute("err2", "권환?�� ?��?��?��주세?��");
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
	
	@RequestMapping("category")
	public String categoryList(AdminKeyWord adkey, Model model) {
		
		List<Cat> category = admin.catelist(adkey);
		model.addAttribute("cate", category);
		model.addAttribute("key", adkey);
		
		return "/admin/category";
		
	}
	
	@RequestMapping("member")
	public String memberlist(AdminKeyWord adkey, Model model) {
		
		List<Mem> member = admin.memberlist(adkey);
		model.addAttribute("member", member);
		model.addAttribute("key", adkey);
		
		return "/admin/member";
	}
	
	@RequestMapping("creAd")
	public String marketingList(AdminKeyWord adkey, Model model) {
		
		List<Marketing> marketing = admin.marketinglist(adkey);
		model.addAttribute("marketing", marketing);
		model.addAttribute("key", adkey);
		
		return "/admin/creAd";
	}
	
	@RequestMapping("adCheck")
	public String marketingCheck(AdminKeyWord adkey, Model model) {
	
		List<Marketing> list = admin.purchase(adkey);
		model.addAttribute("key", adkey);
		model.addAttribute("list", list);
		
		List<Marketing> month = admin.month();
		model.addAttribute("month", month);
		
		List<Marketing> year = admin.year();
		model.addAttribute("year", year);
		
		return "/admin/creAd2";
	}
	
	@RequestMapping("adreg")
	public String marketReg() {
		
		return "/admin/admin_adreg";
	}
	
	@RequestMapping("marReg")
	public String marinsert(Marketing market, HttpServletRequest req) {
		admin.reg(market, req);

		return "/admin/admin_adreg";
	}
	
	@RequestMapping("admodify")
	public String marketingModify(@ModelAttribute("seqno") String seqno, Model model) {
		
			Marketing market = admin.modify(seqno);

			model.addAttribute("market", market);
		
		return "/admin/admin_adreg2";
	}
	
	@RequestMapping("adupdate")
	public String marketingUpdate(Marketing market, HttpServletRequest req) {
		
		admin.reg(market, req);
		
		return "/master/admofiy";
	}

}
