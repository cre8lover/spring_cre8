<<<<<<< HEAD
package com.cre8.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cre8.dto.AucNowListVO;
import com.cre8.dto.AucNowTotalVO;
import com.cre8.dto.AucNowVO;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.CartlistVO;
import com.cre8.service.AucNowService;
import com.cre8.service.CartService;

@RestController
@RequestMapping("/aucnow/")
public class AucNowController {

	private static final Logger log = LoggerFactory.getLogger(AucNowController.class);

	@Autowired
	AucNowService as;

	@PostMapping(value = "add", consumes = "application/json", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> delete(@RequestBody AucNowVO aucnow) {
		log.info("delete .............");
		log.info("delete:" + aucnow.getPrice());

		return as.priceadd(aucnow) == -1 ? new ResponseEntity<String>(aucnow.getPrice() + "원 = 경매 입찰 완료", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	  @GetMapping(value="list/{bno}/{page}",
			produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	  public ResponseEntity<AucNowTotalVO> getList(@PathVariable("bno") long bno,
														@PathVariable("page") int page){
		log.info("getList........");
	  
	  	Auc_Criteria cri = new Auc_Criteria(page);
	  
	  return new ResponseEntity<AucNowTotalVO>(as.getList(cri,bno),HttpStatus.OK) ; 
	  }
	 
=======
package com.cre8.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cre8.dto.AucNowListVO;
import com.cre8.dto.AucNowTotalVO;
import com.cre8.dto.AucNowVO;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.CartlistVO;
import com.cre8.service.AucNowService;
import com.cre8.service.CartService;

@RestController
@RequestMapping("/aucnow/")
public class AucNowController {

	private static final Logger log = LoggerFactory.getLogger(AucNowController.class);

	@Autowired
	AucNowService as;

	@PostMapping(value = "add", consumes = "application/json", produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> delete(@RequestBody AucNowVO aucnow) {
		log.info("delete .............");
		log.info("delete:" + aucnow.getPrice());

		return as.priceadd(aucnow) == -1 ? new ResponseEntity<String>(aucnow.getPrice() + "원 = 경매 입찰 완료", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	  @GetMapping(value="list/{bno}/{page}",
			produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	  public ResponseEntity<AucNowTotalVO> getList(@PathVariable("bno") long bno,
														@PathVariable("page") int page){
		log.info("getList........");
	  
	  	Auc_Criteria cri = new Auc_Criteria(page);
	  
	  return new ResponseEntity<AucNowTotalVO>(as.getList(cri,bno),HttpStatus.OK) ; 
	  }
	 
>>>>>>> branch 'master' of https://github.com/cre8lover/spring_cre8.git
}