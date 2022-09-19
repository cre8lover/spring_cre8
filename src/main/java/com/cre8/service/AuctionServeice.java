package com.cre8.service;

import java.util.List;
import java.util.Map;

import dto.Auc;
import dto.Auc_Criteria;

public interface AuctionServeice {

	public List<Auc> aucList(Auc_Criteria cri);

	public Auc detailList(String seqno);

	public void aucnow(String srt, String seqno, String id);
	
	
}
