package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Cat implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer catSeqno;
	private String catName;
	private Mem mem;
	private Date catRegdate;
	private Pro proSet;

	public Cat() {
	}

	public Integer getCatSeqno() {
		return catSeqno;
	}

	public void setCatSeqno(Integer catSeqno) {
		this.catSeqno = catSeqno;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Date getCatRegdate() {
		return catRegdate;
	}

	public void setCatRegdate(Date catRegdate) {
		this.catRegdate = catRegdate;
	}

	public Pro getProSet() {
		return proSet;
	}

	public void setProSet(Pro proSet) {
		this.proSet = proSet;
	}

}