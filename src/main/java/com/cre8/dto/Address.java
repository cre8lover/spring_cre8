package com.cre8.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer addSeqno;
	private String addAddress;
	private String addetail;
	private Integer addNum;
	private String addPhone;
	private String addPerson;
	private String addCategory;
	private Mem mem;
	private Ship shipSet;

	public Address() {
	}

	
	public String getAddetail() {
		return addetail;
	}


	public void setAddetail(String addetail) {
		this.addetail = addetail;
	}


	public void setAddSeqno(Integer addSeqno) {
		this.addSeqno = addSeqno;
	}

	public Integer getAddSeqno() {
		return this.addSeqno;
	}

	public void setAddAddress(String addAddress) {
		this.addAddress = addAddress;
	}

	public String getAddAddress() {
		return this.addAddress;
	}

	public void setAddNum(Integer addNum) {
		this.addNum = addNum;
	}

	public Integer getAddNum() {
		return this.addNum;
	}

	public void setAddPhone(String addPhone) {
		this.addPhone = addPhone;
	}

	public String getAddPhone() {
		return this.addPhone;
	}

	public void setAddPerson(String addPerson) {
		this.addPerson = addPerson;
	}

	public String getAddPerson() {
		return this.addPerson;
	}

	public void setAddCategory(String addCategory) {
		this.addCategory = addCategory;
	}

	public String getAddCategory() {
		return this.addCategory;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Mem getMem() {
		return this.mem;
	}

	public void setShipSet(Ship shipSet) {
		this.shipSet = shipSet;
	}

	public Ship getShipSet() {
		return this.shipSet;
	}


}
