package com.cre8.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Orderdetail implements Serializable {

	private Integer orderdetailSeqno;
	private String orderdetailWay;
	private String orderdetailBuyer;
	private String orderdetailPhone;
	private Orders orders;
	private String orderdetailStat;
	private String orderdetailFinish;
	private OrderModify orderModifySet;

	public Orderdetail() {

	}

	public Integer getOrderdetailSeqno() {
		return orderdetailSeqno;
	}

	public void setOrderdetailSeqno(Integer orderdetailSeqno) {
		this.orderdetailSeqno = orderdetailSeqno;
	}

	public String getOrderdetailWay() {
		return orderdetailWay;
	}

	public void setOrderdetailWay(String orderdetailWay) {
		this.orderdetailWay = orderdetailWay;
	}

	public String getOrderdetailBuyer() {
		return orderdetailBuyer;
	}

	public void setOrderdetailBuyer(String orderdetailBuyer) {
		this.orderdetailBuyer = orderdetailBuyer;
	}

	public String getOrderdetailPhone() {
		return orderdetailPhone;
	}

	public void setOrderdetailPhone(String orderdetailPhone) {
		this.orderdetailPhone = orderdetailPhone;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getOrderdetailStat() {
		return orderdetailStat;
	}

	public void setOrderdetailStat(String orderdetailStat) {
		this.orderdetailStat = orderdetailStat;
	}

	public String getOrderdetailFinish() {
		return orderdetailFinish;
	}

	public void setOrderdetailFinish(String orderdetailFinish) {
		this.orderdetailFinish = orderdetailFinish;
	}

	public OrderModify getOrderModifySet() {
		return orderModifySet;
	}

	public void setOrderModifySet(OrderModify orderModifySet) {
		this.orderModifySet = orderModifySet;
	}

}