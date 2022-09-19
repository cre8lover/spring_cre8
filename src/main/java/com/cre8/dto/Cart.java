package com.cre8.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cartSeqno;
	private Integer cartAmount;
	private Mem mem;
	private Pro pro;
	private Auc auc;
	private int totalprice;
	private Orders ordersSet;

	public Cart() {

	}

	public Integer getCartSeqno() {
		return cartSeqno;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public void setCartSeqno(Integer cartSeqno) {
		this.cartSeqno = cartSeqno;
	}

	public Integer getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(Integer cartAmount) {
		this.cartAmount = cartAmount;
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

	public Auc getAuc() {
		return auc;
	}

	public void setAuc(Auc auc) {
		this.auc = auc;
	}

	public Orders getOrdersSet() {
		return ordersSet;
	}

	public void setOrdersSet(Orders ordersSet) {
		this.ordersSet = ordersSet;
	}

}