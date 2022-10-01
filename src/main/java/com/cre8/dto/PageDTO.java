package com.cre8.dto;

import java.util.List;

public class PageDTO {
	
	private int Cnt;
	private List<MarketingVo> list;

	public PageDTO(List<MarketingVo> list, int Cnt) {
		this.Cnt = Cnt;
		this.list = list;
	}

	public int getCnt() {
		return Cnt;
	}

	public void setCnt(int Cnt) {
		this.Cnt = Cnt;
	}

	public List<MarketingVo> getList() {
		return list;
	}

	public void setList(List<MarketingVo> list) {
		this.list = list;
	}
	
	
	
}
