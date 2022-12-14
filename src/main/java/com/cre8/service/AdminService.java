package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Cat;
import com.cre8.dto.Marketing;
import com.cre8.dto.MarketingVo;
import com.cre8.dto.Mem;
import com.cre8.dto.PageDTO;

public interface AdminService {
	
	Map<String, String> login(String id, String pw);

	List<Cat> catelist(AdminKeyWord adkey);
	
	List<Mem> memberlist(AdminKeyWord adkey);

//	List<Pro> itemlist();
	
	List<Marketing> purchase(AdminKeyWord adkey);
	
	List<Marketing> month();
	
	List<Marketing> year();
	
	void reg(Marketing market, MultipartFile filename, String string);

	Marketing modify(String seqno);

	int update(MarketingVo vo);

	int add(MarketingVo vo);

	int remove(Long marSeqno);

	PageDTO marketingList(AdminKeyWord adkey, int page);

	

}
