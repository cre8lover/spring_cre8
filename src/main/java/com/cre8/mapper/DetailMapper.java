package com.cre8.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.AnswerVo;
import com.cre8.dto.QnaVo;
import com.cre8.dto.ReviewDTO;
import com.cre8.dto.ReviewVo;

public interface DetailMapper {

	List<QnaVo> qnaList(String seqno);

	int register(QnaVo qnaVo);

	QnaVo get(String seqno);

	int update(QnaVo QnaVo);

	int remove(String seqno);

	List<ReviewVo> ReviewList(@Param("adkey") AdminKeyWord adkey, @Param("seqno") int seqno);

	int Reviewregister(ReviewVo reviewVo);

	ReviewVo ReviewGet(String reviewSeqno);

	int reviewRemove(String reviewNo);
	
	public int getCountReview(int seqno);

	int qnaAnswer(AnswerVo answerVo);

}
