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

import com.cre8.dto.Auc;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Auc_Page;
import com.cre8.service.AuctionServeice;
import com.cre8.service.AuctionServiceimp;


@WebServlet("/auc/*")
public class Auctioncontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AuctionServeice auc = new AuctionServiceimp();
	
    public Auctioncontroller() {
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
		
		
		if(cmd.equals("auction")) {
			
			
			String currentPage = req.getParameter("currentPage");
			if(currentPage == null) currentPage = "1";
			
			Auc_Criteria cri = new Auc_Criteria(Integer.parseInt(currentPage));
			cri.setCategory(req.getParameter("tab_item"));
			
			if (cri.getCategory() == null) {
				cri.setCategory("sdate");
			}
			
			List<Auc> auclist = auc.aucList(cri);
			auclist.get(0).getItem().getItemAmount();
			req.setAttribute("pageMaker", new Auc_Page(auclist.get(0).getItem().getItemAmount(),cri));
			req.setAttribute("auclist", auclist);
			req.setAttribute("cate", cri.getCategory());
			goView(req, resp, "/auction/auction.jsp");
			
			
		} else if(cmd.equals("auctionDetail")) {
			String seqno = req.getParameter("seqno");
			if (seqno == null) {
				seqno = (String) req.getAttribute("seqno");
			}
			
			Auc detail = auc.detailList(seqno);
			req.setAttribute("detail", detail);
			
			goView(req, resp, "/auction/auctionDetail.jsp");
		
		} else if(cmd.equals("aucnow")) {
			
			String srt = req.getParameter("money");
			String seqno = req.getParameter("seqno");
			String id = (String)req.getSession().getAttribute("sess_id");
//			System.out.println(id);
			auc.aucnow(srt,seqno,id);
			req.setAttribute("seqno", seqno);
			
			goView(req, resp, "/auc/auctionDetail");
		}
		
		
	}

	private void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);		
	}

}
