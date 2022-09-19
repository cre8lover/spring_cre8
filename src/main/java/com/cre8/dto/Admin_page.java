package com.cre8.dto;

public class Admin_page {

	private int startPage;
	private int endPage;
	private int total;
	private AdminKeyWord adkey;
	private boolean prev;
	private boolean next;
	
	
	public Admin_page(int total, AdminKeyWord adkey) {
		super();
		this.total = total;
		this.adkey = adkey;
		
		this.endPage = (int)Math.ceil(adkey.getCurrentPage()/(adkey.getRowPerPage()*1.0))*adkey.getRowPerPage(); 
		this.startPage = this.endPage - (adkey.getRowPerPage()-1);
		
		int realEnd = (int)(Math.ceil((total*1.0)/adkey.getRowPerPage()));
		if(realEnd<this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage >1;
		this.next = this.endPage <realEnd;
		
	}

	
	

	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public AdminKeyWord getAdkey() {
		return adkey;
	}


	public void setAdkey(AdminKeyWord adkey) {
		this.adkey = adkey;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}
	
	
}
