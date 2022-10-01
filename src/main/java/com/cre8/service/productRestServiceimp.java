package com.cre8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dto.Pro;
import com.cre8.mapper.productRestMapper;

@Service
public class productRestServiceimp implements productRestService{

	@Autowired
	private productRestMapper mapper;
	
	@Override
	public int cartadd(Pro pro) {
		
		return mapper.cartadd(pro);
	}
	
	

}
