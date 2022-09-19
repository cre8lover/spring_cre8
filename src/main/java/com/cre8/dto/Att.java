package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;

public class Att implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer attSeqno;
	private String attSaveName;
	private String attType;
	private String attName;
	private String attPath;
	private String attSize;
	private Thumbnail attThumb;
	private Date attSavedate;
	private Item item;
	private Marketing marketing;
	private Artdetail artdetail;
	private Mem mem;
	private String itemSeqno;
	private String marSeqno;
	private String artSeqno;

	public Att() {
	}

	
	
	public String getAttSize() {
		return attSize;
	}



	public void setAttSize(String attSize) {
		this.attSize = attSize;
	}



	public Thumbnail getAttThumb() {
		return attThumb;
	}


	
	public Mem getMem() {
		return mem;
	}



	public void setMem(Mem mem) {
		this.mem = mem;
	}



	public void setAttThumb(Thumbnail attThumb) {
		this.attThumb = attThumb;
	}



	public void setAttSeqno(Integer attSeqno) {
		this.attSeqno = attSeqno;
	}

	public Integer getAttSeqno() {
		return this.attSeqno;
	}

	public void savefilename(String attSaveName) {
		this.attSaveName = attSaveName;
	}

	public String savefilename() {
		return this.attSaveName;
	}

	public void setAttType(String attType) {
		this.attType = attType;
	}

	public String getAttType() {
		return this.attType;
	}

	public void setAttName(String attName) {
		this.attName = attName;
	}

	public String getAttName() {
		return this.attName;
	}

	public void setAttPath(String attPath) {
		this.attPath = attPath;
	}

	public String getAttPath() {
		return this.attPath;
	}

	public void setAttSavedate(Date attSavedate) {
		this.attSavedate = attSavedate;
	}

	public Date getAttSavedate() {
		return this.attSavedate;
	}



	public String getSavefilename() {
		return attSaveName;
	}



	public void setSavefilename(String attSaveName) {
		this.attSaveName = attSaveName;
	}



	public String getItemSeqno() {
		return itemSeqno;
	}



	public void setItemSeqno(String itemSeqno) {
		this.itemSeqno = itemSeqno;
	}



	public String getMarSeqno() {
		return marSeqno;
	}



	public void setMarSeqno(String marSeqno) {
		this.marSeqno = marSeqno;
	}



	public String getArtSeqno() {
		return artSeqno;
	}



	public void setArtSeqno(String artSeqno) {
		this.artSeqno = artSeqno;
	}

	
}
