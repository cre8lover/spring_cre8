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
			
			model.addAttribute("err", "비밀번호를 확인해주세요");
			viewPage = "/member/login";
			break;
			
		case "no_member" :
			
			model.addAttribute("err", "회원정보를 확인해주세요");
			viewPage = "/member/login";
			break;
			
		default :
			model.addAttribute("err", "회원정보를 확인해주세요");
			viewPage = "/member/login";
			
		}
		return viewPage;

	}
	
	@GetMapping("loginout")
	public String logout(HttpSession sess) {
	
		sess.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("memreg")
	public String memreg() {
		
		return "/member/memreg";
	}
	
	@PostMapping("memregform")
	public String register(Mem mem) {
		
		member.insert(mem);
		
		return "/member/login";
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
		
		return "redirect:/mem/meminfo";
	}
	
	@GetMapping("buyHistory")
	public String buyHistory(HttpSession sess,
							Model model){
		String sess_id = (String)sess.getAttribute("sess_id");

		 List<Pro> pro = member.membuylist(sess_id);
		
		model.addAttribute("buy", pro);
		
		Map<String, List<Cart>> auc = member.memauclist(sess_id);
		List<Cart> cart = auc.get("END");
		List<Cart> car2 = auc.get("ING");
		
		if(cart != null) {
			model.addAttribute("cart", cart);
		}
		if(car2 != null) {
			model.addAttribute("car2", car2);
		}
		
		Map<String, List<Ship>> ship = member.ordercheck(sess_id);
		
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
			
			model.addAttribute("lostpw", "회원님의 임시비밀번호는"+findpw.get("lostpw")+"입니다.");
			
			break;
			
		case "pwfail" :
			
			model.addAttribute("lostpw", "회원정보를 확인해주세요");
			
			break;
			
		case "no_member" :
			
			model.addAttribute("lostpw", "회원정보를 확인해주세요");
			
			break;
			
		case "null" :
			
			model.addAttribute("lostpw", "회원정보를 확인해주세요");
			
			break;
			
		default :
			
			model.addAttribute("lostpw", "회원정보를 확인해주세요");

		}
		
		return "/member/login";
	}
	
	@PostMapping("findId")
	public String find(Mem mem, Map<String, String> findid,
						Model model) {
		String lostid = mem.getMemId();
		
		findid = member.findId(lostid);
		
		switch(findid.get("find")) {
		case "ok" :
			
			model.addAttribute("lostid", "회원님의 아이디는"+findid.get("lostid")+"입니다.");
			
			break;
			
		case "pwfail" :
			
			model.addAttribute("lostid", "회원정보를 확인해주세요");
			
			break;
			
		case "no_member" :
			
			model.addAttribute("lostid", "회원정보를 확인해주세요");
			
			break;
			
		default :
			
			model.addAttribute("lostid", "회원정보를 확인해주세요");

		}
		
		return "/member/login";
	}
	
	@PostMapping("changepw")
	public String change(HttpSession sess, Model model,Map<String, String> find,
						@RequestParam("find_id") String find_id,
						@RequestParam("n_password") String now_pw,
						@RequestParam("c_password") String new_pw) {
		
		String sess_id = (String)sess.getAttribute("sess_id");
		
		if(find_id.equals(sess_id)) {
			
			find = member.changePw(new_pw, find_id, now_pw);
			model.addAttribute("change", find.get("change"));
			
		} else {
			model.addAttribute("change", "no_member");
		}
		
		return "redirect:/mem/mypage";
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
