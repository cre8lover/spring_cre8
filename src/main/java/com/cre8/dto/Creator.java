package com.cre8.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Creator implements Serializable {

	private String creCompany;
	private String crePhone;
	private String creName;
	private String creAddress;
	private String creRegnum;
	private String creSalenum;
	private String crePot;
	private Mem mem;
	private Artdetail artdetailSet;
	private Att attSet;

	public Creator() {

	}

	public String getCreCompany() {
		return creCompany;
	}

	public void setCreCompany(String creCompany) {
		this.creCompany = creCompany;
	}

	public String getCrePhone() {
		return crePhone;
	}

	public void setCrePhone(String crePhone) {
		this.crePhone = crePhone;
	}

	public String getCreName() {
		return creName;
	}

	public void setCreName(String creName) {
		this.creName = creName;
	}

	public String getCreAddress() {
		return creAddress;
	}

	public void setCreAddress(String creAddress) {
		this.creAddress = creAddress;
	}

	public String getCreRegnum() {
		return creRegnum;
	}

	public void setCreRegnum(String creRegnum) {
		this.creRegnum = creRegnum;
	}

	public String getCreSalenum() {
		return creSalenum;
	}

	public void setCreSalenum(String creSalenum) {
		this.creSalenum = creSalenum;
	}

	public String getCrePot() {
		return crePot;
	}

	public void setCrePot(String crePot) {
		this.crePot = crePot;
	}

	public Mem getMem() {
		return mem;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Artdetail getArtdetailSet() {
		return artdetailSet;
	}

	public void setArtdetailSet(Artdetail artdetailSet) {
		this.artdetailSet = artdetailSet;
	}

	public Att getAttSet() {
		return attSet;
	}

	public void setAttSet(Att attSet) {
		this.attSet = attSet;
	}

}