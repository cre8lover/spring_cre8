package com.cre8.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Item implements Serializable {

	private Integer itemSeqno;
	private String itemName;
	private String itemImg;
	private String itemDetail;
	private Integer itemAmount;
	private Mem mem;
	private Att attSet;
	private Auc aucSet;
	private Pro proSet;

	public Item() {
	}

	public Integer getItemSeqno() {
		return itemSeqno;
	}

	public void setItemSeqno(Integer itemSeqno) {
		this.itemSeqno = itemSeqno;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public Integer getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(Integer itemAmount) {
		this.itemAmount = itemAmount;
	}

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Att getAttSet() {
		return attSet;
	}

	public void setAttSet(Att attSet) {
		this.attSet = attSet;
	}

	public Auc getAucSet() {
		return aucSet;
	}

	public void setAucSet(Auc aucSet) {
		this.aucSet = aucSet;
	}

	public Pro getProSet() {
		return proSet;
	}

	public void setProSet(Pro proSet) {
		this.proSet = proSet;
	}

}