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

import com.cre8.dto.Att;
import com.cre8.dto.Cart;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.Ship;
import com.cre8.dto.Thumbnail;
import com.cre8.service.MemberServiceImp;


@WebServlet("/mem/*")
public class Membercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberServiceImp member = new MemberServiceImp();
	
    public Membercontroller() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf8");
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String path = req.getContextPath();
		
		HttpSession sess = req.getSession();

		if(cmd.equals("loginpage")) {
			goView(req, resp, "/member/login.jsp");
			
		} else if(cmd.equals("login")) {
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			Map<String, String> status = member.login(id, pw);
			
			switch(status.get("login")) {
			case "ok" :
				
				sess.setAttribute("sess_id", id);
				sess.setAttribute("sess_name", status.get("name"));
				sess.setAttribute("auth", status.get("auth"));
				
				goView(req, resp, "/index.jsp");
				break;
				
			case "pwfail" :
				
				sess.setAttribute("err", "ÎπÑÎ?Î≤àÌò∏Î•? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				goView(req, resp, "/member/login.jsp");
				
				break;
				
			case "no_member" :
				
				sess.setAttribute("err", "?öå?õê?†ïÎ≥¥Î?? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				goView(req, resp, "/member/login.jsp");
				
				break;
				
			default :
				
				sess.setAttribute("err", "?öå?õê?†ïÎ≥¥Î?? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");

			}
			
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
				
				req.setAttribute("lostpw", "?öå?õê?ãò?ùò ÎπÑÎ?Î≤àÌò∏?äî"+findpw.get("lostpw")+"?ûÖ?ãà?ã§.");
				
				break;
				
			case "pwfail" :
				
				req.setAttribute("lostpw", "Ï£ºÏÜåÎ•? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				
				break;
				
			case "no_member" :
				
				req.setAttribute("lostpw", "?öå?õê?†ïÎ≥¥Î?? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				
				break;
				
			case "null" :
				
				req.setAttribute("lostpw", "?öå?õê?†ïÎ≥¥Î?? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				
				break;
				
			default :
				
				req.setAttribute("lostpw", "?öå?õê?†ïÎ≥¥Î?? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");

			}
			goView(req, resp, "/member/login.jsp");
			
		} else if(cmd.equals("findId")) {

			String lostid = req.getParameter("idemail");
			Map<String, String> findid = member.findId(lostid);
			
			
			switch(findid.get("find")) {
			case "ok" :
				
				req.setAttribute("lostid", "?öå?õê?ãò?ùò ?ïÑ?ù¥?îî?äî"+findid.get("lostid")+"?ûÖ?ãà?ã§.");
				
				break;
				
			case "pwfail" :
				
				req.setAttribute("lostid", "?öå?õê?†ïÎ≥¥Î?? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				
				break;
				
			case "no_member" :
				
				req.setAttribute("lostid", "?öå?õê?†ïÎ≥¥Î?? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				
				break;
				
			default :
				
				req.setAttribute("lostid", "?öå?õê?†ïÎ≥¥Î?? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");

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
	
	void goView (HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	

}
