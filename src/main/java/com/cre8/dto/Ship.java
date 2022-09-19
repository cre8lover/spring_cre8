package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Ship implements Serializable {

	private Integer shipSeqno;
	private Date shipStart;
	private Date shipFinish;
	private String shipStatus;
	private Orders orders;
	private Address address;
	private Waybill waybillSet;

	public Ship() {

	}

	public Integer getShipSeqno() {
		return shipSeqno;
	}

	public void setShipSeqno(Integer shipSeqno) {
		this.shipSeqno = shipSeqno;
	}

	public Date getShipStart() {
		return shipStart;
	}

	public void setShipStart(Date shipStart) {
		this.shipStart = shipStart;
	}

	public Date getShipFinish() {
		return shipFinish;
	}

	public void setShipFinish(Date shipFinish) {
		this.shipFinish = shipFinish;
	}

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Waybill getWaybillSet() {
		return waybillSet;
	}

	public void setWaybillSet(Waybill waybillSet) {
		this.waybillSet = waybillSet;
	}

}