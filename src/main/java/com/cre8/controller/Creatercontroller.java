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

import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;
import com.cre8.service.CreatorServiceImp;
import com.cre8.service.FileService;


@WebServlet("/cre/*")
public class Creatercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Creatercontroller() {
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
		
		CreatorServiceImp cs = new CreatorServiceImp();
		
		if(cmd.equals("creReg")) {
			String add = (String)req.getSession().getAttribute("auth");
			String id = (String)req.getSession().getAttribute("sess_id");
//			System.out.println(id);
			
			if(id == null || add == null) {
				goView(req, resp, "/member/memreg.jsp");
			}
			else if(add.equals("C")) {
				
				String seqno = (String) req.getAttribute("seqno");
				
				List<Pro> prolist = cs.Prolist(seqno, id);
				List<Auc> auclist = cs.Auclist(seqno, id);
				
				String total = cs.totalmoney(id);
				
				req.setAttribute("prolist", prolist);
				req.setAttribute("auclist", auclist);
				req.setAttribute("total", total);
			
				goView(req, resp, "/creater/artistpage.jsp");
			}else {
				cs.CreatorName(id);
				goView(req, resp, "/creater/creReg.jsp");
			}
			
			
	/////?ó¨Í∏∞ÏÑú ?ãú?ûë!!//////////////////////
		}else if(cmd.equals("artistpage")) {
			//?ó¨Í∏∞ÏÑú ?ûëÍ∞?Î°? ?ì±Í∏âÏùÑ Ï§?
			cs.Creatoradd(req);//?ã§?ò§?óê?†ëÍ∑ºÏùÑ ?ïòÍ∏∞ÏúÑ?ïú ?àò?ã®?ù¥?ùº ?ÉùÍ∞?!
			goView(req, resp, "/cre/creReg");
				
		} else if(cmd.equals("cremodify")) { 
	         //Î™ªÌï®
	         String id = (String)req.getSession().getAttribute("sess_id");
	         Creator cre = cs.infomodify(id);
	         
	         req.setAttribute("cre", cre);
	         goView(req, resp, "/creater/creReg2.jsp");
	         
	      } //Í¥ëÍ≥† Î¶¨Ïä§?ä∏Î≥¥Ïó¨Ï£ºÎäî ?éò?ù¥Ïß? 
			else if(cmd.equals("Adlist")) {
			List<Marketing> marketing = cs.mk(); 
			req.setAttribute("marketing", marketing);
			goView(req, resp, "/listimg/product_ad.jsp");
			
		}//Í¥ëÍ≥† ?ïò?ÇòÎ•? ?Å¥Î¶??ñà?ùÑ?ïå ?Çò?ò§?äî ?éò?ù¥Ïß? 
			else if(cmd.equals("marketingDetail")) {	
			int seqno = Integer.parseInt(req.getParameter("seqno"));
//			System.out.println(seqno);
//			List<Marketing> marketing2 = cs.mkk(seqno); 
			
			req.setAttribute("marketing", cs.mkk(seqno));
			
			goView(req, resp, "/creater/marketingDetail.jsp");
				
		}
			//?ïÑÏß? sqlÎ¨? ÎØ∏ÏôÑ?Ñ±!
		else if(cmd.equals("salesHistory")) {
			String id = (String)req.getSession().getAttribute("sess_id");
			List<Pro> salesHistory = cs.salesHistory(id);
			
			Map<String, List<Pro>> calculate = cs.calculate(id);
			
			
			req.setAttribute("cre", salesHistory);
			req.setAttribute("month", calculate.get("month"));
			req.setAttribute("year", calculate.get("year"));
			goView(req, resp, "/creater/jmh_salesHistory.jsp");
			
		} else if(cmd.equals("auction_reg")) {
		
			String seqno = req.getParameter("seqno");
		
			if(seqno != null) {
		     Auc auc = cs.aucdetail(seqno);
		     req.setAttribute("auc", auc);
			}
		         
		 goView(req, resp, "/creater/auction_registration.jsp");
		 
		 //?ò•?Öò ?àò?†ï?ì±Î°?
		  } else if(cmd.equals("auction_modify")) {
			  

		 String seqno = cs.aucadd(req);
		 
		 
		 goView(req, resp, "/cre/auction_reg?seqno="+seqno);
		 
		 
		 //?àò?†ï?ì±Î°ùÏ∞Ω ?ùÑ?ö∞?äîÍ≥?
		  } else if(cmd.equals("product_registration")) {
		    
		 String seqno = req.getParameter("seqno");
		 
		    if(seqno != null) {
		       Pro pro = cs.productdetail(seqno);
		       req.setAttribute("pro", pro);
		}
		
		goView(req,resp,"/creater/product_registration.jsp");
		
		//?ùºÎ∞? ?àò?†ï ?ì±Î°?
		   } else if(cmd.equals("promodify")) {
			   
		   String seqno = cs.productadd(req);
		   
		  goView(req,resp,"/cre/product_registration?seqno="+seqno);
		   
		   
		   } else if(cmd.equals("cremodifyreg")) { 
		          //?Å¨Î¶¨Ïóê?ù¥?Ñ∞ ?†ïÎ≥¥Ïàò?†ï
		            Map<String, String> cremo = cs.cremodifyreg(req);
		            req.setAttribute("modi", cremo);
		           goView(req, resp, "/cre/cremodify");
		            
		   }else if (cmd.equals("fileDel")) {
			   FileService fileservice = new FileServiceImp();
			   int rs=0;
			    String attseqno = req.getParameter("attseqno");
				String savefilename = req.getParameter("savefilename");
				String filepath = req.getParameter("filepath");
				String thumb_filename = req.getParameter("thumb_filename");
//				System.out.println("?ãú???ä§?äî?"+attseqno);
				if(attseqno != "") {
				rs = fileservice.delete(attseqno,savefilename,filepath,thumb_filename);
//				System.out.println("?åå?ùº?Ç≠?†úÍ≤∞Í≥º"+rs);
				}else {
					rs = 1;
				}
				PrintWriter out = resp.getWriter();
				
				out.print(rs);
			   
		   }else if (cmd.equals("prodel")) {
			   String seqno = req.getParameter("proseqno");
			   cs.prodel(seqno);
			   goView(req, resp, "/cre/creReg");
		   }
		  
		  
		
	}

	private void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);		
	}

}
