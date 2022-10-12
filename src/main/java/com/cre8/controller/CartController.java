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
import org.springframework.web.bind.annotation.RestController;

import com.cre8.dto.Cart;
import com.cre8.dto.CartlistVO;
import com.cre8.service.CartService;


@RestController
@RequestMapping("/cart/")
public class CartController {
	
	private static final Logger log = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService cs;
	
	@DeleteMapping(value="delete", consumes="application/json", produces="text/plain; charset=utf-8")
	public ResponseEntity<String> delete(@RequestBody List<String> seqno){
		log.info("delete .............");
			log.info("delete rno:" + seqno.get(0));
			
		return cs.delete(seqno) >= 1 ? new ResponseEntity<String>("장바구니 물품 삭제 완료", HttpStatus.OK) :
											new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping(value="list/{id}",
				produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<CartlistVO>> getList(@PathVariable("id") String id){
		log.info("getList........");
	return new ResponseEntity<>(cs.getList(id),HttpStatus.OK) ;
}
	
	
	@GetMapping(value="update/{cartSeqno}/{cartAmount}",
			produces = {"text/plain; charset=utf-8"})
	public ResponseEntity<String> cartamountmodify(Cart cart) {
		log.info("cartamountmodify............");
		return cs.amountmodify(cart) > 0 ? new ResponseEntity<String>("장바구니 수량 수정완료", HttpStatus.OK) :
											new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
}	