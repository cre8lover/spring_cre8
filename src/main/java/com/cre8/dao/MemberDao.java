package com.cre8.dao;

import java.util.List;
import java.util.Map;

import com.cre8.dto.Cart;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.Ship;

public interface MemberDao {

	public Map<String, String> longinProc(String id, String pw);
	
	public void reginsert(Mem mem);
	
	public Mem mypage(String id);
	
	public Mem info(String id);
	
	public List<Pro> membuylist(String id);
	
	public Map<String, List<Cart>> memauclist(String id);
	
	public List<Pro> buystat(String id);
	
	public Map<String, List<Ship>> ordercheck(String id);
	
	public void infoinsert(Mem mem);
	
	public Map<String, String> changePw(String new_pw, String id, String now_pw);
	
	public Map<String, String> findId(String idemail);
	
	public Map<String, String> findPw(String id, String email);

	public int checkid(String id);
}
