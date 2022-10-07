package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;

public class ReviewVo implements Serializable {

	private Integer reviewSeqno;
	private String reviewContent;
	private int seqno;
	private String memId;
	private String memPw;
	private Date memWdate;
	private String memTel;
	private String memEmail;
	private String memBirth;
	private String memSnsinfo;
	private String memImg;
	private String memName;
	private Address addressSet;
	private AucNowing aucNowingSet;
	private Cart cartSet;
	private Creator creatorSet;
	private Item itemSet;
	private MemAuth memAuthSet;
	private Orders ordersSet;
	private Pro proSet;
	private Qna qnaSet;
	private Reply replySet;
	private Review reviewSet;
	private String check;
	private Att att;


	public ReviewVo() {
	}


	public int getSeqno() {
		return seqno;
	}


	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getMemPw() {
		return memPw;
	}


	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}


	public Date getMemWdate() {
		return memWdate;
	}


	public void setMemWdate(Date memWdate) {
		this.memWdate = memWdate;
	}


	public String getMemTel() {
		return memTel;
	}


	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}


	public String getMemEmail() {
		return memEmail;
	}


	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}


	public String getMemBirth() {
		return memBirth;
	}


	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}


	public String getMemSnsinfo() {
		return memSnsinfo;
	}


	public void setMemSnsinfo(String memSnsinfo) {
		this.memSnsinfo = memSnsinfo;
	}


	public String getMemImg() {
		return memImg;
	}


	public void setMemImg(String memImg) {
		this.memImg = memImg;
	}


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public Address getAddressSet() {
		return addressSet;
	}


	public void setAddressSet(Address addressSet) {
		this.addressSet = addressSet;
	}


	public AucNowing getAucNowingSet() {
		return aucNowingSet;
	}


	public void setAucNowingSet(AucNowing aucNowingSet) {
		this.aucNowingSet = aucNowingSet;
	}


	public Cart getCartSet() {
		return cartSet;
	}


	public void setCartSet(Cart cartSet) {
		this.cartSet = cartSet;
	}


	public Creator getCreatorSet() {
		return creatorSet;
	}


	public void setCreatorSet(Creator creatorSet) {
		this.creatorSet = creatorSet;
	}


	public Item getItemSet() {
		return itemSet;
	}


	public void setItemSet(Item itemSet) {
		this.itemSet = itemSet;
	}


	public MemAuth getMemAuthSet() {
		return memAuthSet;
	}


	public void setMemAuthSet(MemAuth memAuthSet) {
		this.memAuthSet = memAuthSet;
	}


	public Orders getOrdersSet() {
		return ordersSet;
	}


	public void setOrdersSet(Orders ordersSet) {
		this.ordersSet = ordersSet;
	}


	public Pro getProSet() {
		return proSet;
	}


	public void setProSet(Pro proSet) {
		this.proSet = proSet;
	}


	public Qna getQnaSet() {
		return qnaSet;
	}


	public void setQnaSet(Qna qnaSet) {
		this.qnaSet = qnaSet;
	}


	public Reply getReplySet() {
		return replySet;
	}


	public void setReplySet(Reply replySet) {
		this.replySet = replySet;
	}


	public Review getReviewSet() {
		return reviewSet;
	}


	public void setReviewSet(Review reviewSet) {
		this.reviewSet = reviewSet;
	}


	public String getCheck() {
		return check;
	}


	public void setCheck(String check) {
		this.check = check;
	}


	public Att getAtt() {
		return att;
	}


	public void setAtt(Att att) {
		this.att = att;
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


}