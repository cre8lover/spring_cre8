package com.cre8.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.ProductMainVO;
import com.cre8.dto.ProductTotalVO;
import com.cre8.service.MainListRestService;


@RestController
@RequestMapping("/mainrest/")
public class MainListRestController {
	
	private static final Logger log = LoggerFactory.getLogger(MainListRestController.class);
	
	@Autowired
	MainListRestService ms;
	
	@GetMapping(value="list/{Category}/{currentPage}",
				produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ProductTotalVO> getList(Auc_Criteria maincriteria){
		log.info("getList........");
		
		return new ResponseEntity<>(ms.getList(maincriteria),HttpStatus.OK);
}
	
}	