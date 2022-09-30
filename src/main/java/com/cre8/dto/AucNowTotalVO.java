package com.cre8.dto;

import java.util.List;

public class AucNowTotalVO {

	private List<AucNowListVO> anlist;
	private int total;
	
	
	
	public AucNowTotalVO(List<AucNowListVO> anlist, int total) {
		super();
		this.anlist = anlist;
		this.total = total;
	}

	
	
	public List<AucNowListVO> getAnlist() {
		return anlist;
	}

	public void setAnlist(List<AucNowListVO> anlist) {
		this.anlist = anlist;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	
	
	
	
	
}