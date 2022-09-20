package com.cre8.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Cat;
import com.cre8.dto.Marketing;
import com.cre8.dto.Mem;

public interface AdminDao {

	Map<String, String> longinProc(String id, String pw);

	List<Cat> categorylist(AdminKeyWord adkey);

	List<Marketing> marketinglist(AdminKeyWord adkey);

	List<Marketing> monthlist();

	List<Marketing> yearlist();

	void marketReg(Marketing market);

	List<Mem> memberlist(AdminKeyWord adkey);

	List<Marketing> buylist(AdminKeyWord adkey);

	Marketing modify(String seqno);

}
