package com.cre8.service;

import java.util.List;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.AnswerVo;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Cart;
import com.cre8.dto.Pro;
import com.cre8.dto.QnaVo;
import com.cre8.dto.ReviewDTO;
import com.cre8.dto.ReviewVo;

public interface ProService {

	List<Pro> proList_clothes(Auc_Criteria ac);

	public Pro detailList(String seqno);

	List<Cart> nowbuy(String seqno, String amount);

	List<QnaVo> qnaList(String seqno);

	int register(QnaVo qnaVo);

	QnaVo get(String seqno);

	int modify(QnaVo vo);

	int remove(String seqno);

	ReviewDTO ReviewList(AdminKeyWord adkey, int seqno);

	int Reviewregister(ReviewVo reviewVo);

	ReviewVo reviewget(String reviewSeqno);

	int reivewremove(String reviewNo);

	int answer(AnswerVo answerVo);



}
