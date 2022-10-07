package com.cre8.controller;

import javax.servlet.http.HttpServlet;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cre8.dto.QnaVo;
import com.cre8.dto.ReviewVo;
import com.cre8.service.ProService;

@Controller
@RequestMapping("/review/")
public class Reviewcontroller extends HttpServlet {
   private static final Logger log = LoggerFactory.getLogger("Reviewcontroller.class");
   @Autowired
   ProService pro;

    @RequestMapping(value="{seqno}/{page}.*",
					produces="application/json; charset=utf-8")
	public ResponseEntity<List<ReviewVo>> qnaList(@PathVariable("seqno") String seqno) {
	
    	log.info(" 리스트 출력 컨트롤러.......................................");
	
    	
		return new ResponseEntity<List<ReviewVo>>(pro.ReviewList(seqno), HttpStatus.OK);
	}
    
    @PostMapping(value="reviewadd", 
			 consumes = "application/json",
			 produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ReviewVo ReviewVo) {
    	log.info("add called..");
	
    	int rs = pro.Reviewregister(ReviewVo);
    	System.out.println("dddddddddd"+rs);
    	return rs == 1 ? new ResponseEntity<>("등록되었습니다.", HttpStatus.OK) 
    					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping(value="{reviewNo}.*",
			produces = "application/json")
    public ResponseEntity<ReviewVo> get(@PathVariable("reviewNo") String reviewSeqno){
	
    	log.info("get reply......." + reviewSeqno);
	
    	return new ResponseEntity<>(pro.reviewget(reviewSeqno), HttpStatus.OK);
    }
    
	@DeleteMapping(value="del/{reviewNo}", produces="text/plain; charset=utf-8")
	public ResponseEntity<String> remove(@PathVariable("reviewNo") String reviewNo){
		log.info("delete seqno : " + reviewNo);
		
		return pro.reivewremove(reviewNo) == 1 ? new ResponseEntity<>("댓글 삭제 완료", HttpStatus.OK) 
										: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}