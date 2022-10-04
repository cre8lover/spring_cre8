package com.cre8.dao;

import java.util.List;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Cart;
import com.cre8.dto.Pro;

public interface ProductDao {
	public List<Pro> proList_clothes(Auc_Criteria ac);
	public List<Cart> nowbuy(String seqno, String amount);
	public Pro detailList(String seqno);
}
