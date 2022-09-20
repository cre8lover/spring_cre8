package com.cre8.dto;

public class orderadd {
	private String[] cart;
	private String[] orderamount;
	private String pay_method;
	private String buyer_name;
	private String buyer_tel;
	private String merchant_uid;
	private String amount;
	private String id;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getCart() {
		return cart;
	}
	public void setCart(String[] cart) {
		this.cart = cart;
	}
	public String[] getOrderamount() {
		return orderamount;
	}
	public void setOrderamount(String[] orderamount) {
		this.orderamount = orderamount;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_tel() {
		return buyer_tel;
	}
	public void setBuyer_tel(String buyer_tel) {
		this.buyer_tel = buyer_tel;
	}
	public String getMerchant_uid() {
		return merchant_uid;
	}
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
