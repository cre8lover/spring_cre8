package com.cre8.dao;

import com.cre8.dto.Att;

public interface FileDao {

	int deletfile(String no);

	String insertAttachFile(String seqno, Att attachfile);

	void insertThumbNail(Att attachfile, String att_seqno);

}
