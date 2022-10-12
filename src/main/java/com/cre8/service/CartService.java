package com.cre8.service;

import java.util.List;

import com.cre8.dto.Cart;
import com.cre8.dto.CartlistVO;

public interface CartService {

	int delete(List<String> seqno);

	List<CartlistVO> getList(String id);

	int amountmodify(Cart cart);

}
