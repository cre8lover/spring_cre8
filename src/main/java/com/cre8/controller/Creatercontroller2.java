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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
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

	//마케팅 리스트 조회
	@GetMapping(value = "/list", produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
														   MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<Marketing>> getList() {
		log.info("getList.....");

		return new ResponseEntity<>(cs.getList(),HttpStatus.OK);

	}
	
	
	
	//크리에이터 정보 수정
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH},
					value = "ccc",
					produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> modify(@RequestBody Creator c){
	log.info("----------@@@@@@@@@@@@@@@@@@@@@@------------------------");

	return cs.infomodify(c) == 1 ? new ResponseEntity<>("크리에이터 수정완료",HttpStatus.OK) :
									   new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	// 일반물풀 삭제
	//RestService로 바꿈
	@DeleteMapping(value="remove", produces ="text/plain; charset=utf-8", consumes="application/json")
	public ResponseEntity<String> remove(@RequestBody String seqno){
	log.info("delete : " + seqno);
	
	return cs.prodel(seqno) == 1 ? new ResponseEntity<>("삭제되었습니다 ",HttpStatus.OK) :
								   new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	  //@RequestBody방식은 html 바디에 숨겨서 post 방식 키값을 안써도됨 
	  //@path는 url : get방식
	}
	
	

}




