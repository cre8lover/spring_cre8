package com.cre8.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;




public class Auc implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer aucSeqno;
	private String aucDetail;
	private Integer aucCloseprice;
	private String aucShortdetail;
	private String aucImg;
	private Item item;
	private String aucStart;
	private String aucFinish;
	private Integer aucPrice;
	private Integer aucAmount;
	private String aucStat;
	private Integer aucHits;
	private List<AucNowing> aucNowingSet;
	private Cart cartSet;
	private Att att_file;
	private Thumbnail thumb;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAucSeqno() {
		return aucSeqno;
	}
	public void setAucSeqno(Integer aucSeqno) {
		this.aucSeqno = aucSeqno;
	}
	public String getAucDetail() {
		return aucDetail;
	}
	public void setAucDetail(String aucDetail) {
		this.aucDetail = aucDetail;
	}
	public Integer getAucCloseprice() {
		return aucCloseprice;
	}
	public void setAucCloseprice(Integer aucCloseprice) {
		this.aucCloseprice = aucCloseprice;
	}
	public String getAucShortdetail() {
		return aucShortdetail;
	}
	public void setAucShortdetail(String aucShortdetail) {
		this.aucShortdetail = aucShortdetail;
	}
	public String getAucImg() {
		return aucImg;
	}
	public void setAucImg(String aucImg) {
		this.aucImg = aucImg;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getAucStart() {
		return aucStart;
	}
	public void setAucStart(String aucStart) {
		this.aucStart = aucStart;
	}
	public String getAucFinish() {
		return aucFinish;
	}
	public void setAucFinish(String aucFinish) {
		this.aucFinish = aucFinish;
	}
	public Integer getAucPrice() {
		return aucPrice;
	}
	public void setAucPrice(Integer aucPrice) {
		this.aucPrice = aucPrice;
	}
	public Integer getAucAmount() {
		return aucAmount;
	}
	public void setAucAmount(Integer aucAmount) {
		this.aucAmount = aucAmount;
	}
	public String getAucStat() {
		return aucStat;
	}
	public void setAucStat(String aucStat) {
		this.aucStat = aucStat;
	}
	public Integer getAucHits() {
		return aucHits;
	}
	public void setAucHits(Integer aucHits) {
		this.aucHits = aucHits;
	}
	public List<AucNowing> getAucNowingSet() {
		return aucNowingSet;
	}
	public void setAucNowingSet(List<AucNowing> aucNowingSet) {
		this.aucNowingSet = aucNowingSet;
	}
	public Cart getCartSet() {
		return cartSet;
	}
	public void setCartSet(Cart cartSet) {
		this.cartSet = cartSet;
	}
	public Att getAtt_file() {
		return att_file;
	}
	public void setAtt_file(Att att_file) {
		this.att_file = att_file;
	}
	public Thumbnail getThumb() {
		return thumb;
	}
	public void setThumb(Thumbnail thumb) {
		this.thumb = thumb;
	}

	
	
}
