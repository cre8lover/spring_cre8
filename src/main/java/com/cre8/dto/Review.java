package com.cre8.dto;

import java.io.Serializable;

public class Review implements Serializable {

	private Integer reviewSeqno;
	private String reviewContent;
	private Mem mem;
	private Pro pro;


	public Review() {
	}


	public Integer getReviewSeqno() {
		return reviewSeqno;
	}


	public void setReviewSeqno(Integer reviewSeqno) {
		this.reviewSeqno = reviewSeqno;
	}


	public String getReviewContent() {
		return reviewContent;
	}


	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}


	public Mem getMem() {
		return mem;
	}


	public void setMem(Mem mem) {
		this.mem = mem;
	}


	public Pro getPro() {
		return pro;
	}


	public void setPro(Pro pro) {
		this.pro = pro;
	}

}