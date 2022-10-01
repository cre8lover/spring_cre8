package com.cre8.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

import com.cre8.dto.Att;
import com.cre8.dto.Auc;
import com.cre8.dto.Item;
import com.cre8.dto.Pro;
import com.cre8.dto.Thumbnail;
import com.cre8.dto.prodelVo;


public interface FileService {

	public Att fileUpload(FileItem item) throws Exception;
	
	public Att fileUpload(MultipartFile item) throws Exception;
	
	public Thumbnail setThumbnail(String saveFileName,File file) throws IOException;

	public Pro getFormParameter(FileItem item, Pro pro, Item proitem) throws ParseException;
	
	public Auc getFormParameter2(FileItem item, Auc pro, Item proitem) throws ParseException;

	int delete(String attseqno, String savefilename, String filepath, String thumb_filename);
}
