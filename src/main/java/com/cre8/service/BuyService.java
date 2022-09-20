package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cre8.dto.Cart;
import com.cre8.dto.Orders;


public interface BuyService {
	
	public List<Cart> myCart(String logid, String[] chklist);
//	public Cart buylist(String cart_seqno);
	public List<Orders> orderlist(String logid,String o_seqno);
	public int orderand(HttpServletRequest req, HttpServletResponse resp);
}
