package com.cre8.dto;

public class AdminKeyWord {
	
	private String category;
	private String keyword;
	private String classification;
	private int page;
	private String sdate;
	private String fdate;
	private int currentPage;
	private int rowPerPage;	
	
	
	public AdminKeyWord() {
		super();
	}
	public AdminKeyWord(String category, String keyword) {
		super();
		this.category = category;
		this.keyword = keyword;
	}
	
	public AdminKeyWord(int currentPage, int rowPerPage) {
		super();
		this.currentPage = currentPage;
		this.rowPerPage = rowPerPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRowPerPage() {
		return rowPerPage;
	}
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	

	
}
