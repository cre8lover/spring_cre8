package com.cre8.service;

import java.util.HashMap;
import java.util.List;

import com.cre8.dao.MainDao;
import com.cre8.dto.Creator;
import com.cre8.dto.Pro;


public class MainlistServiceImp implements MainlistService {
MainDao dao = new MainDao();
	@Override
	public List<Pro> mainList() {
		return dao.mainList();
	}

	@Override
	public HashMap<String, List<Creator>> creList() {
		return dao.creList();
	}

	
}
