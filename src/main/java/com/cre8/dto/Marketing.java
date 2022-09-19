package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Marketing implements Serializable {

	private int cnt;
	private int no;
	private Integer marSeqno;
	private String marCategory;
	private String marProduct;
	private String marCompany;
	private String marCeo;
	private String marPhone;
	private String marRegnum;
	private String marOpendate;
	private String marPrice;
	private String marStat;
	private String marClosedate;
	private String marInfo;
	private String marDetail;
	private String marImg;
	private Att attSet;
	private Orders ordersSet;

	public Marketing() {
	
	}

	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMarCategory() {
		return marCategory;
	}


	public void setMarCategory(String marCategory) {
		this.marCategory = marCategory;
	}


	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Integer getMarSeqno() {
		return marSeqno;
	}

	public void setMarSeqno(Integer marSeqno) {
		this.marSeqno = marSeqno;
	}

	public String getMarProduct() {
		return marProduct;
	}

	public void setMarProduct(String marProduct) {
		this.marProduct = marProduct;
	}

	public String getMarCompany() {
		return marCompany;
	}

	public void setMarCompany(String marCompany) {
		this.marCompany = marCompany;
	}

	public String getMarCeo() {
		return marCeo;
	}

	public void setMarCeo(String marCeo) {
		this.marCeo = marCeo;
	}

	public String getMarPhone() {
		return marPhone;
	}

	public void setMarPhone(String marPhone) {
		this.marPhone = marPhone;
	}

	public String getMarRegnum() {
		return marRegnum;
	}

	public void setMarRegnum(String marRegnum) {
		this.marRegnum = marRegnum;
	}

	public String getMarOpendate() {
		return marOpendate;
	}

	public void setMarOpendate(String marOpendate) {
		this.marOpendate = marOpendate;
	}

	public String getMarPrice() {
		return marPrice;
	}

	public void setMarPrice(String marPrice) {
		this.marPrice = marPrice;
	}

	public String getMarStat() {
		return marStat;
	}

	public void setMarStat(String marStat) {
		this.marStat = marStat;
	}

	public String getMarClosedate() {
		return marClosedate;
	}

	public void setMarClosedate(String marClosedate) {
		this.marClosedate = marClosedate;
	}

	public String getMarInfo() {
		return marInfo;
	}

	public void setMarInfo(String marInfo) {
		this.marInfo = marInfo;
	}

	public String getMarDetail() {
		return marDetail;
	}

	public void setMarDetail(String marDetail) {
		this.marDetail = marDetail;
	}

	public String getMarImg() {
		return marImg;
	}

	public void setMarImg(String marImg) {
		this.marImg = marImg;
	}

	public Att getAttSet() {
		return attSet;
	}

	public void setAttSet(Att attSet) {
		this.attSet = attSet;
	}

	public Orders getOrdersSet() {
		return ordersSet;
	}

	public void setOrdersSet(Orders ordersSet) {
		this.ordersSet = ordersSet;
	}

}