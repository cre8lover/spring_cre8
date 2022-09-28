package com.cre8.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cre8.dto.Att;
import com.cre8.dto.prodelVo;
import com.cre8.service.CreatorService;
import com.cre8.service.FileService;


@RestController
@RequestMapping(value = "/cre2/")
public class Creatercontroller2 {

	private static final Logger log = LoggerFactory.getLogger(Creatercontroller2.class);
	
	@Autowired
	CreatorService cs;
	@Autowired
	FileService fs;

	 // 게시물 삭제
	
	//RestService로 바꿈
	@DeleteMapping(value="{rno}", produces ="text/plain; charset=utf-8")
	public ResponseEntity<prodelVo> remove(@PathVariable("rno") String seqno){
		log.info("delete : " + seqno);
		return cs.prodel(seqno) == 1 ? new ResponseEntity<prodelVo>(HttpStatus.OK) :
			  						 new ResponseEntity<prodelVo>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
