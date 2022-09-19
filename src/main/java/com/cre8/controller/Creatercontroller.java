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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;
import com.cre8.service.CreatorServiceImp;
import com.cre8.service.FileService;

@Controller
@RequestMapping(value="/cre/")
public class Creatercontroller {
   
	@Autowired
	CreatorServiceImp cs;
	
	@RequestMapping(value="creReg", method = {RequestMethod.POST, RequestMethod.GET})
	public String Creatoradd(HttpSession sess, @RequestParam("seqno") String seqno, Model model) {
		String add = (String)sess.getAttribute("auth");
		String id = (String)sess.getAttribute("sess_id");
		
		if(id == null || add == null) {
			return "/member/memreg";
		}
		else if(add.equals("C")) {
			
			List<Pro> prolist = cs.Prolist(seqno, id);
			List<Auc> auclist = cs.Auclist(seqno, id);
			
			String total = cs.totalmoney(id);
			
			model.addAttribute("prolist", prolist);
			model.addAttribute("auclist", auclist);
			model.addAttribute("total", total);
			
			return "/creater/artistpage";
		}else {
			cs.CreatorName(id);
			return "/creater/creReg";
		}
		
	}
			
			
	/////?��기서 ?��?��!!//////////////////////
	/*
	 * }else if(cmd.equals("artistpage")) { //?��기서 ?���?�? ?��급을 �?
	 * cs.Creatoradd(req);//?��?��?��?��근을 ?��기위?�� ?��?��?��?�� ?���?! goView(req,
	 * resp, "/cre/creReg");
	 * 
	 * } else if(cmd.equals("cremodify")) { //못함 String id =
	 * (String)req.getSession().getAttribute("sess_id"); Creator cre =
	 * cs.infomodify(id);
	 * 
	 * req.setAttribute("cre", cre); goView(req, resp, "/creater/creReg2.jsp");
	 * 
	 * } //광고 리스?��보여주는 ?��?���? else if(cmd.equals("Adlist")) { List<Marketing>
	 * marketing = cs.mk(); req.setAttribute("marketing", marketing); goView(req,
	 * resp, "/listimg/product_ad.jsp");
	 * 
	 * }//광고 ?��?���? ?���??��?��?�� ?��?��?�� ?��?���? else
	 * if(cmd.equals("marketingDetail")) { int seqno =
	 * Integer.parseInt(req.getParameter("seqno")); // System.out.println(seqno); //
	 * List<Marketing> marketing2 = cs.mkk(seqno);
	 * 
	 * req.setAttribute("marketing", cs.mkk(seqno));
	 * 
	 * goView(req, resp, "/creater/marketingDetail.jsp");
	 * 
	 * } //?���? sql�? 미완?��! else if(cmd.equals("salesHistory")) { String id =
	 * (String)req.getSession().getAttribute("sess_id"); List<Pro> salesHistory =
	 * cs.salesHistory(id);
	 * 
	 * Map<String, List<Pro>> calculate = cs.calculate(id);
	 * 
	 * 
	 * req.setAttribute("cre", salesHistory); req.setAttribute("month",
	 * calculate.get("month")); req.setAttribute("year", calculate.get("year"));
	 * goView(req, resp, "/creater/jmh_salesHistory.jsp");
	 * 
	 * } else if(cmd.equals("auction_reg")) {
	 * 
	 * String seqno = req.getParameter("seqno");
	 * 
	 * if(seqno != null) { Auc auc = cs.aucdetail(seqno); req.setAttribute("auc",
	 * auc); }
	 * 
	 * goView(req, resp, "/creater/auction_registration.jsp");
	 * 
	 * //?��?�� ?��?��?���? } else if(cmd.equals("auction_modify")) {
	 * 
	 * 
	 * String seqno = cs.aucadd(req);
	 * 
	 * 
	 * goView(req, resp, "/cre/auction_reg?seqno="+seqno);
	 * 
	 * 
	 * //?��?��?��록창 ?��?��?���? } else if(cmd.equals("product_registration")) {
	 * 
	 * String seqno = req.getParameter("seqno");
	 * 
	 * if(seqno != null) { Pro pro = cs.productdetail(seqno);
	 * req.setAttribute("pro", pro); }
	 * 
	 * goView(req,resp,"/creater/product_registration.jsp");
	 * 
	 * //?���? ?��?�� ?���? } else if(cmd.equals("promodify")) {
	 * 
	 * String seqno = cs.productadd(req);
	 * 
	 * goView(req,resp,"/cre/product_registration?seqno="+seqno);
	 * 
	 * 
	 * } else if(cmd.equals("cremodifyreg")) { //?��리에?��?�� ?��보수?�� Map<String,
	 * String> cremo = cs.cremodifyreg(req); req.setAttribute("modi", cremo);
	 * goView(req, resp, "/cre/cremodify");
	 * 
	 * }else if (cmd.equals("fileDel")) { FileService fileservice = new
	 * FileServiceImp(); int rs=0; String attseqno = req.getParameter("attseqno");
	 * String savefilename = req.getParameter("savefilename"); String filepath =
	 * req.getParameter("filepath"); String thumb_filename =
	 * req.getParameter("thumb_filename"); //
	 * System.out.println("?��???��?��?"+attseqno); if(attseqno != "") { rs =
	 * fileservice.delete(attseqno,savefilename,filepath,thumb_filename); //
	 * System.out.println("?��?��?��?��결과"+rs); }else { rs = 1; } PrintWriter out =
	 * resp.getWriter();
	 * 
	 * out.print(rs);
	 * 
	 * }else if (cmd.equals("prodel")) { String seqno =
	 * req.getParameter("proseqno"); cs.prodel(seqno); goView(req, resp,
	 * "/cre/creReg"); }
	 * 
	 * 
	 * 
	 * }
	 */

	private void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);		
	}

}
