package com.cre8.dao;

import com.cre8.dto.Att;

public interface FileDao {
<<<<<<< HEAD
	
	public int deletfile(String no);
	public String insertAttachFile(String seqno,Att attachfile);
	public void insertThumbNail(Att attachfile,String att_seqno);
=======

	int deletfile(String no);

	String insertAttachFile(String seqno, Att attachfile);

	void insertThumbNail(Att attachfile, String att_seqno);

>>>>>>> branch 'master' of https://github.com/cre8lover/spring_cre8.git
}
