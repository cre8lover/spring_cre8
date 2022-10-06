package com.cre8.mapper;

import java.util.List;

import com.cre8.dto.QnaVo;

public interface DetailMapper {

	List<QnaVo> qnaList(String seqno);

	int register(QnaVo qnaVo);

	QnaVo get(String seqno);

	int update(QnaVo QnaVo);

	int remove(String seqno);

}
