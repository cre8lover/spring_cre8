package com.cre8.service;

import java.util.List;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Cart;
import com.cre8.dto.Pro;
import com.cre8.dto.QnaVo;

public interface ProService {

	List<Pro> proList_clothes(Auc_Criteria ac);

	public Pro detailList(String seqno);

	List<Cart> nowbuy(String seqno, String amount);

	List<QnaVo> qnaList(String seqno);

	int register(QnaVo qnaVo);

	QnaVo get(String seqno);

	int modify(QnaVo vo);

	int remove(String seqno);


}
