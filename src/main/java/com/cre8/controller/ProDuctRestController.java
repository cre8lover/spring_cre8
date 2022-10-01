package com.cre8.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cre8.dto.Pro;
import com.cre8.service.productRestService;


@RestController
@RequestMapping("/prductrest/")
public class ProDuctRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ProDuctRestController.class);
	
	@Autowired
	productRestService prs;
	
	@PostMapping(value="cartadd", consumes="application/json", produces="text/plain; charset=utf-8")
	public ResponseEntity<String> cartadd(@RequestBody Pro pro){
		log.info("cart add........... .............");
			log.info("proseqno:" + pro.getProSeqno());
			
		return prs.cartadd(pro) >= 1 ? new ResponseEntity<String>("장바구니에 등록 되었습니다. 장바구니로 이동하시겠습니까?", HttpStatus.OK) :
											new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}	