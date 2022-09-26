package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public void setAucSeqno(Integer aucSeqno) {
		this.aucSeqno = aucSeqno;
	}

	public Integer getAucSeqno() {
		return this.aucSeqno;
	}

	public void setAucDetail(String aucDetail) {
		this.aucDetail = aucDetail;
	}

	public String getAucDetail() {
		return this.aucDetail;
	}

	public void setAucCloseprice(Integer aucCloseprice) {
		this.aucCloseprice = aucCloseprice;
	}

	public Integer getAucCloseprice() {
		return this.aucCloseprice;
	}

	public void setAucShortdetail(String aucShortdetail) {
		this.aucShortdetail = aucShortdetail;
	}

	public String getAucShortdetail() {
		return this.aucShortdetail;
	}

	public void setAucImg(String aucImg) {
		this.aucImg = aucImg;
	}

	public String getAucImg() {
		return this.aucImg;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public void setAucStart(String aucStart) {
		this.aucStart = aucStart;
	}

	public String getAucStart() {
		return this.aucStart;
	}

	public void setAucFinish(String aucFinish) {
		this.aucFinish = aucFinish;
	}

	public String getAucFinish() {
		return this.aucFinish;
	}

	public void setAucPrice(Integer aucPrice) {
		this.aucPrice = aucPrice;
	}

	public Integer getAucPrice() {
		return this.aucPrice;
	}

	public void setAucAmount(Integer aucAmount) {
		this.aucAmount = aucAmount;
	}

	public Integer getAucAmount() {
		return this.aucAmount;
	}

	public void setAucStat(String aucStat) {
		this.aucStat = aucStat;
	}

	public String getAucStat() {
		return this.aucStat;
	}

	public void setAucHits(Integer aucHits) {
		this.aucHits = aucHits;
	}

	public Integer getAucHits() {
		return this.aucHits;
	}

	public void setAucNowingSet(List<AucNowing> aucNowingSet) {
		this.aucNowingSet = aucNowingSet;
	}

	public List<AucNowing> getAucNowingSet() {
		return this.aucNowingSet;
	}

	public void setCartSet(Cart cartSet) {
		this.cartSet = cartSet;
	}

	public Cart getCartSet() {
		return this.cartSet;
	}

}
