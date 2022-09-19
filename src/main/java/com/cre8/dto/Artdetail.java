package com.cre8.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Artdetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer artSeqno;
	private String artImg;
	private String artGenre;
	private Mem mem;
	private Att attSet;

	
	public Artdetail() {

	}

	public void setArtSeqno(Integer artSeqno) {
		this.artSeqno = artSeqno;
	}

	public Integer getArtSeqno() {
		return this.artSeqno;
	}

	public void setArtImg(String artImg) {
		this.artImg = artImg;
	}

	public String getArtImg() {
		return this.artImg;
	}

	public void setArtGenre(String artGenre) {
		this.artGenre = artGenre;
	}

	public String getArtGenre() {
		return this.artGenre;
	}

	public void setMem(Mem mem) {
		this.mem = mem;
	}

	public Mem getMem() {
		return this.mem;
	}

	public void setAttSet(Att attSet) {
		this.attSet = attSet;
	}

	public Att getAttSet() {
		return this.attSet;
	}

}
