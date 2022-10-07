package com.cre8.mapper;

import java.util.List;

import com.cre8.dto.QnaVo;
import com.cre8.dto.ReviewVo;

public interface DetailMapper {

	List<QnaVo> qnaList(String seqno);

	int register(QnaVo qnaVo);

	QnaVo get(String seqno);

	int update(QnaVo QnaVo);

	int remove(String seqno);

	List<ReviewVo> ReviewList(String seqno);

	int Reviewregister(ReviewVo reviewVo);

	ReviewVo ReviewGet(String reviewSeqno);

	int reviewRemove(String reviewNo);

}
