package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;

public class AucNowing implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer aucnowSeqno;
	private Integer aucnowLastprice;
	private Date aucnowDate;
	private Mem mem;
	private Auc auc;

	public AucNowing() {
	}

	public void setAucnowSeqno(Integer aucnowSeqno) {
		this.aucnowSeqno = aucnowSeqno;
	}

	public Integer getAucnowSeqno() {
		return this.aucnowSeqno;
	}

	public void setAucnowLastprice(Integer aucnowLastprice) {
		this.aucnowLastprice = aucnowLastprice;
	}

	public Integer getAucnowLastprice() {
		return this.aucnowLastprice;
	}

	public void setAucnowDate(Date aucnowDate) {
		this.aucnowDate = aucnowDate;
	}

	public Date getAucnowDate() {
		return this.aucnowDate;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Mem getMem() {
		return this.mem;
	}

	public void setAuc(Auc auc) {
		this.auc = auc;
	}

	public Auc getAuc() {
		return this.auc;
	}


}
