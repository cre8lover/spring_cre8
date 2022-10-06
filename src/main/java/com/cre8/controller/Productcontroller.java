package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Cart;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.QnaVo;
import com.cre8.service.ProService;

@Controller
@RequestMapping("/product/")
public class Productcontroller extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final Logger log = LoggerFactory.getLogger("Productcontroller.class");
   @Autowired
   ProService pro;

    @GetMapping("/cate/{category}") 
    public String clothes(Model model,Auc_Criteria ac) {
//    	System.out.println(ac.getCategory());
//       List<Pro> prolist1 = pro.proList_clothes(ac);
//       model.addAttribute("proList", prolist1);
       model.addAttribute("category", ac.getCategory());
       return "/listimg/product_clothes";
    }
    
    @GetMapping("productDetail")
    public String detail(@ModelAttribute("seqno") String seqno, Model model,
    					HttpSession sess) {
    	String sess_id = (String)sess.getAttribute("sess_id");
    	Pro detailList = pro.detailList(seqno);
    	Mem m = new Mem();
    	
    	m.setMemId(sess_id);
    	detailList.setMem(m);
    	model.addAttribute("detailList",detailList);
    	
    	return "/buy/DetailClothes";
    }

    @GetMapping("nowbuy")
    public String nowbuy (@ModelAttribute("seqno") String seqno,@ModelAttribute("amount") String amount,Model model) {
    	
    	List<Cart> prolist = pro.nowbuy(seqno,amount);
    	model.addAttribute("cartp", prolist);
		return "/buy/buylist";
    }
    
    @RequestMapping(value="{seqno}/{page}.*",
					produces="application/json; charset=utf-8")
	public ResponseEntity<List<QnaVo>> qnaList(@PathVariable("seqno") String seqno) {
	
    	log.info(" 리스트 출력 컨트롤러.......................................");
	
    	
		return new ResponseEntity<List<QnaVo>>(pro.qnaList(seqno), HttpStatus.OK);
	}
    
    @PostMapping(value="add", 
			 consumes = "application/json",
			 produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody QnaVo QnaVo) {
    	log.info(" called..");
	
    	int rs = pro.register(QnaVo);
	
    	return rs == 1 ? new ResponseEntity<>("등록되었습니다.", HttpStatus.OK) 
    					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
}