package com.cre8.dto;

import java.io.Serializable;
import java.util.Date;

public class Att implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer attSeqno;
	private String Savefilename;
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
	
	
	
	public String getSavefilename() {
		return Savefilename;
	}
	public void setSavefilename(String savefilename) {
		Savefilename = savefilename;
	}
	public Integer getAttSeqno() {
		return attSeqno;
	}
	public void setAttSeqno(Integer attSeqno) {
		this.attSeqno = attSeqno;
	}
	
	public String getAttType() {
		return attType;
	}
	public void setAttType(String attType) {
		this.attType = attType;
	}
	public String getAttName() {
		return attName;
	}
	public void setAttName(String attName) {
		this.attName = attName;
	}
	public String getAttPath() {
		return attPath;
	}
	public void setAttPath(String attPath) {
		this.attPath = attPath;
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
	public void setAttThumb(Thumbnail attThumb) {
		this.attThumb = attThumb;
	}
	public Date getAttSavedate() {
		return attSavedate;
	}
	public void setAttSavedate(Date attSavedate) {
		this.attSavedate = attSavedate;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Marketing getMarketing() {
		return marketing;
	}
	public void setMarketing(Marketing marketing) {
		this.marketing = marketing;
	}
	public Artdetail getArtdetail() {
		return artdetail;
	}
	public void setArtdetail(Artdetail artdetail) {
		this.artdetail = artdetail;
	}
	public Mem getMem() {
		return mem;
	}
	public void setMem(Mem mem) {
		this.mem = mem;
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
