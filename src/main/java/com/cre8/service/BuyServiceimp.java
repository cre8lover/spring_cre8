package com.cre8.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dao.BuyDao;
import com.cre8.dto.Cart;
import com.cre8.dto.Orders;
import com.cre8.dto.orderadd;

@Service
public class BuyServiceimp implements BuyService{
	@Autowired
	BuyDao Dao;
	
	@Override
	public List<Cart> myCart(String logid, String[] chklist) {
		
		return Dao.myCart(logid, chklist);
	}
	
	/*
	 * public Cart buylist(String id) {
	 * 
	 * return Dao.buylist(id);
	 * 
	 * }
	 */
	@Override
	public List<Orders> orderlist(String logid, String o_seqno) {
			return Dao.orderlist(logid,o_seqno);
	}
	@Override
	public int orderand(orderadd orderadd) {
		
		return Dao.orderand(orderadd);
	}
}
