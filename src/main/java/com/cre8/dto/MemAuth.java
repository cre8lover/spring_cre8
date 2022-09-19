package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MemAuth implements Serializable {

	private Mem mem;
	private String authName;
	private Date authDate;
	private Cat catSet;

	public MemAuth() {
	}

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public Date getAuthDate() {
		return authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	public Cat getCatSet() {
		return catSet;
	}

	public void setCatSet(Cat catSet) {
		this.catSet = catSet;
	}

}