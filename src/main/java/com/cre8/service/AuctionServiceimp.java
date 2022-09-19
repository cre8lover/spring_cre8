package com.cre8.service;

import java.util.List;
import java.util.Map;

import dao.AucDao;
import dto.Auc;
import dto.Auc_Criteria;

public class AuctionServiceimp implements AuctionServeice {
	AucDao Dao = new AucDao();
	
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
