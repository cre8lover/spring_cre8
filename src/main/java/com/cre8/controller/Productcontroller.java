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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cre8.dto.AnswerVo;
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
	
    	log.info(" ????????? ?????? ????????????.......................................");
	
    	
		return new ResponseEntity<List<QnaVo>>(pro.qnaList(seqno), HttpStatus.OK);
	}
    
    @PostMapping(value="add", 
			 consumes = "application/json",
			 produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody QnaVo QnaVo) {
    	log.info("add ddddddddddddddddddddddddddd called..");
	
    	int rs = pro.register(QnaVo);
    	System.out.println("ddddddddddddddddddddddddddddddddddddddddddd"+rs);
    	return rs == 1 ? new ResponseEntity<>("?????????????????????.", HttpStatus.OK) 
    					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping(value="{QnaNo}.*",
			produces = "application/json")
    public ResponseEntity<QnaVo> get(@PathVariable("QnaNo") String seqno){
	
    	log.info("get reply......." + seqno);
	
    	return new ResponseEntity<>(pro.get(seqno), HttpStatus.OK);
    }
    
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH},
			value ="update/{seqno}", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> modify(@PathVariable("seqno") String seqno,
									 	@RequestBody QnaVo QnaVo){
	
		log.info("dddd : " + QnaVo.getQnaContent());
		log.info("seqno : " + QnaVo.getSeqno());
		log.info("qnaseqno : " + QnaVo.getQnaSeqno());
		
		
		return pro.modify(QnaVo) == 1 ? new ResponseEntity<>("?????? ?????? ??????", HttpStatus.OK) 
										: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="del/{QnaNo}", produces="text/plain; charset=utf-8")
	public ResponseEntity<String> remove(@PathVariable("QnaNo") String seqno){
		log.info("delete seqno : " + seqno);
		
		return pro.remove(seqno) == 1 ? new ResponseEntity<>("?????? ?????? ??????", HttpStatus.OK) 
										: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
    @PostMapping(value="answer", 
    			consumes = "application/json",
    			produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> answer(@RequestBody AnswerVo AnswerVo) {
    	log.info("add called++++++++++++++++++");
	
    	int rs = pro.answer(AnswerVo);
    	return rs == 1 ? new ResponseEntity<>("?????????????????????.", HttpStatus.OK) 
    					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}