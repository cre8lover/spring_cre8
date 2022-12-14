package com.cre8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dao.ProductDaoimp;
import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.AnswerVo;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Cart;
import com.cre8.dto.Pro;
import com.cre8.dto.Qna;
import com.cre8.dto.QnaVo;
import com.cre8.dto.ReviewDTO;
import com.cre8.dto.ReviewVo;
import com.cre8.mapper.DetailMapper;

@Service
public class ProServiceImp implements ProService {
	@Autowired
	ProductDaoimp ProDao;
	@Autowired
	private DetailMapper mapper;
	
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

	@Override
	public List<QnaVo> qnaList(String seqno) {
		return mapper.qnaList(seqno);
	}

	@Override
	public int register(QnaVo QnaVo) {

		return mapper.register(QnaVo);
	}

	@Override
	public QnaVo get(String seqno) {
		
		return mapper.get(seqno);
	}

	@Override
	public int modify(QnaVo QnaVo) {
		
		return mapper.update(QnaVo);
	}

	@Override
	public int remove(String seqno) {
		
		return mapper.remove(seqno);
	}

	@Override
	public ReviewDTO ReviewList(AdminKeyWord adkey, int seqno) {
		
		return new ReviewDTO(mapper.ReviewList(adkey, seqno),
								mapper.getCountReview(seqno));
	}

	@Override
	public int Reviewregister(ReviewVo reviewVo) {

		return mapper.Reviewregister(reviewVo);
	}

	@Override
	public ReviewVo reviewget(String reviewSeqno) {

		return mapper.ReviewGet(reviewSeqno);
	}

	@Override
	public int reivewremove(String reviewNo) {
		
		return mapper.reviewRemove(reviewNo);
	}

	@Override
	public int answer(AnswerVo answerVo) {
		
		return mapper.qnaAnswer(answerVo);
	}



}
