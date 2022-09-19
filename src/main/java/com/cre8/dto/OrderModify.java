package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;

public class OrderModify implements Serializable {

	private Integer odSeqno;
	private Date odModifydate;
	private String odStat;
	private Orderdetail orderdetail;

	public OrderModify() {
	}

	public Integer getOdSeqno() {
		return odSeqno;
	}

	public void setOdSeqno(Integer odSeqno) {
		this.odSeqno = odSeqno;
	}

	public Date getOdModifydate() {
		return odModifydate;
	}

	public void setOdModifydate(Date odModifydate) {
		this.odModifydate = odModifydate;
	}

	public String getOdStat() {
		return odStat;
	}

	public void setOdStat(String odStat) {
		this.odStat = odStat;
	}

	public Orderdetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(Orderdetail orderdetail) {
		this.orderdetail = orderdetail;
	}

}