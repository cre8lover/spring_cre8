package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pro{

	private static final long serialVersionUID = 1L;
	
	private Integer proSeqno;
	private Integer proPrice;
	private String proDetail;
	private String proOpendate;
	private String proClosedate;
	private Integer proSaleprice;
	private Integer proAmount;
	private String proStat;
	private Integer proHits;
	private Cat cat;
	private Mem mem;
	private Item item;
	private Cart cartSet;
	private Orders ordersSet;
	private List<Qna> qnaSet;
	private List<Review> reviewSet;
	private Integer discount;
	private Integer reviewcount;
	private String companyname;
	private Att att_file;
	private Thumbnail thumb;
	
	
	
	
	
	
	public Thumbnail getThumb() {
		return thumb;
	}

	public void setThumb(Thumbnail thumb) {
		this.thumb = thumb;
	}

	public Att getAtt_file() {
		return att_file;
	}

	public void setAtt_file(Att att_file) {
		this.att_file = att_file;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getReviewcount() {
		return reviewcount;
	}

	public void setReviewcount(Integer reviewcount) {
		this.reviewcount = reviewcount;
	}

	public Pro() {
	}

	public Integer getProSeqno() {
		return proSeqno;
	}

	public void setProSeqno(Integer proSeqno) {
		this.proSeqno = proSeqno;
	}

	public Integer getProPrice() {
		return proPrice;
	}

	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}

	public String getProDetail() {
		return proDetail;
	}

	public void setProDetail(String proDetail) {
		this.proDetail = proDetail;
	}

	public String getProOpendate() {
		return proOpendate;
	}

	public void setProOpendate(String proOpendate) {
		this.proOpendate = proOpendate;
	}

	public String getProClosedate() {
		return proClosedate;
	}

	public void setProClosedate(String proClosedate) {
		this.proClosedate = proClosedate;
	}

	public Integer getProSaleprice() {
		return proSaleprice;
	}

	public void setProSaleprice(Integer proSaleprice) {
		this.proSaleprice = proSaleprice;
	}

	public Integer getProAmount() {
		return proAmount;
	}

	public void setProAmount(Integer proAmount) {
		this.proAmount = proAmount;
	}

	public String getProStat() {
		return proStat;
	}

	public void setProStat(String proStat) {
		this.proStat = proStat;
	}

	public Integer getProHits() {
		return proHits;
	}

	public void setProHits(Integer proHits) {
		this.proHits = proHits;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Cart getCartSet() {
		return cartSet;
	}

	public void setCartSet(Cart cartSet) {
		this.cartSet = cartSet;
	}

	public Orders getOrdersSet() {
		return ordersSet;
	}

	public void setOrdersSet(Orders ordersSet) {
		this.ordersSet = ordersSet;
	}

	public List<Qna> getQnaSet() {
		return qnaSet;
	}

	public void setQnaSet(List<Qna> qna_arr) {
		this.qnaSet = qna_arr;
	}

	public List<Review> getReviewSet() {
		return reviewSet;
	}

	public void setReviewSet(List<Review> review_arr) {
		this.reviewSet = review_arr;
	}

}