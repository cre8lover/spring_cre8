package com.cre8.dto;

import java.util.List;

public class ProductTotalVO {

	private int total;
	private List<ProductMainVO> list;
	
	public ProductTotalVO(int total, List<ProductMainVO> list) {
		super();
		this.total = total;
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<ProductMainVO> getList() {
		return list;
	}
	public void setList(List<ProductMainVO> list) {
		this.list = list;
	}
	
	
	
}
