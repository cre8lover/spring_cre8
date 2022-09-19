package com.cre8.service;

import java.util.HashMap;
import java.util.List;

import dto.Creator;
import dto.Pro;

public interface MainlistService {
	
	public List<Pro> mainList();
	
	public HashMap<String, List<Creator>> creList();
	

}
