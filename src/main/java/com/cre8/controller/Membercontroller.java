package com.cre8.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cre8.dto.Address;
import com.cre8.dto.Att;
import com.cre8.dto.Cart;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.Ship;
import com.cre8.dto.Thumbnail;
import com.cre8.service.MemberService;
import com.cre8.service.MemberServiceImp;

@Controller
@RequestMapping("/mem/")
public class Membercontroller{
       
	@Autowired
	private MemberService member;
	
	@GetMapping("loginpage")
	public String loginpage() {
		
		return "/member/login";
	}
		
	@PostMapping("login")
	public String login(Mem mem, Model model, HttpSession sess) {
		
		String id = mem.getMemId();
		String pw = mem.getMemPw();
		String viewPage = null;
		Map<String, String> status = member.login(id, pw);
		
		switch(status.get("login")) {
		case "ok" :
			
			sess.setAttribute("sess_id", id);
			sess.setAttribute("sess_name", status.get("name"));
			sess.setAttribute("auth", status.get("auth"));
			
			viewPage = "/index";
			break;
		case "pwfail" :
			
			model.addAttribute("err", "鍮꾨�踰덊샇瑜� �솗�씤�빐二쇱꽭�슂");
			viewPage = "/member/login";
			break;
			
		case "no_member" :
			
			model.addAttribute("err", "�쉶�썝�쓣 �솗�씤�빐二쇱꽭�슂");
			viewPage = "/member/login";
			break;
			
		default :
			model.addAttribute("err", "�쉶�썝�쓣 �솗�씤�빐二쇱꽭�슂");
			viewPage = "/member/login";
			
		}
		return viewPage;

	}
	
	@GetMapping("loginout")
	public String logout(HttpSession sess) {
	
		sess.invalidate();
		
		return "redirect:/index";
	}
	
	@GetMapping("memreg")
	public void memreg() {
		
	}
	
	@PostMapping("memregform")
	public String register(Mem mem) {
		
		member.insert(mem);
		
		return "/mem/loginpage";
	}
	
	@GetMapping("mypage")
	public String mypage(HttpSession sess, Mem mem, 
						 Att att, Thumbnail thumb,
						 Model model) {
		String sess_id = (String)sess.getAttribute("sess_id");
		
		mem = member.mypage(sess_id);
		
		if(mem.getAtt().getAttName() == null) {
			mem.setAtt(att);
			mem.getAtt().setAttThumb(thumb);
			mem.getAtt().getAttThumb().setFileName("profile.png");
		}
		
		model.addAttribute("page", mem);
		
		return "/member/mypage";
	}

	@GetMapping("meminfo")
	public String info(Model model, HttpSession sess, Mem mem) {
		String sess_id = (String)sess.getAttribute("sess_id");
		mem = member.meminfo(sess_id);
		model.addAttribute("info",mem);
		
		return "/member/meminfo";
	}
	
	@PostMapping("infoinsert")
	public String infoinsert(Mem mem, Address add,
							HttpServletRequest req,
							Model model) {
		mem.setAddressSet(add);
		
		member.infoinsert(mem, req);
		
		return "/mem/meminfo";
	}
	
	@GetMapping("buyHistory")
	public String buyHistory(HttpSession sess, List<Pro> pro,
							Model model,
							Map<String, List<Cart>> auc,
							Map<String, List<Ship>> ship){
		String sess_id = (String)sess.getAttribute("sess_id");

		pro = member.membuylist(sess_id);
		
		model.addAttribute("buy", pro);
		
		auc = member.memauclist(sess_id);
		List<Cart> cart = auc.get("END");
		List<Cart> car2 = auc.get("ING");
		
		ship = member.ordercheck(sess_id);
		
		List<Ship> order = ship.get("order");
		List<Ship> detail = ship.get("detail");
		
		if(order != null) {
			model.addAttribute("order", order);
		}
		if(detail != null) {
			model.addAttribute("detail", detail);
		}
		
		List<Pro> stat = member.buystat(sess_id);
		model.addAttribute("stat", stat);
		
		return "/member/buyHistory";
	}
	
	@GetMapping("mainpage")
	public String mainpage() {
		
		return "/index";
	}
	
	@PostMapping("findpw")
	public String findpw(Mem mem, Map<String, String> findpw,
						Model model) {
		
		String lostid = mem.getMemId();
		String lostemail = mem.getMemEmail();
		
		findpw = member.findPw(lostid, lostemail);
		
		switch(findpw.get("find")) {
		case "ok" :
			
			model.addAttribute("lostpw", "�쉶�썝�떂�쓽 鍮꾨�踰덊샇�뒗 "+findpw.get("lostpw")+"�엯�땲�떎.");
			
			break;
			
		case "pwfail" :
			
			model.addAttribute("lostpw", "二쇱냼瑜� �솗�씤�빐二쇱꽭�슂");
			
			break;
			
		case "no_member" :
			
			model.addAttribute("lostpw", "�쉶�썝�젙蹂대�� �솗�씤�빐二쇱꽭�슂");
			
			break;
			
		case "null" :
			
			model.addAttribute("lostpw", "�쉶�썝�젙蹂대�� �솗�씤�빐二쇱꽭�슂");
			
			break;
			
		default :
			
			model.addAttribute("lostpw", "�쉶�썝�젙蹂대�� �솗�씤�빐二쇱꽭�슂");

		}
		
		return "/member/login";
	}
	
	@GetMapping("findId")
	public String find(Mem mem, Map<String, String> findid,
						Model model) {
		String lostid = mem.getMemId();
		
		findid = member.findId(lostid);
		
		switch(findid.get("find")) {
		case "ok" :
			
			model.addAttribute("lostid", "�쉶�썝�떂�쓽 �븘�씠�뵒�뒗 "+findid.get("lostid")+"�엯�땲�떎.");
			
			break;
			
		case "pwfail" :
			
			model.addAttribute("lostid", "�쉶�썝�젙蹂대�� �솗�씤�빐二쇱꽭�슂");
			
			break;
			
		case "no_member" :
			
			model.addAttribute("lostid", "�쉶�썝�젙蹂대�� �솗�씤�빐二쇱꽭�슂");
			
			break;
			
		default :
			
			model.addAttribute("lostid", "�쉶�썝�젙蹂대�� �솗�씤�빐二쇱꽭�슂");

		}
		
		return "/member/login";
	}
	
	@PostMapping("changepw")
	public String change(HttpSession sess, Model model,Map<String, String> find,
						@RequestParam("find_id") String find_id,
						@RequestParam("now_pw") String now_pw,
						@RequestParam("new_pw") String new_pw) {
		
		String sess_id = (String)sess.getAttribute("sess_id");
		
		if(find_id.equals(sess_id)) {
			
			find = member.changePw(new_pw, find_id, now_pw);
			model.addAttribute("change", find.get("change"));
			
		} else {
			model.addAttribute("change", "no_member");
		}
		
		return "/mem/mypage";
	}
	
//	@GetMapping("idCheck")
//	public int idcheck(@RequestParam("id") String id) {
//		int rs = member.idcheck(id);
//		PrintWriter out = resp.getWriter();
//		out.print(rs);
//		
//		return rs;
//	}

}
