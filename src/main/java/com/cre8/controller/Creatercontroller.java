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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cre8.dto.Att;
import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Item;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;
import com.cre8.dto.prodelVo;
import com.cre8.service.CreatorService;
import com.cre8.service.CreatorServiceImp;
import com.cre8.service.FileService;
import com.cre8.service.FileServiceImp;

@Controller
@RequestMapping(value = "/cre/")
public class Creatercontroller {

	private static final Logger log = LoggerFactory.getLogger(Creatercontroller.class);
	
	
	@Autowired
	CreatorService cs;
	@Autowired
	FileService fs;

	// 크리에이터 페이지( if)비회원&작가이닐경우 =>작가등록 및 회원가입)
	@GetMapping("creReg")
	public String Creatoradd(HttpSession sess, @ModelAttribute("id") String seqno, Model model) {
		String add = (String) sess.getAttribute("auth");
		String id = (String) sess.getAttribute("sess_id");
		if (id == null || add == null) {
			return "/member/memreg";
		} else if (add.equals("C")) {
			
			//prodelVo prodelvo = new prodelVo();
			
			List<Pro> prolist = cs.Prolist(seqno, id);
			List<Auc> auclist = cs.Auclist(seqno, id);

			String total = cs.totalmoney(id);

			model.addAttribute("prolist", prolist);
			model.addAttribute("auclist", auclist);
			model.addAttribute("total", total);
			//model.addAttribute("prodelvo", prodelvo);

			return "/creater/artistpage";
		} else {
			cs.CreatorName(id);
			return "/creater/creReg";
		}

	}

	// 크리에이터 등록페이지
	@PostMapping("artistpage")
	public String Creatorpage(HttpServletRequest request, HttpSession sess, Model model) {

		String id = (String) sess.getAttribute("sess_id");

		model.addAttribute("id", id);
		return "/cre/creReg";
	}

	// 수정페이지
	@GetMapping("cremodify")
	public String cremodify(HttpSession sess, Model model) {
		String id = ((String) sess.getAttribute("sess_id"));
//		int cre = cs.infomodify(c);

//		model.addAttribute("cre", cre);
		return "/creater/creReg2";
	}
	/*
	 * //광고리스트 조회
	 * 
	 * @GetMapping("Adlist") public String mk(List<Marketing> mar , Model model) {
	 * mar = cs.mk(); model.addAttribute("marketing", mar);
	 * 
	 * return "/creater/marketingDetail"; }
	 */

	
	  //광고리스트 조회
	  @GetMapping("Adlist")
	  public String mk( Model model) {
	  model.addAttribute("marketing",cs.mk());
	  
	  return "/creater/Adlist"; }
	 

	// 광고 세부내용 출력
	@GetMapping("marketingDetail")
	public String mkk(@ModelAttribute("seqno") int seqno, Model model) {

		model.addAttribute("marketing", cs.mkk(seqno));

		return "/creater/marketingDetail";
	}

	// 파일 삭제
	@PostMapping("fileDel")
	public void fileDel(@RequestParam("attseqno") String attseqno, @RequestParam("savefilename") String savefilename,
			@RequestParam("filepath") String filepath, @RequestParam("thumb_filename") String thumb_filename,
			Model model, HttpServletResponse resp) {
		int rs = 0;
		rs = fs.delete(attseqno, savefilename, filepath, thumb_filename);
		model.addAttribute("fileDel", rs);
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(rs);
	}


	@RequestMapping("product_registration")
	public String product_reg(@ModelAttribute("seqno") String seqno, Model model) {

		if (seqno.length() != 0) {
			Pro pro = cs.productdetail(seqno);
			model.addAttribute("pro", pro);
		}
		return "/creater/product_registration";

	}

	@RequestMapping("salesHistory")
	public String salesHistory(Model model, HttpSession sess) {

		String id = (String) sess.getAttribute("sess_id");
		List<Pro> salesHistory = cs.salesHistory(id);
		Map<String, List<Pro>> calculate = cs.calculate(id);

		model.addAttribute("cre", salesHistory);
		model.addAttribute("month", calculate.get("month"));
		model.addAttribute("year", calculate.get("year"));
		model.addAttribute("cre", salesHistory);
		return "/creater/jmh_salesHistory";
	}
	
	//게시물 수정 
	@RequestMapping("promodify")
	public String promodify(Model model,Pro pro, Item item, MultipartFile filename,HttpSession sess) {
		
		pro.setItem(item);
//		System.out.println("컨"+pro.getProSeqno());
		String seqno = cs.productadd(pro,filename,(String)sess.getAttribute("sess_id"));
		
		   model.addAttribute("seqno", seqno);
		  return "redirect:/cre/product_registration";	
	}
	
	 // 게시물 삭제
	  
//	  @RequestMapping("prodel") public String prodel(@RequestParam("proseqno")
//	  String seqno, Model model) { model.addAttribute("proseqno");
//	  cs.prodel(seqno); return "redirect:/cre/creReg"; }
	 
	
	/*
	 * //RestService로 바꿈
	 * 
	 * controller2에 구현
	 * @DeleteMapping(value="{rno}", produces ="text/plain; charset=utf-8") public
	 * void remove(@PathVariable("prodel") String seqno, Att att_seq){
	 * log.info("delete : " + seqno); }
	 */
	
	
	
	
	
	@RequestMapping(value="auction_registration", method= {RequestMethod.POST, RequestMethod.GET})
	public String aucmodi(@ModelAttribute("seqno") String seqno, Model model) {

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
	//옥션수정등록
	@RequestMapping(value="auction_reg", method= {RequestMethod.POST, RequestMethod.GET})
	public String acumodi(@ModelAttribute("seqno") String seqno, Model model) {

		if(seqno != null) {
			Auc auc = cs.aucdetail(seqno);
			model.addAttribute("auc", auc);
		}

		return "creater/auction_registration";
	}
}
