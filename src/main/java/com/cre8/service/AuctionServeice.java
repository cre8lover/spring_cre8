package com.cre8.service;

import java.util.List;

import com.cre8.dto.Auc;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Orders;
import com.cre8.dto.orderadd;


public interface AuctionServeice {

	public List<Auc> aucList(Auc_Criteria cri);

	public Auc detailList(String seqno);

	public void aucnow(String srt, String seqno, String id);

	public int orderand(orderadd orderadd);

	public List<Orders> orderlist(String o_seqno);
	
}
