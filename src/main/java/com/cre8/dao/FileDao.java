package com.cre8.dao;

import com.cre8.dto.Att;

public interface FileDao {
	
	public int deletfile(String no);
	public String insertAttachFile(String seqno,Att attachfile);
	public void insertThumbNail(Att attachfile,String att_seqno);
}
