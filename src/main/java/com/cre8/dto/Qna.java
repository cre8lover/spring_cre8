package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Qna implements Serializable {

	private Integer qnaSeqno;
	private String qnaContent;
	private Pro pro;
	private String memid;
	private Date qnaDate;
	private Reply replySet;

	public Qna() {

	}

	public Integer getQnaSeqno() {
		return qnaSeqno;
	}

	public void setQnaSeqno(Integer qnaSeqno) {
		this.qnaSeqno = qnaSeqno;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Pro getPro() {
		return pro;
	}

	public void setPro(Pro pro) {
		this.pro = pro;
	}



	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public Reply getReplySet() {
		return replySet;
	}

	public void setReplySet(Reply reply_arr) {
		this.replySet = reply_arr;
	}

}