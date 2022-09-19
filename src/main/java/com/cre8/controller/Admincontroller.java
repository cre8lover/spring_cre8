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

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Cat;
import com.cre8.dto.Marketing;
import com.cre8.dto.Mem;
import com.cre8.service.AdminServiceImp;


@WebServlet("/master/*")
public class Admincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminServiceImp admin = new AdminServiceImp();
       
    public Admincontroller() {
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

		
		if(cmd.equals("adminlogin")) {
			
			goView(req, resp, "/admin/adminlogin.jsp");
			
		} else if(cmd.equals("adminMain")) {
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			Map<String, String> status = admin.login(id, pw);
			

			switch(status.get("login")) {
			case "ok" :
				
				sess.setAttribute("sess_id", id);
				sess.setAttribute("sess_name", status.get("name"));
				
				goView(req, resp, "/admin/adminMain.jsp");
				break;
				
			case "pwfail" :
				
				sess.setAttribute("err2", "ÎπÑÎ?Î≤àÌò∏Î•? ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				goView(req, resp, "/admin/adminlogin.jsp");
				
				break;
				
			case "no_member" :
				
				sess.setAttribute("err2", "Í∂åÌôò?ùÑ ?ôï?ù∏?ï¥Ï£ºÏÑ∏?öî");
				goView(req, resp, "/admin/adminlogin.jsp");
				
				break;
				
			default :
				
				goView(req, resp, "/admin/adminlogin.jsp");


			}
			
		} else if(cmd.equals("logout")) {
			sess.invalidate();
			
			resp.sendRedirect(req.getContextPath() + "/admin/adminlogin.jsp");
			
		} else if(cmd.equals("category")) {
			String currentPage = req.getParameter("currentPage");
			String rowPerPage = req.getParameter("rowPerPage");
			
			AdminKeyWord adkey = new AdminKeyWord();
//			AdminKeyWord adkey = new AdminKeyWord(Integer.parseInt(currentPage), Integer.parseInt(rowPerPage));
			
			adkey.setCategory(req.getParameter("gory"));
			adkey.setKeyword(req.getParameter("keysearch"));
			adkey.setSdate(req.getParameter("sdate"));
			adkey.setFdate(req.getParameter("fdate"));
//			adkey.setClassification(req.getParameter("stype"));
			
			if(currentPage == null) currentPage = "1";
			if(rowPerPage == null) rowPerPage = "10";
			
			
			List<Cat> category = admin.catelist(adkey);
			req.setAttribute("cate", category);
			req.setAttribute("key", adkey);
			goView(req, resp, "/admin/category.jsp");

		} else if(cmd.equals("member")) {
	         
			AdminKeyWord adkey = new AdminKeyWord();
	         
	         adkey.setCategory(req.getParameter("gory"));
	         adkey.setKeyword(req.getParameter("keysearch"));
	         adkey.setClassification(req.getParameter("classification"));
	         adkey.setSdate(req.getParameter("sdate"));
	         adkey.setFdate(req.getParameter("fdate"));
	         
	         List<Mem> member = admin.memberlist(adkey);
	         req.setAttribute("member", member);
	         req.setAttribute("key", adkey);
	         goView(req, resp, "/admin/member.jsp");
/*	         
		} else if(cmd.equals("item")) {
			
			List<Pro> item = admin.itemlist();
			req.setAttribute("item", item);
			
			goView(req, resp, "/admin/item.jsp");
*/			
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

	private void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);		
	}

}
