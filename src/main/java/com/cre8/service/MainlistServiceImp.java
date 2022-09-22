package com.cre8.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dao.MainDao;
import com.cre8.dao.MainDaoImp;
import com.cre8.dto.Creator;
import com.cre8.dto.Pro;

@Service
public class MainlistServiceImp implements MainlistService {
	
    @Autowired
	MainDao dao;
	
	@Override
	public List<Pro> mainList() {
		return dao.mainList();
	}

	@Override
	public HashMap<String, List<Creator>> creList() {
		return dao.creList();
	}

	@Override
	public Creator creDetail(String memid) {
		
		return dao.detailcre(memid);	
		
	}

	
}
