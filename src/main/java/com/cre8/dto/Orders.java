package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Orders implements Serializable {

	private Integer orderSeqno;
	private Integer orderTotalprice;
	private Date orderDate;
	private Integer orderAmount;
	private Mem mem;
	private Pro pro;
	private Auc auc;
	private Cart cart;
	private Marketing marketing;
	private Orderdetail orderdetailSet;
	private Ship shipSet;

	public Orders() {

	}

	
	
	public Auc getAuc() {
		return auc;
	}



	public void setAuc(Auc auc) {
		this.auc = auc;
	}



	public Integer getOrderSeqno() {
		return orderSeqno;
	}

	public void setOrderSeqno(Integer orderSeqno) {
		this.orderSeqno = orderSeqno;
	}

	public Integer getOrderTotalprice() {
		return orderTotalprice;
	}

	public void setOrderTotalprice(Integer orderTotalprice) {
		this.orderTotalprice = orderTotalprice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Marketing getMarketing() {
		return marketing;
	}

	public void setMarketing(Marketing marketing) {
		this.marketing = marketing;
	}

	public Orderdetail getOrderdetailSet() {
		return orderdetailSet;
	}

	public void setOrderdetailSet(Orderdetail orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}

	public Ship getShipSet() {
		return shipSet;
	}

	public void setShipSet(Ship shipSet) {
		this.shipSet = shipSet;
	}

}