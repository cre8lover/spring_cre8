package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.AdminKeyWord;
import dto.Cat;
import dto.Item;
import dto.Marketing;
import dto.Mem;
import dto.Pro;

public interface AdminService {
	
	Map<String, String> login(String id, String pw);

	List<Cat> catelist(AdminKeyWord adkey);
	
	List<Mem> memberlist(AdminKeyWord adkey);

//	List<Pro> itemlist();
	
	List<Marketing> marketinglist(AdminKeyWord adkey);

	List<Marketing> purchase(AdminKeyWord adkey);
	
	List<Marketing> month();
	
	List<Marketing> year();
	
	void reg(HttpServletRequest req);
	
	Marketing modify(String seqno);

}
