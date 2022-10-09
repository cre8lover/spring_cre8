package com.cre8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dao.AucDao;
import com.cre8.dto.Auc;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Orders;
import com.cre8.dto.orderadd;
import com.cre8.mapper.AucNowMapper;

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


	@Override
	public int orderand(orderadd orderadd) {
		return Dao.aucadd(orderadd);
	}


	@Override
	public List<Orders> orderlist(String o_seqno) {
		return Dao.aucorderlist(o_seqno);
	}


}
