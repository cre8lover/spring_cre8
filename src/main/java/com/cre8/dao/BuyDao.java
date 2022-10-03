package com.cre8.dao;

import java.util.ArrayList;
import java.util.List;

import com.cre8.dto.Cart;
import com.cre8.dto.Orders;
import com.cre8.dto.orderadd;

public interface BuyDao {
	
	public List<Cart> myCart(String logid, String[] list);
	public List<Orders> orderlist(String logid, String o_seqno);
	public int orderand(orderadd orderadd);
}
