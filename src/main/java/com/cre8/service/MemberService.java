package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.Att;
import dto.Cart;
import dto.Mem;
import dto.Pro;
import dto.Ship;

public interface MemberService {

	Map<String, String> login(String id, String pw);

	String insert(HttpServletRequest req);
	
	Mem mypage(String id);

	Mem meminfo(String id);

	List<Pro> membuylist(String id);

	Map<String, List<Cart>> memauclist(String id);
	
	List<Pro> buystat(String id);
	
	Map<String, List<Ship>> ordercheck(String id);
	
	void infoinsert(HttpServletRequest req);

	Map<String, String> changePw(String new_pw, String id, String now_pw);
	
	Map<String, String> findId(String idemail);

	Map<String, String> findPw(String id, String email);

	int idcheck(String id);



}
