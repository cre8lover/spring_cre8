package com.cre8.dto;

import java.util.List;

public class ReviewDTO {
	
	private int cnt;
	private List<ReviewVo> list;

	public ReviewDTO(List<ReviewVo> list, int cnt) {
		this.cnt = cnt;
		this.list = list;
	}

	public int getcnt() {
		return cnt;
	}

	public void setcnt(int cnt) {
		this.cnt = cnt;
	}

	public List<ReviewVo> getList() {
		return list;
	}

	public void setList(List<ReviewVo> list) {
		this.list = list;
	}
	
	
	
}
