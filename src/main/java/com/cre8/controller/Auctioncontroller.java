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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cre8.dto.Auc;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Auc_Page;
import com.cre8.service.AuctionServeice;
import com.cre8.service.AuctionServiceimp;

@Controller
@RequestMapping("/auc/")
public class Auctioncontroller{
	
    @Autowired
	AuctionServeice auc;
    
    @RequestMapping("auction")
    public String auction(Auc_Criteria cri,Model model) {
		if(cri.getCurrentPage() == 0) cri.setCurrentPage(1);
    	if(cri.getCategory() == null) cri.setCategory("sdate");
    	
		List<Auc> auclist = auc.aucList(cri);
		model.addAttribute("pageMaker", new Auc_Page(auclist.get(0).getItem().getItemAmount(),cri));
		model.addAttribute("auclist", auclist);
		model.addAttribute("cate", cri.getCategory());
		
    	return "/auction/auction";
    }
    
    @RequestMapping("auctionDetail")
    public String auctionDetail (@ModelAttribute("seqno")String seqno,Model model) {
		
		Auc detail = auc.detailList(seqno);
		model.addAttribute("detail", detail);
		
    	return "/auction/auctionDetail";
    }
    
    @RequestMapping("aucnow")
    public String aucnow(@RequestParam("money")String srt,
    						@RequestParam("seqno")String seqno,
    						HttpSession sess,Model model) {
    	
		String id = (String)sess.getAttribute("sess_id");
//		System.out.println(id);
		auc.aucnow(srt,seqno,id);
		model.addAttribute("seqno", seqno);
		
		return "redirect:/auc/auctionDetail";
    	
    }


}
