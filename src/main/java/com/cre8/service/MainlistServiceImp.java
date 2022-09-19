package com.cre8.service;

import java.util.HashMap;
import java.util.List;

import dao.CreatorDao;
import dao.MainDao;
import dto.Creator;
import dto.Pro;

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
