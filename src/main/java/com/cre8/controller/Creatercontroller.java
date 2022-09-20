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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Item;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;
import com.cre8.service.CreatorService;
import com.cre8.service.CreatorServiceImp;
import com.cre8.service.FileService;
import com.cre8.service.FileServiceImp;

@Controller
@RequestMapping(value="/cre/")
public class Creatercontroller {
   
	@Autowired
	CreatorService cs;
	FileServiceImp fs;
	
	//크리에이터 페이지( if)비회원&작가이닐경우 =>작가등록 및 회원가입)
	@GetMapping("creReg")
	public String Creatoradd(HttpSession sess, @ModelAttribute("id") String seqno, Model model) {
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
	//크리에이터 등록페이지
	@PostMapping("artistpage")
	public String Creatorpage(Creator cre) {
		cs.Creatoradd(cre);
//		return "redirect:/cre/creReg";
		return "/creater/artistpage";
	}

	//광고리스트 조회
	@GetMapping("Adlist")
	//@RequestMapping(value="Adlist", method= {RequestMethod.POST, RequestMethod.GET})
	public String mk(Model model) {
		List<Marketing> mar  = cs.mk(); 
		model.addAttribute("marketing", mar);
		return "/listimg/product_ad";
	}
	
	//옥션수정등록
	@RequestMapping(value="auction_reg", method= {RequestMethod.POST, RequestMethod.GET})
	public String acumodi(@ModelAttribute("seqno") String seqno, Model model) {

		if(seqno != null) {
			Auc auc = cs.aucdetail(seqno);
			model.addAttribute("auc", auc);
		}
		
		return "creater/auction_registration";
	}
	
	@RequestMapping(value="auction_registration", method= {RequestMethod.POST, RequestMethod.GET})
	public String umodi(@ModelAttribute("seqno") String seqno, Model model) {
		
		if(seqno != null) {
			Auc auc = cs.aucdetail(seqno);
			model.addAttribute("auc", auc);
		}
		
		return "creater/auction_registration?seqno =" + seqno;
	}
	@RequestMapping(value="auction_modify", method= {RequestMethod.POST, RequestMethod.GET})
	public String auc_modi(MultipartFile filename, Auc auc, Item item,
							HttpSession sess,
							Model model) {
		auc.setId((String)sess.getAttribute("sess_id"));
		auc.setItem(item);
		
		String seqno = cs.aucadd(filename, auc);
		model.addAttribute("seqno", seqno);
		return "redirect:/cre/auction_reg";
	}
	
	
//	일반상품 아직 미구현
//		@RequestMapping(value="product_registration", method= {RequestMethod.POST, RequestMethod.GET})
//	public String proReg(@ModelAttribute("seqno") String seqno, Model model) {
//		
//		 if(seqno != null) {
//		       Pro pro = cs.productdetail(seqno);
//		       model.addAttribute("pro", pro);
//		}
//		 
//		return "/creater/product_registration";
//	}
//		@RequestMapping(value="promodify", method= {RequestMethod.POST, RequestMethod.GET})
//	public String promdify(@ModelAttribute("seqno") String seqno, Model model) {
//		
//		if(seqno != null) {
//			
//		}
//		return "/cre/product_registration?seqno="+seqno;
//	}

}
