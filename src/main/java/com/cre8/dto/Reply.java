package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {

	private Integer replySeqno;
	private String replyContent;
	private Date replyDate;
	private Mem mem;
	private Qna qna;

	public Reply() {
	}

	public Integer getReplySeqno() {
		return replySeqno;
	}

	public void setReplySeqno(Integer replySeqno) {
		this.replySeqno = replySeqno;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Qna getQna() {
		return qna;
	}

	public void setQna(Qna qna) {
		this.qna = qna;
	}

}