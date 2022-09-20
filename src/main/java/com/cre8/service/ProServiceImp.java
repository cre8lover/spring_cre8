package com.cre8.service;

import java.util.List;

import com.cre8.dao.ProductDao;
import com.cre8.dto.Pro;


public class ProServiceImp implements ProService {
	ProductDao ProDao = new ProductDao();

	@Override
	public List<Pro> proList_clothes() {
		return ProDao.proList_clothes();
	}

	@Override
	public List<Pro> proList_furn() {
		return ProDao.proList_furn();
	}

	@Override
	public List<Pro> proList_cos() {
		return ProDao.proList_cos();
	}

	@Override
	public List<Pro> proList_interior() {
		return ProDao.proList_interior();
	}

	@Override
	public List<Pro> proList_tra() {
		return ProDao.proList_tra();
	}

	public Pro detailList(String seqno) {
		return ProDao.detailList(seqno);
	}



}
