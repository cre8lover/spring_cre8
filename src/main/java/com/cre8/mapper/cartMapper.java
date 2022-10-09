package com.cre8.mapper;

import java.util.List;

import com.cre8.dto.Cart;
import com.cre8.dto.CartlistVO;

public interface cartMapper {

	public int delete(List<String> seqno);

	public List<CartlistVO> list(String id);

	public int modify(Cart cart);
	
}
