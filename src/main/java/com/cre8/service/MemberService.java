package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cre8.dto.Cart;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.Ship;


public interface MemberService {

	Map<String, String> login(String id, String pw);

	Mem mypage(String id);

	Mem meminfo(String id);

	List<Pro> membuylist(String id);

	Map<String, List<Cart>> memauclist(String id);
	
	List<Pro> buystat(String id);
	
	Map<String, List<Ship>> ordercheck(String id);
	
	Map<String, String> changePw(String new_pw, String id, String now_pw);
	
	Map<String, String> findId(String idemail);

	Map<String, String> findPw(String id, String email);

	int idcheck(String id);

	void insert(Mem mem);

	void infoinsert(Mem mem, HttpServletRequest req);



}
