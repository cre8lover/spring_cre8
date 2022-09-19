package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;

public class Waybill implements Serializable {

	private Integer waybillSeq;
	private String waybillName;
	private Date waybillDate;
	private Date waybillChange;
	private Integer waybillNumber;
	private Ship ship;

	public Waybill() {
	}

	public Integer getWaybillSeq() {
		return waybillSeq;
	}

	public void setWaybillSeq(Integer waybillSeq) {
		this.waybillSeq = waybillSeq;
	}

	public String getWaybillName() {
		return waybillName;
	}

	public void setWaybillName(String waybillName) {
		this.waybillName = waybillName;
	}

	public Date getWaybillDate() {
		return waybillDate;
	}

	public void setWaybillDate(Date waybillDate) {
		this.waybillDate = waybillDate;
	}

	public Date getWaybillChange() {
		return waybillChange;
	}

	public void setWaybillChange(Date waybillChange) {
		this.waybillChange = waybillChange;
	}

	public Integer getWaybillNumber() {
		return waybillNumber;
	}

	public void setWaybillNumber(Integer waybillNumber) {
		this.waybillNumber = waybillNumber;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

}