package com.cre8.dto;


public class AucNowListVO {

	private int rn;
	private String memName;
	private String aucnowDate;
	private String aucnowLastprice;
	private String memId;
	
	
	
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getAucnowDate() {
		return aucnowDate;
	}
	public void setAucnowDate(String aucnowDate) {
		this.aucnowDate = aucnowDate;
	}
	public String getAucnowLastprice() {
		return aucnowLastprice;
	}
	public void setAucnowLastprice(String aucnowLastprice) {
		this.aucnowLastprice = aucnowLastprice;
	}

}