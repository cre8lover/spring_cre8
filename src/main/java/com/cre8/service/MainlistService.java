package com.cre8.service;

import java.util.HashMap;
import java.util.List;

import com.cre8.dto.Creator;
import com.cre8.dto.Pro;


public interface MainlistService {
	
	public List<Pro> mainList();
	
	public HashMap<String, List<Creator>> creList();

	public Creator creDetail(String memid);
	

}
