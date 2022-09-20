package com.cre8.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dao.AucDao;
import com.cre8.dto.Auc;
import com.cre8.dto.Auc_Criteria;

@Service
public class AuctionServiceimp implements AuctionServeice {
	@Autowired
	AucDao Dao;
	
	@Override
	public List<Auc> aucList(Auc_Criteria cri) {
		return Dao.aucList(cri);
	}


	@Override
	public Auc detailList(String seqno) {
		return Dao.detailList(seqno);
	}


	@Override
	public void aucnow(String srt, String seqno,String id) {
		Dao.aucnow(srt,seqno,id);
	}

}
