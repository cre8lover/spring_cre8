package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cre8.dto.Att;
import com.cre8.dto.Cart;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.Ship;
import com.cre8.dto.Thumbnail;
import com.cre8.service.MemberServiceImp;

@Controller
@RequestMapping("/mem/*")
public class Membercontroller{
       
	@Autowired
	private MemberServiceImp member;
	
	@GetMapping("loginpage")
	public String loginpage() {
		
		return "/member/login";
	}
		
	@GetMapping("login")
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
			
			sess.setAttribute("err", "비밀번호를 확인해주세요");
			viewPage = "/member/login";
			break;
			
		case "no_member" :
			
			sess.setAttribute("err", "회원을 확인해주세요");
			viewPage = "/member/login";
			break;
			
		default :
			sess.setAttribute("err", "회원을 확인해주세요");
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
		
		return "/member/memreg";
	}
	
	
/*
		} else if(cmd.equals("loginout")) {
			sess.invalidate();
			
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
			
		} else if(cmd.equals("memreg")) {
			goView(req, resp, "/member/memreg.jsp");
			
		} else if(cmd.equals("memregform")) {
			
			member.insert(req);
			
			goView(req, resp, "/mem/loginpage");
			
		} else if(cmd.equals("mypage")) {
		 	String sess_id = (String)sess.getAttribute("sess_id");
			
		 	Mem mempage = member.mypage(sess_id);
		 	if(mempage.getAtt().getAttName() == null ) {
		 		Att att = new Att();
		 		Thumbnail thumb = new Thumbnail();
		 		mempage.setAtt(att);
		 		mempage.getAtt().setAttThumb(thumb);
		 		mempage.getAtt().getAttThumb().setFileName("profile.png");
		 	}
		 	req.setAttribute("page", mempage);
			
		 	
		 	goView(req, resp, "/member/mypage.jsp");
			
		} else if(cmd.equals("meminfo")) {
			
		 	String sess_id = (String)sess.getAttribute("sess_id");
		 	Mem info = member.meminfo(sess_id);
		 	req.setAttribute("info", info);
			goView(req, resp, "/member/meminfo.jsp");
			
		} else if(cmd.equals("infoinsert")) {
			
		 	member.infoinsert(req);
		 	
		 	String sess_id = (String)sess.getAttribute("sess_id");

		 	Mem info = member.meminfo(sess_id);
		 	req.setAttribute("info", info);

			goView(req, resp, "/member/meminfo.jsp");
			
		} else if(cmd.equals("buyHistory")) {
			
		 	String sess_id = (String)sess.getAttribute("sess_id");
		 	List<Pro> buy = member.membuylist(sess_id);
		 	
		 	req.setAttribute("buy", buy);


			Map<String, List<Cart>> auc = member.memauclist(sess_id);

		 	
		 	List<Cart> cart = auc.get("END");
			List<Cart> car2 = auc.get("ING");
			
			
			
			if(cart != null) {
				req.setAttribute("cart", cart);
			}
			if(car2 != null) {
				req.setAttribute("car2", car2);
			}
			
			
			Map<String, List<Ship>> ship = member.ordercheck(sess_id);
			List<Ship> order = ship.get("order");
			List<Ship> detail = ship.get("detail");
			
			if(order != null) {
				req.setAttribute("order", order);
			}
			if(detail != null) {
				req.setAttribute("detail", detail);
			}
			
			List<Pro> stat = member.buystat(sess_id);
			req.setAttribute("stat", stat);
			
			goView(req, resp, "/member/buyHistory.jsp");

		} else if(cmd.equals("mainpage")) {
			goView(req, resp, "/index.jsp");

		} else if(cmd.equals("findpw")) {
			String lostid = req.getParameter("findid");
			String lostemail = req.getParameter("e-mail");
			Map<String, String> findpw = member.findPw(lostid, lostemail);
			
			
			switch(findpw.get("find")) {
			case "ok" :
				
				req.setAttribute("lostpw", "?��?��?��?�� 비�?번호?��"+findpw.get("lostpw")+"?��?��?��.");
				
				break;
				
			case "pwfail" :
				
				req.setAttribute("lostpw", "주소�? ?��?��?��주세?��");
				
				break;
				
			case "no_member" :
				
				req.setAttribute("lostpw", "?��?��?��보�?? ?��?��?��주세?��");
				
				break;
				
			case "null" :
				
				req.setAttribute("lostpw", "?��?��?��보�?? ?��?��?��주세?��");
				
				break;
				
			default :
				
				req.setAttribute("lostpw", "?��?��?��보�?? ?��?��?��주세?��");

			}
			goView(req, resp, "/member/login.jsp");
			
		} else if(cmd.equals("findId")) {

			String lostid = req.getParameter("idemail");
			Map<String, String> findid = member.findId(lostid);
			
			
			switch(findid.get("find")) {
			case "ok" :
				
				req.setAttribute("lostid", "?��?��?��?�� ?��?��?��?��"+findid.get("lostid")+"?��?��?��.");
				
				break;
				
			case "pwfail" :
				
				req.setAttribute("lostid", "?��?��?��보�?? ?��?��?��주세?��");
				
				break;
				
			case "no_member" :
				
				req.setAttribute("lostid", "?��?��?��보�?? ?��?��?��주세?��");
				
				break;
				
			default :
				
				req.setAttribute("lostid", "?��?��?��보�?? ?��?��?��주세?��");

			}
			goView(req, resp, "/member/login.jsp");

			
		} else if(cmd.equals("changepw")) {
			
			String sess_id = (String)sess.getAttribute("sess_id");
			String find_id = req.getParameter("find_id");
			String now_pw = req.getParameter("n_password");
			String new_pw = req.getParameter("c_password");
			
			if(find_id.equals(sess_id)) {
			
				Map<String, String> find = member.changePw(new_pw, find_id, now_pw);
				req.setAttribute("change", find.get("change"));
				
			goView(req, resp, "/mem/mypage");
			
			
			} else {
				req.setAttribute("change", "no_member");
			
				goView(req, resp, "/mem/mypage");
			
			}
			
		} else if(cmd.equals("idCheck")) {
			String id = req.getParameter("id");
			int rs = member.idcheck(id);
			PrintWriter out = resp.getWriter();
			out.print(rs);
		}
		
	}
*/	

}
