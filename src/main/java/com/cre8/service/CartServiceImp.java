<<<<<<< HEAD
package com.cre8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dto.CartlistVO;
import com.cre8.mapper.cartMapper;

@Service
public class CartServiceImp implements CartService {

	@Autowired
	private cartMapper mapper;
	
	@Override
	public int delete(List<String> seqno) {
		return mapper.delete(seqno);
	}

	@Override
	public List<CartlistVO> getList(String id) {
		return mapper.list(id);
	}

}
=======
package com.cre8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dto.CartlistVO;
import com.cre8.mapper.cartMapper;

@Service
public class CartServiceImp implements CartService {

	@Autowired
	private cartMapper mapper;
	
	@Override
	public int delete(List<String> seqno) {
		return mapper.delete(seqno);
	}

	@Override
	public List<CartlistVO> getList(String id) {
		return mapper.list(id);
	}

}
>>>>>>> branch 'master' of https://github.com/cre8lover/spring_cre8.git
