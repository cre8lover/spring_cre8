package com.cre8.dao;

import java.util.List;

import com.cre8.dto.Auc;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Orders;
import com.cre8.dto.orderadd;

public interface AucDao {
	
	public List<Auc> aucList(Auc_Criteria cri);
	public Auc detailList(String seqno);
	public void aucnow(String srt, String seqno, String id);
	public int aucadd(orderadd orderadd);
	public List<Orders> aucorderlist(String o_seqno);
}
