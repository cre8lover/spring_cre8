package com.cre8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dao.ProductDaoimp;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Cart;
import com.cre8.dto.Pro;

@Service
public class ProServiceImp implements ProService {
	@Autowired
	ProductDaoimp ProDao;

	@Override
	public List<Pro> proList_clothes(Auc_Criteria ac) {
		return ProDao.proList_clothes(ac);
	}

	public Pro detailList(String seqno) {
		return ProDao.detailList(seqno);
	}

	@Override
	public List<Cart> nowbuy(String seqno,String amount) {
		return ProDao.nowbuy(seqno,amount);
	}



}
